package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends NavigationPage {

	// login
	@FindBy(css = ".nav-right__user button")
	private WebElement signinField;

	@FindBy(css = "#email")
	private WebElement emailfield;

	@FindBy(css = "div>#password")
	private WebElement passwordfield;

	@FindBy(css = ".btn-blue.btn-fluid.btn")
	private WebElement loginButtfield;

	@FindBy(css = "form > div.form-error")
	private WebElement erormsgfield;


	

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public void clickOnSignin() {
		click(signinField);
	}

	public void loginPageMain(String email, String password) {
		fillText(emailfield, email);
		fillText(passwordfield, password);
		click(loginButtfield);
		
	}

	public String geterrorMsg() {
		waiting(1500);
		String eror = getText(erormsgfield);
		return eror;

	}

	
}
