package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		List<HashMap<String, String>> mapDatasList = new ArrayList(); 
		try {
	
			File excelLocaltion = new File("./Excel/Adactin.xlsx");
			String sheetName = "Adact";
			FileInputStream f = new FileInputStream(
					excelLocaltion.getAbsolutePath());
			Workbook w = new XSSFWorkbook(f);
			Sheet sheet = w.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> mapDatas = new HashMap<String, String>();
				for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
				
					switch (currentCell.getCellType() ) {
					case  NUMERIC :
			        mapDatas.put(headerRow.getCell(j).getStringCellValue(),
			        currentCell.getStringCellValue());
					break; 
					case Cell.CELL_TYPE_NUMERIC :
					mapDatas.put(headerRow.getCell(j).getStringCellValue(),
					String.valueOf(currentCell.getNumericCellValue()));
					break;
					} }
				mapDatasList.add(mapDatas); }
			// System.out.println(mapDatasList);
			String s = mapDatasList.get(1).get("Username"); 
			String s1 =mapDatasList.get(1).get("Password"); 
			System.out.println(s); System.out.println(s1);
		} catch (Throwable e) {
			e.printStackTrace(); 
		}
	}}
