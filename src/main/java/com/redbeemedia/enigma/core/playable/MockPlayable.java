package com.redbeemedia.enigma.core.playable;

import android.annotation.SuppressLint;
import android.os.Parcel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@SuppressLint("ParcelCreator")
public class MockPlayable implements IAssetPlayable {
    private IType type;

    public MockPlayable() {
        this("mockAsset");
    }

    public MockPlayable(String assetId) {
        this.type = new AssetType(assetId);
    }

    @Override
    public void useWith(IPlayableHandler playableHandler) {
        type.useWith(playableHandler);
    }

    public MockPlayable useAssetId(String assetId) {
        type = new AssetType(assetId);
        return this;
    }

    public MockPlayable useUrl(String url) {
        try {
            type = new UrlType(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public MockPlayable useDownloadData(Object downloadData) {
        type = new DownloadType(downloadData);
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public String getAssetId() {
        return "mock-assetid";
    }

    private interface IType {
        void useWith(IPlayableHandler playableHandler);
    }

    private static class AssetType implements IType {
        private final String assetId;

        public AssetType(String assetId) {
            this.assetId = assetId;
        }

        @Override
        public void useWith(IPlayableHandler playableHandler) {
            playableHandler.startUsingAssetId(assetId);
        }
    }

    private static class UrlType implements IType {
        private final URL url;

        public UrlType(URL url) {
            this.url = url;
        }

        @Override
        public void useWith(IPlayableHandler playableHandler) {
            playableHandler.startUsingUrl(url);
        }
    }

    private static class DownloadType implements IType {
        private final Object downloadData;

        public DownloadType(Object downloadData) {
            this.downloadData = downloadData;
        }

        @Override
        public void useWith(IPlayableHandler playableHandler) {
            playableHandler.startUsingDownloadData(downloadData, String.valueOf(UUID.randomUUID()), "", "", -1);
        }
    }
}
