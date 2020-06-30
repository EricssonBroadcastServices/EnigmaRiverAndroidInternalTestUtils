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

    @Override
    public void doHttp(URL url, IHttpCall httpCall, IHttpResponseHandler response) {
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
            if(responseHandler != null) {
                responseHandler.doHttp(url, httpCall, response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private IHttpHandler getReponseHandler(String urlString) {
        for(Pattern pattern : specialResponses.keySet()) {
            if(pattern.matcher(urlString).matches()) {
                Queue<IHttpHandler> specialQueue = specialResponses.get(pattern);
                if(!specialQueue.isEmpty()) {
                    return specialQueue.poll();
                }
            }
        }
        if(!responses.isEmpty()) {
            return responses.poll();
        }
        return null;
    }

    @Override
    public void doHttpBlocking(URL url, IHttpCall httpCall, IHttpResponseHandler responseHandler) {
        doHttp(url, httpCall, responseHandler);
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

    public void queueResponse(Pattern urlPattern, HttpStatus httpStatus, String responseBody) {
        Queue<IHttpHandler> queue = specialResponses.get(urlPattern);
        if(queue == null) {
            queue = new LinkedList<>();
            specialResponses.put(urlPattern, queue);
        }
        queue.add(new MockOnResponseResponse(httpStatus, responseBody.getBytes(StandardCharsets.UTF_8)));
    }
}
