package com.applicationfunction;

import java.io.BufferedWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentTest;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.utilities.TestResults;

public class RestAPIFunctions {
	public static RequestSpecification request;
	public static Response response;
	public WebDriver driver;
	public RestAPIFunctions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void RestAPI(String URL, String Token, BufferedWriter writer, ExtentTest test) throws Exception 
	{	
		for (int i = 1; i < 4; i++) 
		{
			long startTime= 0;
			long finishTime = 0;
			String restAPI_url = URL + "&token=" + Token;
			try 
			{
				SSLCert( writer,  test);
				URL url = new URL(restAPI_url);
				HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
				httpUrlConnect.setConnectTimeout(10000);
				startTime = System.currentTimeMillis();
				System.out.println(startTime);
				httpUrlConnect.connect();
				if (httpUrlConnect.getResponseCode() == 200) 
				{
					finishTime = System.currentTimeMillis();
				}
				if (httpUrlConnect.getResponseCode() == httpUrlConnect.HTTP_NOT_FOUND) 
				{
					System.out.println(restAPI_url + " - " + httpUrlConnect.getResponseMessage() + " - " + httpUrlConnect.HTTP_NOT_FOUND);
				}
				TestResults.PrintResultToReport("Response time for page load when "+i+ " time hitting is - " + (finishTime - startTime) + " Milli Seconds.",  test);
			} catch (Exception error) {
				TestResults.PrintFailResultToReportWithoutScreenshot("Response got failed and error is:- "+ error,  test);
			}
			
		}
	}
	
	public void SSLCert(BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
		    SSLContext ssl_ctx = SSLContext.getInstance("TLS");
		        TrustManager[ ] trust_mgr = new TrustManager[ ] {
		    new X509TrustManager() {
		       public X509Certificate[ ] getAcceptedIssuers() { return null; }
		       public void checkClientTrusted(X509Certificate[ ] certs, String t) { }
		       public void checkServerTrusted(X509Certificate[ ] certs, String t) { }
		     }
		  };
		        ssl_ctx.init(null,                // key manager
		                     trust_mgr,           // trust manager
		                     new SecureRandom()); // random number generator
		        HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());
		    } catch(NoSuchAlgorithmException e) {
		        e.printStackTrace();
		    } catch(KeyManagementException e) {
		        e.printStackTrace();
		    }
	}
}
