package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.Format;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class readXLSdata {

//	public static void main(String[] args) throws EncryptedDocumentException, IOException 
//	{
//		readXLSdata red=new readXLSdata();
//		red.getdata("Login");
//}   //to use the testNG need to make it as a class so added cmt to this code so that this class we can use
	//anywhere and to execute it independenly we need this main method

	
	@DataProvider (name="testdata")
	public Object[][] getdata() throws IOException {
		
	    //String path=System.getProperty("user.dir")+"\\testData\\tesxldata.xlsx";  //we can use tis or file class
        File path=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdatssheet.xlsx"); //we can use this or String path stmt
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        
//        System.out.println(path.getAbsolutePath());
//        System.out.println(path.exists());
//        System.out.println("Total Sheets = " + wb.getNumberOfSheets());
//
//        for(int i=0; i<wb.getNumberOfSheets(); i++)
//        {
//            System.out.println("Sheet Name = " + wb.getSheetName(i));
//        }
//        
//        //Sheet sheet = wb.getSheet("regSeetName");   // <-- must match Excel sheet tab exactly
//        
//        Sheet sheet = wb.getSheet("regSeetName");
//
//        if(sheet == null)
//        {
//            throw new RuntimeException("Sheet not found");
//        }
        Sheet sheet = wb.getSheet("excelsheet");
        //Sheet sheet = wb.getSheetAt(0);
        

        int totalrow = sheet.getLastRowNum();
        int totalcall = sheet.getRow(0).getLastCellNum();
        System.out.println(totalrow);
	    System.out.println(totalcall);

        Object[][] data = new Object[totalrow][totalcall];
        DataFormatter df = new DataFormatter();  //DataFormatter is an Apache POI class used to read Excel cell values as displayed in Excel.
                                                 //It converts cell data into String format safely.

        for (int i = 1; i <= totalrow; i++) {
            Row row = sheet.getRow(i);

            for (int j = 0; j < totalcall; j++) {
                data[i - 1][j] = df.formatCellValue(row.getCell(j));
                System.out.println(data[i-1][j]);
            }
        }

        wb.close();
        fis.close();

        return data;
}
	
	
	
	
	
	
	
	
}
