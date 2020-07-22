package com.redbeemedia.enigma.core.http.mockresponses;

import com.redbeemedia.enigma.core.http.IHttpCall;
import com.redbeemedia.enigma.core.http.IHttpHandler;
import com.redbeemedia.enigma.core.http.IHttpTask;
import com.redbeemedia.enigma.core.http.MockHttpTask;

import java.net.URL;

public abstract class AbstractMockResponse implements IHttpHandler {
    @Override
    public void doHttpBlocking(URL url, IHttpCall httpCall, IHttpResponseHandler responseHandler) {
        this.doSimpleHttp(url, httpCall, responseHandler);
    }

    @Override
    public final IHttpTask doHttp(URL url, IHttpCall httpCall, IHttpResponseHandler responseHandler) {
        this.doSimpleHttp(url, httpCall, responseHandler);
        return new MockHttpTask();
    }

    public abstract void doSimpleHttp(URL url, IHttpCall httpCall, IHttpResponseHandler responseHandler);
}
