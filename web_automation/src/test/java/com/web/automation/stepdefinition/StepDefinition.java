package com.web.automation.stepdefinition;

import com.web.automation.base.DriverInstance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.desktop.SystemEventListener;

import static org.junit.Assert.assertEquals;


public class  StepDefinition {
    WebDriver driver=null;
    private double total=0;

    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {

        System.setProperty("webdriver.chrome.driver","Driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();


    }

    @When("^User enters username$")
    public void user_enters_username() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
    }

    @When("^User enters password$")
    public void user_enters_password() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
    }

    @Then("^User clicks on signing button$")
    public void user_clicks_on_signing_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @And("User adds two products to cart {string} {string}")
    public void userAddsTwoProductsToCart(String arg0, String arg1) {
        driver.findElement(By.id(arg0)).click();
        driver.findElement(By.id(arg1)).click();
    }

    @And("User clicks on shopping cart")
    public void userClicksOnShoppingCart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And("User clicks checkout")
    public void userClicksCheckout() {
        driver.get("https://www.saucedemo.com/cart.html");
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        
    }

    @And("User add the information with firstName {string}, lastName {string} and zipCode {string}")
    public void userAddTheInformationWithFirstNameLastNameAndZipCode(String arg0, String arg1, String arg2) {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(arg0);
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(arg1);
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(arg2);
    }

    @Then("Verify if the total price is correct")
    public void verifyIfTheTotalPriceIsCorrect() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");

        String p1= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        String p1clean=p1.replace("$","").replace(",",".").trim();
        double p1final= Double.parseDouble(p1clean);

        String p2= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
        String p2clean=p2.replace("$","").replace(",",".").trim();
        double p2final= Double.parseDouble(p2clean);
        String taxa= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")).getText();
        String taxaclean=taxa.replaceAll("[^0-9.]","");
        double taxafinal= Double.parseDouble(taxaclean);
        String total_price=driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).getText();
        String total_price_clean= total_price.replaceAll("[^0-9.]","");
        double total_price_final= Double.parseDouble(total_price_clean);

        double bigequal=p1final+p2final+ taxafinal;
        if(bigequal == total_price_final){
            System.out.println("Valor final corresponde");
        }else{
            System.out.println("Valor final não corresponde");
            Assert.fail("Wrong price");
        }

    }



    @And("User clicks cancel")
    public void userClicksCancel() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        driver.findElement(By.xpath("//*[@id=\"cancel\"]")).click();

    }

    @Then("user finalize the buy and return to initial page")
    public void userFinalizeTheBuyAndReturnToInitialPage() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        driver.get("https://www.saucedemo.com/checkout-complete.html");
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }

    @And("User click in the continue")
    public void userClickInTheContinue() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }


    @And("User remove the item {string} from the cart")
    public void userRemoveTheItemFromTheCart(String arg0) {
        driver.findElement(By.id(arg0)).click();

    }

    @Then("Verify if the item {string} is remove")
    public void verifyIfTheItemIsRemove(String arg0) {
        boolean helper = driver.findElements(By.id(arg0)).isEmpty();
        if(!helper){
            System.out.println("Fail to remove");
        }else{
            System.out.println("esta lá");
        }

    }

    @And("User adds two products to cart {string}")
    public void userAddsTwoProductsToCart(String arg0) {
        driver.findElement(By.id(arg0)).click();
    }
}
