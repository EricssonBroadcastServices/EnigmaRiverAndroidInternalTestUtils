package com.redbeemedia.enigma.core.video;

public class MockVideoTrack implements IVideoTrack {
    private int bitrate;
    private int width;
    private int height;

    public MockVideoTrack() {
        this(-1,-1,-1);
    }

    public MockVideoTrack(int bitrate) {
        this(bitrate, -1, -1);
    }

    public MockVideoTrack(int bitrate, int width, int height) {
        this.bitrate = bitrate;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getBitrate() {
        return bitrate;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public MockVideoTrack setWidth(int width) {
        this.width = width;
        return this;
    }

    public MockVideoTrack setHeight(int height) {
        this.height = height;
        return this;
    }

    public MockVideoTrack setDimensions(int width, int height) {
        return setWidth(width).setHeight(height);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IVideoTrack) {
            IVideoTrack other = (IVideoTrack) obj;
            return this.bitrate == other.getBitrate()
                && this.width == other.getWidth()
                && this.height == other.getHeight();
        }
        return false;
    }


}
