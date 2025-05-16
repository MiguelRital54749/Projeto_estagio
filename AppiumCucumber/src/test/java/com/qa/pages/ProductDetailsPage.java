package com.qa.pages;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ProductDetailsPage extends MenuPage {
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]\n" + 
			"") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[1]")
	private WebElement title;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]"
			+ "") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Description\"]/child::XCUIElementTypeStaticText[2]")
	private WebElement desc;


	@AndroidFindBy (accessibility = "test-BACK TO PRODUCTS") 
	@iOSXCUITFindBy (id = "test-BACK TO PRODUCTS")
	private WebElement backToProductsBtn;

	@iOSXCUITFindBy (id = "test-Price")
	private WebElement iOSProductPrice;

	@iOSXCUITFindBy (id = "test-ADD TO CART") private WebElement addToCartBtn;

	public ProductDetailsPage() throws Exception {
	}

	public String getTitle() throws IOException {
	return getText(title);
}

public String getDesc() throws IOException {
	return getText(desc);
}

public String getPrice() throws Exception {
	switch(new GlobalParams().getPlatformName()){
		case "Android":
			return getText(andScrollToElementUsingUiScrollable("description", "test-Price"));
		case "iOS":
			return getText(iOSScrollToElementUsingMobileScroll(iOSProductPrice));
		default:
			throw new Exception("Invalid platform name");
	}
}

public Boolean isAddToCartBtnDisplayed() {
	return addToCartBtn.isDisplayed();
}

public ProductsPage pressBackToProductsBtn() throws Exception {
	click(backToProductsBtn);
	return new ProductsPage();
}



}
