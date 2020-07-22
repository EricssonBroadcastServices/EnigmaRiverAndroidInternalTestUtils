package com.redbeemedia.enigma.core.player.controls;

import com.redbeemedia.enigma.core.error.EnigmaError;
import com.redbeemedia.enigma.core.testutil.Counter;

import java.util.ArrayList;
import java.util.List;

public class AssertiveControlResultHandler implements IControlResultHandler {
    private final Counter responseCounter = new Counter();
    private final Counter rejectCounter = new Counter();
    private final Counter cancelCounter = new Counter();
    private final Counter errorCounter = new Counter();
    private final Counter doneCounter = new Counter();
    private final List<String> calledMethods = new ArrayList<>();

    @Override
    public void onRejected(IRejectReason reason) {
        calledMethods.add("onRejected");
        responseCounter.count();
        rejectCounter.count();
    }

    @Override
    public void onCancelled() {
        calledMethods.add("onCancelled");
        responseCounter.count();
        cancelCounter.count();
    }

    @Override
    public void onError(EnigmaError error) {
        calledMethods.add("onError");
        responseCounter.count();
        errorCounter.count();
    }

    @Override
    public void onDone() {
        calledMethods.add("onDone");
        responseCounter.count();
        doneCounter.count();
    }

    private void assertOneResponse() {
        try {
            responseCounter.assertOnce();
        } catch (AssertionError e) {
            String message;
            if(responseCounter.getCounts() == 0) {
                message = "No callbacks called!";
            } else {
                message = "Callbacks called "+responseCounter.getCounts()+" times!";
            }
            if(!calledMethods.isEmpty()) {
                message = " "+getCalledMethodsMessage();
            }
            throw new AssertionError(message, e);
        }
    }

    private void assertCalledOnce(Counter counter, String methodName) {
        try {
            counter.assertOnce();
        } catch (AssertionError e) {
            String message;
            if(counter.getCounts() == 0) {
                message = methodName + " never called!";
            } else {
                message = methodName + " called "+counter.getCounts()+" times!";
            }
            if(!calledMethods.isEmpty()) {
                message = " "+getCalledMethodsMessage();
            }
            throw new AssertionError(message, e);
        }
    }


    private String getCalledMethodsMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        if(!calledMethods.isEmpty()) {
            stringBuilder.append("These methods were called: ");
            for(int i = 0; i < calledMethods.size(); ++i) {
                if(i != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(calledMethods.get(i));
            }
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    public void assertOnRejectedCalled() {
        assertOneResponse();
        assertCalledOnce(rejectCounter, "onReject");
    }

    public void assertOnCancelledCalled() {
        assertOneResponse();
        assertCalledOnce(cancelCounter, "onCancelled");
    }

    public void assertOnErrorCalled() {
        assertOneResponse();
        assertCalledOnce(errorCounter, "onError");
    }

    public void assertOnDoneCalled() {
        assertOneResponse();
        assertCalledOnce(doneCounter, "onDone");
    }
}