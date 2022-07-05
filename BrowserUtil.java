package checkingConsoleError;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	public WebDriver driver;

	/**
	 * 
	 * @param browserName
	 * @return this will return the driver.
	 */

	public WebDriver initializingDriver(String browserName) {

		System.out.println("Browser Name is " + browserName);

//It will not check the spelling if we apply the below comment(toLowerCase())
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;

		default:
			System.out.println("Please pass the right browser details");
			break;

		}
		return driver;

	}

	public void lauchUrl(String Url) {
		if (Url.isEmpty())
			return;
		driver.get(Url);

	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public String getPageUrl() {
		return driver.getCurrentUrl();

	}

	public void closeBrowser() {
		driver.close();
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

}
