package skmt.wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandler {

	
	private WebDriver driver;
	
	public DropdownHandler(WebDriver driver) {
		this.driver = driver;
		System.out.println("DropdownHandler : " + this.driver.hashCode());
	}
	
	/**
	 * This method will select the drop down value 
	 * @param element The webelement of the dropdown
	 * @param value The value to be selected (visibletext) from the dropdown 
	 */
	public void selectVisibileText(WebElement element, String value) {
		try{
			new Select(element).selectByVisibleText(value);
			System.out.println("The element : "+element+" is selected with value : "+value);
		} catch (Exception e) {
			System.out.println("The value: "+value+" could not be selected.");
		}
	}

	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (index) from the dropdown 
	 */
	public void selectIndexById(WebElement element, int value) {
		try{
			new Select(element).selectByIndex(value);
			System.out.println("The element with id: "+element+" is selected with index :"+value);
		} catch (Exception e) {
			System.out.println("The index: "+value+" could not be selected.");
		}
	}
}