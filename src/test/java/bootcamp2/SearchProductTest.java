package bootcamp2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchProductTest extends TestBase {

	public SearchProductTest() throws Exception {
		super();
	}

	public static ChromeOptions options;
	public static WebDriver driver;
	public static SoftAssert softassert = new SoftAssert();
	public static LandingPage landingpage;
	public static SearchPage searchpage;
	public static LoginPage loginpage;
	public static LogoutPage logoutpage;
	public static InsideOfLoginPage insideofloginpage;
	public static Actions action;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnSearchButton();
	}

	@Test(priority = 1)
	public void verifySearchBoxIsClickable() {
		searchpage = new SearchPage(driver);
		searchpage.clickOnSearchBox();

	}

	@Test(priority = 2)
	public void verifySearchWithExistingProductName() {
		searchpage = new SearchPage(driver);
		searchpage.typeInSearchBox(dataProp.getProperty("existingProduct"));
		searchpage.clickOnSubmitButton();
		String actualExistingProdName = searchpage.existingProductDisplayedOrNot();
		String expectedExistingProdName = dataProp.getProperty("existingProduct");
		softassert.assertTrue(actualExistingProdName.contains(expectedExistingProdName),
				"Search criteria does not match");
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void verifySearchWithANonExistingProductName() {
		searchpage = new SearchPage(driver);
		searchpage.typeInSearchBox(dataProp.getProperty("nonExistingProduct"));
		searchpage.clickOnSubmitButton();
		String actualNonExistingProdName = searchpage.nonExistingProductDisplayedOrNot();
		String expectedNonExistingProdName = dataProp.getProperty("noMatchForSearchedProductMessage");
		softassert.assertTrue(actualNonExistingProdName.contains(expectedNonExistingProdName),
				"Search criteria does not match");
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void verifySearchWithoutProvidingAnything() {
		searchpage = new SearchPage(driver);
		searchpage.clickOnSubmitButton();
		String actualNonExistingProdName = searchpage.nonExistingProductDisplayedOrNot();
		String expectedNonExistingProdName = dataProp.getProperty("noMatchForSearchedProductMessage");
		softassert.assertTrue(actualNonExistingProdName.contains(expectedNonExistingProdName),
				"Search criteria does not match");
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void verifySearchProductAfterLogin() {
		landingpage = new LandingPage(driver);
		loginpage = new LoginPage(driver);
		searchpage = new SearchPage(driver);
		insideofloginpage = new InsideOfLoginPage(driver);
		landingpage.clickOnMyAccountLink();
		landingpage.clickOnLoginLink();
		loginpage.enterEmailId(prop.getProperty("validUserName"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		String actualMessageForLogin = insideofloginpage.editYourAccountInfoDisplayedOrNot();
		String expectedMessageForLogin = dataProp.getProperty("validateLogin");
		softassert.assertTrue(actualMessageForLogin.contains(expectedMessageForLogin),
				"Edit your account information is not displayed");
		searchpage.clickOnSearchBox();
		searchpage.typeInSearchBox(dataProp.getProperty("existingProduct"));
		searchpage.clickOnSubmitButton();
		String actualExistingProdName = searchpage.existingProductDisplayedOrNot();
		String expectedExistingProdName = dataProp.getProperty("existingProduct");
		softassert.assertTrue(actualExistingProdName.contains(expectedExistingProdName),
				"Search criteria does not match");
		softassert.assertAll();

	}
