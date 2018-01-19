package Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.Properties;

public class ORFile
{
	public static String getlocator(String strxpath) throws IOException,FileNotFoundException
	{
	String xpath;
	
	Properties prop=new Properties();
    FileInputStream file=new FileInputStream(Utilities.Testutilities.OR_E1);
	prop.load(file);
	xpath=prop.getProperty(strxpath);
	return xpath;
	}
	
}


