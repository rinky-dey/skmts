package skmts.pageobject.guru99.registeration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import skmt.configReader.ObjectRepository;
import skmt.wrappers.VerifyHandler;
import skmt.wrappers.WaitHandler;

public class RegistrationSuccess {
	
	
	private WebDriver driver;
	private WaitHandler wait;
	private VerifyHandler verify;

	@FindBy(xpath="//body//table//tr//td[@valign='top'][2]//tr[4]//table//table//tr[3]//p[1]//font//b")
	WebElement confirmName;

	@FindBy(xpath="//body//table//tr//td[@valign='top'][2]//tr[4]//table//table//tr[3]//p[2]")
	WebElement confirmationMsg;

	@FindBy(xpath="//body//table//tr//td[@valign='top'][2]//tr[4]//table//table//tr[3]//p[3]//font//b")
	WebElement confirmUserName;

	public RegistrationSuccess(WebDriver driver) {
		this.driver = driver;
		System.out.println("RegisterUser : " + this.driver.hashCode());
		PageFactory.initElements(this.driver, this);
		verify = new VerifyHandler(this.driver);
		wait = new WaitHandler(this.driver);
		wait.waitForElementToBeVisible(confirmUserName, ObjectRepository.reader.getExplicitWait(), ObjectRepository.reader.getPollingTimeInMilliSecond());
	}

	public boolean verifyConfirmName(String fName, String lName) {
		System.out.println("Verifying Name");
		String name = "Dear " + fName + " " + lName + ",";
		return verify.isTextVerifiedByElement(confirmName, name);
	}

	public boolean verifyConfirmMessage(String welcomeMsg) {
		System.out.println("Verifying Confirmation message");
		return verify.isTextVerifiedByElement(confirmationMsg, welcomeMsg);

	}

	public boolean verifyConfirmUserName(String userName) {
		System.out.println("Verifying Username");
		String uName = "Note: Your user name is " + userName + ".";
		return verify.isTextVerifiedByElement(confirmUserName, uName);
	}
}
