package checkingConsoleError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class TestLogin {

	public static void main(String[] args) {
		BrowserUtil bu = new BrowserUtil();
		WebDriver driver = bu.initializingDriver("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		bu.maximizeWindow();
		bu.lauchUrl("https://www.mytheresa.com/ende/men.html");
		String title = driver.getTitle();
		// Title Verification
		System.out.println(title);
		if (title.equals("Men's Luxury Fashion & Designer Shopping | Mytheresa")) {
			System.out.println("Valid URL");
		} else {
			System.out.println("Invalid URL");
		}
		ElementUtil lg = new ElementUtil(driver);
		By Login = By.id("myaccount");
		lg.doClick(Login);
		By Email = By.xpath("//input[@class=\"input-text validate-latin-only required-entry validate-email\"]");
		lg.doSendKeys(Email, "sujitht@maildrop.cc");
		By Password = By.xpath("//input[@class=\"input-text required-entry validate-latin-only validate-password\"]");
		lg.doSendKeys(Password, "Maildrop@cc");
		By Button = By.xpath("//div[@class=\"buttons-set\" and @id=\"qa-login-button\"]//button[@id=\"send2\"]");
		lg.doClick(Button);
		// Get the title of the page.
		String title1 = driver.getTitle();
		// Title Verification
		System.out.println(title);
		if (title1.equals("My account")) {
			System.out.println("Valid URL");
		} else {
			System.out.println("Error found in the page");
		}
		System.out.println(driver.getCurrentUrl());
	}

}
