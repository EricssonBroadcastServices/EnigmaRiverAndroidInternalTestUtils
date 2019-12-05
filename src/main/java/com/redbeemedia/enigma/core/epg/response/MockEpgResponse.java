package com.redbeemedia.enigma.core.epg.response;

import com.redbeemedia.enigma.core.epg.IProgram;

import java.util.Collections;
import java.util.List;

public class MockEpgResponse implements IEpgResponse {
    private long start;
    private long end;
    private List<IProgram> programs;

    public MockEpgResponse(List<IProgram> programs) {
        this(Collections.min(programs, (o1, o2) -> Long.compare(o1.getStartUtcMillis(), o2.getStartUtcMillis())).getStartUtcMillis(),
             Collections.max(programs, (o1, o2) -> Long.compare(o1.getEndUtcMillis(), o2.getEndUtcMillis())).getEndUtcMillis(),
             programs);
    }

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
