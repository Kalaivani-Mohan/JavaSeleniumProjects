package pages;

import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P4_MyVehicles extends KMABase{

	
	public P4_MyVehicles(RemoteWebDriver driver, ExtentTest test) throws InterruptedException{
		this.driver = driver;
		this.test =test;
		waitUntilElementVisisble("//*[@class='vehicle-tab active']");
		if(!verifyTitle("Welcome")){
			reportStep("This is not Welcome Page", "FAIL");	
		}		
	}
	
	public P4_MyVehicles verifyMyVechileScreen() throws InterruptedException{
		
		waitUntilElementVisisble("//div[@class='my-vehicles-ulility-nav']//following::h1[contains(text(),'My Vehicles')]");
		if (driver.findElementByXPath("//div[@class='my-vehicles-ulility-nav']//following::h1[contains(text(),'My Vehicles')]").isDisplayed()) {
			reportStep("As expected user has been navigate to 'My vehicle' screen", "pass");
			if (driver.findElementByXPath("//input[@placeholder='Search']/../input").isDisplayed()) {
			String	text = getTextByXpath("//input[@placeholder='Search']/../input");
				reportStep("Vehicle search box is present name as "+text, "pass");
			}else {
				reportStep("Vehicle search box is not present", "Fail");
			}
			if (driver.findElementByXPath("//span[@title='Add Vehicle']").isDisplayed()) {
					reportStep("Add Vechile button is present", "pass");
				}else {
					reportStep("Add Vechile button not present", "Fail");
				}
			verifyCarDetails();
		}else {
			reportStep("Failed to navigate to My vehicle page", "Fail");
		}
		return this;
	}
	
	public P4_MyVehicles verifyCarDetails() throws InterruptedException{
		waitUntilElementVisisble("//*[@title='TELLURIDE']");
		if (driver.findElementByXPath("//*[@title='TELLURIDE']").isDisplayed()) {
			reportStep("As expected Car section is present under my vechile  ", "pass");
			String	mileageText = getTextByXpath("//*[@title='TELLURIDE']/../following-sibling::div//div//div//strong[normalize-space()='Mileage']//following-sibling::em");
			String	serviceText = getTextByXpath("//*[@title='TELLURIDE']/../following-sibling::div//div//div//strong[normalize-space()='Next Service In']//following-sibling::em");
			String	diagnosticText = getTextByXpath("//*[@title='TELLURIDE']/../following-sibling::div//div//div//strong[normalize-space()='Diagnostic Issue']//following-sibling::em");
				reportStep("As expected car 'Mileage' detail is present as "+mileageText, "pass");
				reportStep("As expected car 'Next Service In' detail is present as "+serviceText, "pass");
				reportStep("As expected car 'Diagnostic Issue' detail is present as "+diagnosticText, "pass");		
		}else {
			reportStep("Failed to display car section in my vehicle page", "Fail");
		}
		return this;
	}
	
	public P4_MyVehicles enterInvalidDataInSearchBox() throws InterruptedException{
		enterByXpath("//input[@placeholder='Search']/../input", "fhf");
		waitUntilElementVisisble("//div[@class='no-results-found show']");
		String	warningMsg = getTextByXpath("//div[@class='no-results-found show']");
		reportStep("As expected warning message is displayed as" + warningMsg, "Pass");
		return this;
	}

	public P4_MyVehicles clickAndVerifyAddVechilesButton() throws InterruptedException{
		clickByXpath("//span[@title='Add Vehicle']");
		waitUntilElementVisisble("//div[@class='item active remember-back']");
		reportStep("As expected 'Add your Vechile'pop up is displayed while clicking the 'Add vechile' button", "Pass");
		return this;
	}
		
	public P4_MyVehicles verifyAddYourVehiclePopUp() throws InterruptedException{
		if (driver.findElementByXPath("//span[@class='entervinlabel']/strong//following-sibling::input").getAttribute("value").isEmpty()) {
			String disableChk=driver.findElementByXPath("//span[@title='Verify VIN']").getAttribute("class");
			if (disableChk.contains("disabled")) {
				reportStep("As expected 'Verify vin' button is disabled", "Pass");
				
			}else {
				reportStep("Enabled", "Fail");
			}
		}
		
		return this;
	}
	
	public P4_MyVehicles clickVechiles() throws InterruptedException{
		clickByXpath("//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
		return this;
	}
	
	public P4_MyVehicles enterVehicle(String vehicleModel) {
		waitUntilElementVisisble("(//*[@title='TELLURIDE'])[1]");
//		waitVisibilityOfElementLocatedByName("userLoginId");
		enterByXpath("//input[@placeholder='Search']/../input", vehicleModel );
		return this;
	}	
	 
	public P5_Dashboard pickTheCar(String vehicleModel) throws InterruptedException {
		waitUntilElementVisisble("(//*[@title='TELLURIDE'])[1]");
		pickTheCar("//div[@class='my-vehicles-grid-item-header']/strong", vehicleModel, "(//*[@title='TELLURIDE'])[1]");   
		waitUntilElementVisisble("//*[@class='dropdown-toggle']");
		return new P5_Dashboard(driver, test);
	}		
}
		
	


