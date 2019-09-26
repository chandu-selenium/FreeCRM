package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	CallsPage callsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Intialization();
		landingPage = new LandingPage();
		loginPage = landingPage.validateLoginButtonLink();

		loginPage = new LoginPage();
		homePage=loginPage.validateLoginWithValidCred(prop.getProperty("emailId"),prop.getProperty("password"));
	}
	
	@Test
	public void validateUserLableTest() {
		Assert.assertTrue(homePage.validateUserLable());
	}
	
	@Test
	public void validateContactsSettingIconTest() {
		Assert.assertTrue(homePage.validateContactsSettingIcon());
	}
	
	@Test
	public void validateContactHelpIconTest() {
		Assert.assertTrue(homePage.validateContactHelpIcon());
	}
	
	@Test
	public void verifyContactLinkTest() {
		contactsPage = homePage.verifyContactLink();
		String contactUrl=driver.getCurrentUrl();
		Assert.assertEquals(contactUrl, "https://ui.freecrm.com/contacts");
	}
	
	@Test
	public void verifyDealsLinkTest() {
		dealsPage = homePage.verifyDealsLink();
		String contactUrl=driver.getCurrentUrl();
		Assert.assertEquals(contactUrl, "https://ui.freecrm.com/deals");
	}
	
	@Test
	public void verifyTasksLinkTest() {
		tasksPage = homePage.verifyTasksLink();
		String contactUrl=driver.getCurrentUrl();
		Assert.assertEquals(contactUrl, "https://ui.freecrm.com/tasks");
	}
	
	@Test
	public void verifyCallsLinkTest() {
		callsPage = homePage.verifyCallsLink();
		String contactUrl=driver.getCurrentUrl();
		Assert.assertEquals(contactUrl, "https://ui.freecrm.com/calls");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
