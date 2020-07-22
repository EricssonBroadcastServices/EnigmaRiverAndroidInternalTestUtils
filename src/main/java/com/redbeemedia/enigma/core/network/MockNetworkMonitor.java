package com.redbeemedia.enigma.core.network;

import android.os.Handler;

import com.redbeemedia.enigma.core.util.Collector;
import com.redbeemedia.enigma.core.util.HandlerWrapper;
import com.redbeemedia.enigma.core.util.OpenContainer;
import com.redbeemedia.enigma.core.util.OpenContainerUtil;

public class MockNetworkMonitor implements INetworkMonitor {
    private final ListenerCollector listeners = new ListenerCollector();
    private final OpenContainer<Boolean> internetAccess = new OpenContainer<>(true);

    @Override
    public boolean hasInternetAccess() {
        return OpenContainerUtil.getValueSynchronized(internetAccess);
    }

    public MockNetworkMonitor setInternetAccess(boolean value) {
        OpenContainerUtil.setValueSynchronized(internetAccess, value, (oldValue, newValue) -> {
            listeners.onInternetAccessChanged(newValue);
        });
        return this;
    }

    @Override
    public boolean addListener(INetworkMonitorListener listener) {
        return listeners.addListener(listener);
    }

    @Override
    public boolean addListener(INetworkMonitorListener listener, Handler handler) {
        return listeners.addListener(listener, new HandlerWrapper(handler));
    }

    @Override
    public boolean removeListener(INetworkMonitorListener listener) {
        return listeners.removeListener(listener);
    }

    private static class ListenerCollector extends Collector<INetworkMonitorListener> implements INetworkMonitorListener {
        public ListenerCollector() {
            super(INetworkMonitorListener.class);
        }

        @Override
        public void _dont_implement_INetworkMonitorListener___instead_extend_BaseNetworkMonitorListener_() {
        }

        @Override
        public void onInternetAccessChanged(boolean internetAccess) {
            forEach(listener -> listener.onInternetAccessChanged(internetAccess));
        }
    }
}
