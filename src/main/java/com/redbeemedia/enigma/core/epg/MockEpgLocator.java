package com.redbeemedia.enigma.core.epg;

import com.redbeemedia.enigma.core.businessunit.IBusinessUnit;
import com.redbeemedia.enigma.core.epg.impl.MockEpg;

public class MockEpgLocator implements IEpgLocator {
    @Override
    public IEpg getEpg(IBusinessUnit businessUnit) {
        return new MockEpg();
    }
}
