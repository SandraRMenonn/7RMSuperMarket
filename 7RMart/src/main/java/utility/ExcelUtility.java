package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtility {

	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String readStringData(int row, int col, String sheet) throws IOException {

		String filePath = Constant.TESTDATAPATH;
		f = new FileInputStream(filePath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static String readIntegerData(int row, int col, String sheet) throws IOException {

		String filePath = Constant.TESTDATAPATH;
		f = new FileInputStream(filePath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue();// convert double to int using typecasting
		return String.valueOf(val); // Converting to string as we are using int as strings here
		// return val; If we are using int value itself.

	}

}
