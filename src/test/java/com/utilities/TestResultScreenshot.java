package com.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestResultScreenshot extends TestInitializer{
	
	public static String capture(WebDriver driver, String screenShotName) throws Exception
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //String dest = prop.getProperty("screenShotFolderPath") + "\\"+ screenShotName+ ".png";
        String dest = "./TestReport/Screenshots/" +  screenShotName+ ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
        return dest;
    }
}
