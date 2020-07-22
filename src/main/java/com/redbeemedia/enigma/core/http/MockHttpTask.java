package com.redbeemedia.enigma.core.http;

public class MockHttpTask implements IHttpTask {
    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public void cancel(long joinMillis) {
    }
}
