package com.qa.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.File;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {

        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();
        DesiredCapabilities caps = new DesiredCapabilities();
        try {
            caps.setCapability("appium:noReset", true);
            caps.setCapability("appium:fullReset", false);
            caps.setCapability("normalizeTagNames", true);
            caps.setCapability("appium:logLevel","error");
            switch (params.getPlatformName()) {
                case "Android":
                    caps.setCapability("platformName", "Android");
                    caps.setCapability("automationName", props.getProperty("androidAutomationName"));
                     caps.setCapability("appium:appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appium:appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("app", "/Users/miguel.fernandes/Documents/Software/Apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                    utils.log().info("appUrl is" + props.getProperty("androidAppLocation"));
                    break;
                case "iOS":
                    caps.setCapability("platformName", "iOS");
                    caps.setCapability("deviceName", "iPhone 16 Pro Max");
                    caps.setCapability("automationName", props.getProperty("iOSAutomationName"));
                    caps.setCapability("platformVersion", "18.3");
                    caps.setCapability("platformVersion", "18.3");
                    caps.setCapability("newCommandTimeout","120000");
                    caps.setCapability("wdaLauchTimeout","120000");
                    caps.setCapability("appWaitDuration","120000");
                    caps.setCapability("deviceReadTimeout", 120);
                    caps.setCapability("autGrantPermissions", true);
                    caps.setCapability("ignoreHiddenApiPolicyError", true);
                    caps.setCapability("normalizeTagNames", true);
                    caps.setCapability("appium:bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("appium:app", props.getProperty("iOSAppLocation"));
                    caps.setCapability("appium:enforceAppInstall", true);
                    break;
            }
            System.out.println(caps);
        return caps;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(caps);
            throw e;
        }

    }


}
