package pom.Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealmeMobilePage {
	WebDriver driver;
	
	@FindBy (xpath="//span[text()='Electronics']") private WebElement electronicsNextPage;
	@FindBy (xpath="//a[text()='Realme']") private WebElement realme;
	
	public RealmeMobilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnRealme() {
		Actions act =new Actions(driver);
		act.moveToElement(electronicsNextPage).build().perform();
		act.moveToElement(realme).click().build().perform();
	}

}
