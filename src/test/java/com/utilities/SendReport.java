package com.utilities;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendReport extends TestResults{
	
	public static int pass = 0;
	public static int fail = 0;
	public static int skipped = 0;
	public static int TotalCount = 0;
	
	public void SendMailWithAttachment () throws Exception
	{
		try {
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true");
	        props.setProperty("mail.smtp.host", "smtp.enbridge.com");
	        props.setProperty("mail.smtp.port", "25");
			
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("sagar.kulkarni@enbridge.com", "Associate#2024");
						}
					});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(propConfig.getProperty("MailFrom")));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(propConfig.getProperty("TORecipient")));
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(propConfig.getProperty("CCRecipient")));
			if (propConfig.getProperty("Environment").toUpperCase().equals("PROD"))
				message.setSubject("Emap(GTM) Prod Env - Automation test execution Summary");
			else if(propConfig.getProperty("Environment").toUpperCase().equals("TEST"))
				message.setSubject("Emap(GTM) Test Env - Automation test execution Summary");
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setContent("***This is Auto generated mail triggered after automation execution of Emap scenarios***" + 
					"<br/>" + "<br/>" + "<b>"+"Hello All, "+ "<br/>" + 
					"<br/>" + "<br/>" + "<b>"+"Below mentioned is the Execution Summary :- "+"<b>" + "<br/>" + "<br/>" +"<table width='100%' border='1' align='center'>"
	                + "<tr align='center'>"+ "<td><b>Test Result <b></td>"  + "<td><b>Count<b></td>" + "</tr>"
					+"<tr align='center'>"+ "<td>Total Run </td>"  + "<td>"+(pass+fail+skipped)+"</td>" + "</tr>"
					+ "<tr align='center'>"+ "<td>Pass </td>"  + "<td>"+pass+"</td>" + "</tr>"
					+ "<tr align='center'>"+ "<td>Fail </td>"  + "<td>"+fail+"</td>" + "</tr>"
					+ "<tr align='center'>"+ "<td>Skip </td>"  + "<td>"+skipped+"</td>" + "</tr>"+ "</table>"+ "<br/>" + "<br/>" + "<b>"+"Thanks,"+ "<br/>" +  "<br/>" + "<b>"+"Sagar K"
					,"text/html;charset=UTF-8" );
			
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			File latestGeneratedFilename = getTheNewestFile("./TestReport", "html");
			DataSource source = new FileDataSource(latestGeneratedFilename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.attachFile(latestGeneratedFilename);
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException  e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
}

