package com.redbeemedia.enigma.core.restriction;

public class MockContractRestrictions implements IContractRestrictions {
    @Override
    public <T> T getValue(IContractRestriction<T> restriction, T fallback) {
        return fallback;
    }
}
