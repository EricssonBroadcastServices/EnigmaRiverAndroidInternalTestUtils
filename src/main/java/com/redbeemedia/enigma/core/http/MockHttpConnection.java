package com.redbeemedia.enigma.core.http;

import java.util.LinkedHashMap;
import java.util.Map;

public class MockHttpConnection implements IHttpConnection {
    private Map<String,String> headers = new LinkedHashMap<>();

    @Override
    public void setHeader(String name, String value) {
        headers.put(name, value);
    }

    @Override
    public void setDoOutput(boolean value) {
    }

    @Override
    public void setDoInput(boolean value) {
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
