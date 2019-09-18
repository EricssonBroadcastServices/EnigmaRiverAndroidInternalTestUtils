package com.redbeemedia.enigma.core.restriction;

public class MockContractRestriction<T> implements IContractRestriction<T> {
    private final T value;

    public MockContractRestriction(T value) {
        this.value = value;
    }

    @Override
    public T getValue(IContractRestrictionsValueSource valueSource) {
        return value;
    }
}
