package pom.Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	

	WebDriver driver;
	Actions act;
	
	@FindBy (xpath="//div[text()='Rahul']") private WebElement rahul;
	@FindBy (xpath="//div[text()='Logout']") private WebElement logout;
	
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void logoutFromFlipkart(){
		act=new Actions(driver);
		act.moveToElement(rahul).build().perform();
		act.moveToElement(logout).click().build().perform();
	}
}
