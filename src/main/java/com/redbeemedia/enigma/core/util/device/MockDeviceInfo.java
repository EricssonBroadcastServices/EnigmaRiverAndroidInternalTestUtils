package com.redbeemedia.enigma.core.util.device;

public class MockDeviceInfo implements IDeviceInfo {
    private String deviceId = "JUnitDevice";
    @Override
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String getModel() {
        return "testModel";
    }

    @Override
    public String getOS() {
        return "os";
    }

    @Override
    public String getOSVersion() {
        return "v0";
    }

    @Override
    public String getManufacturer() {
        return "manufacturer";
    }

    @Override
    public boolean isDeviceRooted() {
        return false;
    }

    @Override
    public String getWidevineDrmSecurityLevel() {
        return "N/A (JUnit)";
    }

    @Override
    public int getWidthPixels() {
        return 640;
    }

    @Override
    public int getHeightPixels() {
        return 480;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getType() {
        return "MOCK";
    }

    @Override
    public String getAppType() {
        return "android-app-type";
    }
}
