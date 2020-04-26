package com.qa.eticketing.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eticketing.base.TestBase;

public class ETicketReportsPage extends TestBase{
	
	@FindBy(id="ContentPlaceHolder1_gvdetailsnew")
	WebElement TotalApplicationsPendingApplicationWise;
	
	
	public ETicketReportsPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyETicketReportsPageTitle() {

		return driver.getTitle();

	}
	public void getScreenshotForTotalApplicationsPendingApplicationWise()
	{
		
		getScreenshot(TotalApplicationsPendingApplicationWise, "TotalApplicationsPendingApplicationWise");

		
		//return AddNewCustomerLabel.isDisplayed();
	}
	
	public void getScreenshot(WebElement element, String filename)
	{
		
		File scrFile = element.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(strAbsolutepath+"\\Screenshot\\"+filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//return AddNewCustomerLabel.isDisplayed();
	}
	
	
	

}
