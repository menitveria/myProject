package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;

	JavascriptExecutor js;
	private WebDriverWait wait;
	private Actions action;
	private String mainWindow;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		action = new Actions(driver);
	}

	public void fillText(WebElement el, String Text) {
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(Text);
	}

	public void click(WebElement el) {
		// js.executeScript("arguments[0].setAttribute('style','background-color:yellow;border:
		// 1px solid blue;');", el);//
		highlightElement(el, "yellow");
		waiting(2500);
		el.click();
	}

	// Wait
	void waitForVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	void waitForInVisibilityOf(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}

	void waitForClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void waiting(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(WebElement el) {
		return el.getText();
	}

	public void selectByValue(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByValue(value);
	}

	public void alertOk(String Text) {
		driver.switchTo().alert().sendKeys(Text);
		driver.switchTo().alert().accept();
	}

	// windows
			public void moveToNewWindow() {
				mainWindow = driver.getWindowHandle();
				Set<String> list = driver.getWindowHandles();
				for (String win : list) {
					System.out.println(win);
					driver.switchTo().window(win);
				}
			}
			public void moveToMainWindow() {
				driver.close();
				driver.switchTo().window(mainWindow);
				waiting(2000);
			}

	// Test validation method - test that the element is displayed
	public boolean validitionByEl(WebElement element) {
		boolean actual = element.isDisplayed();
		return actual;
	}

	// Call this method with your element and a color like (red,green,orange etc...)

	private void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:yellow;border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

	// mouse action
	public void mouseToWebElement(WebElement el) {

		action.moveToElement(el).build().perform();
	
	}
	
	public void mouseMove(WebElement el) {
		action.moveByOffset(0, 100).click().build().perform();
	}
	
}