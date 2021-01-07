package com.pages;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleMapPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	//locators
	
	//locator for searchbox
	By searchboxinput=By.id("searchboxinput");
	
	//locator for searchbutton
	By searchbutton=By.id("searchbox-searchbutton");
	
	//locator for text
	By text1=By.xpath("//span[text()='Wankhede Stadium']");
	
	//locator for ratings
	By ratings=By.xpath("//div[@id='pane']//span[@class='section-star-display']");
	
	//locator for reviews
	By reviews=By.xpath("//span[@class='section-rating-term-list']//button[contains(@jsaction,'rating')]");
	
	
	
	public GoogleMapPage(WebDriver driver)
	{
		this.driver=driver;  
		wait=new WebDriverWait(driver, 30);//this refer current class instance variable
	}
	
	/**
	 * Author: Deepali Pawar
	 * method: setGoogleMapPageSearchBox
	 * @param txt(Set value in Searchbox Input)
	 * Input on Google Map Page
	 */
	
	public void setGoogleMapPagesearchBox(String txt)
	{
		driver.findElement(searchboxinput).sendKeys(txt);
		
	}
	
	/** 
	 * Author: Deepali Pawar
	 * method: googleMapSearchButton
	 */
	public void googleMapsearchButton() throws IOException{
		driver.findElement(searchbutton).click();
		GoogleMapPage.getGoogleMapPageScreenshot(driver);
	}
	
	
	public String getGoogleMapStadiumText(){
		 String text=wait.until(ExpectedConditions.visibilityOfElementLocated(text1)).getText();
		 return text;
		
	}
	
	
	public String getGoogleMapRatings(){
		return	driver.findElement(ratings).getText();
		
	}
	
	public String getGoogleMapReviews(){
	
		return driver.findElement(reviews).getText();
			
	}
	
	
	public String getGoogleMapPageTitle()
	{
		return driver.getTitle();
	}

	public String getGooglemapPageWankhedeStadium()
	{
		WebElement txt=driver.findElement(text1);
		 String stadiumText=txt.getText();
		
		return stadiumText;
	}
	

	public static void  getGoogleMapPageScreenshot(WebDriver  webdriver) throws IOException
	{	
		File file=((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./ScrShot/googlemap.png"));
		
		
	}
	}
 

