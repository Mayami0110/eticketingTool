package com.qa.eticketing.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eticketing.base.TestBase;

public class ETicketReportsPage extends TestBase {

	

	// @FindBy(id="ContentPlaceHolder1_gvdetailsnew") //
	@FindBy(css = "#ContentPlaceHolder1_gvdetailsnew")
	WebElement TotalApplicationsPendingApplicationWise;

	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvdetailsnew\"]/tbody/tr/td[contains(text(),\"Chenchu\")]/following-sibling::td/a")
	WebElement PendingChenchu;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvdetailsnew\"]/tbody/tr/td[contains(text(),\"DCC\")]/following-sibling::td/a")
	WebElement PendingDCC;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvdetailsnew\"]/tbody/tr/td[contains(text(),\"MCC\")]/following-sibling::td/a")
	WebElement PendingMCC;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvdetailsnew\"]/tbody/tr/td[contains(text(),\"DWMA EFMS\")]/following-sibling::td/a")
	WebElement PendingDWMAEFMS;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvdetailsnew\"]/tbody/tr/td[contains(text(),\"MIS Portal\")]/following-sibling::td/a")
	WebElement PendingMISPortal;
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvdetailsnew\"]/tbody/tr/td[contains(text(),\"Mobile Application\")]/following-sibling::td/a")
	WebElement PendingMobApp;

	public ETicketReportsPage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyETicketReportsPageTitle() {

		return driver.getTitle();

	}

	public void getScreenshotForTotalApplicationsPendingApplicationWise() {

		
		
		getScreenshot(TotalApplicationsPendingApplicationWise, "TotalApplicationsPendingApplicationWise2");

		// return AddNewCustomerLabel.isDisplayed();
	}

	public void getScreenshot(WebElement element, String filename) {

		scrolToElement(element);
		
		File scrFile = element.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(strAbsolutepath + "\\Screenshot\\" + filename + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// return AddNewCustomerLabel.isDisplayed();
	}

	public List<String> getCountForTotalApplicationsPendingApplicationWise() {

		List<String> ls = new ArrayList<String>();
		ls.add(PendingChenchu.getText());
		ls.add(PendingDCC.getText());		
		ls.add(PendingMCC.getText());
		ls.add(PendingMISPortal.getText());
		ls.add(PendingDWMAEFMS.getText());
		ls.add(PendingMobApp.getText());

		System.out.println(ls);
		
		Set<String> st = new HashSet<String>(ls);
		System.out.println(st);

		return ls;


	}

}
