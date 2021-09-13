package com.redbeemedia.enigma.core.http;

import com.redbeemedia.enigma.core.http.mockresponses.MockOnExceptionResponse;
import com.redbeemedia.enigma.core.http.mockresponses.MockOnResponseNoInputstreamResponse;
import com.redbeemedia.enigma.core.http.mockresponses.MockOnResponseResponse;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Pattern;

public class MockHttpHandler implements IHttpHandler {
    private Queue<IHttpHandler> responses = new LinkedList<>();
    private Map<Pattern, Queue<IHttpHandler>> specialResponses = new HashMap<>();
    private List<String> log = new ArrayList<>();

    /** Set this flag to `true` if the last queued response should be kept in the queue after reply. */
    public boolean keepLastResponse;

    @Override
    public IHttpTask doHttp(URL url, IHttpCall httpCall, IHttpResponseHandler response) {
        try {
            String urlString = url.toString();
            MockHttpConnection mockHttpConnection = new MockHttpConnection();
            httpCall.prepare(mockHttpConnection);
            JSONObject logEntry = new JSONObject();
            logEntry.put("method", httpCall.getRequestMethod());
            logEntry.put("url", urlString);
            JSONObject headerMap = new JSONObject();
            for (Map.Entry<String, String> header : mockHttpConnection.getHeaders().entrySet()) {
                headerMap.put(header.getKey(), header.getValue());
            }
            logEntry.put("headers", headerMap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            httpCall.writeBodyTo(byteArrayOutputStream);
            logEntry.put("body", new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8));
            log.add(logEntry.toString());
            IHttpHandler responseHandler = getReponseHandler(urlString);
            if(responseHandler != null && response != null) {
                responseHandler.doHttp(url, httpCall, response);
            } else {
                onIgnoredRequest(url, httpCall, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return new MockHttpTask();
    }

    private IHttpHandler getReponseHandler(String urlString) {
        for(Pattern pattern : specialResponses.keySet()) {
            if(pattern.matcher(urlString).matches()) {
                Queue<IHttpHandler> specialQueue = specialResponses.get(pattern);
                if(!specialQueue.isEmpty()) {
                    if (keepLastResponse) {
                        return specialQueue.peek();
                    } else {
                        return specialQueue.poll();
                    }
                }
            }
        }
        if(!responses.isEmpty()) {
            if (keepLastResponse) {
                return responses.peek();
            } else {
                return responses.poll();
            }
        }
        return null;
    }

    @Override
    public void doHttpBlocking(URL url, IHttpCall httpCall, IHttpResponseHandler responseHandler) {
        doHttp(url, httpCall, responseHandler);
    }

    protected void onIgnoredRequest(URL url, IHttpCall httpCall, IHttpResponseHandler response) {
        //Ignore
    }

    public void queueResponse(IHttpHandler response) {
        this.responses.add(response);
    }

    public void queueResponse(HttpStatus httpStatus) {
        this.queueResponse(new MockOnResponseNoInputstreamResponse(httpStatus));
    }

    public void queueResponse(Exception exception) {
        this.queueResponse(new MockOnExceptionResponse(exception));
    }

    public void queueResponse(HttpStatus httpStatus, String responseBody) {
        this.queueResponse(new MockOnResponseResponse(httpStatus, responseBody.getBytes(StandardCharsets.UTF_8)));
    }

    public List<String> getLog() {
        return log;
    }

    public void clearLog() { log = new ArrayList<>(); }

    public void queueBinaryResponse(Pattern urlPattern, HttpStatus httpStatus, byte[] responseBody) {
        Queue<IHttpHandler> queue = specialResponses.get(urlPattern);
        if(queue == null) {
            queue = new LinkedList<>();
            specialResponses.put(urlPattern, queue);
        }
        queue.add(new MockOnResponseResponse(httpStatus, responseBody));
    }
    public void queueResponse(Pattern urlPattern, HttpStatus httpStatus, String responseBody) {
        queueBinaryResponse(urlPattern, httpStatus, responseBody.getBytes(StandardCharsets.UTF_8));
    }

    public void queueResponseOk(Pattern urlPattern, String responseBody) {
        queueResponse(urlPattern, new HttpStatus(200, "OK"), responseBody);
    }

    public void queueBinaryResponseOk(Pattern urlPattern, byte[] responseBody) {
        queueBinaryResponse(urlPattern, new HttpStatus(200, "OK"), responseBody);
    }
}
