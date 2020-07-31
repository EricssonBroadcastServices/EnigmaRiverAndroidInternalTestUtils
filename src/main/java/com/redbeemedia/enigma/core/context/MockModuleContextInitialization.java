package com.redbeemedia.enigma.core.context;

import android.app.Application;

public class MockModuleContextInitialization implements IModuleContextInitialization {
    @Override
    public Application getApplication() {
        return null;
    }

    @Override
    public <I extends IModuleInitializationSettings> I getModuleSettings(IModuleInfo<I> moduleInfo) {
        return null;
    }
}
