package com.redbeemedia.enigma.core.time;

public class MockStopWatch implements IStopWatch {
    private Duration currentDuration = Duration.millis(0);

    public MockStopWatch() {
    }

    public MockStopWatch setCurrentDuration(Duration currentDuration) {
        this.currentDuration = currentDuration;
        return this;
    }

    public MockStopWatch setCurrentDuration(long currentMillis) {
        return setCurrentDuration(Duration.millis(currentMillis));
    }

    public MockStopWatch addDuration(Duration duration) {
        this.currentDuration = currentDuration.add(duration);
        return this;
    }

    public MockStopWatch addDuration(long millis) {
        return addDuration(Duration.millis(millis));
    }

    @Override
    public void start() {
    }

    @Override
    public Duration stop() {
        return currentDuration;
    }

    @Override
    public Duration readTime() {
        return currentDuration;
    }
}
