package com.redbeemedia.enigma.core.testutil.json;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectBuilder {
    private final JSONObject jsonObject;

    public JsonObjectBuilder() {
        this(new JSONObject());
    }

    public JsonObjectBuilder(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    @Override
    public String toString() {
        return getJsonObject().toString();
    }

    public JsonObjectBuilder put(String attribute, String value) {
        try {
            jsonObject.put(attribute, value);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public JsonObjectBuilder put(String attribute, int value) {
        try {
            jsonObject.put(attribute, value);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public JsonObjectBuilder put(String attribute, long value) {
        try {
            jsonObject.put(attribute, value);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public JsonObjectBuilder put(String attribute, double value) {
        try {
            jsonObject.put(attribute, value);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public JsonObjectBuilder put(String attribute, boolean value) {
        try {
            jsonObject.put(attribute, value);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public JsonArrayBuilder putArray(String attribute) {
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        try {
            jsonObject.put(attribute, jsonArrayBuilder.getJsonArray());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonArrayBuilder;
    }

    public JsonObjectBuilder putObject(String attribute) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        try {
            jsonObject.put(attribute, jsonObjectBuilder.getJsonObject());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObjectBuilder;
    }
}
