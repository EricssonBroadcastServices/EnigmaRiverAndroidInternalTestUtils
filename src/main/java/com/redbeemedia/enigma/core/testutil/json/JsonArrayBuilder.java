package com.redbeemedia.enigma.core.testutil.json;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonArrayBuilder {
    private final JSONArray array;

    public JsonArrayBuilder() {
        this(new JSONArray());
    }

    public JsonArrayBuilder(JSONArray array) {
        this.array = array;
    }

    public JSONArray getJsonArray() {
        return array;
    }

    @Override
    public String toString() {
        return getJsonArray().toString();
    }

    public JsonObjectBuilder addObject() {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        array.put(jsonObjectBuilder.getJsonObject());
        return jsonObjectBuilder;
    }

    public JsonArrayBuilder addArray() {
        JsonArrayBuilder jsonArrayBuilder = new JsonArrayBuilder();
        array.put(jsonArrayBuilder.getJsonArray());
        return jsonArrayBuilder;
    }

    public JsonArrayBuilder add(String value) {
        array.put(value);
        return this;
    }

    public JsonArrayBuilder add(int value) {
        array.put(value);
        return this;
    }

    public JsonArrayBuilder add(long value) {
        array.put(value);
        return this;
    }

    public JsonArrayBuilder add(double value) {
        try {
            array.put(value);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public JsonArrayBuilder add(boolean value) {
        array.put(value);
        return this;
    }
}
