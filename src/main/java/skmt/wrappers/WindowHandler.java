package skmt.wrappers;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandler {

	
	private WebDriver driver;
	
	public WindowHandler(WebDriver driver) {
		this.driver = driver;
		System.out.println("WindowHandler : " + this.driver.hashCode());
	}
	
	/**
	 * Method to switch to the desired window from any other window
	 * 
	 */
	public void switchToWindow(int index) {

		System.out.println(index);
		int windowCounter = 0;
		try {
			Set<String> windowList = this.driver.getWindowHandles();
			
			if (index < 0 || index > windowList.size())
				throw new IllegalArgumentException("Invalid Index : " + index);
			
			for (String eachWindow : windowList) {
				if (windowCounter==index) {
					driver.switchTo().window(eachWindow);
					break;
				}
				windowCounter++;
			}
		} catch (Exception e) {
			System.out.println("Could not switch to " +index+ " window");
		}
		System.out.println("switched to " +index+ " window");
	}
	
	/**
	 * Method to switch to the parent window from any other window
	 * 
	 */
	public void switchToParentWindow() {
		try {
			Set<String> windowList = this.driver.getWindowHandles();
			for (String eachWindow : windowList) {
				this.driver.switchTo().window(eachWindow);
				break;
			}
		} catch (Exception e) {
			System.out.println("Could not be switched to the first window.");
		} 
		System.out.println("Switched to parent window successfully");
	}
	
	/**
	 * Method to switch to the last window
	 * 
	 */
	public void switchToLastWindow() {
		try {
			Set<String> windowList = this.driver.getWindowHandles();
			for (String eachWindow : windowList) {
				this.driver.switchTo().window(eachWindow);
			}
		} catch (Exception e) {
			System.out.println("Could not be switched to the last window.");
		} 
		System.out.println("Switched to last window successfully");
	}
}