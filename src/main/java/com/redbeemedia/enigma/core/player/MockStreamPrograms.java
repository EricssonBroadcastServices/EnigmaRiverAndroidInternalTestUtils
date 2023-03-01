package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.epg.IProgram;

public class MockStreamPrograms implements IStreamPrograms {
    @Override
    public IProgram getProgram() {
        return null;
    }

    @Override
    public IProgram getProgramForEntitlementCheck() {
        return null;
    }

    @Override
    public Long getNeighbouringSectionStartOffset(long fromOffset, boolean searchBackwards) {
        return null;
    }
}
