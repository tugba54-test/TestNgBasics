package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static Workbook book;
	public static Sheet sheet;
	//for reusability and maintainability
	public static void openExcel(String filepath,String sheetName) {
		try {
			FileInputStream fileIs=new FileInputStream(filepath);
			book=new XSSFWorkbook(fileIs);
			sheet = book.getSheet(sheetName);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	

	public static int colsCount(int row) {
	//	Row row=sheet.getRow(row);
		return sheet.getRow(row).getLastCellNum();
	}
	public static String cellDAta(int rowIndex,int colIndex) {//specific data almak icn 
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
		
	}
	public static Object[][] excelIntoArray(String filePath,String sheetName){
		openExcel(filePath,sheetName);
		

		int rows = rowCount();
		int cols = colsCount(0);

		Object[][] data = new Object[rows - 1][cols];

		// iterating rows
		for (int i = 1; i < rows; i++) {//header i istemiyrz

			// iterating cols
			for (int j = 0; j < cols; j++) {
				
				//storing values into 2D array
				data[i - 1][j] = cellDAta(i, j);//artik array oldugu icn 0 dan baslaticaz
			}
		}

		return data;
	}
	
	//HW Create a method that will return a List of Maps
	
	
	}

