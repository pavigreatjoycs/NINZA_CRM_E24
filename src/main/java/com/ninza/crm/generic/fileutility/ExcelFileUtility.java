package com.ninza.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String toReadTheDataFromExcel(String sheet, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fs = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		String data = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int toGetTheRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fs = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		int lastRowNum = wb.getSheet(sheet).getLastRowNum();
		return lastRowNum;
	}
	
	public List<String> toReadMultiSetOfData(int lastRowNum,String sheet, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fs = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		List<String> list = new ArrayList<String>();
		for(int i=1;i<=lastRowNum;i++) {
			String campaignName = wb.getSheet(sheet).getRow(i).getCell(cellNum).getStringCellValue();
			list.add(campaignName);		
			}
		return list;
		
	}
	
	public void toWriteTheDataToExcelFile(String sheetName,int rowNum,int cellNum,String text) throws EncryptedDocumentException, IOException {
		FileInputStream fs2 = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fs2);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(text);
		FileOutputStream fout = new FileOutputStream("./src/test/resources/testdata.xlsx");
		wb.write(fout);
		
		wb.close();
	}
}
