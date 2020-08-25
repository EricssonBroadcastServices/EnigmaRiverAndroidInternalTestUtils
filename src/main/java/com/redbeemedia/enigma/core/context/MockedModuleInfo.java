package com.redbeemedia.enigma.core.context;

public abstract class MockedModuleInfo<I extends IModuleInitializationSettings> implements IModuleInfo<I> {
    private final IModuleInfo<I> moduleInfo;

    public MockedModuleInfo(IModuleInfo<I> moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    @Override
    public String getModuleId() {
        return moduleInfo.getModuleId();
    }
}
