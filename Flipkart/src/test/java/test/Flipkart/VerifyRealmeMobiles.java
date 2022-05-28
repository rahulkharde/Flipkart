

package test.Flipkart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import pom.Flipkart.LoginPage;
import pom.Flipkart.LogoutPage;
import pom.Flipkart.RealmeMobilePage;
import pom.Flipkart.SelectRealme9iMobile;
import pom.Flipkart.SelectRealmeC11Mobile;
import pom.Flipkart.SelectRealmeNarzoMobile;
import pom.Flipkart.TopOfferPage;
import test.BrowserSetting.BaseClass;
import until.Utility;

public class VerifyRealmeMobiles {
	WebDriver driver;
	LoginPage loginPage;
	TopOfferPage topOfferPage;
	RealmeMobilePage realMe;
	SelectRealmeNarzoMobile selectNarzo;
	SelectRealme9iMobile select9i;
	SelectRealmeC11Mobile selectC11;
	LogoutPage logout;

	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browser) {
		if (browser.equals("ChromeBrowser"))
		{
			driver=BaseClass.openChromeBrowser();
		}
		if (browser.equals("FirefoxBrowser"))
		{
			driver=BaseClass.openFirefoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	@BeforeClass
	public void objectOfPOMClass() {
		driver.get("https://flipkart.com/");
		loginPage=new LoginPage(driver);
		logout = new LogoutPage(driver);
		topOfferPage=new TopOfferPage(driver);
		realMe=new RealmeMobilePage(driver);
		selectNarzo=new SelectRealmeNarzoMobile(driver);
		select9i= new SelectRealme9iMobile(driver);
		selectC11=new SelectRealmeC11Mobile(driver);

	}
	@BeforeMethod
	public void loginToFlipkartAndSelectElectronics() throws InterruptedException, EncryptedDocumentException, IOException {
		loginPage.sendUserName(Utility.fetchData("TestData", 2, 0));
		loginPage.sendPassword(Utility.fetchData("TestData", 2, 1));
		loginPage.clickOnSiginIn();
		Thread.sleep(6000);
		topOfferPage.selectTopOffers();
		realMe.clickOnRealme();
		Thread.sleep(2000);

	}
	@Test (priority=1)
	public void selectRealmeNarzo50i() throws InterruptedException {

		selectNarzo.clickOnRealmeNarzo();
		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		String childBrowserAddr = addr.get(1);//index 1 for child browser
		driver.switchTo().window(childBrowserAddr);
		Thread.sleep(1000);
		//		SoftAssert s=new SoftAssert();
		//		s.assertNotEquals(driver.getTitle(), "realme Narzo 50i ( 64 GB Storage, 4 GB RAM ) Online at Best Price On Flipkart.com");
		//		s.assertAll();
		System.out.println(driver.getTitle());

	}
	@Test (priority=2)
	public void selectRealmeC11() throws InterruptedException {
		selectC11.clickOnRealmeC11();
		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		String childBrowserAddr = addr.get(2);//index 1 for child browser
		driver.switchTo().window(childBrowserAddr);
		Thread.sleep(1000);
		//		SoftAssert s2=new SoftAssert();
		//		s2.assertEquals(driver.getTitle(), "realme C11 2021 ( 64 GB Storage, 4 GB RAM ) Online at Best Price On Flipkart.com");
		//		s2.assertAll();
		System.out.println(driver.getTitle());
	}
	@Test (invocationCount=0)
	public void selectRealme9i() throws InterruptedException {
		select9i.clickOnRealme9i();
		Thread.sleep(4000);
		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		String childBrowserAddr = addr.get(3);//index 1 for child browser
		driver.switchTo().window(childBrowserAddr);
		Thread.sleep(4000);
		//		SoftAssert s3=new SoftAssert();
		//		s3.assertEquals(driver.getTitle(), "realme 9i ( 128 GB Storage, 6 GB RAM ) Online at Best Price On Flipkart.com");
		//		s3.assertAll();
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void logoutFlipkart() throws InterruptedException{
		Thread.sleep(2000);
		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		String childBrowserAddr = addr.get(0);//index 1 for child browser
		driver.switchTo().window(childBrowserAddr);
		logout.logoutFromFlipkart();
		//System.out.println(driver.getTitle());
	}
	@AfterClass
	public void nullAllObject() throws InterruptedException
	{
		loginPage=null;
		topOfferPage=null;
		realMe=null;
		selectNarzo=null;
		select9i=null;
		selectC11=null;
		logout=null;

	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
		driver=null;
		System.gc();
		
	}


}
