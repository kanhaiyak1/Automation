package com.abof.generic;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
	
	public static final String FILE_PATH="./src/main/resources/testData.xlsx";
	
	/**
	 * @Author Kanhaiya
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @Desc: Method will read the data from excel sheet.
	 * @Date 19-01-2019
	 */
	
	public static String readData(String sheetName, int rowNum, int cellNum){
		String data="";
		try {
			Workbook workbook=WorkbookFactory.create(new FileInputStream(new File(FILE_PATH)));
			data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	//writeExcel---->> Assignment

}
