package skmts.pageobject.guru99.registeration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import skmt.configReader.ObjectRepository;
import skmt.wrappers.DropdownHandler;
import skmt.wrappers.GenericHandlers;
import skmt.wrappers.WaitHandler;

public class Registration {
	
	private WebDriver driver;
	private WaitHandler wait;
	private GenericHandlers handlers;
	private DropdownHandler dropdownHandlers;
	
	@FindBy(name="firstName")
	WebElement firstName;

	@FindBy(name="lastName")
	WebElement lastName;

	@FindBy(name="phone")
	WebElement phone;

	@FindBy(id="userName")
	WebElement eMail;

	@FindBy(name="address1")
	WebElement address;

	@FindBy(name="city")
	WebElement city;

	@FindBy(name="state")
	WebElement state;

	@FindBy(name="postalCode")
	WebElement postalCode;

	@FindBy(name="country")
	WebElement country;

	@FindBy(id="email")
	WebElement userName;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="confirmPassword")
	WebElement confirmPassword;

	@FindBy(name="submit")
	WebElement submitButton;

	public Registration(WebDriver driver) {
		this.driver = driver;
		System.out.println("RegisterUser : " + this.driver.hashCode());
		PageFactory.initElements(this.driver, this);
		handlers = new GenericHandlers(this.driver);
		dropdownHandlers = new DropdownHandler(this.driver);
		wait = new WaitHandler(this.driver);
		wait.waitForElement(submitButton, ObjectRepository.reader.getExplicitWait());
	}
	
	public Registration enterFirstName(String firstName) {
		System.out.println("Entering first name : " + firstName);
		handlers.enterData(this.firstName, firstName);
		return this;
	}

	public Registration enterLastName(String lastName) {
		System.out.println("Entering last name : " + lastName);
		handlers.enterData(this.lastName, lastName);
		return this;
	}

	public Registration enterPhone(String phoneNumber) {
		System.out.println("Entering phone number : " + phoneNumber);
		handlers.enterData(this.phone, phoneNumber);
		return this;
	}

	public Registration enterEmail(String emailId) {
		System.out.println("Entering address : " + emailId);
		handlers.enterData(this.eMail, emailId);
		return this;
	}

	public Registration enterAddress(String address) {
		System.out.println("Entering address : " + address);
		handlers.enterData(this.address, address);
		return this;
	}

	public Registration enterCity(String city) {
		System.out.println("Entering city :" + city);
		handlers.enterData(this.city, city);
		return this;
	}

	public Registration enterState(String state) {
		System.out.println("Entering state :" + state);
		handlers.enterData(this.state, state);
		return this;
	}

	public Registration enterPostalCode(String postalCode) {
		System.out.println("Entering postal code :" + postalCode);
		handlers.enterData(this.postalCode, postalCode);
		return this;
	}

	public Registration selectCountry(String country) {
		System.out.println("Selecting country : " + country);
		dropdownHandlers.selectVisibileText(this.country, country);
		return this;
	}

	public Registration enterUsername(String userName) {
		System.out.println("Entering username : " + userName);
		handlers.enterData(this.userName, userName);
		return this;
	}

	public Registration enterPassword(String password) {
		System.out.println("Entering password : " + password);
		handlers.enterData(this.password, password);
		return this;
	}

	public Registration enterConfirmPassword(String confirmPassword) {
		System.out.println("Entering password again : " + confirmPassword);
		handlers.enterData(this.confirmPassword, confirmPassword);
		return this;
	}
	public RegistrationSuccess clickSubmitButton() {
		System.out.println("Clicking on Submit button");
		handlers.clickElement(this.submitButton);
		return new RegistrationSuccess(this.driver);
	}
}
