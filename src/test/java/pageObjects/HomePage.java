package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends NavigationPage {

	// change Currency
	@FindBy(css = ".nav-right__toggle>.btn")
	private WebElement languageBtn;

	@FindBy(css = ".locale-settings-list>button:nth-child(2) > span:nth-child(2)")
	private WebElement languageEnglishBtn;
	@FindBy(css = "header .locale-settings__tab:nth-child(2)")
	private WebElement currencyBtn;
	@FindBy(css = "button:nth-child(2) > span:nth-child(2)")
	private WebElement currencyDollar;

	@FindBy(css = "button:nth-child(3) > span:nth-child(2)")
	private WebElement currencyEuro;

	// firstbtnPlanTrip

	@FindBy(css = " div > div > div.home-hero__button > a")
	private WebElement startPlaningFirstBtn;

	// secondbtnplantrip

	@FindBy(css = " div:nth-child(1) > div.flows__item-btn.hide-xs.show-md > button")
	private WebElement startPlaningSecondtBtn;

	@FindBy(css = "div.flows > div:nth-child(2) > div.flows__item-btn.hide-xs.show-md > button")
	private WebElement inspireMeBtn;

	@FindBy(css = "  div > div > div > form > div > div > div > div.hide-xs.show-md > div > button")
	private WebElement nextStepBtn;

	@FindBy(css = " div.purpose-form__submit > button")
	private WebElement nextStepBtn2;

	@FindBy(css = " div.create-trip__subtitle")
	private WebElement msgPagePlanTrip;

	// choosePopularDestination

	@FindBy(css = " div.destination-form__list-items > button:nth-child(1)")
	private WebElement choosePopularDestinationBtn;

	// choose place

	@FindBy(css = ".rs-select2__input input")
	private WebElement destinationFiled;

	@FindBy(css = ".rs-select2__option span")
	private WebElement listDestinations;

	@FindBy(css = ".home-hero-menu")
	private WebElement datesFiled;

	@FindBy(css = "  div.dates-form__picker > div.search-dates-menu > div.search-dates-menu__controls > button")
	private WebElement FlexibleDatesBtn;

	@FindBy(css = "toaster__title")
	private WebElement successMsg;

	@FindBy(css = "div.trip2-hero__button > button")
	private WebElement saveTripBtn;

	@FindBy(css = ".flatpickr-current-month > span")
	private List<WebElement> month;

	@FindBy(css = "span.flatpickr-next-month")
	private WebElement clickNextMonthBtn;

	@FindBy(css = ".Toastify>div>div>div.Toastify__toast-body")
	private WebElement erorMsg;

	@FindBy(css = ".react-joyride__tooltip")
	private WebElement screenBlock;

	@FindBy(css = "div.Toastify__toast-body>div.toaster__title")
	private WebElement getSuccesAfterSaveTrip;

	// backToMainPage

	@FindBy(css = "#__next > header > div > div > a")
	private WebElement mainPageBtn;

	// destinationSuggestion

	@FindBy(css = ".hero-desktop__tabs > button:nth-child(2)")
	private WebElement destinationSuggestionBtn;

	@FindBy(css = " div.hero-desktop__bar > form > div:nth-child(1)")
	private WebElement purposeBtn;

	@FindBy(css = "   div.purpose-form__body > div > ul > li:nth-child(4) > button")
	private WebElement catgoryNaturalGreenBtn;

	@FindBy(css = "form > div:nth-child(3) > div > div:nth-child(1) > div > div")
	private WebElement suggestionDatesFiled;

	@FindBy(css = "  header > div > div > a")
	private WebElement shichorBtn;

	@FindBy(css = " ul > li:nth-child(3) > div.interests-list__item--slider")
	private WebElement culturalEventBtn;

	@FindBy(css = " div.interests-form__submit > button")
	private WebElement shoewResult2Btn;

	@FindBy(css = " main > div > h1")
	private WebElement searchResult;

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// currency dollar
	public void currencyToDollar() {
		mouseToWebElement(languageBtn);
		click(currencyBtn);
		click(currencyDollar);
		waiting(1000);
	}

	public void clickOnStartPlaningFirstBtn() {
		click(startPlaningFirstBtn);
		waiting(1000);
	}

	public void clickOnStartPlaningSecondBtn() {
		js.executeScript("window.scrollBy(0, 100)");
		mouseToWebElement(startPlaningSecondtBtn);
		click(startPlaningSecondtBtn);
		waiting(2000);

	}

	// get msg when you click on plan trip2
	public String getMsgPagePlanTrip() {
		waiting(1500);
		String act = getText(msgPagePlanTrip);
		return act;
	}

	// click on next step
	public void clicNextStep() {
		js.executeScript("window.scrollBy(0, 50)");
		waiting(1000);
		click(nextStepBtn);
		waiting(1000);
	}

	// click on next step in page of "What do you plan to do"
	public void clicNextStep2() {
		click(nextStepBtn2);
	}

	// click on popular destination
	public void clicPopulardestination() {
		click(choosePopularDestinationBtn);
		waiting(1000);
	}

	// get msg eror when you dont ckick on dates
	public String getMsgEror() {
		waiting(1500);
		String act = getText(erorMsg);
		return act;
	}

	// choose your location to go
	public void choosedestination(String name) {
		fillText(destinationFiled, name);
		waiting(3000);
		click(listDestinations);

	}

	// choose dates to go
	public void chooseDates(String month, String year, String day, String month2, String year2, String day2) {
		String date = "[aria-label='" + month + " " + day + ", " + year + "']";
		driver.findElement(By.cssSelector(date)).click();
		String date2 = "[aria-label='" + month2 + " " + day2 + ", " + year2 + "']";
		driver.findElement(By.cssSelector(date2)).click();
	}

	// choose month to go
	public void chooseMonth(String monthName) {
		// click(datesFiled);
		js.executeScript("window.scrollBy(0, 100)");
		waiting(1000);
		for (WebElement el : month) {
			String monthTitle = el.getText();
			while (!(monthTitle.equalsIgnoreCase(monthName))) {
				click(clickNextMonthBtn);
				break;
			}
		}
	}

	// choose month to go (Destination Suggestion plan)
	// public void chooseDestinationSuggestionMonth(String monthName) {
	// click(suggestionDatesFiled);
	// js.executeScript("window.scrollBy(0, 100)");
	// waiting(1000);
	// for (WebElement el : month) {
	// String monthTitle = el.getText();
	// while (!(monthTitle.equalsIgnoreCase(monthName))) {
	// click(clickNextMonthBtn);
	// break;
	// }
	// }
	// }

	public void chooseFlexibleDates() {
		// js.executeScript("window.scrollBy(0, 200)");
		waiting(2000);
		click(FlexibleDatesBtn);
	}

	public String getMsgFlexibleDates() {
		waiting(1500);
		String act = getText(successMsg);
		return act;

	}

	public void clickOnSaveTrip() {
		js.executeScript("window.scrollBy(0, 350)");
		click(saveTripBtn);
		waiting(3000);
		js.executeScript("window.scrollBy(-350, -100)");
		waiting(1000);
	}

	public String getMsgSuccess() {
		String act = getText(getSuccesAfterSaveTrip);
		return act;
	}

	// public void choosePurpose(String name) {
	// click(purposeBtn);
	// js.executeScript("window.scrollBy(0, 150)");
	// List<WebElement> purposeList =
	// driver.findElements(By.cssSelector("button.search-purpose__item"));
	// for (WebElement el : purposeList) {
	// if (el.getText().equalsIgnoreCase(name)) {
	// click(el);

	// }
	// }
	// }

	public void chooseCatgoryNatural(String name) {
		waiting(1000);
		click(catgoryNaturalGreenBtn);
		waiting(3000);
		js.executeScript("window.scrollBy(-150, 100)");
	}

	public void clickOnsScreenBlock() {
		mouseMove(screenBlock);
		waiting(2000);
	}

	public void backToMainPage() {
		click(mainPageBtn);
		waiting(2500);
	}

	public void clickOnInspireMe() {
		click(inspireMeBtn);
		waiting(2000);
	}

	public void chooseWhatDoYouPrefer() {
		click(culturalEventBtn);
		waiting(1000);
		Actions a = new Actions(driver);
		a.moveByOffset(0, 2).click().build().perform();
		js.executeScript("window.scrollBy(-150, 100)");
	}

	public void clickShowResult() {
		click(shoewResult2Btn);
	}

	// Validation to SearchResult page
	public String getMsgSearchResult() {
		waiting(1500);
		String act = getText(searchResult);
		return act;
	}
}
