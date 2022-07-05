package checkingConsoleError;

public class GitHubOpenPullRequest {

	public static void main(String[] args) {
		
		
		BrowserUtil bu = new BrowserUtil();
		bu.initializingDriver("Chrome");
		bu.maximizeWindow();
		bu.lauchUrl("https://github.com/appwrite/appwrite/pulls");
	//	List<WebElement> rows = driver.findElements
		
		
	}

}
