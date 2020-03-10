package skmt.wrappers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler {

	
	private WebDriver driver;

	public WaitHandler(WebDriver driver) {
		this.driver =  driver;
		System.out.println("Wait : " + this.driver.hashCode());
	}

	public void setImplicitWait(long timeout, TimeUnit unit) {
		System.out.println("Implicit timeout : " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}

	public WebElement waitForElementToBeClickable(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	private WebDriverWait getWait(int timeOutInSeconds, long pollingEveryInMiliSec) {
		System.out.println("Webdriver wait : " + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public void waitForElementToBeVisible(WebElement locator, int timeOutInSeconds, long pollingEveryInMiliSec) {
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(locator));
		System.out.println("Element found : " + locator.getText());
	}

	public void waitForElement(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(this.driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Element found : " + element.getText());
	}
	
	public void explicitWait(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			System.out.println(e.getStackTrace());
		}
	}
}