package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all reusable methods to perform operation on Excel file
 * @author sunil
 *
 */
public class ExcelFileUtility {
	
	private Workbook wb;
	/**
	 * This method is used to initialize excel
	 * @param filePath
	 */
	public void excelInitialization(String filePath)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to read one data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String fecthSingleData(String sheetName, int rowNum)
	{
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(1).getStringCellValue();
		return data;
	}
	/**
	 * This method is used to read multiple data from excel
	 * @param SheetName
	 * @return
	 */
	public List<String> readMultipleData(String SheetName)
	{
		List<String> dataList = new ArrayList<>();
		Sheet sheet = wb.getSheet(SheetName);
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			String data = sheet.getRow(i).getCell(1).getStringCellValue();
			dataList.add(data);		}
		return dataList;
	}
	/**
	 * This method is used to close excel workbook
	 */
	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
