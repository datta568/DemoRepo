package com.FirstMaven.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxml4j.exceptions.InvalidFormatException;

public class TestUtil {
	public static long Page_Load_time=30;
	public static long Implicit_time=10;
	public static String Test_DataSheet_Path="C:\\Users\\ManoharDattaChebrolu\\Selenium_Practice1\\FirstMaven\\src\\main\\"
											+"java\\com\\FirstMaven\\TestData\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static String sheetName="TestData";
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream fip=null;
		try {
			fip= new FileInputStream(Test_DataSheet_Path);
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		try {
			book=WorkbookFactory.create(fip);
		}catch(IOException e) {
			e.printStackTrace();
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
