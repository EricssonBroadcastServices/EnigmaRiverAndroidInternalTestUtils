package com.redbeemedia.enigma.core.login;

import com.redbeemedia.enigma.core.error.EnigmaError;
import com.redbeemedia.enigma.core.session.ISession;

public class MockLoginResultHandler implements ILoginResultHandler {
    @Override
    public void onSuccess(ISession session) {
        //Ignore
    }

    @Override
    public void onError(EnigmaError error) {
        //ignore
    }
}
