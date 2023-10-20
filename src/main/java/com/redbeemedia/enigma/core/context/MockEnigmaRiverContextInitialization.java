package com.redbeemedia.enigma.core.context;

import com.redbeemedia.enigma.core.activity.IActivityLifecycleManagerFactory;
import com.redbeemedia.enigma.core.activity.MockActivityLifecycleManagerFactory;
import com.redbeemedia.enigma.core.analytics.EnigmaStorageManager;
import com.redbeemedia.enigma.core.epg.IEpgLocator;
import com.redbeemedia.enigma.core.epg.MockEpgLocator;
import com.redbeemedia.enigma.core.http.IHttpHandler;
import com.redbeemedia.enigma.core.http.MockHttpHandler;
import com.redbeemedia.enigma.core.network.INetworkMonitor;
import com.redbeemedia.enigma.core.network.MockNetworkMonitor;
import com.redbeemedia.enigma.core.ads.IAdInsertionFactory;
import com.redbeemedia.enigma.core.task.ITaskFactory;
import com.redbeemedia.enigma.core.task.ITaskFactoryProvider;
import com.redbeemedia.enigma.core.task.MockTaskFactoryProvider;
import com.redbeemedia.enigma.core.util.device.IDeviceInfo;
import com.redbeemedia.enigma.core.util.device.MockDeviceInfo;

public class MockEnigmaRiverContextInitialization extends EnigmaRiverContext.EnigmaRiverContextInitialization {
    public MockEnigmaRiverContextInitialization() {
        super("https://mock.unittests.example.com");
        setDeviceInfo(new MockDeviceInfo());
        setHttpHandler(new MockHttpHandler());
        setActivityLifecycleManagerFactory(new MockActivityLifecycleManagerFactory());
        setTaskFactoryProvider(new MockTaskFactoryProvider());
        setEpgLocator(new MockEpgLocator());
        setNetworkMonitor(new MockNetworkMonitor());
        setStorageManager(new MockEngimaStoreManager(null));
    }

    @Override
    public MockEnigmaRiverContextInitialization setDeviceInfo(IDeviceInfo deviceInfo) {
        return (MockEnigmaRiverContextInitialization) super.setDeviceInfo(deviceInfo);
    }

    @Override
    public MockEnigmaRiverContextInitialization setHttpHandler(IHttpHandler httpHandler) {
        return (MockEnigmaRiverContextInitialization) super.setHttpHandler(httpHandler);
    }

    @Override
    public MockEnigmaRiverContextInitialization setAnalyticsUrl(String analyticsUrl) {
        return (MockEnigmaRiverContextInitialization) super.setAnalyticsUrl(analyticsUrl);
    }

    @Override
    public MockEnigmaRiverContextInitialization setExposureBaseUrl(String exposureBaseUrl) {
        return (MockEnigmaRiverContextInitialization) super.setExposureBaseUrl(exposureBaseUrl);
    }

    @Override
    public MockEnigmaRiverContextInitialization setActivityLifecycleManagerFactory(IActivityLifecycleManagerFactory activityLifecycleManagerFactory) {
        return (MockEnigmaRiverContextInitialization) super.setActivityLifecycleManagerFactory(activityLifecycleManagerFactory);
    }

    @Override
    public MockEnigmaRiverContextInitialization setTaskFactory(ITaskFactory taskFactory) {
        return (MockEnigmaRiverContextInitialization) super.setTaskFactory(taskFactory);
    }

    @Override
    public MockEnigmaRiverContextInitialization setEpgLocator(IEpgLocator epgLocator) {
        return (MockEnigmaRiverContextInitialization) super.setEpgLocator(epgLocator);
    }

    @Override
    public MockEnigmaRiverContextInitialization setTaskFactoryProvider(ITaskFactoryProvider taskFactoryProvider) {
        return (MockEnigmaRiverContextInitialization) super.setTaskFactoryProvider(taskFactoryProvider);
    }

    @Override
    public MockEnigmaRiverContextInitialization setNetworkMonitor(INetworkMonitor networkMonitor) {
        return (MockEnigmaRiverContextInitialization) super.setNetworkMonitor(networkMonitor);
    }

    @Override
    public MockEnigmaRiverContextInitialization setAdInsertionFactory(IAdInsertionFactory adInsertionFactory) {
        return (MockEnigmaRiverContextInitialization) super.setAdInsertionFactory(adInsertionFactory);
    }

    @Override
    public MockEnigmaRiverContextInitialization setStorageManager(EnigmaStorageManager storageManager) {
        return (MockEnigmaRiverContextInitialization) super.setStorageManager(storageManager);
    }
}
