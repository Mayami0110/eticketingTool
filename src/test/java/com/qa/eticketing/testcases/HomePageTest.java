package com.qa.eticketing.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.eticketing.base.TestBase;
import com.qa.eticketing.pages.ETicketReportsPage;
import com.qa.eticketing.pages.HomePage;
import com.qa.eticketing.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ETicketReportsPage eticketReportPage;
	
	public HomePageTest() {
		
		super();
	}
	
	//testcases should be independent from each other
	
	@BeforeMethod
	public void setup() {
		initializations();
		
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("homePageTitle"),"HomePageTitle is Not matching");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		
		Assert.assertTrue(homePage.verifyCorrectUserName(), "User Name is not Correct");
	}
	
	@Test(priority=3)
	public void verifyNewCustomerTest() {
		
		eticketReportPage= homePage.clickOnETicketReports();
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
