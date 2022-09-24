package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
////import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public static Actions a;

	public static Robot r;
	
	public static JavascriptExecutor js;
	
//	public static ExtentReports extentReport;
//	
//	//public static ExtentHtmlReporter htmlReporter;
//	
//	public static ExtentTest test;
	
	public static void launchBrowser() {
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

	}
	
//public static void generateReport() {
//	//blank html
//	//ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
//	
//	//report
//	ExtentReports extent=new ExtentReports();
//	
//	extent.attachReporter(reporter);
//	
//	ExtentTest Test = extent.createTest("tc001-search");
//	
//	Test.pass("enter the userid");
//	Test.pass("enter the password");
//	Test.pass("click btn");
//	extent.flush();
//	

//		ExtentTest test=extentReport.createTest("launch browser");
//		 extentReport=new ExtentReports();
//		 htmlReporter=new ExtentHtmlReporter("ExtentReport.html");
//		 extentReport.attachReporter(htmlReporter);


	//}

	public static void passUrl(String url) {

		driver.get(url);

	}

	public static void maxBrowser() {

		driver.manage().window().maximize();

	}

	public static void toInput(WebElement element, String input) {

		element.sendKeys(input);

	}

	public static void btnClick(WebElement element) {

		element.click();

	}

	public static void radioBtnclick(WebElement element) {

		element.submit();
	}

	public static void entireBrowser() {

		driver.quit();

	}

	public static void closebrowser() {
		driver.close();

	}

	public static void printText(WebElement element) {

		System.out.println(element.getText());

	}

	public static void getValue(WebElement element) {

		System.out.println(element.getAttribute("value"));

	}

	public static void printUrl() {

		System.out.println(driver.getCurrentUrl());

	}

	public static void printTitle() {

		System.out.println(driver.getTitle());

	}

	public static void toPerformMouseHoverAction(WebElement element) {

		a = new Actions(driver);

		a.moveToElement(element).perform();

	}

	public static void toPerformEnter() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void toPerformTabs() {
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}
	public static void toPerformDragandDrop( WebElement src, WebElement des) {
		
		a.dragAndDrop(src, des);

	}
	
	public static  void rightClick() {
		
		a.contextClick().perform();

	}
	
	public static void doubleClick(WebElement element) {
		
		a.doubleClick(element);

	}
	public static void toGetSingleWindowId() {
		
		driver.getWindowHandle();

	}
	
	public static void toGetMultipleWindowId() {

		driver.getWindowHandles();
	}
	
	public  static void toSwitchoverBtnWindows(String name) {
		
		driver.switchTo().window(name);
		

	}
	
	public static void javaScriptsetAttributr(WebElement element, String name) {
		
		 js= (JavascriptExecutor)driver;
		 
		 js.executeScript("arguments[0].setAttribute('value','name')", element);

		
	}
	public static void quickInteractionPrintText(WebElement element, String name) {
		
		js.executeScript("arguments[0].getAttribute('value','name')", element);

	}
	
	public static void quickInteractionClick(WebElement btnclick) {
		
		js.executeScript("arguments[0].click()",btnclick);

	}
	
	public static void screenshot(String filename) throws IOException {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File des= new File("C:\\Users\\Admin\\eclipse-workspace\\Cucumber2\\target\\screenshot");
		
		FileUtils.copyFile(src, des);

	}
	
	

	public static String excelRead(int row, int cell) throws IOException {

		File file = new File("C:\\Users\\Admin\\Downloads\\Sample\\src\\data\\data.xlsx");

		FileInputStream f1 = new FileInputStream(file);

		Workbook w = new XSSFWorkbook(f1);

		Sheet s = w.getSheet("Sheet1");

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {

			Row r = s.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {

				Cell c = r.getCell(j);

				int cellType = c.getCellType();

				String value;

				if (cellType == 1) {

					value = c.getStringCellValue();

				}

				else if (DateUtil.isCellDateFormatted(c)) {

					Date d = c.getDateCellValue();

					SimpleDateFormat s1 = new SimpleDateFormat("dd-mm-yyyy");

					value = s1.format(d);

				} else {
					double dd = c.getNumericCellValue();

					long l = (long) dd;

					value = String.valueOf(l);
				}

				return value;

			}

		}
		return null;

	}

}


