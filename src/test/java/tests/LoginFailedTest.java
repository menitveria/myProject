package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginFailedTest extends BaseTest {

	@Override
	@BeforeClass
	public void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.clickOnSignin();
	}

	@Test(dataProvider = "getData")
	public void tc01_login(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.loginPageMain(email, password);
		lp.popUp();
		String actual = lp.geterrorMsg();
		Assert.assertEquals(actual, "Unable to log in with provided credentials.");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "mm@gmail.com", "Sa123456" },

		};
		return data;
	}

}
