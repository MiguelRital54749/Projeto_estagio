package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.core.snippets.SnippetType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber/", "summary"}
        , features = {"src/test/resources/features"}
        , glue = {"com.qa.stepdef"}
        //,snippets = CucumberOptions.SnippetType.CAMELCASE
        //,dryRun = true
        //,monochrome = true
        ,tags = "@test"

)

public class MyRunnerTest {
    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getDeviceName());
        new ServerManager().starServer();
        new DriverManager().initializeDriver();
    }

    @AfterClass
    public static void quit() throws Exception {
        ServerManager serverManager= new ServerManager();
        if(serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }
        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver()!=null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
    }
}
