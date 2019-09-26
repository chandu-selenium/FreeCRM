package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='user-display' and contains(text(),'Chand K')]")
	WebElement userLable;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@href='/deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@href='/tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[@href='/calls']")
	WebElement callsLink;
	
	@FindBy(xpath="//div[@class='content card-header']//i[@class='right floated help circle icon color-gray']")
	WebElement contactHelpIcon;
	
	@FindBy(xpath="//div[@class='content card-header']//i[@class='right floated setting icon color-gray']")
	WebElement contactSettingIcon;
	
	@FindBy(xpath="//div[@name='model_type']")
	WebElement uiSelectionDropDown;
	
	@FindBy(xpath="//div[@class='content ui segment']")
	WebElement activityHelp;
	
	
	//Initializing PageFactory Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUserLable() {
		return userLable.isDisplayed();
	}
	
	public boolean validateContactsSettingIcon() {
		contactSettingIcon.click();
		return uiSelectionDropDown.isDisplayed();
	}
	
	public boolean validateContactHelpIcon() {
		contactHelpIcon.click();
		return activityHelp.isDisplayed();
	}
	
	public ContactsPage verifyContactLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage verifyDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage verifyTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public CallsPage verifyCallsLink() {
		callsLink.click();
		return new CallsPage();
	}
}
