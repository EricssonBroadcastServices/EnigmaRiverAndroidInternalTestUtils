package com.redbeemedia.enigma.core.player;

import android.os.Handler;

import com.redbeemedia.enigma.core.ads.AdDetector;
import com.redbeemedia.enigma.core.ads.IAdDetector;
import com.redbeemedia.enigma.core.analytics.IAnalyticsReporter;
import com.redbeemedia.enigma.core.http.MockHttpHandler;
import com.redbeemedia.enigma.core.marker.IMarkerPointsDetector;
import com.redbeemedia.enigma.core.player.controls.IEnigmaPlayerControls;
import com.redbeemedia.enigma.core.player.listener.IEnigmaPlayerListener;
import com.redbeemedia.enigma.core.player.timeline.ITimeline;
import com.redbeemedia.enigma.core.player.timeline.SimpleTimeline;
import com.redbeemedia.enigma.core.playrequest.IPlayRequest;
import com.redbeemedia.enigma.core.session.ISession;
import com.redbeemedia.enigma.core.util.IHandler;
import com.redbeemedia.enigma.core.virtualui.IVirtualControls;

public class MockEnigmaPlayer implements IEnigmaPlayer {
    @Override
    public void play(IPlayRequest playerRequest) {
    }

    @Override
    public boolean addListener(IEnigmaPlayerListener playerListener) {
        return false;
    }

    @Override
    public boolean addListener(IEnigmaPlayerListener playerListener, Handler handler) {
        return false;
    }

    @Override
    public boolean removeListener(IEnigmaPlayerListener playerListener) {
        return false;
    }

    @Override
    public IEnigmaPlayerControls getControls() {
        return null;
    }

    @Override
    public ITimeline getTimeline() {
        return null;
    }

    @Override
    public EnigmaPlayerState getState() {
        return null;
    }

    @Override
    public IAdDetector getAdDetector() {
        ITimeline timeline = new SimpleTimeline();
        MockHttpHandler mockHttpHandler = new MockHttpHandler();
        return new AdDetector(mockHttpHandler, timeline,null);
    }

    @Override
    public IMarkerPointsDetector getMarkerPointsDetector() {
        return null;
    }

    @Override
    public IEnigmaPlayer setCallbackHandler(IHandler handler) {
        return null;
    }

    @Override
    public IEnigmaPlayer setCallbackHandler(Handler handler) {
        return null;
    }

    @Override
    public void setDefaultSession(ISession session) {
    }

    @Override
    public boolean isLiveStream() {
        return false;
    }

    @Override
    public void release() {
    }

    @Override
    public boolean isAdBeingPlayed() {
        return false;
    }

    @Override
    public IVirtualControls getVirtualControls() {
        return null;
    }

    @Override
    public void setVirtualControls(IVirtualControls virtualControls) {

    }

    @Override
    public IAnalyticsReporter getCurrentAnalyticsReporter() {
        return null;
    }
}
