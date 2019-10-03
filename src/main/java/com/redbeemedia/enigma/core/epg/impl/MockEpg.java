package com.redbeemedia.enigma.core.epg.impl;

import com.redbeemedia.enigma.core.epg.request.IEpgRequest;
import com.redbeemedia.enigma.core.epg.response.IEpgResponseHandler;
import com.redbeemedia.enigma.core.error.InternalError;

public class MockEpg extends AbstractEpg {
    @Override
    public void getPrograms(IEpgRequest request, IEpgResponseHandler responseHandler) {
        responseHandler.onError(new InternalError("TODO do something")); //TODO
    }
}
