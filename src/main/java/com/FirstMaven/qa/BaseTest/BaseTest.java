package com.FirstMaven.qa.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.FirstMaven.qa.pages.TestUtil;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest(){
		
		try {
		prop=new Properties();
		FileInputStream fip = new FileInputStream("C:\\Users\\ManoharDattaChebrolu\\Selenium_Practice1\\FirstMaven\\src\\main\\java\\com\\FirstMaven\\qa\\Configurations\\config.properties");
		prop.load(fip);	
		}catch(FileNotFoundException e) {
			System.out.println("No Such file");
		}
		catch(IOException e) {
			System.out.println("IO Exception");
		}
		
	}

	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\ManoharDattaChebrolu\\\\Downloads\\\\Selenium jars\\\\Drivers\\\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_time, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
