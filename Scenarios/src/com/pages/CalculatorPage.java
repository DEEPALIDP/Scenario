package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CalculatorPage {
	WebDriver driver;
	
	//locators for Calculator 
	By firstnumber=By.id("ID_nameField1");
	By secondnumber=By.id("ID_nameField2");
	By radiobutton=By.id("gwt-uid-7");
	By calculator=By.id("ID_calculator");
	By result=By.xpath("//input[@type='text'][@id='ID_nameField3']");
	
	public CalculatorPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getfirstnumber(String a)
	{
		driver.findElement(firstnumber).clear();
		driver.findElement(firstnumber).sendKeys(a);

	}
	public void getsecondnumber(String b)
	{
		driver.findElement(secondnumber).clear();
		driver.findElement(secondnumber).sendKeys(b);
	}
	public void clickonEuclid(){
		driver.findElement(radiobutton).click();
	}
	public void calculate()
	{
		driver.findElement(calculator).click();
		
	}
	public String result()
	{
		return driver.findElement(result).getAttribute("value");
		
	}
	public int equation(int a,int b)
	{
		int result=a*2-2*(a*b)+b*2;
		return result;
	}
	
	
	
  
}
