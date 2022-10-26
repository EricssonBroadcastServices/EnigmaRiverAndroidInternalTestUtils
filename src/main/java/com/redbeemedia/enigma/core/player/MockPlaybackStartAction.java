package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.ads.IAdDetector;
import com.redbeemedia.enigma.core.error.EnigmaError;
import com.redbeemedia.enigma.core.marker.IMarkerPointsDetector;
import com.redbeemedia.enigma.core.playrequest.IPlayRequest;
import com.redbeemedia.enigma.core.virtualui.IVirtualControls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MockPlaybackStartAction implements IPlaybackStartAction {
    private final IPlayRequest playRequest;
    private final IEnigmaPlayerCallbacks playerConnection;
    private IAdDetector adDetector;
    private IVirtualControls virtualControls;

    public MockPlaybackStartAction(IPlayRequest playRequest, IEnigmaPlayerCallbacks playerConnection) {
        this.playRequest = playRequest;
        this.playerConnection = playerConnection;
    }

    @Override
    public void start() {
        IInternalPlaybackSession playbackSession = newInternalPlaybackSession();
        playerConnection.deliverPlaybackSession(playbackSession);
        playerConnection.setStateIfCurrentStartAction(this, EnigmaPlayerState.PLAYING);
        onStarted(playbackSession);
    }

    protected IInternalPlaybackSession newInternalPlaybackSession() {
        return new MockInternalPlaybackSession(false);
    }

    @Override
    public void cancel() {

    }

    @Override
    public void onStarted(IInternalPlaybackSession internalPlaybackSession) {
        playRequest.getResultHandler().onStarted(internalPlaybackSession);
    }

    @Override
    public void onErrorDuringStartup(EnigmaError error) {
        throw new RuntimeException("Please override this method to ignore error or verify expected error");
    }

    @Override
    public void setAdDetector(IAdDetector adDetector) {
        this.adDetector = adDetector;
    }


    @Override
    public void setMarkerPointsDetector(IMarkerPointsDetector markerPointsDetector) {

    }

    public static class MockEnigmaPlayerCallbacks implements IEnigmaPlayerCallbacks {
        private IPlaybackSessionInfo playbackSessionInfo = new MockPlaybackSessionInfo();

        @Override
        public void setStateIfCurrentStartAction(IPlaybackStartAction action, EnigmaPlayerState state) {

        }

        @Override
        public void deliverPlaybackSession(IInternalPlaybackSession internalPlaybackSession) {

        }

        @Override
        public IPlaybackSessionInfo getPlaybackSessionInfo(String assetId, String manifestUrl, String cdnProvider, String playbackSessionId) {
            return playbackSessionInfo;
        }

        public MockEnigmaPlayerCallbacks setPlaybackSessionInfo(IPlaybackSessionInfo playbackSessionInfo) {
            this.playbackSessionInfo = playbackSessionInfo;
            return this;
        }

        @Override
        public JSONObject getUsableMediaFormat(JSONArray formats) throws JSONException {
            return formats.getJSONObject(0);
        }
    }
}
