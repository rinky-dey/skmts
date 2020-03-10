package skmt.configReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import skmt.utility.ResourceHandler;



public class PropertyFileReader implements ConfigReader {
	private Properties prop;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHandler.getResourcePathInputStream("\\src\\main\\resources\\configfile\\" + "config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBrowser() {
		return prop.getProperty("Browser");
	}

	@Override
	public String getReservationUrl() {
		// TODO Auto-generated method stub
		return prop.getProperty("ReservationUrl");
	}

	@Override
	public String getHerokuappUrl() {
		// TODO Auto-generated method stub
		return prop.getProperty("HerokuappUrl");
	}

	@Override
	public int getPageLoadTimeOut() {
		// TODO Auto-generated method stub
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	@Override
	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(prop.getProperty("ImplicitWait"));
	}

	@Override
	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	@Override
	public long getPollingTimeInMilliSecond() {
		// TODO Auto-generated method stub
		return Integer.parseInt(prop.getProperty("PollingTimeInMilliSecond"));
	}
}
