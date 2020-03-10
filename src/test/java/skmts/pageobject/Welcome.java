package skmts.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import skmt.wrappers.GenericHandlers;
import skmt.wrappers.WaitHandler;
import skmts.pageobject.guru99.registeration.Registration;

public class Welcome {
	
	
	private WebDriver driver;
	private WaitHandler wait;
	private GenericHandlers handlers;
	
	@FindBy(linkText="REGISTER")
	WebElement registerUser;
	
	@FindBy(linkText="Flights")
	WebElement flightTicketBook;
	
	public Welcome(WebDriver driver) {
		this.driver = driver;
		System.out.println("Welcome : " + this.driver.getTitle());
		PageFactory.initElements(driver, this);
		handlers = new GenericHandlers(driver);
		wait = new WaitHandler(driver);
		//wait.waitForElement(this.registerUser, ObjectRepository.reader.getExplicitWait());
	}
	
	public Registration clickRegister() {
		System.out.println("Clicking REGISTER");
		handlers.clickElement(registerUser);
		return new Registration(driver);
	}
	
	/*
	 * public FlightReservation clickFlightTicketBooking() {
	 * System.out.println("Clicking flight ticket booking");
	 * handlers.clickElement(flightTicketBook); return new
	 * FlightReservation(this.driver); }
	 */

}
