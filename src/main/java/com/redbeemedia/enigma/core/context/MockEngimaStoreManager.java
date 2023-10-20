package com.redbeemedia.enigma.core.context;

import android.app.Application;

import com.redbeemedia.enigma.core.analytics.EnigmaStorageManager;

public class MockEngimaStoreManager  extends EnigmaStorageManager {
    public MockEngimaStoreManager(Application application) {
    }

    @Override
    public void store(String contentId, byte[] data) {
        //ignore
    }
}
