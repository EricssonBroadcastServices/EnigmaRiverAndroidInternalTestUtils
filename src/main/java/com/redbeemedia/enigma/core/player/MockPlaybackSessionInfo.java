package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.playable.IPlayable;
import com.redbeemedia.enigma.core.playable.MockPlayable;
import com.redbeemedia.enigma.core.playrequest.IPlaybackProperties;
import com.redbeemedia.enigma.core.playrequest.MockPlaybackProperties;
import com.redbeemedia.enigma.core.time.Duration;

public class MockPlaybackSessionInfo implements IPlaybackSessionInfo {
    private Duration currentPlaybackOffset = Duration.millis(0);
    private String assetId = "mockAssetId";
    private String programId = "mockProgramId";
    private IPlayable playable = new MockPlayable(assetId);
    private String mediaLocator = "https://www.example.com/someAsset";
    private String playerTechnologyName = "UnitTestMockPlayer";
    private String playerTechnologyVersion = "1.0.3";
    private IPlaybackProperties playbackProperties = new MockPlaybackProperties();

    @Override
    public Duration getCurrentPlaybackOffset() {
        return currentPlaybackOffset;
    }

    public MockPlaybackSessionInfo setCurrentPlaybackOffset(Duration currentPlaybackOffset) {
        this.currentPlaybackOffset = currentPlaybackOffset;
        return this;
    }

    @Override
    public IPlayable getPlayable() {
        return playable;
    }

    public MockPlaybackSessionInfo setPlayable(IPlayable playable) {
        this.playable = playable;
        return this;
    }

    @Override
    public String getAssetId() {
        return assetId;
    }

    public MockPlaybackSessionInfo setAssetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    @Override
    public String getMediaLocator() {
        return mediaLocator;
    }

    public MockPlaybackSessionInfo setMediaLocator(String mediaLocator) {
        this.mediaLocator = mediaLocator;
        return this;
    }

    @Override
    public String getPlayerTechnologyName() {
        return playerTechnologyName;
    }

    public MockPlaybackSessionInfo setPlayerTechnologyName(String playerTechnologyName) {
        this.playerTechnologyName = playerTechnologyName;
        return this;
    }

    @Override
    public String getPlayerTechnologyVersion() {
        return playerTechnologyVersion;
    }

    public MockPlaybackSessionInfo setPlayerTechnologyVersion(String playerTechnologyVersion) {
        this.playerTechnologyVersion = playerTechnologyVersion;
        return this;
    }

    @Override
    public String getCurrentProgramId() {
        return programId;
    }

    public MockPlaybackSessionInfo setProgramId(String programId) {
        this.programId = programId;
        return this;
    }

    @Override
    public IPlaybackProperties getPlaybackProperties() {
        return playbackProperties;
    }

    public MockPlaybackSessionInfo setPlaybackProperties(IPlaybackProperties playbackProperties) {
        this.playbackProperties = playbackProperties;
        return this;
    }
}
