package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P13_AdditionalDrivers extends KMABase {
	

	
	public P13_AdditionalDrivers(RemoteWebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver = driver;
		this.test =test;
		if(!verifyTitle("Welcome")){
			reportStep("This is not Welcome Page", "FAIL");	
		}		
	}

	
	public P13_AdditionalDrivers addSecondaryDriver(String secondaryDriverEmailId ) {
		waitUntilElementVisisble("//*[@title='ADD DRIVER']");
		clickByXpathJavascriptExecutor("//*[@title='ADD DRIVER']");
		waitUntilElementVisisble("//*[text()='ADD DRIVER']");
		enterByXpath("(//*[@name='newDriverEmail'])[2]", secondaryDriverEmailId);
		waitUntilElementVisisble("//*[@id='addDriverbtn']");
		clickByXpath("//*[@id='addDriverbtn']");
		waitUntilElementVisisble("(//*[text()='CANCEL'])[2]");
		clickByXpath("(//*[@class='checkmark'])[4]");
		clickByXpath("(//*[@class='checkmark'])[5]");
		clickByXpath("(//*[@class='checkmark'])[6]");
		clickByXpath("(//*[@class='checkmark'])[7]");
		clickByXpath("(//*[@class='checkmark'])[8]");
		waitUntilElementVisisble("//*[text()='SEND REQUEST']");
		clickByXpathJavascriptExecutor("//*[text()='SEND REQUEST']");
		waitUntilElementVisisble("//*[text()='prodauto1@mailinator.com']");
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='prodauto1@mailinator.com']")).isDisplayed());
		waitElementToBeClickableXpathFW();
		return this;
	}
}