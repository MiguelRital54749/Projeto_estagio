package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;

public class CartPage extends MenuPage{

    @AndroidFindBy(accessibility = "test-First Name")
    private WebElement firstName;

    @AndroidFindBy(accessibility = "test-Last Name")
    private WebElement lastName;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement Zippostalcode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")
    private WebElement continuebtn;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]")
    private WebElement checkbtn;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]\n"+"")
    private WebElement titleitem;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView[1]\n"+        "")
    private WebElement price;


    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-FINISH\"]")
    private WebElement finish;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")
    private WebElement backhome;


    public CartPage() throws Exception {
    }

    public void enterfirstname(String Firstname){
        clear(firstName);
        sendKeys(firstName,Firstname);
    }

    public void enterlastname(String lastname){
        clear(lastName);
        sendKeys(lastName,lastname);
    }

    public void zippostalcode(String Postalcode){
        clear(Zippostalcode);
        sendKeys(Zippostalcode,Postalcode);
    }

    public String gettitle() throws Exception{
        return getText(titleitem);
    }



    public void clickcheckbtn()throws Exception{
        click(checkbtn);
    }
    public void continuebtn()throws Exception{
        click(continuebtn);
    }

    public String getprice() throws Exception{
        return getText(price);
    }

    public void clickfinish() throws Exception{
        andScrollToElementUsingUiScrollable("description","test-FINISH");
        click(finish);
    }

    public void clickbackhome() throws Exception{
        click(backhome);
    }

}
