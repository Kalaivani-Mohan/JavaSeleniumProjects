package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P0_Settings extends KMABase {
	
	public P0_Settings(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test =test;
		
		
		waitUntilElementVisisble("//*[@class='personal-tab active']");
		if(!verifyTitle("Settings")){
			reportStep("This is not Kia Owners Portal", "FAIL");	
		}		
	}

	
	
	public P0_Settings updatePersonalDetails(String address, String zipCode) {
		waitUntilElementVisisble("//*[text()='First Name ']");
	
		enterByXpath("//*[@name='addressLine1']", address);
		waitElementToBeClickableXpathFW();
		enterByXpath("//*[@id='personal_zipcode']", zipCode);
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("(//*[@type='submit'])[2]");
		waitUntilElementVisisble("(//*[@class='close'])[6]");
		return this;
	}
	
	
	
}
