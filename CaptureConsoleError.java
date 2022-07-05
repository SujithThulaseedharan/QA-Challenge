package checkingConsoleError;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


public class CaptureConsoleError {

	public static void main(String[] args) {
		BrowserUtil bu = new BrowserUtil();
		WebDriver driver = bu.initializingDriver("Chrome");
		bu.maximizeWindow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));			
		bu.lauchUrl("https://www.mytheresa.com/en-de/men.html");
		List<LogEntry> entries = driver.manage().logs().get(LogType.BROWSER).getAll();
		System.out.println(entries.size() + " " + LogType.BROWSER + " log entries found");
		for (LogEntry entry : entries) {
			System.out.println(entry.getMessage());
			System.out.println("Level is: \n" + entry.getLevel());
		}
		driver.quit();
			
			
	
		
	}

}