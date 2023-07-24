package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P7_RemoteSection extends KMABase {
	
	public P7_RemoteSection(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		//waitUntilElementVisisble("//*[@class='icon-info']");
		if(!verifyTitle("Remote")) {
			reportStep("This is not Remote Page", "FAIL");
		}
	}
		
		public P7_RemoteSection clickDoorUnLockRS()  {
			waitVisibilityOfElementLocatedByID("securitytab");
			clickByXpathJavascriptExecutor("//*[@class='remote-security-unlock action-button state-1']");
			waitVisibilityOfElementLocatedByXpath("(//*[@class='close'])[5]");
			return this;		
	}
		

		
	

}
