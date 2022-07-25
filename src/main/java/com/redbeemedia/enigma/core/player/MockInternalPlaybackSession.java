package com.redbeemedia.enigma.core.player;

import android.os.Handler;

import com.redbeemedia.enigma.core.ads.IAdMetadata;
import com.redbeemedia.enigma.core.analytics.IAnalyticsReporter;
import com.redbeemedia.enigma.core.audio.IAudioTrack;
import com.redbeemedia.enigma.core.drm.IDrmInfo;
import com.redbeemedia.enigma.core.playable.IPlayable;
import com.redbeemedia.enigma.core.playable.MockPlayable;
import com.redbeemedia.enigma.core.playbacksession.IPlaybackSessionListener;
import com.redbeemedia.enigma.core.player.track.IPlayerImplementationTrack;
import com.redbeemedia.enigma.core.restriction.IContractRestrictions;
import com.redbeemedia.enigma.core.restriction.MockContractRestrictions;
import com.redbeemedia.enigma.core.subtitle.ISubtitleTrack;
import com.redbeemedia.enigma.core.video.ISpriteRepository;
import com.redbeemedia.enigma.core.video.IVideoTrack;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.List;

public class MockInternalPlaybackSession implements IInternalPlaybackSession {
    private JsonStreamInfo streamInfo;
    private IStreamPrograms streamPrograms = null;
    private IPlaybackSessionInfo playbackSessionInfo = new MockPlaybackSessionInfo();
    private IContractRestrictions contractRestrictions = new MockContractRestrictions();
    private IEnigmaPlayerConnection playerConnection = new MockEnigmaPlayerConnection();
    private IDrmInfo drmInfo = null;

    public MockInternalPlaybackSession(boolean live) {
        this(live, -1L);
    }

    public MockInternalPlaybackSession(boolean live, long start) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("live", live);
            jsonObject.put("static", !live);
            jsonObject.put("start", start);
            this.streamInfo = new JsonStreamInfo(jsonObject);
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
    public void addInternalListener(IInternalPlaybackSessionListener listener) {
    }

    @Override
    public JsonStreamInfo getStreamInfo() {
        return streamInfo;
    }

    @Override
    public IAnalyticsReporter getAnalyticsReporter() {
        return null;
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
    public IPlaybackSessionInfo getPlaybackSessionInfo() {
        return playbackSessionInfo;
    }

    @Override
    public IDrmInfo getDrmInfo() {
        return drmInfo;
    }

    @Override
    public IAdMetadata getAdsMetadata() {
        return null;
    }

    public MockInternalPlaybackSession setDrmInfo(IDrmInfo drmInfo) {
        this.drmInfo = drmInfo;
        return this;
    }

    public MockInternalPlaybackSession setPlaybackSessionInfo(IPlaybackSessionInfo playbackSessionInfo) {
        this.playbackSessionInfo = playbackSessionInfo;
        return this;
    }

    @Override
    public IPlayable getPlayable() {
        return new MockPlayable(playbackSessionInfo.getAssetId());
    }

    @Override
    public void setPlayingFromLive(boolean live) {
    }

    @Override
    public void setSeekLiveAllowed(boolean allowed) {

    }


    @Override
    public void fireEndReached() {
    }

    @Override
    public void fireSeekCompleted() {
    }

    @Override
    public void setTracks(Collection<? extends IPlayerImplementationTrack> tracks) {
    }

    @Override
    public void setSelectedSubtitleTrack(ISubtitleTrack track) {
    }

    @Override
    public void setSelectedSubtitleTrack(String trackId) {

    }

    @Override
    public ISubtitleTrack getSubtitleTrack(String trackId) {
        return null;
    }

    @Override
    public void setSelectedAudioTrack(IAudioTrack track) {
    }

    @Override
    public void setSelectedAudioTrack(String trackId) {

    }

    @Override
    public IAudioTrack getAudioTrack(String trackId) {
        return null;
    }

    @Override
    public void setSelectedVideoTrack(IVideoTrack track) {
    }

    @Override
    public void setSelectedVideoTrack(String trackId) {

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
    public boolean isSeekInLiveAllowed() {
        return false;
    }

    @Override
    public String getPlaybackSessionId() {
        return null;
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
    public List<IVideoTrack> getVideoTracks() {
        return null;
    }

    @Override
    public IVideoTrack getSelectedVideoTrack() {
        return null;
    }

    @Override
    public ISpriteRepository getSpriteRepository() {
        return null;
    }

    @Override
    public boolean isSeekToLiveAllowed() {
        return true && isSeekAllowed();
    }

    @Override
    public IContractRestrictions getContractRestrictions() {
        return contractRestrictions;
    }

    @Override
    public void setContractRestrictions(IContractRestrictions contractRestrictions) {
        this.contractRestrictions = contractRestrictions;
    }

    @Override
    public IEnigmaPlayerConnection getPlayerConnection() {
        return playerConnection;
    }
}
