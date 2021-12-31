package Day_1_practice;

import java.io.FileOutputStream;
import java.util.Properties;

public class storeDataToProperties {
	
	public static void main(String[] args) throws Throwable {
		FileOutputStream output=new FileOutputStream("./Data/commondata.properties",true);
		Properties prop=new Properties();
		prop.setProperty("name", "mohna");
		prop.store(output,null);
	}

}
