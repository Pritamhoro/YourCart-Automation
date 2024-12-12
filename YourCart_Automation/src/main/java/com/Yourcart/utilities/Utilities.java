package com.Yourcart.utilities;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Utilities 
{
	public static final int IMPLICIT_WAIT_TIME =10;
	public static final int PAGE_LOAD_TIME=10;
	
	@Test
	public static String  GenearteEmailwithTimeStamp() 
	{
		Date date=new Date();
		String middle=date.toString().replace(" ", "_").replace(":", "_");
		return "Pritam"+middle + "H" +"@gmail.com";
	}
	
	@Test
	public static Object[][] GetTestDataFromExecl(String sheetName) throws IOException 
	{
		FileInputStream FIS=new FileInputStream("./src/main/java/com/Yourcart/qa/TestData/YourcartTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(FIS);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) 
		{
		    throw new RuntimeException("Sheet not found: " + sheetName);
		}
		
		int rows=sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][columns];
		
		for(int i=0;i<rows;i++) 
		{
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<columns;j++) 
			{
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch(cellType) 
				{
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
				
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				}
			}
	
		}
	return data;
	
	}
	
}
