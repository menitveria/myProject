package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {

	@FindBy(css = ".app-header__container>a")
	private WebElement logofield;

	// destination

	@FindBy(css = "  div.app-header__desktop > nav > div > a:nth-child(1)")
	private WebElement destinationPagefield;

	@FindBy(css = "#__next > main > div.destinations-header > div > h1 ")
	private WebElement headerField;

	// my Trips

	@FindBy(css = " div.app-header__desktop > nav > div > a:nth-child(2)")
	private WebElement myTripfield;
	
	@FindBy(css = " div.tabs > a:nth-child(2)")
	private WebElement clickMyRoutesBtn;

	@FindBy(css = " div:nth-child(2) > section > div > p")
	private WebElement msginPageTripfield;
	
	//covid assist
	
	@FindBy(css = ".app-header__desktop >nav > div >a:nth-child(3)")
	private WebElement covidassistfield;
	
	@FindBy(css = "#select-country-wrap > div.row.mb-3.justify-center > div > h1")
	private WebElement pagecovidfield;

	// service

	@FindBy(css = "  div.app-header__desktop > nav > div > div > span > span")
	private WebElement servicefield;

	

	// hotels

	@FindBy(css = "div.app-header__desktop > nav > div > div > div.hide-xs.show-xl > div > div > a:nth-child(1) > span")
	private WebElement hotelstfield;

	@FindBy(css = "   div.aff--cobrand_header_wrapper.hide_this_for_print > span")
	private WebElement msginPagehotelfield;
	
	// flight

	@FindBy(css = "div.app-header__desktop > nav > div > div > div.hide-xs.show-xl > div > div > a:nth-child(2)")
	private WebElement flightfield;

	@FindBy(css = " div:nth-child(1) > div > h1")
	private WebElement msginPageflightfield;
	
	@FindBy(css = " div.Stack__StyledStack-sc-oaff2v-0.jIQtzq > button > div > div")
	private WebElement msgJumpfield;

	// experience

	@FindBy(css = "div.app-header__desktop > nav > div > div > div.hide-xs.show-xl > div > div > a:nth-child(3)")
	private WebElement experiencefield;

	@FindBy(css = " div > div.advantageBannerHeader__-v05 > span")
	private WebElement msginPageExperiencefield;

	// insurance

	@FindBy(css = "div.app-header__desktop > nav > div > div > div.hide-xs.show-xl > div > div > a:nth-child(4)")
	private WebElement insurancefield;

	@FindBy(css = "  div > div:nth-child(3) > span > span.MuiStepLabel-labelContainer > span")
	private WebElement pagetitlefield;

	// car rental

	@FindBy(css = "div.app-header__desktop > nav > div > div > div.hide-xs.show-xl > div > div > a:nth-child(5)")
	private WebElement carfield;

	@FindBy(css = " div.country_tooltip")
	private WebElement msginPageCarfield;

	public NavigationPage(WebDriver driver) {
		super(driver);
	}

	// Click on the site logo and return to the home page

	public void backtoHomePage() {
		click(logofield);
	}

	// open destinatnation Page

	public void opendestinatnationPage() {
		click(destinationPagefield);
		// waitForVisibilityOf(SearchField);
		waiting(3000);
	}

	// Validation to destinations page
	public boolean isDenstinationsPage() {
		return validitionByEl(headerField);
	}

	// open my Trip
	public void openMyTrip() {
		click(myTripfield);
		waiting(3000);

	}
	
	//validation to Trip page

	public String getMsginPageTrip() {
		waiting(2500);
		String msg = getText(msginPageTripfield);
		return msg;
	}
	
	public void clickOnMyRoutes() {
		waiting(3000);
		click(clickMyRoutesBtn);
		waiting(3000);
	}
	// click on covid
	
	public void clickOncovid() {
		click(covidassistfield);
		waiting(1000);
		moveToNewWindow();
	}
	
	public String getMsginPagecovid() {
		waiting(2500);
		String msg = getText(pagecovidfield );
		return msg;
	}
	
	

	// click on service

	public void clickOnService() {

		click(servicefield);
		waiting(2000);
	}



	// open hotels page
	public void servicesHotels() {
		mouseToWebElement(servicefield);
		click(hotelstfield);
		waiting(1000);
		moveToNewWindow();
	}

	public String getMsgBooking() {
		String msg = getText(msginPagehotelfield);
		return msg;
	
	}

	// Open flights page
	public void openflightPage() {
		mouseToWebElement(servicefield);
		click(flightfield);
		waiting(1000);
		moveToNewWindow();
	}
	public void closeMsgJump() {
		waiting(1000);
		click(msgJumpfield);
		waiting(1000);
	}

	public String getMsgPageflight() {
		String msg = getText(msginPageflightfield);
		return msg;
	}

	// Open Experience page
	public void openExperiencePage() {
		mouseToWebElement(servicefield);
		click(experiencefield);
		waiting(1000);
		moveToNewWindow();
	}

	public String getMsgPageExperience() {
		String msg = getText(msginPageExperiencefield);
		return msg;
	}

	// open insurance page

	public void openInsurancePage() {
		mouseToWebElement(servicefield);
		waiting(1000);
		click(insurancefield);
		waiting(3000);
		moveToNewWindow();
	}

	// Validation to insurance page
	public String getMsgInsurancePage() {
		waiting(2000);
		String msg = getText(pagetitlefield);
		return msg;
	}

	// open car page

	public void openCarPage(){
		mouseToWebElement(servicefield);
		click(carfield);
		waiting(2000);
		moveToNewWindow();		
	}

	public String getMsgPageCar() {
		String msg = getText(msginPageCarfield);
		return msg;
	}

	// General method for returning to the main page
	public void backToMainPage() {
		moveToMainWindow();
	}
	
	public String getLoginName() {
		WebElement el = driver.findElement(By.cssSelector("div.nav-right__user > div"));
		return getText(el);
	}

}
