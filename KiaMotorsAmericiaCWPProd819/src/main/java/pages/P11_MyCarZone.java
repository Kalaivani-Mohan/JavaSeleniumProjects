package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P11_MyCarZone extends KMABase {
	
	public P11_MyCarZone(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test= test; 
		
		if(!verifyTitle("My Car Zone"))
			reportStep("This is not MyCarZone Page", "FAIL");
	}
		
	public P11_MyCarZone geoFenceAlerts(String alertName, String locationName) {
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='CREATE ALERT']");
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@title='Geo Fence Alert ']");
		waitElementToBeClickableXpathFW();
		enterByName("geofenceName", alertName);
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[text()=' Next: Set Boundaries ']");
		waitElementToBeClickableXpathFW();
		enterByName("searchLocation", locationName);
		waitElementToBeClickableXpathFW();
		clickByXpathJavascriptExecutor("//*[@class='button full has-spinner dtmSaveGeofenceAlert']");
		//waitUntilElementVisisble("(//*[@class='close'])[10]");
		return this;	
	}
	
	
}
