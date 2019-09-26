package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;


public class LandingPageTest extends TestBase{
	
	LandingPage landingPage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Intialization();
		landingPage = new LandingPage();
	}
	
	@Test
	public void validateLandingPageTitleTest() {
		String landingPageTitle = landingPage.validateLandingPageTitle();
		Assert.assertEquals(landingPageTitle, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test
	public void validateTelephoneNumberDisplayTest() {
		boolean tel = landingPage.validateTelephoneNumberDisplay();
		Assert.assertTrue(tel);
	}
	
	@Test
	public void validateCrmlogoTest() {
		boolean flag = landingPage.validateCrmlogo();
		Assert.assertTrue(flag);

	}
	
	@Test
	public void validateSingupLinkTest() {
		landingPage.validateSingupLink();
		
	}
	
	@Test
	public void validateLoginButtonLinkTest() {
		landingPage.validateLoginButtonLink();
		
	}
	
	@Test
	public void aboutLinkTest() {
		String aboutTitle = landingPage.aboutLink();
		Assert.assertEquals(aboutTitle, "Free CRM About cloud CRM software and services");
	}
	
	@Test
	public void validateCrmDropDwnTest() {
		String crmAnyBusinessTitle = landingPage.validateCrmDropDwn();
		Assert.assertEquals(crmAnyBusinessTitle, "Free CRM Cloud Software");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
