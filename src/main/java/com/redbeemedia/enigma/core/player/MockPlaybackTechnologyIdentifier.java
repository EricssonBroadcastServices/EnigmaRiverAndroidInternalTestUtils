package com.redbeemedia.enigma.core.player;

import com.redbeemedia.enigma.core.context.EnigmaRiverContext;

public class MockPlaybackTechnologyIdentifier implements IPlaybackTechnologyIdentifier {
    @Override
    public String getTechnologyName() {
        return "InternalTestMockPlayer";
    }

    @Override
    public String getTechnologyVersion() {
        return EnigmaRiverContext.getVersion();
    }
}
