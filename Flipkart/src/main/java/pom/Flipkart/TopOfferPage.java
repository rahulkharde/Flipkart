package pom.Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopOfferPage {
	
	WebDriver driver;
	Actions act;
	
//	WebElement electronics=driver.findElement(By.xpath("//div[text()='Electronics']"));
//	act.moveToElement(electronics).build().perform();
//	Thread.sleep(1000);
//	WebElement electronicsGstStore=driver.findElement(By.xpath("//a[text()='Electronics GST Store']"));
//	act.moveToElement(electronicsGstStore).click().build().perform();
	
	@FindBy (xpath="//div[text()='Top Offers']") private WebElement topOffers;
	
	
	
	public TopOfferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	} 
	
	public void selectTopOffers() {
		
		topOffers.click();
	}

}
