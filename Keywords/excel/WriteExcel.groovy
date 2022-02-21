package excel

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kms.katalon.core.annotation.Keyword

public class WriteExcel {

	private  static int i = 0;

	@Keyword
	public void demoKey(String file, String name, String Column_Name, int rowCount) throws IOException{

		FileInputStream fis = new FileInputStream(new File(file));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		//		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		//		Row row = sheet.createRow(rowCount+1);
		//		Cell cell = row.createCell(rowCell);
		//		cell.setCellValue(name);
		//

		if (Column_Name=='Expected Result'){
			Row row = sheet.getRow(rowCount+1);
			Cell cell = row.createCell(2,0);
			cell.setCellType(cell.CELL_TYPE_STRING);
			cell.setCellValue(name);
			i = rowCount+1;
		} else if (Column_Name=='Actual Result'){
			Row row2 = sheet.getRow(rowCount+1);
			Cell cell2 = row2.createCell(3,0);
			cell2.setCellType(cell2.CELL_TYPE_STRING);
			cell2.setCellValue(name);
			i = rowCount+1;
		}else if (Column_Name=='Status'){
			Row row2 = sheet.getRow(rowCount+1);
			Cell cell2 = row2.createCell(4,0);
			cell2.setCellType(cell2.CELL_TYPE_STRING);
			cell2.setCellValue(name);
			i = rowCount+1;
		}

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
	}
}