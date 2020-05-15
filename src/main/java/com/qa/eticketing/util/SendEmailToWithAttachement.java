package com.qa.eticketing.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmailToWithAttachement {
	private String from;

	private List<String> to;

	private List<String> cc;
	
	/*
	private String to;

	private String cc;*/

	private String subject;

	private String messageBody;

	private String fileName;

	private String host;

	private String port;

	String strDataFileName = this.getClass().getSimpleName();
	
	public String strAbsolutepath = (new File("")).getAbsolutePath();

	private String strDataPath = this.strAbsolutepath + "\\src\\main\\java\\com\\qa\\eticketing\\testdata\\";

	private String strFilePath = this.strAbsolutepath + "/TestResults/";
	ReadDataFile readData = new ReadDataFile();
	int rownumber = 1;

	private Properties properties;

	private MimeMessage message;

	private BodyPart messageBodyPart;

	private Multipart multipart;

	private Authenticator authenticator;
	
	String PendingChenchuCount,PendingMCCCount,PendingDCCCount,PendingMobAppCount,PendingDWMAEFMSCount,PendingMISPortalCount;

	public void SendMailMethod(String PendingChenchuCount,String PendingMCCCount,String PendingDCCCount,
			String PendingMobAppCount,
			String PendingDWMAEFMSCount,
			String PendingMISPortalCount,
			int PendingTotalCount) {
		
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		
		this.from = "mayank_mishra@cms.co.in";
		
		to = FetchEmails(strDataFileName, "EMailForTo",  name);
		cc = FetchEmails(strDataFileName, "EMailForCC", name);

		
		/*this.to = "mayami0110@gmail.com";
		this.cc = "mayank_mishra@cms.co.in";*/
		String dateTime = (new SimpleDateFormat("dd-MM-yyyy hh:mm a")).format(Calendar.getInstance().getTime());
		String newfinalstatusText = "faf";
		this.subject = "MGNREGS e Ticketing System Report - " + dateTime ;
			
		this.messageBody = "<html><body> <h4>Hi All, &nbsp; </h4></body></html>";
		this.messageBody += "<html><body><h4>Please find the MGNREGS e Ticketing System Applications :</br></br></br></h4></body></html>";
		this.messageBody += "<html><body><h3><u> Total Applications Pending - Application Wise  :</u><h3> </body></html>";
		this.messageBody += "<html> <head> </head> <body> <table border=\"1\" cellpadding=\"1\" cellspacing=\"1\"> <tr style=\"background-color: #a9c2e8;\">";
		this.messageBody += "<td><strong>S No &nbsp;&nbsp;</strong></td><td><strong>Application	</strong></td><td><strong>Pending &nbsp;&nbsp;&nbsp; </strong></td><tr>";
		this.messageBody += "<td>1.&nbsp;</td><td>Chenchu  	&nbsp;</td><td>&nbsp;" + PendingChenchuCount +"&nbsp; </td><tr>";
		this.messageBody += "<td>2.&nbsp;</td><td>MCC  	&nbsp;</td><td>&nbsp;" + PendingMCCCount +"&nbsp; </td><tr>";
		this.messageBody += "<td>3.&nbsp;</td><td>DCC  	&nbsp;</td><td>&nbsp;"+PendingDCCCount+"&nbsp; </td><tr>";
		this.messageBody += "<td>4.&nbsp;</td><td>Mobile Application &nbsp;</td><td>&nbsp;"+PendingMobAppCount+"&nbsp; </td><tr>";
		this.messageBody += "<td>5.&nbsp;</td><td>DWMA EFMS &nbsp;</td><td>&nbsp;"+PendingDWMAEFMSCount+"&nbsp; </td><tr>";
		this.messageBody += "<td>6.&nbsp;</td><td>MIS Portal &nbsp;</td><td>&nbsp;"+PendingMISPortalCount +" &nbsp; </td></tr><tr>";
		this.messageBody += "<tr style=\"background-color: #a9c2e8;\"><td></td><td><strong>Total Pending Count &nbsp;</strong></td><td><strong>&nbsp;"+PendingTotalCount +" &nbsp; </strong></td></tr><tr></body></html>";
		
		
		
		/*if (newfinalstatusText.equalsIgnoreCase("Pass")) {
			this.messageBody += "<html><body><h1><u> STATUS :&nbsp;&nbsp;  <font color=\"Green\">" + newfinalstatusText
					+ "</u> <h1> </body></html>";
		} else {
			this.messageBody += "<html><body><h1><u> STATUS : &nbsp;&nbsp; <font color=\"Red\">" + newfinalstatusText
					+ " </u><h1> </body></html>";
		}*/
		this.messageBody += "<html><body><h4><font color=\"blue\">Note: This is an auto-generated mail. </br></br></br></font> </h4></body></html>";
		this.messageBody += "<html><body><h3> Thanks & Regards,</h3></body></html>";
		this.messageBody += "<html><body><h3> QA Team </h3></body></html>";
		this.fileName = "eTicketAbstract";
		
		
		
		
		
		this.host = "mail.cms.co.in";
		this.port = "587";
		this.authenticator = new SMTPAuthenticator();
		this.properties = System.getProperties();
		this.properties.put("mail.smtp.host", this.host);
		this.properties.put("mail.smtp.starttls.enable", "false");
		this.properties.put("mail.smtp.port", this.port);
		this.properties.put("mail.smtp.auth", "true");
		
		performTask();

	}
	
	
	public List<String> FetchEmails(String strDataFileName, String strElement,String Methodname) 
	{
		List<String> array= new ArrayList();

		try {
			int columnCount = 0;
			String[] Emails = new String[0];
			int rowNumber = 1;
			String strEmails = readData.readDataFile(strDataFileName, rowNumber, strElement , Methodname);

			Emails = strEmails.split(";");
			List<String> emailIds= Arrays.asList(Emails);

			columnCount = emailIds.size();

			for (int cnt = 0; cnt < columnCount; cnt++) 
			{
				String excelEmailValues = emailIds.get(cnt);
				array.add(excelEmailValues);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return array;
	}



	public void sendMail(String from, List<String> to2, List<String> cc2, String subject, String messageBody, String fileName) {
		try {
			Session session = Session.getDefaultInstance(this.properties, this.authenticator);
			this.message = new MimeMessage(session);
			this.message.setFrom((Address) new InternetAddress(from));
			
		/*	this.message.addRecipient(Message.RecipientType.TO, (Address) new InternetAddress(to2));
			this.message.addRecipient(Message.RecipientType.CC, (Address) new InternetAddress(cc2));*/

			for (String string : to2) 
			{
				message.addRecipient ( Message.RecipientType.TO,
						new InternetAddress ( string ) );            }

			for (String string : cc2) 
			{
				message.addRecipient ( Message.RecipientType.CC,
						new InternetAddress ( string ) );            }

			
			
			this.message.setSubject(subject);
			this.multipart = (Multipart) new MimeMultipart();
			this.messageBodyPart = (BodyPart) new MimeBodyPart();
			this.messageBodyPart.setContent(messageBody, "text/html");
			this.multipart.addBodyPart(this.messageBodyPart);
			 messageBodyPart = (BodyPart) new MimeBodyPart();
	         DataSource fds = new FileDataSource(strAbsolutepath + "\\Screenshot\\" + "e-TicketAbstract" + ".png");

	         messageBodyPart.setDataHandler(new DataHandler(fds));
	         messageBodyPart.setHeader("Content-ID", "<image>");
			messageBodyPart.setFileName ( fileName );
	         multipart.addBodyPart(messageBodyPart);
			this.message.setContent(this.multipart);
			Transport.send((Message) this.message);
			System.out.println("Message send successfully....");
		} catch (Exception me) {
			me.printStackTrace();
		}
	}

	public void performTask() {
		sendMail(this.from, this.to, this.cc, this.subject, this.messageBody, this.fileName);
	}

	/*public void SendMail() {
		SendMailMethod();
		performTask();
	}*/

	class SMTPAuthenticator extends Authenticator {
		private static final String SMTP_AUTH_USER = "mayank_mishra";

		private static final String SMTP_AUTH_PASSWORD = "Cms@123456";

		public PasswordAuthentication getPasswordAuthentication() {
			String username = "mayank_mishra";
			String password = "Cms@123456"; // updatedfd
			return new PasswordAuthentication(username, password);
		}
	}
}
