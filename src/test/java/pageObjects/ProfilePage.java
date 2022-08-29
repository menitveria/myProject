package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends NavigationPage {

	@FindBy(css = ".nav-right__user-profile>button")
	private WebElement nameFiled;

	@FindBy(css = " div.nav-right__user > div > div > div > a")
	private WebElement profilefield;

	@FindBy(css = " div:nth-child(3) > div.profile-section__header > div > button > svg")
	private WebElement editPrefenceFiled;

	@FindBy(css = " #purpose > div > div.m-select__indicators.css-l5shxb")
	private WebElement purposeFiled;

	@FindBy(css = " #react-select-purpose-option-1")
	private WebElement familyTripFiled;

	@FindBy(css = " #financial_standard > div > div.m-select__indicators.css-l5shxb")
	private WebElement FinancialStandardFiled;

	@FindBy(css = "#react-select-financial_standard-option-1 ")
	private WebElement economyFiled;

	@FindBy(css = "[type='submit'] ")
	private WebElement saveFiled;

	@FindBy(css = "div.profile-save-interests > form > label:nth-child(1) ")
	private WebElement msginProfilePage;

	public ProfilePage(WebDriver driver) {
		super(driver);

	}

	// click on name and choose profile
	public void openProfile() {
		waiting(1000);
		mouseToWebElement(nameFiled);
		click(profilefield);
		waiting(1000);
		js.executeScript("window.scrollBy(0, 150)");

	}

	// edit my prefence
	public void editProfile() {
		click(editPrefenceFiled);
		waiting(1000);
		click(purposeFiled);
		waiting(1000);
		click(familyTripFiled);
	}

	public void chooseFinancialstandard() {
		click(FinancialStandardFiled);
		waiting(1000);
		click(economyFiled);
		waiting(1000);
		click(saveFiled);
	}

	public String getMsginProfilePage() {
		waiting(2500);
		String msg = getText(msginProfilePage);
		return msg;

	}
}