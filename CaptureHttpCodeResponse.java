package checkingConsoleError;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CaptureHttpCodeResponse {
	public static void main(String[] args) throws MalformedURLException, IOException {
		BrowserUtil bu = new BrowserUtil();
		WebDriver driver = bu.initializingDriver("Chrome");
		bu.maximizeWindow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		bu.lauchUrl("https://www.mytheresa.com/en-de/men.html");
		// wait of 5 seconds
		// establish and open connection with URL
		HttpURLConnection c = (HttpURLConnection) new URL("https://www.mytheresa.com/en-de/men.html").openConnection();
		// set the HEAD request with setRequestMethod
		c.setRequestMethod("HEAD");
		// connection started and get response code
		c.connect();
		int r = c.getResponseCode();
		System.out.println("Http response code: " + r);
		driver.quit();
	}
}
