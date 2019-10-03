package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.epg.IProgram;

public class MockStreamPrograms implements IStreamPrograms {
    @Override
    public IProgram getProgramAtOffset(long offset) {
        return null;
    }

    @Override
    public IProgram getNext(IProgram program) {
        return null;
    }

    @Override
    public IProgram getPrevious(IProgram program) {
        return null;
    }
}
