package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesfile {

	public static void main(String[] args) throws IOException 
	{
		FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		Properties pr=new Properties();
		pr.load(fr);
		
		
		System.out.println(pr.getProperty("browser"));
		System.out.println(pr.getProperty("testURL"));
		
	}

}
