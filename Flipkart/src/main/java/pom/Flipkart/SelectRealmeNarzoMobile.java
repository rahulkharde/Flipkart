package pom.Flipkart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectRealmeNarzoMobile {
	
	
	
	WebDriver driver;
	
	@FindBy (xpath="//a[contains(@href,'/realme-narzo-50a-oxygen-blue-128-gb/')]") private WebElement realmeNarzo;
	
	
	public SelectRealmeNarzoMobile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnRealmeNarzo() {
		Actions act = new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", realmeNarzo);
		act.moveToElement(realmeNarzo).click().build().perform();
		
	}


}
