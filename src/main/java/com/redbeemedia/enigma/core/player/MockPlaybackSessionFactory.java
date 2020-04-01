package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.playrequest.IPlayResultHandler;
import com.redbeemedia.enigma.core.playrequest.IPlaybackProperties;
import com.redbeemedia.enigma.core.session.ISession;

import org.json.JSONObject;

public class MockPlaybackSessionFactory implements IPlaybackSessionFactory {
    @Override
    public void startAsset(ISession session,
                           IPlaybackProperties playbackProperties,
                           IPlayResultHandler playResultHandler,
                           String assetId,
                           IPlaybackSessionFactory.IEnigmaPlayerCallbacks playerConnector) {

        playerConnector.deliverPlaybackSession(newInternalPlaybackSession());
        playerConnector.loadIntoPlayerImplementation("url", playResultHandler,  new JSONObject(), playbackProperties, null);
    }

    public IInternalPlaybackSession newInternalPlaybackSession() {
        return new MockInternalPlaybackSession(true);
    }
}
