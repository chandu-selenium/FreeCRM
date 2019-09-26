package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		Intialization();
		landingPage = new LandingPage();
		loginPage = landingPage.validateLoginButtonLink();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=TestUtil.getTestData("Sheet1");
		return data;
	}
	
	@Test
	public void validateLoginPageTitleTest() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "CRM");
	}
	
	@Test(dataProvider="getData")
	public void validateLoginTest(String username,String password) {
		Assert.assertTrue(loginPage.validateLogin(username, password));
	}
	
	/*@Test
	public void validateLoginWithValidCredTest() {
		String email = prop.getProperty("emailId");
		String pwd = prop.getProperty("password");
		homePage = loginPage.validateLoginWithValidCred(email, pwd);
		
	}
	
	@Test
	public void validateLoginWithInvalidCredTest() {
		String email1 = prop.getProperty("emailId1");
		String pwd1 = prop.getProperty("password1");
		Assert.assertTrue(loginPage.validateLoginWithInvalidCred(email1, pwd1));	
	}
	*/
	@Test
	public void validateSignUpLinkTest() {
		signUpPage = loginPage.validateSignUpLink();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://api.cogmento.com/register/");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
