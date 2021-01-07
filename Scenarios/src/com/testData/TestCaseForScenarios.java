package com.testData;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excelutil.ExcelUtil;
import com.pages.CalculatorPage;
import com.pages.GoogleMapPage;
import com.pages.QaagilityPage;

public class TestCaseForScenarios {
	WebDriver driver;
	GoogleMapPage map;
	QaagilityPage q;
	CalculatorPage cal;
	ExcelUtil read,read1;

	
  @Test(groups={"google"})
  
  public void mapTest() throws IOException {
	  
	  read= new ExcelUtil(System.getProperty("user.dir") + "\\src\\com\\scenarioTestData\\Scenariodata.xlsx");
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(read.getCellData("ScenariosTestData", 1, 0));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  
		map=new GoogleMapPage(driver);
	 	map.setGoogleMapPagesearchBox(read.getCellData("ScenariosTestData", 1, 1));
	  
	  try {
		  	map.googleMapsearchButton();
	  } catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		
	  }
	 
	  String WankhdeStadium=map.getGooglemapPageWankhedeStadium();
	  System.out.println(WankhdeStadium); 
	
	  String printRatings=map.getGoogleMapRatings();
	  System.out.println(printRatings);  
	
	  String printReviews=map.getGoogleMapRatings();
	  System.out.println(printReviews);
	  
	  
	  String googleMapPageTitle=map.getGoogleMapPageTitle();
	 
	  Assert.assertTrue(googleMapPageTitle.contains(read.getCellData("ScenariosTestData", 1, 3)));
	 
	  String wankhedetxt=map.getGooglemapPageWankhedeStadium();
	  Assert.assertEquals(wankhedetxt, read.getCellData("ScenariosTestData", 1, 2));
	  
  }
  
	  @Test(groups={"Qaagility"})
	 public void qaagility()
	 {
		  read= new ExcelUtil(System.getProperty("user.dir") + "\\src\\com\\scenarioTestData\\Scenariodata.xlsx");

		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(read.getCellData("ScenariosTestData", 1, 4));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		  QaagilityPage q=new QaagilityPage(driver);
		  
		  Dimension size1=q.sizeOfQaagilitylogo();
		  System.out.println(""+size1.width +  " "+size1.height);
		  boolean dis= q.twitterIsPresent();
		  Assert.assertTrue(dis,"twitter is present");
		  
		  String text1=q.getfooterlabel();
		 
		  Assert.assertTrue(text1.contains("QAAgility Technologies © 2020. All Rights Reserved"));
		  
		  
	 }
	  @Test(groups={"calculator"})
	  public void superSmartCalculator()
	  {
		  read= new ExcelUtil(System.getProperty("user.dir") + "\\src\\com\\scenarioTestData\\Scenariodata.xlsx");

		  System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("http://ata123456789123456789.appspot.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			
			cal=new CalculatorPage(driver);
			
			cal.getfirstnumber(read.getCellData("ScenariosTestData",1 ,6 ));
			cal.getsecondnumber(read.getCellData("ScenariosTestData",1 , 7));
			cal.clickonEuclid();
			cal.calculate();
			String result1=cal.result();
			System.out.println(result1);
			String result2=Integer.toString(cal.equation(7, 4));
			System.out.println(result2);
			Assert.assertEquals(result1, result2); 
			
			
	  }
	  
		  
	  
  }
  

