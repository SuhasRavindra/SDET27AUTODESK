package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It contains Excel Specific Reusable methods/actions
 * @author MOHANKUMAR GOWDA
 *
 */
public class ExcelUtility {
	
	/**
	 * It is used to read the data from excel based on arguments passed
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable 
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./Data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
	}
	
	
	
	/**
	 * It is used to fetch the last Row Number in excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNum(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./Data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rownum;
	}
	
	
	
	/**
	 * It is used to write the data into excel based on argument passed
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./Data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./Data/testdata.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	

}
