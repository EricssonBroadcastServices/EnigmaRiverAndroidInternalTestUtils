package com.redbeemedia.enigma.core.player;

import android.os.Handler;

import com.redbeemedia.enigma.core.audio.IAudioTrack;
import com.redbeemedia.enigma.core.playable.IPlayable;
import com.redbeemedia.enigma.core.playable.MockPlayable;
import com.redbeemedia.enigma.core.playbacksession.IPlaybackSessionListener;
import com.redbeemedia.enigma.core.player.track.IPlayerImplementationTrack;
import com.redbeemedia.enigma.core.subtitle.ISubtitleTrack;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.List;

public class MockInternalPlaybackSession implements IInternalPlaybackSession {
    private StreamInfo streamInfo;
    private IPlayable playable = new MockPlayable("mockAsset");
    private IStreamPrograms streamPrograms = null;

    public MockInternalPlaybackSession(boolean live) {
        this(live, -1L);
    }

    public MockInternalPlaybackSession(boolean live, long start) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("live", live);
            jsonObject.put("static", !live);
            jsonObject.put("start", start);
            this.streamInfo = new StreamInfo(jsonObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStart(IEnigmaPlayer enigmaPlayer) {
    }

    @Override
    public void onStop(IEnigmaPlayer enigmaPlayer) {
    }

    @Override
    public StreamInfo getStreamInfo() {
        return streamInfo;
    }

    @Override
    public IStreamPrograms getStreamPrograms() {
        return streamPrograms;
    }

    public MockInternalPlaybackSession setStreamPrograms(IStreamPrograms streamPrograms) {
        this.streamPrograms = streamPrograms;
        return this;
    }

    @Override
    public IPlayable getPlayable() {
        return playable;
    }

    @Override
    public void setPlayingFromLive(boolean live) {
    }

    @Override
    public void fireEndReached() {
    }

    @Override
    public void setTracks(Collection<? extends IPlayerImplementationTrack> tracks) {
    }

    @Override
    public void setSelectedSubtitleTrack(ISubtitleTrack track) {
    }

    @Override
    public void setSelectedAudioTrack(IAudioTrack track) {
    }

    @Override
    public void addListener(IPlaybackSessionListener listener) {
    }

    @Override
    public void addListener(IPlaybackSessionListener listener, Handler handler) {
    }

    @Override
    public void removeListener(IPlaybackSessionListener listener) {
    }

    @Override
    public boolean isPlayingFromLive() {
        return false;
    }

    @Override
    public boolean isSeekAllowed() {
        return true;
    }

    @Override
    public List<ISubtitleTrack> getSubtitleTracks() {
        return null;
    }

    @Override
    public ISubtitleTrack getSelectedSubtitleTrack() {
        return null;
    }

    @Override
    public List<IAudioTrack> getAudioTracks() {
        return null;
    }

    @Override
    public IAudioTrack getSelectedAudioTrack() {
        return null;
    }

    @Override
    public boolean isSeekToLiveAllowed() {
        return true;
    }
}
