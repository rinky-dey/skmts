# skmts
data driven framework using page object model
1. /skmts/src/main/java/skmt/configReader -> 
  Includes all Basic Configuration methods-
  
  a) skmt.configReader
      |-ConfigReader -> Reading Properties from config.properties file
      |-ObjectRepository -> Defining property reader object
      |-PropertyFileReader -> Implementing ConfigReader Class
  
    
    public interface ConfigReader {
	
	public String getBrowser();
	public String getReservationUrl();
	public String getHerokuappUrl();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public long getPollingTimeInMilliSecond();
	
}

this functionalities are described.


   b) skmt.utility 
       |-DataInputProvider -> Reads data from Excel Sheet
       |-ResourceHandler -> Retriving the Base Path of the Project Folder
   
   c)skmt.wrappers (Includes all handler classes)
       |-AlertHandler.java -> functionality realted to alert boxes
       |-BrowserHandler.java -> functionality realted to browser | refresh , forward , backward
       |-DropdownHandler.java -> functionality realted to dropdown boxes
       |-GenericHandlers.java -> common functionality realted to input output and invoking browser
       |-VerifyHandler.java -> functionality realted to elements verification
       |-WaitHandler.java -> functionality realted to explicit wait 
       |-WindowHandler.java -> functionality realted to windows
 
 
2. /skmts/src/main/resources

   Resources folder
   
      a)configfile -> includes config.properties file
      b)driver -> includes all driver.exe files


3. /skmts/src/test/java -
       Testcaes and the Page Objects are defined over here -
      
      a) skmts.commontest
          |-TC_Common.java -> Includes all @before.. and @after.. methods
     
     b) skmts.pageobject
          |-Welcome.java -> Main navigation bar page object class
     
     c) skmts.pageobject.guru99.registeration
          |-Registration.java -> Element Defination of the Registration page and the methods releted to those elements
          |-RegistrationSuccess.java -> Element Defination of  Registration Sucess ppage and the methods releted to those elements
     
     d) skmts.testcases -
                     write all the test caes inside this folder
          |-RegistrationTest.java -> Includes all test cases related to registration page
          
 4. src/test/resources -
      
      a)testdata- includes all the excel sheet (includes related data)
      
