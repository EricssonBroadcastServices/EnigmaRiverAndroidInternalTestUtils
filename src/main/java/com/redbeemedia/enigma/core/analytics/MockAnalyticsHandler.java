package com.redbeemedia.enigma.core.analytics;

import org.json.JSONObject;

public class MockAnalyticsHandler implements IBufferingAnalyticsHandler {
    @Override
    public void init() throws AnalyticsException, InterruptedException {
    }

    @Override
    public void sendData() throws AnalyticsException, InterruptedException {
    }

    @Override
    public void onAnalytics(JSONObject jsonObject) {
    }
}
