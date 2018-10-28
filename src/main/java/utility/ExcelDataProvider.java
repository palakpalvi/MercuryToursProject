package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@BeforeClass
	public void testSetup() {
		
	}
	
	@org.testng.annotations.Test(dataProvider="empLogin")
	public void VerifyInvalidLogin(String userName, String password) {
		
		System.out.println(userName);
		System.out.println(password);
		
		
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() throws IOException {
		Object[][] arrayObject = getExcelData("D:\\Test.xlsx","Sheet1");
		return arrayObject;
	}
	
	public String[][] getExcelData(String fileName, String sheetName) throws IOException {
		
		String[][] arrayExcelData = null;
		
		FileInputStream fs = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet ws = wb.getSheet(sheetName);
		
		int rowno = ws.getLastRowNum();
		System.out.println("Row Number = "+rowno);
		int colCount=ws.getRow(0).getLastCellNum();
		System.out.println("Col Number = "+colCount);
		
		arrayExcelData = new String[rowno][colCount];//Define Size
		
		for (int i= 0 ; i < rowno; i++) {
			
			XSSFRow row = ws.getRow(i+1);

				for (int j=0; j < colCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				String value = cell.getStringCellValue();
				
				arrayExcelData[i][j] = value;


			}

		}
		
		
		return arrayExcelData;
	}

}
