package com.redbeemedia.enigma.core.epg;

import com.redbeemedia.enigma.core.playable.IPlayable;
import com.redbeemedia.enigma.core.playable.MockPlayable;
import com.redbeemedia.enigma.core.time.Duration;

public class MockProgram implements IProgram {
    private final String name;
    private final long start;
    private final long end;
    private final IPlayable playable;
    private String assetId = "mockProgramAsset";
    private String programId = "mockProgramId";

    public MockProgram(long start, long end) {
        this("mock", start, end);
    }


    public MockProgram(String name, long start, long end) {
        this(name, start, end, null);
    }

    public MockProgram(String name, long start, long end, IPlayable playable) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.playable = playable;
    }

    @Override
    public Duration getDuration() {
        return Duration.millis(end-start);
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
    public String toString() {
        return name;
    }

    @Override
    public IPlayable getPlayable() {
        return playable != null ? playable : new MockPlayable(getAssetId());
    }

    @Override
    public String getAssetId() {
        return assetId;
    }

    public MockProgram setAssetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    @Override
    public String getProgramId() {
        return programId;
    }

    public MockProgram setProgramId(String programId) {
        this.programId = programId;
        return this;
    }
}
