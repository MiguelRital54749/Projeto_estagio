package com.web.automation.base;

import com.web.automation.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverInstance  {
    static WebDriver driver = null;

    public static WebDriver startDriverInstance() throws IOException {
        if(ConfigReader.readProjectConfiguration("BrowserName").equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
            driver = new ChromeDriver();
        } else if (ConfigReader.readProjectConfiguration("BrowserName").equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","Driver/geckodriver");
            driver = new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.readProjectConfiguration("ApplicationURL"));
        return driver;
    }

    public static WebDriver getDriverInstance() throws IOException {
        if(driver!=null){
            return driver;
        }else{
            DriverInstance.startDriverInstance();
            return driver;
        }
    }

    public static void setDriverInstanceNull(){
        driver=null;;
    }

}
