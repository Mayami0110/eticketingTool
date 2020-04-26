package com.qa.eticketing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.eticketing.base.TestBase;

public class LoginPage extends TestBase {

	// page factory or OR

	/*
	 * By username = By.id("username"); By password = By.id("password");
	 * 
	 * By loginBtn = By.xpath("loginBtn");
	 * 
	 * By signUp = By.xpath("//*[@id=\"hs-login\"]/div[1]/a/i18n-string");
	 */

	/*@FindBy(id = "username")
	WebElement username;
	// By password = By.id("password");
	@FindBy(id = "password")
	WebElement password;

	// By loginBtn = By.xpath("loginBtn");
	@FindBy(id = "loginBtn")
	WebElement loginBtn;

	// By signUp = By.xpath("//*[@id=\"hs-login\"]/div[1]/a/i18n-string");

	@FindBy(xpath = "//*[@id=\"hs-login\"]/div[1]/a/i18n-string")
	WebElement signUp;

	// *[@id="canonical-link"]
*/
	
	@FindBy(id = "ContentPlaceHolder1_txtuname")
	WebElement username;
	// By password = By.id("password");
	@FindBy(id = "ContentPlaceHolder1_txtpsw")
	WebElement password;

	// By loginBtn = By.xpath("loginBtn");
	@FindBy(id = "ContentPlaceHolder1_lnkbtnLogin")
	WebElement loginBtn;

	// By signUp = By.xpath("//*[@id=\"hs-login\"]/div[1]/a/i18n-string");

	@FindBy(xpath = "//*[@id=\"hs-login\"]/div[1]/a/i18n-string")
	WebElement signUp;
	
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();

	}

}
	