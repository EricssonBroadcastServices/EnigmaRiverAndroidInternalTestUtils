package com.redbeemedia.enigma.core.testutil.thread;

/**
 * Used to pause thread execution between threads to emulate exact concurrent thread scenarios.
 */
public class ThreadHalter {
    private volatile Destruction destruction = null;
    private volatile int stepsAllowed = 0;
    private volatile int stepsTaken = 0;

    public void proceed() {
        stepsAllowed++;
    }

    public void waitForGo() throws InterruptedException {
        stepsTaken++;
        while(stepsTaken > stepsAllowed && (destruction == null)) {
            //Wait
            if(Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }
        }
        if(destruction != null) {
            throw new RuntimeException("Destruction from thread "+destruction.destroyingThread.getName(),destruction.throwable);
        }
    }

    public void waitForGoWrapException() {
        try {
            waitForGo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy(Throwable throwable) {
        destruction = new Destruction(throwable, Thread.currentThread());
    }

    public void dependOnCurrentThread() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                ThreadHalter.this.destroy(e);
            }
        });
    }

    private static class Destruction {
        private final Throwable throwable;
        private final Thread destroyingThread;

        public Destruction(Throwable throwable, Thread destroyingThread) {
            this.throwable = throwable;
            this.destroyingThread = destroyingThread;
        }
    }
}