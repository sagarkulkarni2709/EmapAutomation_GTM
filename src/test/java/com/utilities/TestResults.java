package com.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestResults extends TestInitializer {
	
	public static SendReport sendReport = new SendReport();
	public static TestStatistics testStatistics = new TestStatistics();
	
	public static FileWriter FileWriter ;
	public static BufferedWriter writer;
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentTest test ;
	public static ExtentReports extent;
	public static Map<String, Object[]> studentData;
	public static FileOutputStream out;
	public static XSSFWorkbook workbook;
	public static XSSFSheet spreadsheet;
	public static ITestResult result;
	public static String filename;
	
	public static void WriteTestContext(String message, BufferedWriter writer) throws Exception
    {
		writer.write("\n" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss")) + " " + message);
    }
	
	public static void PrintResultToReport(String message, ExtentTest test) throws Exception
    {
		test.log(Status.PASS, message);
    }
	
	public static void PrintFailResultToReportWithoutScreenshot(String message, ExtentTest test) throws Exception
    {
		test.log(Status.FAIL, message);
    }
	
	public static void PrintResultToReportWithScreenshot(String message, ExtentTest test) throws Exception
    {
		Thread.sleep(2000);
		String filename = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss").format(new Date());
        String screenShot = TestResultScreenshot.capture(driver, filename);
        //test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + screenShot).build());
        test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath("." + screenShot).build());
    }
	
	public static void PrintFailResultToReport(String message, ExtentTest test) throws Exception
    {
		//test.log(Status.FAIL, message);
		Thread.sleep(2000);
		String filename = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss").format(new Date());
        String screenShot = TestResultScreenshot.capture(driver, filename);
		test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath("." + screenShot).build());
    }
	
	public static BufferedWriter printToTxt(String TestName) throws Exception
    {
		 try {
			String currentDir = System.getProperty("user.dir");
			 String FilePath = "\\TestLogs";
			 String DirectoryPath = currentDir + FilePath;
			 File directory = new File(DirectoryPath);
			 if(! directory.exists())
			{
				 directory.mkdir();
			}
			 File FileCreate = new File(directory + "\\TestResult-" + TestName + new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + ".txt");
			 FileCreate.createNewFile();
			 FileWriter = new FileWriter(FileCreate);
			 writer = new BufferedWriter(FileWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return writer;
    }
	
	public static ExtentReports TestReport(String TestName)
	{
		try {
			filename =  "\\TestResult-" + TestName + new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()) ;
			htmlReporter = new ExtentHtmlReporter(prop.getProperty("testReport") + filename + ".html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("Automation Test Report");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return extent;
	}
	
	public static void printHeader(String text) throws Exception
	{
		writer.write("\n" + "\n" + "**********" + " " + text + "**********");
	}

	public static void printStepResult(String text) throws Exception
	{
		writer.write("\n" + text);
	}
	
	public static void CloseFile() throws Exception 
	{
		writer.write("\n" + "------------------------------------------------------------------------------------------------------------------------------------------------------");
		writer.close();
		extent.flush();
		KillChromeDriver();
		testCaseNo = 1;
		//CopyLatestReportToSharedDrive();
	}
	
	public static void SendEmail() throws Exception
	{
		sendReport.SendMailWithAttachment();
	}
	
	public static void CloseFileWithoutDriver() throws Exception 
	{
		writer.write("\n" + "------------------------------------------------------------------------------------------------------------------------------------------------------");
		writer.close();
		extent.flush();
		testCaseNo = 1;
	}
	
	public static void ClearData() throws Exception 
	{
		testData.clear();
	}
	
	public static void KillChromeDriver() throws Exception
	{
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static File getTheNewestFile(String filePath, String ext) {
		File theNewestFile = null;
		try {
			
		    File dir = new File(filePath);
		    @SuppressWarnings("deprecation")
			FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		    File[] files = dir.listFiles(fileFilter);

		    if (files.length > 0) {
		        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		        theNewestFile = files[0];
		    }
		} catch (Exception e) {
		}
		return theNewestFile;
	}
	
	public static void CopyLatestReportToSharedDrive() throws Exception
	{
		File latestGeneratedFilename = getTheNewestFile("./TestReport", "html");
		File dest = new File("//usops//Operations//FME_Processes//FME_InputOutput//Test//EMapUIAutomationRegressionTestReport//TestReports//" + filename + ".html");
		try {
		    FileUtils.copyFile(latestGeneratedFilename, dest);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
