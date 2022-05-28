package pom.Flipkart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectRealme9iMobile {
	
	WebDriver driver;
	//js.executeScript("arguments[0].scrollIntoView(true);", realme95G)
	@FindBy(xpath="//a[contains(@href,'/realme-9i-prism-blue-128-gb')]") private WebElement realme9i;

	
	public SelectRealme9iMobile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnRealme9i() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", realme9i);
		realme9i.click();
	}
	
}
