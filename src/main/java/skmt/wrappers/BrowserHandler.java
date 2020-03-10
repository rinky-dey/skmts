package skmt.wrappers;

import org.openqa.selenium.WebDriver;

public class BrowserHandler {
	private WebDriver driver;

	public BrowserHandler(WebDriver driver) {
		this.driver = driver;

	}

	public void goBack() {

		driver.navigate().back();
	}

	public void goForward() {

		driver.navigate().forward();
	}

	public void refresh() {

		driver.navigate().refresh();
	}

}
