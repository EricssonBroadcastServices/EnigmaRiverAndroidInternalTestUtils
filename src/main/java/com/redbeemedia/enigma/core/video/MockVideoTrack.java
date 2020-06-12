package com.redbeemedia.enigma.core.video;

public class MockVideoTrack implements IVideoTrack {
    private final int bitrate;

    public MockVideoTrack(int bitrate) {
        this.bitrate = bitrate;
    }

    @Override
    public int getBitrate() {
        return bitrate;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IVideoTrack) {
            IVideoTrack other = (IVideoTrack) obj;
            return this.bitrate == other.getBitrate();
        }
        return false;
    }
}
