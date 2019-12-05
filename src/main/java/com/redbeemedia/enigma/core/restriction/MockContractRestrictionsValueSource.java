package com.redbeemedia.enigma.core.restriction;

import java.util.HashMap;
import java.util.Map;

public class MockContractRestrictionsValueSource implements IContractRestrictionsValueSource {
    private Map<String, Object> values;

    public MockContractRestrictionsValueSource() {
        this(new HashMap<>());
    }

    public MockContractRestrictionsValueSource(Map<String, Object> values) {
        this.values = values;
    }

    @Override
    public <T> boolean hasValue(String name, Class<T> type) {
        Object obj = values.get(name);
        if(type.isInstance(obj)) {
            return true;
        }
        return false;
    }

    @Override
    public <T> T getValue(String name, Class<T> type) {
        return type.cast(values.get(name));
    }

    public MockContractRestrictionsValueSource put(String name, Object value) {
        values.put(name, value);
        return this;
    }

    public <T> MockContractRestrictionsValueSource put(BasicContractRestriction<T> contractRestriction, T value) {
        values.put(contractRestriction.getPropertyName(), value);
        return this;
    }
}
