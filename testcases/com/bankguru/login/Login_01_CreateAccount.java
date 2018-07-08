package com.bankguru.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Login_01_CreateAccount {
  WebDriver driver;
  String loginUrl, email,userId, password;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  email = "automationfc" + randomEmail() + "@gmail.com";
  }
  
  @Test
  public void TC01_CreateAccount() {
	  driver.get("http://demo.guru99.com/v4/");
	  loginUrl = driver.getCurrentUrl();
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  userId = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td" )).getText();
	  password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td" )).getText();

  }
  
  @Test
  public void TC02_LoginWithAboveInfo() {
	  driver.get(loginUrl);
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\" Welcome To Manager's Page of Guru99 Bank\"]" )).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='heading3'/td[text()='Manger Id : " + userId + "']")).isDisplayed());
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  public int randomEmail() {
	  Random random = new Random();
	  int number =random.nextInt(999999);
	  return number;
  }
}
