package com.redbeemedia.enigma.core.testutil;

import org.junit.Assert;

public class Counter {
    private int counts = 0;
    private int expectedCounts = 0;

    public void count() {
        counts++;
    }

    public int getCounts() {
        return counts;
    }

    public void assertNone() {
        Assert.assertEquals(0, counts);
    }

    public void assertOnce() {
        Assert.assertEquals(1, counts);
    }

    public void assertCount(int times) {
        Assert.assertEquals(times, counts);
    }

    public void assertNone(String message) {
        Assert.assertEquals(message,0, counts);
    }

    public void assertOnce(String message) {
        Assert.assertEquals(message,1, counts);
    }

    public void assertCount(String message, int times) {
        Assert.assertEquals(message, times, counts);
    }

    public void addToExpected(int delta) {
        this.expectedCounts += delta;
    }

    public void setExpectedCounts(int expectedCounts) {
        this.expectedCounts = expectedCounts;
    }

    public void assertExpected() {
        assertCount(expectedCounts);
    }

    public void assertExpected(String message) {
        assertCount(message, expectedCounts);
    }
}
