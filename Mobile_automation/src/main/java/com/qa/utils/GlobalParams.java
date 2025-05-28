package com.qa.utils;

import java.io.IOException;

public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();

    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName() throws IOException {
        String plat=new PropertyManager().getProps().getProperty("platformName");

        return plat;
    }

    public void setUdid(String udid1){
        udid.set(udid1);
    }
    public String getudid(){
        return udid.get();
    }

    public void setDeviceName(String deviceName1){
        deviceName.set(deviceName1);
    }
    public String getDeviceName(){
        return deviceName.get();
    }

    public void setSystemPort(String systemPort1){
        systemPort.set(systemPort1);
    }
    public String getSystemPort(){
        return systemPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort1){
        chromeDriverPort.set(chromeDriverPort1);
    }
    public String getChromeDriverPort(){
        return chromeDriverPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort1){
        wdaLocalPort.set(wdaLocalPort1);
    }
    public String getWdaLocalPort(){
        return wdaLocalPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort1){
        webkitDebugProxyPort.set(webkitDebugProxyPort1);
    }
    public String getWebkitDebugProxyPort(){
        return webkitDebugProxyPort.get();
    }

    public void initializeGlobalParams() throws IOException {
        GlobalParams params= new GlobalParams();
        params.setPlatformName(System.getProperty("platformName","Android"));
        params.setPlatformName(System.getProperty("udid","emulator-5554"));
        params.setPlatformName(System.getProperty("deviceName","Pixel_9"));

        switch (params.getPlatformName()){
            case "Android":
                params.setSystemPort(System.getProperty("systemPort","10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort","11000"));
                break;
            case "iOS":
                params.setWdaLocalPort(System.getProperty("appium:WdaLocalPort","10001"));
                params.setWebkitDebugProxyPort(System.getProperty("appium:WebkitDebugProxyPort","11001"));
                break;
            default:
                throw new IllegalStateException("Plataforma inválida!");
        }
    }

}
