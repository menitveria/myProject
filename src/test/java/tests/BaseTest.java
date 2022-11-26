package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// driver.get("https://www.shichor.co.il/en");
		// Utils u = new Utils();
		String url = Utils.readValue("url");

		driver.get(url);

	}

	@BeforeClass
	public void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.clickOnSignin();	
		lp.loginPageMain("yairtveria@gmail.com", "Aa258963");
		lp.popUp();
		lp.clickLetsGo();		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

