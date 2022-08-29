package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProfilePage;
import pageObjects.NavigationPage;

public class ProfileTest extends BaseTest {
	@Test
	public void tc01_openDestination() {
		ProfilePage pp = new ProfilePage(driver);
		pp.openProfile();
		pp.editProfile();
		pp.chooseFinancialstandard();
		String act = pp.getMsginProfilePage();
		assertEquals(act, "Use my preferences and interests for search");
		

	}
	


}
