package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{


	@FindBy(name="email")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//div[@class='ui stacked segment']/div[3]")
	WebElement loginBtn;

	@FindBy(xpath="//div[@class='ui negative message']")
	WebElement invalidLogin;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgetBtn;

	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement singUpBtn;

	// Initializing PageFactory Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage validateLoginWithValidCred(String email,String pwd) {
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage(); 
			
	}
	
	public boolean validateLoginWithInvalidCred(String email1,String pwd1) {
		username.sendKeys(email1);
		password.sendKeys(pwd1);
		loginBtn.click();
		return invalidLogin.isDisplayed();
	}
	
	public boolean validateLogin(String email,String pwd) {
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
		return invalidLogin.isDisplayed();
	}
	
	public SignUpPage validateSignUpLink() {
		singUpBtn.click();
		return new SignUpPage();
	}
	
	
}
