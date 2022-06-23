package readDataFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcel {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream("./testdata/RegistrationData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet =  workbook.getSheet("Student");
		//XSSFSheet sheetIndex =  workbook.getSheetAt(0);
		
		int rowsCount = sheet.getLastRowNum();
		
		int cloumnsCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Row: " + rowsCount);
		System.out.println("Columns: " + cloumnsCount);
		
		
		for (int i = 1; i <= rowsCount; i++) {
			
			
			XSSFRow currentRow = sheet.getRow(i); // row details
			
			
			String txt_firstName  = currentRow.getCell(0).toString();
			String txt_lastName  = currentRow.getCell(1).toString();
			String txt_email  = currentRow.getCell(2).toString();
			String txt_phone  = currentRow.getCell(3).toString();
			String txt_address  = currentRow.getCell(4).toString();
			
			System.out.println("FirstName: " + txt_firstName);
			System.out.println("Address: " + txt_address);
			
		}
		
		
		
		
	}

}
