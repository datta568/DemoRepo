package com.FirstMaven.qa.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FirstMaven.qa.BaseTest.BaseTest;
import com.FirstMaven.qa.pages.LoginPage;
import com.FirstMaven.qa.pages.TestUtil;

public class LoginPageTest extends BaseTest {
	
	LoginPage login;

	public LoginPageTest(){
		super();
		}
	
	@BeforeTest
	public void setUp(){
		initialization();
		login = new LoginPage();
	}
	
	@Test(priority=2)
	public void verifyLoginTest() {
		login.verifyLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] testData(){
		Object data[][]=TestUtil.getTestData(TestUtil.sheetName);
		return data;
	}
	
	@Test(priority=1)
	public void verifyLogoTest() {
		login.verifyLogo();
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	

}
