package com.TestBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.PageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass
{
	public static WebDriver driver;
	public static Logger logger;
	
	//-----object declaration-----
	public LoginPage login;
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("Dalal Street Framework");
		PropertyConfigurator.configure("Log4j.properties");
		
		logger.info("Framework execution started");
	}
	
	@AfterClass
	public void stop()
	{
		logger.info("Framework execution finished");
	}
	
	//@Parameters("browser")
	@BeforeMethod
	public void setup() throws InterruptedException 
	{
	
		String br="chrome";
	if(br.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("chrome launch");
	}
	else if(br.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		logger.info("firefox launch");
	}
	else if(br.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		logger.info("edge launch");
	}
	else
	{
		System.out.println("Please provide correct browser");
	}
		driver.get("https://suite8demo.suiteondemand.com/#/Login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//-----Obj initialization-----
		login = new LoginPage();
	}
}
