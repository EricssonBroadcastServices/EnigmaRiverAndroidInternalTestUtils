package com.redbeemedia.enigma.core.testutil.thread;

/**
 * Utility class that interruptts a given thread after specified timeout, unless cancelled.
 */
public class Interruptor extends Thread {
    private final Thread threadToInterrupt;
    private final long timeoutMillis;
    private boolean cancelled = false;
    private volatile boolean didInterupt = false;

    public Interruptor(Thread threadToInterrupt, long timeoutMillis) {
        this.threadToInterrupt = threadToInterrupt;
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    public void run() {
        try {
            sleep(timeoutMillis);
        } catch (InterruptedException e) {
            if(!cancelled) {
                throw new RuntimeException(e);
            }
        }
        if(!cancelled) {
            threadToInterrupt.interrupt();
            didInterupt = true;
        }
    }

    public void cancel() {
        cancelled = true;
        interrupt();
    }

    public boolean didInterrupt() {
        return didInterupt;
    }
}
