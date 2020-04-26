package com.qa.eticketing.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import com.qa.eticketing.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public static String strAbsolutepath = new File("").getAbsolutePath() +"\\";

	public TestBase() {

		try {

			prop = new Properties();

			FileInputStream fpi = new FileInputStream(
					strAbsolutepath + "src\\main\\java\\com\\qa\\eticketing\\configs\\config.properties");

			prop.load(fpi);

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void initializations() {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.silentOutput","true");
		/*	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(capabilityName, value);*/
			System.setProperty("webdriver.chrome.driver",
					strAbsolutepath + "Resources\\chromedriver2.exe");
			driver = new ChromeDriver();
		}

		else	if (browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver",
					strAbsolutepath + "Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					strAbsolutepath + "Resources\\IEDriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		else 
		{
			System.out.println("Invalid Browser !!!! Value from Config File  : " + browserName );
		}
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		
		driver.get(prop.getProperty("url"));

	}
	

	public static void mailmethod() {

		SendMail();
}

	private static void SendMail() {
		// TODO Auto-generated method stub
		SendMailMethod();
		performTask();
	}

	private static void performTask() {
		// TODO Auto-generated method stub
		
	}

	private static void SendMailMethod() {
		// TODO Auto-generated method stub
		
	}


class SMTPAuthenticator extends Authenticator {

	private static final String SMTP_AUTH_USER = "mayank.mishra";
	private static final String SMTP_AUTH_PASSWORD = "srit@123";

	public PasswordAuthentication getPasswordAuthentication () {
		String username = SMTP_AUTH_USER;
		String password = SMTP_AUTH_PASSWORD;

		return new PasswordAuthentication( username,  password );
	}
}
}