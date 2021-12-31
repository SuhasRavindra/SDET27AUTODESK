package com.crm.autodesk.genericUtility;

import java.util.Date;
import java.util.Random;
/**
 * it is used to give Generic Methods for Java related Methods
 * @author MOHANKUMAR GOWDA
 */
public class JavaUtility {
	
	/**
	 * It is used to generate Random Number
	 * @return
	 */
	public int getRandomNum() {
		Random ran=new Random();
		return ran.nextInt(10000);
	}
	
	
	/**
	 * It is used to fetch the System Date and Time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
		
	}
	
	/**
	 *  It is used to fetch the System Date and Time in YYYY-MM-DD format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date date=new Date();
		String dateAndTime= date.toString();
		String YYYY=dateAndTime.split(" ")[5];
		int MM=date.getMonth()+1;
		String DAY=dateAndTime.split(" ")[2];
		String yyyy_mm_dd=YYYY+"-"+MM+"-"+DAY;
		return yyyy_mm_dd;
		
		/*
		 * this.getSysDateTime().split(" ");
		 */
	}
	

}
