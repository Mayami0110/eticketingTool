package com.qa.eticketing.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eticketing.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ETicketReportsPage extends TestBase {

	// @FindBy(id="ContentPlaceHolder1_gvdetailsnew") //
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_Receipt\"]/div/div/div[2]/div[1]")
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
	@FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gvdetailsnew\"]/tbody/tr/td[contains(text(),\"State EFMS\")]/following-sibling::td/a")
	WebElement PendingMobApp;

	public ETicketReportsPage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyETicketReportsPageTitle() {

		return driver.getTitle();

	}

	public void getScreenshotForTotalApplicationsPendingApplicationWise() {

	//	getScreenshot(TotalApplicationsPendingApplicationWise, "TotalApplicationsPendingApplicationWise2");
		getScreenshot("e-TicketAbstract");

		// return AddNewCustomerLabel.isDisplayed();
	}

	/*public void getScreenshot(WebElement element, String filename) {

		scrolToElement(element);

		File scrFile = element.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(strAbsolutepath + "\\Screenshot\\" + filename + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// return AddNewCustomerLabel.isDisplayed();
	}*/

	/*
	 * public void getScreenshot(String filename) {
	 * 
	 * // scrolToElement(element);
	 * 
	 * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * try { FileUtils.copyFile(scrFile, new File(strAbsolutepath +
	 * "\\Screenshot\\" + filename + ".png"));
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * // return AddNewCustomerLabel.isDisplayed(); }
	 */

	/*public void getScreenshot(String filename) {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "PNG",
					new File(strAbsolutepath + "\\Screenshot\\" + filename + ".png"));
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public List<String> getCountForTotalApplicationsPendingApplicationWise() {

		List<String> ls = new ArrayList<String>();

		try {
			ls.add(PendingChenchu.getText());
		} catch (Exception e) {
			String Noelement = "0";
			ls.add(Noelement);
		}
		try {
			ls.add(PendingMCC.getText());
		} catch (Exception e) {
			String Noelement = "0";
			ls.add(Noelement);
		}
		try {
			ls.add(PendingDCC.getText());
		} catch (Exception e) {
			String Noelement = "0";
			ls.add(Noelement);
		}

		try {
			ls.add(PendingMobApp.getText());
		} catch (Exception e) {
			String Noelement = "0";
			ls.add(Noelement);
		}
		try {
			ls.add(PendingDWMAEFMS.getText());
		} catch (Exception e) {
			String Noelement = "0";
			ls.add(Noelement);
		}
		try {
			ls.add(PendingMISPortal.getText());

		} catch (Exception e) {
			String Noelement = "0";
			ls.add(Noelement);
		}

		System.out.println(ls);

	/*	Set<String> st = new HashSet<String>(ls);
		System.out.println(st);
*/
		return ls;

	}

}
