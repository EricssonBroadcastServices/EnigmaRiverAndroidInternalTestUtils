package com.redbeemedia.enigma.core.epg.impl;

import com.redbeemedia.enigma.core.epg.MockProgram;
import com.redbeemedia.enigma.core.epg.request.IEpgRequest;
import com.redbeemedia.enigma.core.epg.response.IEpgResponse;
import com.redbeemedia.enigma.core.epg.response.IEpgResponseHandler;
import com.redbeemedia.enigma.core.epg.response.MockEpgResponse;

import java.util.Arrays;

public class MockEpg extends AbstractEpg {
    private IEpgResponse epgResponse;

    public MockEpg() {
        this(new MockEpgResponse(0, 1000, Arrays.asList(new MockProgram(0, 1000))));
    }

    public MockEpg(IEpgResponse epgResponse) {
        this.epgResponse = epgResponse;
    }

    @Override
    public void getPrograms(IEpgRequest request, IEpgResponseHandler responseHandler) {
        if(epgResponse != null) {
            responseHandler.onSuccess(epgResponse);
        } else {
            throw new NullPointerException("epgResponse is null");
        }
    }

    public IEpgResponse getEpgResponse() {
        return epgResponse;
    }

    public MockEpg setEpgResponse(IEpgResponse epgResponse) {
        this.epgResponse = epgResponse;
        return this;
    }
}
