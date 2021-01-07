package com.excelutil;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	//constructor
	public ExcelUtil(String path)
	{
		this.path=path;
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	public String getCellData(String sheetName,int rowNumber, int cellNumber) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			cell=row.getCell(cellNumber);
			String cellValue=cell.getStringCellValue();
			return cellValue;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
			return "";
		}
	}
	

}
