package com.qa.eticketing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eticketing.base.TestBase;



public class HomePage extends TestBase{
	
	@FindBy(id = "lblusername")
	WebElement usernameLabel;

	@FindBy(id = "navbarDropdownMenuLink6")
	WebElement navbarDropdownETicketMenu;

	@FindBy(id = "liTicketAbstract")
	WebElement eticketAbstractLink;

	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();

	}
	
	public boolean verifyCorrectUserName() {

		return usernameLabel.isDisplayed();
	

	}

	public ETicketReportsPage clickOnETicketReports() {

		Actions act = new Actions(driver);
		act.moveToElement(navbarDropdownETicketMenu).build().perform();
		eticketAbstractLink.click();
		
		return new ETicketReportsPage();

	}

	
}
