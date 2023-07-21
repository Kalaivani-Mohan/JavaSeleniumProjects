package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P12_KIAConnectSubscription extends KMABase {
	

	
	public P12_KIAConnectSubscription(RemoteWebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver = driver;
		this.test =test;
		if(!verifyTitle("Kia Connect Subscription")){
			reportStep("This is not Kia Connect Subscription Page", "FAIL");	
		}		
	}
	
	
	public P12_KIAConnectSubscription UpgradePackageToUltimateAnnually() throws InterruptedException {
		waitUntilElementVisisble("//*[contains(text(),' Update Package')]");
		clickByXpath("//*[contains(text(),' Update Package')]");
		////*[@class='form-check form-check-inline']/label 
		clickByXpath("(//*[text()='Annual Subscription'])[2]");
		clickByXpath("(//*[text()='Select Package'])[4]");
		clickByXpath("//*[contains(text(),'PROCEED')]");
		waitUntilElementVisisble("//*[contains(text(),'Package Review')]");
		clickByXpath("//*[@id='custom-control-label']");
		clickByXpath("(//*[@class='custom-control-label'])[2]");
		clickByXpath("//*[contains(text(),'I Agree')]");
		waitUntilElementVisisble("//*[contains(text(),'Thank you for your order!')]");
		return new P12_KIAConnectSubscription(driver, test);
	}
	

}