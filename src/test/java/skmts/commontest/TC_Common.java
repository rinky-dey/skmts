package skmts.commontest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import skmt.utility.DataInputProvider;
import skmt.wrappers.GenericHandlers;

public class TC_Common extends GenericHandlers{
	
	public String dataFileName;
	public String dataSheetName;
	public String browser;
	
	
	@BeforeMethod
	public void setUp() {
		invokeApp(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return DataInputProvider.getAllSheetData(dataFileName, dataSheetName);		
	}
}
