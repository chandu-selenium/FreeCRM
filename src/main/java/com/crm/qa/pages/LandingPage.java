package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase{
	
	public Actions actions;
	
	//PageFactory Objects - OR
	@FindBy(xpath="//div[contains(text(),'+1 415 200 2844')]")
	WebElement Telephone;
	
	@FindBy(xpath="//div[@class='rd-navbar-panel']//a[@class='brand-name']")
	WebElement Logo;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement Singup;
	
	@FindBy(xpath="//ul[@class='rd-navbar-nav']//a[@href='https://ui.freecrm.com']")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement AboutLink;
	
	@FindBy(xpath="//ul[@class='rd-navbar-nav']/li[3]")
	WebElement CrmDropDown;
	
	@FindBy(xpath="//ul[@class='rd-navbar-dropdown rd-navbar-open-right']//a[contains(text(),'CRM for Any Business')]")
	WebElement CrmAnyBusinessLink;
	
	//Initializing PageFactory Objects
	public LandingPage() {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	//Actions
	public String validateLandingPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateTelephoneNumberDisplay() {
		boolean Tel = Telephone.isDisplayed();
		return Tel;
	}
	
	public boolean validateCrmlogo() {
		boolean flag = Logo.isDisplayed();
		return flag;
	}
	
	public SignUpPage validateSingupLink() {
		Singup.click();
		return new SignUpPage();
	}

	public LoginPage validateLoginButtonLink() {
		LoginButton.click();
		return new LoginPage();
	}
	
	public String aboutLink() {
		AboutLink.click();
		return driver.getTitle();
	}
	
	public String validateCrmDropDwn() {
		
		actions.moveToElement(CrmDropDown).build().perform();
		CrmAnyBusinessLink.click();
		return driver.getTitle();
	}
}
