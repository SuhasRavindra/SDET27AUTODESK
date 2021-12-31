package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * It contains File Specific Reusable methods/actions
 * @author MOHANKUMAR GOWDA
 *
 */
public class FileUtility {

	/**
	 * It is used to read the value from properties file based on Argument passed
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/commondata.properties");
		Properties pro_Obj=new Properties();
		pro_Obj.load(fis);
		pro_Obj.getProperty(key);
		return pro_Obj.getProperty(key);		
	}
}
