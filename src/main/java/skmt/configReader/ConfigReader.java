package skmt.configReader;


public interface ConfigReader {
	
	public String getBrowser();
	public String getReservationUrl();
	public String getHerokuappUrl();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public long getPollingTimeInMilliSecond();
	
}
