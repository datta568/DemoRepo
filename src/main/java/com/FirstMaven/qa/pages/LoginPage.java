package com.FirstMaven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FirstMaven.qa.BaseTest.BaseTest;

public class LoginPage extends BaseTest {
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[contains(text(),'Login')]")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[contains(text(),'Log-in to Cogmento CRM')]")
	WebElement logo;
	
	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void verifyLogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
	}
	
	public void verifyLogo() {
		logo.isDisplayed();
	}
	
	
	
}
