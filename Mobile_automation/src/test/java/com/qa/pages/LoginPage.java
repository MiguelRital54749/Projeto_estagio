package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy (accessibility = "test-Username")
	@iOSXCUITFindBy (id = "test-Username")
	private WebElement usernameTxtFld;

	@AndroidFindBy (accessibility = "test-Password")
	@iOSXCUITFindBy (id = "test-Password")
	private WebElement passwordTxtFld;
	
	@AndroidFindBy (accessibility = "test-LOGIN") 
	@iOSXCUITFindBy (id = "test-LOGIN")
	private WebElement loginBtn;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private WebElement errTxt;

	public LoginPage() throws Exception {
        super();
    }

public void enterUserName(String username) throws InterruptedException {
	clear(usernameTxtFld);	
	sendKeys(usernameTxtFld, username);

}

public LoginPage enterPassword(String password) {
	clear(passwordTxtFld);
	sendKeys(passwordTxtFld, password, "password is " + password);
	return this;
}

public ProductsPage pressLoginBtn() throws Exception {
	click(loginBtn);
	return new ProductsPage();
}

public ProductsPage login(String username, String password) throws Exception {
	enterUserName(username);
	enterPassword(password);
	return pressLoginBtn();
}

public String getErrTxt() throws IOException {
	String err = getText(errTxt, "error text is - ");
	return err;
}

}
