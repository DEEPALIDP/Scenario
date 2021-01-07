package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;

public class QaagilityPage {
	
	WebDriver driver;
	
	public QaagilityPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	//locator
	By imgqaagilitylogo=By.xpath("//nav[@id='site-navigation']//img[@title='QAAgility Technologies']");
	By imglogotwitter=By.xpath("//div[@class='site-footer']//aside[@id='custom_html-4']//i[@class='fab fa-twitter']");
	By lblfooter=By.xpath("//footer//div//div[@class='copyright-bar']");
	
	
	public boolean twitterIsPresent()
	{
		   boolean display=driver.findElement(imglogotwitter).isDisplayed();
		   return display;
	}
	//get size of qaagility image logo
	public Dimension  sizeOfQaagilitylogo()
	{
		WebElement attribute=driver.findElement(imgqaagilitylogo);
		return attribute.getSize();
		//return attribute.getAttribute("size");
		
	}
	//get footer Label of qaagility page
	public String getfooterlabel()
	{
		 return driver.findElement(lblfooter).getText();
		
	}
	
	
	
  
}
