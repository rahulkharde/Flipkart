package test.BrowserSetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\New Chrome\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\firefox\\geckodriver.exe");
		WebDriver driver =new FirefoxDriver();
		return driver;
	}
	public static WebDriver openIEBrowser() {
		System.setProperty("webdriver.ie.driver","D:\\selenium\\IE\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		return driver;

}
}