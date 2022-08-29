package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObjects.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void tc01_clickOnStartPlaning() {
		HomePage hp = new HomePage(driver);
		hp.currencyToDollar();
		hp.clickOnStartPlaningFirstBtn();
		hp.waiting(1000);
		hp.clickOnStartPlaningSecondBtn();
		String act = hp.getMsgPagePlanTrip();
		assertEquals(act, "It’s smart and simple");
	}

	@Test
	public void tc02_choosePopularPlace() {
		HomePage hp = new HomePage(driver);
		hp.clicPopulardestination();
		hp.waiting(1000);
		hp.chooseFlexibleDates();
		hp.waiting(5000);
		hp.clickOnsScreenBlock();
		hp.clickOnSaveTrip();
		String act = hp.getMsgSuccess();
		assertEquals(act, "Success");
	}

	@Test

	public void tc03_chooseInspireme() {
		HomePage hp = new HomePage(driver);
		hp.waiting(3000);
		hp.backToMainPage();
		hp.clickOnStartPlaningFirstBtn();
		hp.clickOnInspireMe();
		hp.clicNextStep();
		String act = hp.getMsgEror();
		assertEquals(act, "Please, specify return date");

	}

	@Test

	public void tc04_chooseDate() {
		HomePage hp = new HomePage(driver);
		hp.waiting(2000);
		hp.chooseMonth("September");
		hp.chooseDates("September", "2022", "10", "September", "2022", "18");
		hp.clicNextStep();
		hp.chooseCatgoryNatural("Nature");
		//hp.chooseSubCatgoryNatural("Green (mountains & forests)");
		hp.clicNextStep2();
		hp.chooseWhatDoYouPrefer();
		hp.clickShowResult();
		String act = hp.getMsgSearchResult();
		assertEquals(act, "Search results");

	}

}
