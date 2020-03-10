package skmt.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;



public class ResourceHandler {
	
public static String getBaseResourcePath() {
		
		String basePath = System.getProperty("user.dir");
		return basePath;
	}

	public static String getResourcePath(String resource) {
		String path = getBaseResourcePath() + resource;
		return path;
	}
	
	
	public static InputStream getResourcePathInputStream(String resource) throws FileNotFoundException {
		return new FileInputStream(ResourceHandler.getResourcePath(resource));
		
	}
}
