package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P8_Schedules extends KMABase {

	public P8_Schedules(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test =test;
		
		if(!verifyTitle("Schedules")){
			reportStep("This is not Schedules Page", "FAIL");	
		}		
	}
	
	public P8_Schedules createNewSchedule() throws InterruptedException {
		waitUntilElementVisisble("//*[@title='Create Schedule']");
		clickByXpathJavascriptExecutor("//*[@title='Create Schedule']");
		clickByXpathJavascriptExecutor("//*[@title='Create Climate Schedule']");
		waitElementToBeClickableXpathFW();
		//clickByXpathJavascriptExecutor("(//*[@class='ui-dial-temperateure'])[1]");
		clickByXpathJavascriptExecutor("//*[@class='up']");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@id='createClimateForm']/ul/li[2]/div/div[2]/div/div[5]/span/label/span");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("(//*[@class='checkbox checkbox-round'])[1]");
		waitElementToBeClickableXpathFW();
		/*clickByXpathJavascriptExecutor("//*[@id='createClimateForm']/ul/li[5]/span/label/span");
		waitElementToBeClickableXpathFW();*/
		clickByXpathJavascriptExecutor("//*[@title='Save New Climate Schedule']");
		//waitUntilElementVisisble("(//*[@class='button main has-spinner'])[1]");
		clickByXpathJavascriptExecutor("(//*[@class='button main has-spinner'])[1]");
		waitUntilElementVisisble("(//*[@class='close'])[8]");
		return this;
	}	
}
