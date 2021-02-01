package data.driven.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData
{
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String filePath,String sheetName) throws IOException 
	{
		
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	
	public short getCellCount(String filePath,String sheetName,int rowNum) throws IOException
	{
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		short cellCount = row.getLastCellNum();
		return cellCount;
	}
	
	
	public String getData(String filePath,String sheetName,int rowNum,int columnNum) throws IOException
	{
		String data;
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		try 
		{
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			return celldata;
		}
		catch (Exception e) 
		{	
			data = " ";

		}
		return data;
	}
	
	
	public void setCellData(String filePath,String sheetName,int rowNum,int columnNum,String data) throws IOException
	{
		
		
		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(columnNum);
		cell.setCellValue(data);
		 fos = new FileOutputStream(filePath);
	}
	

}
