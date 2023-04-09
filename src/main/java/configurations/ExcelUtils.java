package configurations;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
      
  
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
    public ExcelUtils(String excelPath, String sheetName) throws Exception
	 {
		 // to locate the path of the file
		 FileInputStream fis = new FileInputStream(excelPath);
		// to get workbook
		 wb = new XSSFWorkbook(fis);
		// to get sheet 
		 sheet = wb.getSheet(sheetName);
	 }
	 
	 public void setCellData(int rowindex, int colindex, String excelpath,String result) throws Exception
	 {
		 FileOutputStream fos = new FileOutputStream(excelpath);
		 sheet.createRow(rowindex).createCell(colindex).setCellValue(result);
		 wb.write(fos);
	 }
	 public String getCellData(int rowindex, int colindex)
	 {
		return sheet.getRow(rowindex).getCell(colindex).getStringCellValue();
	 }
}
