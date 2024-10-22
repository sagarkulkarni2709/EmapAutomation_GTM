package com.utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public static void DynamicWaitToLoadElement(WebDriver driver, String locatorName, By locator) throws Exception
    {
        for(int i = 0; i < 100; i++)
        {
            try
            {
                WebElement ele = null;
                switch (locatorName.toUpperCase())
                {
                    case "CLASSNAME":
                        ele = driver.findElement(locator);
                        break;
                    case "ID":
                        ele = driver.findElement(locator);
                        break;
                    case "XPATH":
                        ele = driver.findElement(locator);
                        break;
                    case "NAME":
                        ele = driver.findElement(locator);
                        break;
                    case "CSS":
                        ele = driver.findElement(locator);
                        break;
                    case "LINKTEXT":
                        ele = driver.findElement(locator);
                        break;
                }
                if (ele.isDisplayed() && ele.isEnabled())
                {
                    break;
                }
            }
            catch(Exception e)
            {
                Thread.sleep(100);
                continue;
            }
        }
    }
	
	public static void waitForElementClickable(WebDriver driver, By locator,long timeout) {
		WebElement ele = driver.findElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForElementVisible(WebDriver driver, By locator,long timeout) {
		WebElement ele = driver.findElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void waitForFrameToAvailable(WebDriver driver, By locator,long timeout) {
		WebElement ele = driver.findElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}
	
	public static void waitForLoadingIconToDisspear(WebDriver driver) throws InterruptedException {
		By loading = By.xpath("//div[@id='app-loading']");
		if(loading!=null) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
			Thread.sleep(1000);
		}
	}
	
	public static void waitForProgressBarToDisspear(WebDriver driver) throws InterruptedException {
		By loading = By.xpath("//div[@class='dijitProgressBarLabel']");
		if(loading!=null) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
			Thread.sleep(1000);
		}
	}
	
	public static void waitForLoadingNodeDisspear(WebDriver driver) throws InterruptedException {
		By loading = By.xpath("(//div[@class='loading-container'])[1]");
		if(loading!=null) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
			Thread.sleep(1000);
		}
	}
	
	public static void waitForAlertPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
}
