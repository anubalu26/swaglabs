package anusha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class saucedemo {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void set() 
	{
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void urlloading()
	{
		driver.get(" https://www.saucedemo.com/");
	}
	
	@Test
	public void login()
	{
		WebElement username=driver.findElement(By.id("//*[@id=\"user-name\"]"));
		WebElement password=driver.findElement(By.id("//*[@id=\"password\"]"));
		WebElement login=driver.findElement(By.name("//*[@name=\"login-button\"]"));
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		login.click();
		String actualUrl="https://www.saucedemo.com/";
    	String expectedUrl=driver.getCurrentUrl();
    	Assert.assertEquals(expectedUrl,actualUrl);
		
	}
	@Test
	public void sort()
	{
		WebElement price=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
		Select select=new Select(price);
		select.selectByValue("price(low to high)");
		
	}
	
	@Test
	public void addtocart()
	{
	 driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
   	 driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
   	 driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
   	 driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
   	 driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
	}
	
	@Test
	public void remove()
	{
		float price = 0;
		driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
		WebElement remove_button = driver.findElement(By.id("//*[@id=\"remove-sauce-labs-backpack\"]"));
		if(price<15) 
		{
			remove_button.click();
		}
	}
		
		@Test
		public void checkout()
		{
			 driver.findElement(By.id("//*[@id=\"checkout\"]")).click();
		}
		
		@Test
		public void continuebutton()
		{
			 driver.findElement(By.id("first-name")).sendKeys("blesson");
	    	 driver.findElement(By.id("last-name")).sendKeys("jacob");
	    	 driver.findElement(By.id("postal-code")).sendKeys("679815");
	    	 driver.findElement(By.id("continue")).click();
		}
		
		@Test
		public void finish()
		{
			 driver.findElement(By.id("finish")).click();
		}

		@Test
		public void returnhomepage()
		{
			driver.findElement(By.id("back-to-products")).click();
		}
		
		@Test
		public void logout()
		{
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.id("logout_sidebar_link")).click();
			
			//closebrowser
			
			driver.quit();
		}
		
		
		
		
}
