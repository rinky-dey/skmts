package skmts.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import skmt.configReader.ObjectRepository;
import skmt.configReader.PropertyFileReader;
import skmts.commontest.TC_Common;
import skmts.pageobject.Welcome;
import skmts.pageobject.guru99.registeration.RegistrationSuccess;

public class RegistrationTest extends TC_Common {

	@Parameters({"url"})
	@BeforeClass
	public void setData(String currentUrl) {
		ObjectRepository.reader = new PropertyFileReader();
		dataFileName = "TC_Mercury_TestData";
		dataSheetName = "Registration";
		browser = ObjectRepository.reader.getBrowser();
		url = currentUrl;
	}
	@Test(dataProvider = "fetchData")
	public void registerUser(String fName, String lName, String phoneNumber, String emailId, String address, 
			String city, String state, String postalCode, String country, String userName, String password,
			String confirmPwd, String welcomeMsg) {

		new Welcome(driver)
		.clickRegister()
		.enterFirstName(fName)
		.enterLastName(lName)
		.enterPhone(phoneNumber)
		.enterEmail(emailId)
		.enterAddress(address)
		.enterCity(city)
		.enterState(state)
		.enterPostalCode(postalCode)
		.selectCountry(country)
		.enterUsername(userName)
		.enterPassword(password)
		.enterConfirmPassword(confirmPwd)
		.clickSubmitButton();
		
		RegistrationSuccess isSuccess = new RegistrationSuccess(driver);
		
		// Confirmation of user firstname and lastname after registration 
		Assert.assertTrue(isSuccess.verifyConfirmName(fName, lName), "User details didnot matched");
		
		// confirmation of success message after successful user registration
		Assert.assertTrue(isSuccess.verifyConfirmMessage(welcomeMsg), "Confirmation messages didnot matched");
		
		// confirmation of newly created username
		Assert.assertTrue(isSuccess.verifyConfirmUserName(userName), "User name didnot matched");
	
	}

}
