package tests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NavigationPage;

public class NavigationTest extends BaseTest {

	@Test
	public void tc01_openDestination() {
		NavigationPage np = new NavigationPage(driver);
		np.opendestinatnationPage();
		Assert.assertTrue(np.isDenstinationsPage());

	}

	@Test
	public void tc02_openMytrip() {
		NavigationPage np = new NavigationPage(driver);
		np.waiting(1500);
		np.openMyTrip();		
		np.clickOnMyRoutes();
		String actual = np.getMsginPageTrip();
		Assert.assertEquals(actual, "Start adding routes to bookmarks now!");
	}

	


	@Test
	public void tc03_openHotelPage() {
		NavigationPage np = new NavigationPage(driver);
		np.clickOnService();
		np.servicesHotels();
		String actual = np.getMsgBooking();
		Assert.assertEquals(actual, "חוסכים 15% עם מבצעי סוף שנה");
		np.waiting(2000);
		np.moveToMainWindow();
	}

	@Test
	public void tc04_openFlightPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openflightPage();
		np.closeMsgJump();
		String actual = np.getMsgPageflight();
		Assert.assertEquals(actual, "Book cheap flights other search tools can't find");
		np.waiting(2000);
		np.moveToMainWindow();

	}

	@Test
	public void tc05_ExperiencePage() {
		NavigationPage np = new NavigationPage(driver);
		np.openExperiencePage();
		String actual = np.getMsgPageExperience();
		Assert.assertEquals(actual, "Why book with Viator?");
		np.waiting(2000);
		np.moveToMainWindow();

	}

	@Test
	public void tc06_insurancePage() {
		NavigationPage np = new NavigationPage(driver);
		np.openInsurancePage();
		np.waiting(4000);
		String actual = np.getMsgInsurancePage();
		Assert.assertEquals(actual, "מתי?");
		np.waiting(5000);
		np.moveToMainWindow();

	}

	@Test
	public void tc07_carPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openCarPage();
		String actual = np.getMsgPageCar();
		Assert.assertEquals(actual, "Where are you traveling to?");
		np.waiting(3000);
		np.moveToMainWindow();

	}

}
