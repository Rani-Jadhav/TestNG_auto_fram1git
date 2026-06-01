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
import org.testng.annotations.DataProvider;


public class readXLSdata {

//	public static void main(String[] args) throws EncryptedDocumentException, IOException 
//	{
//		readXLSdata red=new readXLSdata();
//		red.getdata("Login");
//}   //to use the testNG need to make it as a class so added cmt to this code so that this class we can use
	//anywhere and to execute it independenly we need this main method

	
	@DataProvider (name="testdata")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException
	{
		String excelsheet=m.getName();
		File f1=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\testdatssheet.xlsx");
	    FileInputStream Fin= new FileInputStream(f1);
	    Workbook w1= WorkbookFactory.create(Fin);
	    Sheet sheetname=w1.getSheet(excelsheet);
	    
	    
	    int totalrow= sheetname.getLastRowNum();
	    Row rowcells=sheetname.getRow(0);
	    int totalcall=rowcells.getLastCellNum();
	    System.out.println(totalrow);
	    System.out.println(totalcall);
	    
	    
	    DataFormatter form=new DataFormatter();
	    String testdata[][]=new String[totalrow][totalcall];
	    
	    for(int i=1;i<=totalrow;i++)
	    {
	    	for(int j=0;j<totalcall;j++)
		    {
		    	testdata[i-1][j]=form.formatCellValue(sheetname.getRow(i).getCell(j));
		    	System.out.println(testdata[i-1][j]);
		    }
	    }
	    
	return testdata;
	
	}
}
