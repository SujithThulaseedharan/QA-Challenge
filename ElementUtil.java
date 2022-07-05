package checkingConsoleError;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public WebDriver driver;

	public ElementUtil(WebDriver driver) { // Using constructor
		this.driver = driver;
	}

	public WebElement getElement(By locator) { // Base Code
		return driver.findElement(locator);

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}

		}
		return eleTextList;
	}

	public void printAllElementText(By locator) {
		getElementsTextList(locator).stream().forEach(e -> System.out.println(e));
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	public void doClick(By locator) {
		getElement(locator).click();

	}

	public String doGetText(By locator) {
		return getElement(locator).getText();

	}

	public void doSelectDropDownListByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownListByValue(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.deselectByValue(text);

	}

	public void doSelectDropDownListByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.deselectByVisibleText(text);

	}

	public void doGetDropDownList(By locator) {

		Select select = new Select(getElement(locator));
		List<WebElement> getOptionList = select.getOptions();
		getOptionList.stream().forEach(e -> System.out.println(e.getText()));

	}

	public void doSelectvalueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		for (WebElement e : optionList) {
			if (e.getText().equals(value)) {
				e.click();
				break;

			}

		}

	}

	public Alert waitForAlret(Duration TimeOut) {

		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public Alert acceptAlert(Duration TimeOut) {

		waitForAlret(TimeOut).accept();
		return null;

}
}
