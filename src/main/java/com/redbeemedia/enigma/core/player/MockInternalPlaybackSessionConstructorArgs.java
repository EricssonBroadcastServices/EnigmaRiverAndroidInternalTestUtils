package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.analytics.IAnalyticsReporter;
import com.redbeemedia.enigma.core.analytics.MockAnalyticsReporter;
import com.redbeemedia.enigma.core.drm.IDrmInfo;
import com.redbeemedia.enigma.core.restriction.IContractRestrictions;
import com.redbeemedia.enigma.core.restriction.MockContractRestrictions;

public class MockInternalPlaybackSessionConstructorArgs {
    private JsonStreamInfo streamInfo = JsonStreamInfo.createForNull();
    private IStreamPrograms streamPrograms = new MockStreamPrograms();
    private IPlaybackSessionInfo playbackSessionInfo = new MockPlaybackSessionInfo();
    private IContractRestrictions contractRestrictions = new MockContractRestrictions();
    private IDrmInfo drmInfo = null;
    private IAnalyticsReporter analyticsReporter = new MockAnalyticsReporter();

    public InternalPlaybackSession.ConstructorArgs create() {
        return new InternalPlaybackSession.ConstructorArgs(streamInfo, streamPrograms,playbackSessionInfo, contractRestrictions, drmInfo, analyticsReporter);
    }

    public JsonStreamInfo getStreamInfo() {
        return streamInfo;
    }

    public MockInternalPlaybackSessionConstructorArgs setStreamInfo(JsonStreamInfo streamInfo) {
        this.streamInfo = streamInfo;
        return this;
    }

    public IPlaybackSessionInfo getPlaybackSessionInfo() {
        return playbackSessionInfo;
    }

    public MockInternalPlaybackSessionConstructorArgs setPlaybackSessionInfo(IPlaybackSessionInfo playbackSessionInfo) {
        this.playbackSessionInfo = playbackSessionInfo;
        return this;
    }

    public IContractRestrictions getContractRestrictions() {
        return contractRestrictions;
    }

    public MockInternalPlaybackSessionConstructorArgs setContractRestrictions(IContractRestrictions contractRestrictions) {
        this.contractRestrictions = contractRestrictions;
        return this;
    }

    public IStreamPrograms getStreamPrograms() {
        return streamPrograms;
    }

    public MockInternalPlaybackSessionConstructorArgs setStreamPrograms(IStreamPrograms streamPrograms) {
        this.streamPrograms = streamPrograms;
        return this;
    }

    public IDrmInfo getDrmInfo() {
        return drmInfo;
    }

    public MockInternalPlaybackSessionConstructorArgs setDrmInfo(IDrmInfo drmInfo) {
        this.drmInfo = drmInfo;
        return this;
    }

    public IAnalyticsReporter getAnalyticsReporter() {
        return analyticsReporter;
    }

    public MockInternalPlaybackSessionConstructorArgs setAnalyticsReporter(IAnalyticsReporter analyticsReporter) {
        this.analyticsReporter = analyticsReporter;
        return this;
    }
}
