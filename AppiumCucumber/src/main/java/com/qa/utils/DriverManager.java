package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class DriverManager {
    public static AppiumServiceBuilder Builder;
    private ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver() throws Exception {
        setDriver(initializeDriver());
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }



    public AppiumDriver initializeDriver() throws Exception {
        AppiumDriver driver=null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();

            try {
                switch (params.getPlatformName()){
                    case "Android":
                        System.out.println("Starting Server");

                        driver = new AndroidDriver(new ServerManager().getAppiumServerDefault(), new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerManager().getServer(), new CapabilitiesManager().getCaps());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null!!!");
                }
                this.driver.set(driver);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }

        return driver;
    }
}
