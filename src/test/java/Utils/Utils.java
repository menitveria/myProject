package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
	public static String readValue(String key) {
		String value ="";
		try (InputStream input = new FileInputStream("./src/test/resources/data/config.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			value=prop.getProperty(key);


		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return value;
	}
}

