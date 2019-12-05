package com.redbeemedia.enigma.core.restriction;

public class MockContractRestrictions implements IContractRestrictions {
    private IContractRestrictionsValueSource valueSource = null;
    @Override
    public <T> T getValue(IContractRestriction<T> restriction, T fallback) {
        if(valueSource != null) {
            T value = restriction.getValue(valueSource);
            if(value != null) {
                return value;
            }
        }
        return fallback;
    }

    public MockContractRestrictions setValueSource(IContractRestrictionsValueSource valueSource) {
        this.valueSource = valueSource;
        return this;
    }
}
