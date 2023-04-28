package bootcamp2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.maven.project.Bootcamp.Utilities;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();
	}

	public static ChromeOptions options;
	public static WebDriver driver;
	public static SoftAssert softassert = new SoftAssert();
	public static LandingPage landingpage;
	public static RegisterPage registerpage;
	public static RegistrationSuccessPage registrationsuccesspage;
	public static InsideOfLoginPage insideofloginpage;
	public static LogoutPage logoutpage;
	public static Actions action;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountLink();
		landingpage.clickOnRegisterLink();

	}

	@Test(priority = 1)
	public void verifyRegisterAnAccountWithOnlyMandatoryFields() {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerpage.enterTelephone(Utilities.generatePhoneNumber(11));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.clickOnPrivacyPolicyButton();
		registerpage.clickOnContinueButton();
		String actualMessageForRegister = registerpage.successfullyRegisteredMessageIsDisplayedOrNot();
		String expectedMessageForRegister = dataProp.getProperty("successfullyRegisteredVerifyMessage");
		softassert.assertTrue(actualMessageForRegister.contains(expectedMessageForRegister),
				"Validation for registering account does not match");
		softassert.assertAll();

	}

	@Test(priority = 2)
	public void verifyRegisterAnAccountByProvidingAllFields() {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerpage.enterTelephone(Utilities.generatePhoneNumber(11));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.clickOnSubscribeButton();
		registerpage.clickOnPrivacyPolicyButton();
		registerpage.clickOnContinueButton();
		String actualMessageForRegister = registerpage.successfullyRegisteredMessageIsDisplayedOrNot();
		String expectedMessageForRegister = dataProp.getProperty("successfullyRegisteredVerifyMessage");
		softassert.assertTrue(actualMessageForRegister.contains(expectedMessageForRegister),
				"Validation for registering account does not match");
		softassert.assertAll();

	}

	@Test(priority = 3)
	public void verifyRegisterWithOnlyFirstName() {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.clickOnSubscribeButton();
		registerpage.clickOnPrivacyPolicyButton();
		registerpage.clickOnContinueButton();
		String actualMessageForLastName = registerpage.warningMessageForLastNameDisplayedOrNot();
		String expectedMessageForLastName = dataProp.getProperty("lastNameWarningMessage");
		softassert.assertTrue(actualMessageForLastName.contains(expectedMessageForLastName),
				"Error message for missing last name does not exits");
		softassert.assertAll();
	}

	@Test(priority = 4)
	public void verifyRegisterWithOnlyFirstAndLastName() {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.clickOnSubscribeButton();
		registerpage.clickOnPrivacyPolicyButton();
		registerpage.clickOnContinueButton();
		String actualMessageForEmail = registerpage.warningMessageForEmailDisplayedOrNot();
		String expectedMessageForEmail = dataProp.getProperty("emailWarningMessage");
		softassert.assertTrue(actualMessageForEmail.contains(expectedMessageForEmail),
				"Error message for missing email does not exits");
		softassert.assertAll();
	}

	@Test(priority = 5)
	public void verifyRegisterUptoEmail() {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmail(Utilities.generateEmailWithTimeStamp());
		registerpage.clickOnSubscribeButton();
		registerpage.clickOnPrivacyPolicyButton();
		registerpage.clickOnContinueButton();
		String actualMessageForTelephone = registerpage.warningMessageForTelephoneDisplayedOrNot();
		String expectedMessageForTelephone = dataProp.getProperty("telephoneWarningMessage");
		softassert.assertTrue(actualMessageForTelephone.contains(expectedMessageForTelephone),
				"Error message for missing telephone does not exits");
		softassert.assertAll();
	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
