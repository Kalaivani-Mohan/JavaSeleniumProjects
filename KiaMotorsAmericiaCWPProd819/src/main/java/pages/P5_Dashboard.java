package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P5_Dashboard extends KMABase {
	

	public P5_Dashboard(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test =test;
		waitUntilElementVisisble("//*[@class='icon-info']");
		if(!verifyTitle("Dashboard")){
			reportStep("This is not Dashboard Page", "FAIL");	
		}		
	}
	
public P5_Dashboard clickDashboardIcon() {
		
		
	waitUntilElementVisisble("//i[@class='icon-dashboard']");
	clickByXpath("//i[@class='icon-dashboard']");
	return this;
		
}

	public P5_Dashboard clickDoorUnLock() {
		
		String lockText = driver.findElementByXPath("//span[contains(text(),'Doors are locked')]").getText();
		if (lockText.equalsIgnoreCase("Doors are locked")) {
		clickByXpathJavascriptExecutor("//span[@class='action-button state-1 btn-unlock']");
		waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
		clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
		clickByXpath("//i[@class='icon-remote']");
		acceptAlert();
		scrollDownJavaScriptExecutor("//span[contains(text(),'Vehicle is unlocked')]");
		waitUntilElementVisisble("//span[contains(text(),'Vehicle is unlocked')]");
				
		}else {
			String unlockText = driver.findElementByXPath("//span[contains(text(),'Doors are unlocked')]").getText();
			if (unlockText.equalsIgnoreCase("Doors are unlocked")) {
			clickByXpathJavascriptExecutor("//span[@title='Remote Command Lock']");
			waitUntilElementVisisble("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
			clickByXpath("//div[@class='alert alert-success alert-dismissible in']//button[@class='close']");
			clickByXpath("//i[@class='icon-remote']");
			acceptAlert();
			scrollDownJavaScriptExecutor("//span[contains(text(),'Vehicle is locked')]");
			waitUntilElementVisisble("//span[contains(text(),'Vehicle is locked')]");
		}
		
	}
		return this;
		
}

}

