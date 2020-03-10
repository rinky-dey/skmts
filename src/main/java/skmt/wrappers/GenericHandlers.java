package skmt.wrappers;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import skmt.configReader.ObjectRepository;
import skmt.utility.ResourceHandler;

public class GenericHandlers {
	public static WebDriver driver;
	protected static Properties prop;
	public String url;
	
public GenericHandlers() {
		
	}

	public GenericHandlers(WebDriver driver) {
		this.driver = driver;
	}

	public void unloadObjects() {
		prop = null;
	}
	
	/**
	 * This method will launch the browser in local machine and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser) {
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ResourceHandler.getResourcePath("\\src\\main\\resources\\driver\\chromedriver.exe"));
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", ResourceHandler.getResourcePath("\\src\\main\\resources\\driver\\geckodriver.exe"));
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ObjectRepository.reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.get(url);
	}
	
	/**
	 * This method will enter the value to the text field
	 * @param element
	 * @param data
	 */
	public void enterData(WebElement element, String data) {
		try {
			element.clear();
			element.sendKeys(data);	
		} catch (NoSuchElementException e) {
			
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}
	
	/**
	 * This method will enter the value to the text area
	 * @param element
	 * @param data
	 */
	public void enterTextAreaData(WebElement element, String data) {
		try {
			element.sendKeys(data);	
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}
	
	/**
	 * This method will close all the browsers
	 */
	public void closeAllBrowsers() {
		try {
			if (driver!=null) {
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("The browser could not be closed.");
			System.out.println(e.getStackTrace());
		}
	}
	/**
	 * This method will close current browser window
	 */
	public void closeBrowser() {
		try {
			if (driver!=null) {
				driver.close();
			}
		} catch (Exception e) {
			System.out.println("The browser could not be closed.");
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * This method clicks the WebElement
	 * @param element
	 */
	public void clickElement(WebElement element) {
		try{
			System.out.println("The element : "+element+" is clicked.");
			element.click();
		} catch (Exception e) {
			System.out.println("The element : "+element+" could not be clicked.");
			System.out.println(e.getStackTrace());
		}
	}

	/**
	 * This method will check if the radio button is not selected, then select the radio button
	 * @param radioElement
	 */
	public void selectElement(WebElement radioElement) {
		boolean isSelected = false;
		try {
			isSelected = radioElement.isSelected();
			if (!isSelected) {
				radioElement.click();
			}
		} catch (Exception e) {
			System.out.println("The element : "+radioElement+" could not be selected.");
			System.out.println(e.getStackTrace());
		}
		System.out.println("The element : "+radioElement+" is selected.");
	}
	
	/**
	 * This method will return the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 */
	public String getTextByXpath(WebElement element){
		String bReturn = "";
		try{
			return element.getText();
		} catch (Exception e) {
			System.out.println("The element with xpath: "+element+" could not be found.");
			System.out.println(e.getStackTrace());
		}
		return bReturn; 
	}
}
