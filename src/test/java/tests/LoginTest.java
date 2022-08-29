  
package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

	@Override
	public void setupLogin() {
	}

	@Test
	public void tc01_login() {

		LoginPage lp = new LoginPage(driver);

		lp.clickOnSignin();

		// String Email = Utils.readValue("Email");
		// driver.get(Email);

		lp.loginPageMain("yairtveria@gmail.com", "Aa258963");
		lp.waiting(1000);

		Assert.assertEquals(lp.getLoginName(), "Hi, yair");

	}
	


}
