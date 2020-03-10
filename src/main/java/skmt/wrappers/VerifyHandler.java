package skmt.wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyHandler {

	
	private WebDriver driver;
	public VerifyHandler(WebDriver driver) {
		System.out.println("VerifyHandler : " + driver.hashCode());
		this.driver = driver;
	}
	
	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				System.out.println("The title of the page matches with the value :"+title);
				bReturn = true;
			}else
				System.out.println();
			System.out.println("The title of the page:"+driver.getTitle()+" did not match with the value :"+title);
		}catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
		return bReturn;
	}

	/**
	 * This method will verify the given text matches in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @return isVerified - returns true if the text matches or else returns false 
	 */
	public boolean isTextVerifiedByElement(WebElement element, String text){
		boolean isTextVerified = false;
		try {
			String sText = element.getText().trim();
			if (sText.equalsIgnoreCase(text)){
				isTextVerified = true;
				System.out.println("The text: "+sText+" matches with the value : "+text);
			}else{
				System.out.println("The text: "+sText+" did not match with the value : "+text);
			}
		}catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
		return isTextVerified;
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 */
	public boolean isTextVerifiedContainsElement(WebElement element, String text){
		boolean isTextVerified = false;
		try{
			String sText = element.getText().trim();
			if (sText.contains(text)){
				isTextVerified = true;
				System.out.println("The text: "+sText+" contains the value :"+text);
			}else{
				System.out.println("The text: "+sText+" did not contain the value :"+text);
			}
		}catch (Exception e) {
			System.out.println("Unknown exception occured while verifying the title");
		}
		return isTextVerified;
	}
}