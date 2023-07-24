package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.TestNGUtils;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P10_Maintenance extends KMABase {

	public P10_Maintenance(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test =test;
		
		
		waitUntilElementVisisble("//*[@id='maintenancetab']");
		if(!verifyTitle("Maintenance")){
			reportStep("This is not Kia Owners Portal", "FAIL");	
		}		
	}
	
	public 	P10_Maintenance preferredDealer(String xpathValue, String dealerDetails) {
		waitUntilElementVisisble("(//*[@class='settings-icon'])[4]");
		clickByXpathJavascriptExecutor("(//*[@class='settings-icon'])[3]");
		waitUntilElementVisisble("//*[@name='dealer_map_search']");
		enterByXpathJSExecutor(xpathValue, dealerDetails);
		return this;
	}
	
}
