package skmt.wrappers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHandler {

	
	private WebDriver driver;
	
	public AlertHandler(WebDriver driver) {
		this.driver = driver;
		System.out.println("AlertHandler : " + this.driver.hashCode());
	}
	
	private Alert getAlert() {
		Alert alert = null;
		try {
			alert =  driver.switchTo().alert();
			Thread.sleep(2000);
		} catch (NoAlertPresentException nape) {
			System.out.println("The alert could not be found.");
		} catch (Exception e) {
			System.out.println("An unknown error occured");
		}
		return alert;
	}
	
	/**
	 * This method will accept the opened alert
	 */
	public void acceptAlert() {
		try {
			getAlert().accept();
		} catch (Exception e) {
			System.out.println("The alert could not be accepted.");
		}
		System.out.println("Alert accepted");
	}
	
	/**
	 * This method will dismiss the opened alert
	 */
	public void dismissAlert() {
		System.out.println("dismiss alert");
		try {
			getAlert().dismiss();
		} catch (Exception e) {
			System.out.println("The alert could not be dismissed");
		}
	}
	
	/**
	 * This method will return the text of alert
	 * @return
	 */
	public String getAlertString() {
		String alertText="";
		try {
			alertText = getAlert().getText();
		} catch (Exception e) {
			System.out.println("Could not get the alert text");
		}
		System.out.println("Alert text is : " + alertText);
		return alertText;
	}
	
	/**
	 * This method will enter the value in prompt box
	 * @param text
	 * @return
	 */
	public void promptBox(String alertText) {
		try {
			getAlert().sendKeys(alertText);
			getAlert().accept();
		} catch (Exception e) {
			System.out.println("Could not get the alert text");
		}
		System.out.println("Prompt box message is : " + alertText);
	}
}