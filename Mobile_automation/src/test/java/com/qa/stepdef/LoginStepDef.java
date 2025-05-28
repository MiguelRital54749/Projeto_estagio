package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
    private AppiumDriver driver;
    @When("I enter username as {string}")
    public void iEnterUsernameAs(String username) throws Exception {
        new LoginPage().enterUserName(username);
    }

    @When("I enter password as {string}")
    public void iEnterPasswordAs(String password) throws Exception {
        new LoginPage().enterPassword(password);
    }

    @When("I login")
    public void iLogin() throws Exception {
        new LoginPage().pressLoginBtn();
    }

    @Then("login should fail with an error {string}")
    public void loginShouldFailWithAnError(String err) throws Exception {
        Assert.assertEquals(new LoginPage().getErrTxt(), err);
    }

    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) throws Exception {
        Assert.assertEquals(new ProductsPage().getTitle(), title);

    }


}
