package test.Flipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pom.Flipkart.LoginPage;
import pom.Flipkart.LogoutPage;
import pom.Flipkart.TopOfferPage;

public class VerifyElectronicsPage {

	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\New Chrome\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	@BeforeMethod
	public void loginToFlipkart() throws InterruptedException {
		driver.get("https://flipkart.com/");
		LoginPage loginPage=new LoginPage(driver);
	
		Thread.sleep(4000);
	}
	@Test
	public void verifyselectTopOffersTab() {
		TopOfferPage topOffer = new TopOfferPage(driver);
		topOffer.selectTopOffers();
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void logoutFlipkart(){
		LogoutPage logoutPage=new LogoutPage(driver);
		logoutPage.logoutFromFlipkart();

	}
	@AfterClass
	public void exitBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}