package until;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility {
	public static void captureScreenShot(int testID, WebDriver driver) throws IOException {
		TakesScreenshot shot=(TakesScreenshot)driver;
		File source=shot.getScreenshotAs(OutputType.FILE);
		Calendar cal=Calendar.getInstance();
		String time=cal.getTime().toString().replace(":", "-").replace("IST", " ");
		File Dest=new File("D:\\selenium\\ScreenShot\\Test"+testID+" "+time+".jpg");
		FileHandler.copy(source, Dest);
		
	}
	
	
	public static String  fetchData(String sheetName, int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("D:\\selenium\\Rahul.xlsx");
		Workbook book=WorkbookFactory.create(file);
		Sheet sheet=book.getSheet(sheetName);
		Row r=sheet.getRow(row);
		Cell c=r.getCell(col);
		
		try {
			String data=c.getStringCellValue();
			return data;
		}
		catch(Exception e) {
			double value=c.getNumericCellValue();
			long l=(long) value;
			String data=String.valueOf(l);
			return data;
		
		}
	}

}
