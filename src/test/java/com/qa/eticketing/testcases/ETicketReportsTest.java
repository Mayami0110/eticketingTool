package com.qa.eticketing.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.eticketing.base.TestBase;
import com.qa.eticketing.pages.ETicketReportsPage;
import com.qa.eticketing.pages.HomePage;
import com.qa.eticketing.pages.LoginPage;
import com.qa.eticketing.util.SendEmailTo;
import com.qa.eticketing.util.SendEmailToWithAttachement;

public class ETicketReportsTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ETicketReportsPage eticketReportPage;
	SendEmailTo sendEmailtTo;
	String PendingChenchuCount,PendingMCCCount,PendingDCCCount,PendingMobAppCount,
	PendingDWMAEFMSCount,
	PendingMISPortalCount;
	int PendingTotalCount;
	public ETicketReportsTest()
	{
		super();
	}
	
	//@BeforeMethod
	@BeforeTest
	public void setup() {
		
		initializations();
		
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		eticketReportPage= homePage.clickOnETicketReports();

	}
	
	//@Test(priority=1)
	public void verifyNewCustomerPageTitleTest() {
		
		String eticketReportPageTitle= eticketReportPage.verifyETicketReportsPageTitle();
		Assert.assertEquals(eticketReportPageTitle, prop.getProperty("ETicketReportsPageTitle"),"eticketReportPageTitle is Not matching");
	}
	
	@Test(priority=2)
	public void getScreenshotForTotalApplicationsPendingApplicationWiseTest() {
		
		eticketReportPage.getScreenshotForTotalApplicationsPendingApplicationWise();

		
	}
	@Test(priority=3)
	public void getCountForTotalApplicationsPendingApplicationWiseTest() {
		
		List<String> newls = eticketReportPage.getCountForTotalApplicationsPendingApplicationWise();
		PendingChenchuCount = newls.get(0);
		PendingMCCCount = newls.get(1);
		PendingDCCCount = newls.get(2);
		PendingMobAppCount = newls.get(3);
		PendingDWMAEFMSCount = newls.get(4);
		PendingMISPortalCount = newls.get(5);
		
		PendingTotalCount = Integer.parseInt(PendingChenchuCount)+Integer.parseInt(PendingMCCCount)+
				Integer.parseInt(PendingDCCCount)+Integer.parseInt(PendingMobAppCount)+
				Integer.parseInt(PendingDWMAEFMSCount)+Integer.parseInt(PendingMISPortalCount);

		SendEmailToWithAttachement sendEmailtTo = new SendEmailToWithAttachement();
		sendEmailtTo.SendMailMethod(PendingChenchuCount, PendingMCCCount, 
				PendingDCCCount, PendingMobAppCount, PendingDWMAEFMSCount, PendingMISPortalCount , PendingTotalCount);
	}
	
	
	//@AfterMethod
	@AfterTest
	public void teardown() {
		
	
		driver.quit();
	}

}
