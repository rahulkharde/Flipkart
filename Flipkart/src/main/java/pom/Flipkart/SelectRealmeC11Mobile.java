package pom.Flipkart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectRealmeC11Mobile {
	WebDriver driver;
	//js.executeScript("arguments[0].scrollIntoView(true);", realme95G)
	@FindBy(xpath="//a[contains(@href,'/realme-c11-2021-cool-blue-64-gb/p/')]") private WebElement realmeC11;

	
	public SelectRealmeC11Mobile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnRealmeC11() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", realmeC11);
		realmeC11.click();
	}
	
}
