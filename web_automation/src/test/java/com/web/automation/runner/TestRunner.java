package com.web.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",

        //monochrome = true,
        //dryRun = false,
        glue="com.web.automation.stepdefinition",
        plugin ={"html:target/cucumber-reports/cucumber.html",
                "html:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt",
                "junit:target/cucumber-results.xml"}
        //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}
)
public class TestRunner {

   /* @BeforeClass
    public void setReportConfiguration(){
        ExtentProperties property = ExtentProperties.INSTANCE;
        property.setReportPath("./Reports/Reports.html");
    }

    @AfterClass
    public static void setConfiguration(){
        Reporter.loadXMLConfig("./ConfigFiles/extent-config.xml");
    }*/
}
