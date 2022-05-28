package pom.Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	@FindBy (xpath="(//input[@autocomplete='off'])[2]") private WebElement userName;

	@FindBy (xpath="(//input[@autocomplete='off'])[3]") private WebElement password;

	@FindBy (xpath="(//button[@type='submit'])[2]") private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

//	public void loginToFlipkart() {
//		userName.sendKeys("9011224143");
//		password.sendKeys("rahul@123");
//		loginButton.click();
//	}
	public void sendUserName(String mobileNo) {
		userName.sendKeys(mobileNo);
	}
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnSiginIn() {
		loginButton.click();
	}
	
}
