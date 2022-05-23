/**
 * 
 */
package com.rsa.qa.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Admin
 *
 */
public class XlUtililty {

	
static	FileInputStream fis;
static	FileOutputStream fos;
static	XSSFWorkbook workbook;
static	XSSFSheet sheet;
static	XSSFRow row;
static	XSSFCell cell;
	
public static int getLastRow(String path, String xlfile) throws IOException	
{
	fis= new FileInputStream(path);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(xlfile);
    int row=sheet.getLastRowNum();
    
    workbook.close();
    fis.close();
	return row;
	
}

public static int getLastCell(String path, String xlfile, int rownum) throws IOException
{
	fis= new FileInputStream(path);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(xlfile);
	row=sheet.getRow(rownum);
	int cell=row.getLastCellNum();
	workbook.close();
    fis.close();
    return cell;
}

public static String getCellData(String path, String xlfile, int rownum, int cellnum) throws IOException
{
	fis= new FileInputStream(path);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(xlfile);
	row=sheet.getRow(rownum);
	XSSFCell cell=row.getCell(cellnum);
	String data;
	try
	{
		DataFormatter format= new DataFormatter();
		String cellData=format.formatCellValue(cell);
		return cellData;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		data="";
	}
	workbook.close();
    fis.close();
    return data;
	
}

public static void setCellData(String path, String xlfile, int rownum, int cellnum, String data) throws IOException
{
	fis= new FileInputStream(path);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(xlfile);
	row=sheet.getRow(rownum);
	XSSFCell cell=row.getCell(cellnum);
	cell.setCellValue(data);
	fos= new FileOutputStream(path);
	workbook.write(fos);
	workbook.close();
	fos.close();
    fis.close();
}


}
