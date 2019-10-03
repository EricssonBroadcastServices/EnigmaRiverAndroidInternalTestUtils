package com.redbeemedia.enigma.core.epg.response;

import com.redbeemedia.enigma.core.epg.IProgram;

import java.util.List;

public class MockEpgResponse implements IEpgResponse {
    private long start;
    private long end;
    private List<IProgram> programs;

    public MockEpgResponse(long start, long end, List<IProgram> programs) {
        this.start = start;
        this.end = end;
        this.programs = programs;
    }

    @Override
    public long getStartUtcMillis() {
        return start;
    }

    @Override
    public long getEndUtcMillis() {
        return end;
    }

    @Override
    public IProgram getProgramAt(long utcMillis) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<IProgram> getPrograms() {
        return programs;
    }
}
