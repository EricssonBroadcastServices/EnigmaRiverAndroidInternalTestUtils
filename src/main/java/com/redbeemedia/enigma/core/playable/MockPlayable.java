package com.redbeemedia.enigma.core.playable;

import android.annotation.SuppressLint;
import android.os.Parcel;

@SuppressLint("ParcelCreator")
public class MockPlayable implements IPlayable {
    private String assetID;

    public MockPlayable(String assetID) {
        this.assetID = assetID;
    }

    @Override
    public void useWith(IPlayableHandler playableHandler) {
        playableHandler.startUsingAssetId(assetID);
    }

    @Override
    public int describeContents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        throw new UnsupportedOperationException();
    }
}
