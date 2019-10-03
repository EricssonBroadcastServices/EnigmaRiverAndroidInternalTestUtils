package com.redbeemedia.enigma.core.testutil.thread;

/**
 * Used to pause thread execution between threads to emulate exact concurrent thread scenarios.
 */
public class ThreadHalter {
    private volatile int stepsAllowed = 0;
    private volatile int stepsTaken = 0;

    public void proceed() {
        stepsAllowed++;
    }

    public void waitForGo() throws InterruptedException {
        stepsTaken++;
        while(stepsTaken > stepsAllowed) {
            //Wait
            if(Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
        }
    }

    public void waitForGoWrapException() {
        try {
            waitForGo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}