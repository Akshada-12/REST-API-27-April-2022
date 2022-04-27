package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	//constructor to get excelPath and sheetName
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
		}
	}

	//functions to get row count
	public static void getRowCount() {

		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows : "+rows);
	}
	//function to get data from excel
	public static void getCellData(int rowNum, int colNum) {
		try {

			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println("Value : "+value);


		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
		}
	}

}