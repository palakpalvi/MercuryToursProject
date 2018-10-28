package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {

	public static void main(String[] args) throws IOException 
	{
		File src = new File("C:\\Selenium\\ExcelData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		Iterator<Row> rowItr = ws.iterator();
		rowItr.next();
		
		while(rowItr.hasNext())
		{
			Row row = rowItr.next();
			Iterator<Cell> cellItr = row.iterator();
			
			while(cellItr.hasNext())
			{
				Cell cell = cellItr.next();
				System.out.println(cell.getStringCellValue());
			}
			System.out.println(" ");
		}
		wb.close();
		fis.close();
	}

}
