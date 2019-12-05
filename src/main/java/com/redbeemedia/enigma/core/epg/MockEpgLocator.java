package com.redbeemedia.enigma.core.epg;

import com.redbeemedia.enigma.core.businessunit.IBusinessUnit;
import com.redbeemedia.enigma.core.epg.impl.MockEpg;

public class MockEpgLocator implements IEpgLocator {
    private IEpg epg = new MockEpg();

    @Override
    public IEpg getEpg(IBusinessUnit businessUnit) {
        return epg;
    }

    public IEpg getEpg() {
        return epg;
    }

    public MockEpgLocator setEpg(IEpg epg) {
        this.epg = epg;
        return this;
    }
}
