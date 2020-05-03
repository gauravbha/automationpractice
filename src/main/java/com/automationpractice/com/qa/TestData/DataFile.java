package com.automationpractice.com.qa.TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;

import com.automationpractice.qa.TestBase.TestBase;

import TestNG.Xls_Reader;



public class DataFile extends TestBase {
	public static Workbook book;
	public static Sheet sheet;
	
		public static Object[][] TestData(String SheetName) {
			String TESTDATA_SHEET_PATH = "D:\\Java_projects\\com.automationpractice.com\\Files\\Data_sheet.xlsx";
			 Workbook book = null;
			Sheet sheet;
			FileInputStream file = null;
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(SheetName);
			
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i + 1);
	            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	                Cell cell = row.getCell(k);
	                String value;
	                try {
	                    value = cell.getRichStringCellValue().toString();
	                } catch (Exception e) {
	                    value = ((XSSFCell) cell).getRawValue();
	                }
	                data[i][k] = value;
	            }
			}
			return data;
		}
}


