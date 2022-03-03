package com.c6.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	XSSFWorkbook work_book;                   // 'XSSFWorkbook' is a class that is used to represent both high and low level Excel file formats.
	XSSFSheet sheet;                          // 'XSSFSheet' is a class which represents high level representation of excel spreadsheet. It is under org. apache.
/*	public static void main(String[] args) {
		ReadExcelFile re = new ReadExcelFile();
		
		int rows = re.getRowCount(0);
		System.out.println(rows);

		for (int i = 0; i < rows; i++) {
	         System.out.println(re.getData(0, i, 0)); // (sheetnumber, row, column)
	         System.out.println(re.getData(0, i, 1));		
		}
	}
*/
	public ReadExcelFile() {
	try {
	File s = new File(".\\TestData\\DDT_Testing.xlsx");
	FileInputStream stream = new FileInputStream(s); // 'FileInputStream' is a class which obtains input bytes from a file. It is used for reading byte-oriented data (streams of raw bytes) such as image data, audio, video etc.
 // 'FileInputStream' class is useful to read data from a file in the form of sequence of bytes. 
	work_book = new XSSFWorkbook(stream);

}
	catch(Exception e) {
	System.out.println(e.getMessage());
    }
}
	
	public String getData(int sheetnumber, int row, int column){
	sheet = work_book.getSheetAt(sheetnumber);
	
	DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
    String data = formatter.formatCellValue(sheet.getRow(row).getCell(column));                          // For String value.
   
	return data;
	}
	
	public int getRowCount(int sheetIndex){
	int row = work_book.getSheetAt(sheetIndex).getLastRowNum();
	row = row + 1;
	
	return row;
	
	}

}

