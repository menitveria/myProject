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
	public void tc03_openCovidAssist() {
		NavigationPage np = new NavigationPage(driver);
		np.clickOncovid();
		String actual = np.getMsginPagecovid();
		Assert.assertEquals(actual, "אל תתנו לקורונה לשבש לכם את הטיול");
		np.waiting(2000);
		np.moveToMainWindow();
	}

	@Test
	public void tc04_openHotelPage() {
		NavigationPage np = new NavigationPage(driver);
		np.servicesHotels();
		String actual = np.getMsgBooking();
		Assert.assertEquals(actual, "בשיתוף פעולה עם:");
		np.waiting(2000);
		np.moveToMainWindow();
	}

	@Test
	public void tc05_openFlightPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openflightPage();
		np.closeMsgJump();
		String actual = np.getMsgPageflight();
		Assert.assertEquals(actual, "We hack the system." + "\n" + "You fly for less.");
		np.waiting(2000);
		np.moveToMainWindow();

	}

	@Test
	public void tc06_ExperiencePage() {
		NavigationPage np = new NavigationPage(driver);
		np.openExperiencePage();
		String actual = np.getMsgPageExperience();
		Assert.assertEquals(actual, "Why book with Viator?");
		np.waiting(2000);
		np.moveToMainWindow();

	}

	@Test
	public void tc07_insurancePage() {
		NavigationPage np = new NavigationPage(driver);
		np.openInsurancePage();
		np.waiting(4000);
		String actual = np.getMsgInsurancePage();
		Assert.assertEquals(actual, "מתי?");
		np.waiting(5000);
		np.moveToMainWindow();

	}

	@Test
	public void tc08_carPage() {
		NavigationPage np = new NavigationPage(driver);
		np.openCarPage();
		String actual = np.getMsgPageCar();
		Assert.assertEquals(actual, "Where are you traveling to?");
		np.waiting(3000);
		np.moveToMainWindow();

	}

}
