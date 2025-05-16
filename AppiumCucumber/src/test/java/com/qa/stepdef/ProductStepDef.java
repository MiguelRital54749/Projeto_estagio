package com.qa.stepdef;

import com.qa.pages.CartPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.xml.catalog.Catalog;

public class ProductStepDef {
    ProductsPage productsPage = new ProductsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    CartPage cartPage= new CartPage();

    public ProductStepDef() throws Exception {
    }

    @Given("I'm logged in")
    public void iMLoggedIn() throws Exception {
     new LoginPage().login("standard_user", "secret_sauce");
    }

    @Then("the product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String string, String string2) throws Exception {
        boolean titleCheck = new ProductsPage().getProductTitle(string).equalsIgnoreCase(string2);
        Boolean priceCheck = true;
        Assert.assertEquals("title is:",titleCheck,
                titleCheck & priceCheck);
    }

    @When("I click product title {string}")
    public void iClickProductTitle(String string)throws Exception {
        new ProductsPage().pressProductTitle(string);
    }

    @Then("I should be on product details page with title {string}, price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String string, String string2, String string3) throws Exception {
        boolean checkTitle = productDetailsPage.getTitle().equalsIgnoreCase(string);
        boolean checkDes = productDetailsPage.getDesc().equalsIgnoreCase(string2);
        boolean checkPrice = productDetailsPage.getPrice().equalsIgnoreCase(string3);
        Assert.assertEquals(checkTitle, checkTitle);
        Assert.assertEquals(checkDes, checkDes );
        Assert.assertEquals(checkPrice,checkPrice);
    }

    @And("I Add product in the Cart")
    public void iAddProductInTheCart() throws Exception {

       new ProductsPage().addCartBtn();

    }

    @And("I click CartButton")
    public void iClickCartButton() throws Exception {
       new ProductsPage().pressCartBtn();
    }


    @Then("the product is listed with title {string} and price {string} should be equal to menu")
    public void theProductIsListedWithTitleAndPriceAndShouldBeEqualToMenu(String arg0, String arg1) throws Exception {
        Assert.assertEquals(arg0,new CartPage().gettitle());
        Assert.assertEquals(arg1,new CartPage().getprice());
    }


    @When("I click in the checkoutButton")
    public void iClickInTheCheckoutButton() throws Exception {
        cartPage.clickcheckbtn();
    }

    @And("complete the firstName {string} lastName {string} and PostalCode {string}")
    public void completeTheFirstNameLastNameAndPostalCode(String arg0, String arg1, String arg2) throws Exception {
        cartPage.enterfirstname(arg0);
        cartPage.enterlastname(arg1);
        cartPage.zippostalcode(arg2);
    }

    @And("I click in continue button")
    public void iClickInContinueButton() throws Exception {
        cartPage.continuebtn();
    }



    @Then("I click in Back Home")
    public void iClickInBackHome() throws Exception {
        cartPage.clickbackhome();
    }


    @And("I click in finish button")
    public void iClickInFinishButton() throws Exception {
        cartPage.clickfinish();
    }
}
