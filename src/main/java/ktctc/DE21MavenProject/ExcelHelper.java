package ktctc.DE21MavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	XSSFSheet sh;
	public ExcelHelper(String fileName, String sheetName)
	{

		try {
			File f = new File(System.getProperty("user.dir")+"\\"+fileName);
			
			FileInputStream fis = new  FileInputStream(f);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			 sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			
		} 
	}
	
	public ArrayList<String> getKeysListFromExcel()
	{
ArrayList<String> keys = new ArrayList<>();
		
		for (int i=1; i<sh.getPhysicalNumberOfRows();i++)
		{
			XSSFRow row = sh.getRow(i);		
		
		XSSFCell cel = row.getCell(0);
		
		String each = getValueFromCellAccordingToitsType(cel);
		
		keys.add(each);
			
		}
		
		return keys;
	}
	
	public ArrayList<String> getValuesListFromExcel()
	{
ArrayList<String> values = new ArrayList<>();
		
		for (int i=1; i<sh.getPhysicalNumberOfRows();i++)
		{
			XSSFRow row = sh.getRow(i);		
		
		XSSFCell cel = row.getCell(1);
		
		String each = getValueFromCellAccordingToitsType(cel);
		
		values.add(each);
			
		}
		
		return values;
	}
	
	public ArrayList<String> getDataFromMentionedColumnFromExcel(int columnNumber)
	{
ArrayList<String> values = new ArrayList<>();
		
		for (int i=1; i<sh.getPhysicalNumberOfRows();i++)
		{
			XSSFRow row = sh.getRow(i);		
		
		XSSFCell cel = row.getCell(columnNumber);
		
		String each = getValueFromCellAccordingToitsType(cel);
		
		values.add(each);
			
		}
		
		return values;
	}
	
	// Get column data by using column header
	
	public HashMap<String,String> getKeysValuePairFromExcel()
	{
		
		HashMap<String, String> data = new HashMap<>();
		for (int i=1; i<sh.getPhysicalNumberOfRows();i++)
		{
			XSSFRow row = sh.getRow(i);		
		
		XSSFCell cel = row.getCell(0);
		
		String eachKey = getValueFromCellAccordingToitsType(cel);
		cel = row.getCell(1);
		String eachVal = getValueFromCellAccordingToitsType(cel);
		data.put(eachKey, eachVal);			
		}
		
		return data;
	}
	
	
	
	public static String getValueFromCellAccordingToitsType(XSSFCell cel)
	{
CellType ctype = cel.getCellType();
		Object data = null;
		switch (ctype) {
		case STRING:
			data = cel.getStringCellValue();
			break;
			
		case NUMERIC:
			data = cel.getNumericCellValue();
			break;
		case BOOLEAN:
			data = cel.getBooleanCellValue();
			break;
			
		case BLANK:
			data = "Blank";
			System.out.println("cell does not have value");
			break;
		case FORMULA:
			data = cel.getCellFormula();
			break;

		default:
			data = "Blank";
			System.out.println("unknown cell type");
			break;
		}	
		
		return data.toString();
	}

}
