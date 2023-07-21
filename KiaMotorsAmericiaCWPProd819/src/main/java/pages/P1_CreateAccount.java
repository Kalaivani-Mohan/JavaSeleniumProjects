package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P1_CreateAccount extends KMABase {
	
	
	
	public P1_CreateAccount(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test =test;
		
		
		waitUntilElementVisisble("//*[@id='header-signIn']");
		if(!verifyTitle("Kia Owners Portal")){
			reportStep("This is not Kia Owners Portal", "FAIL");	
		}		
	}
	

	public P1_CreateAccount clickCreateAccountButton() {
		clickByXpath("//*[@class='header-createAccount btn btn-block']");
		Assert.assertTrue(driver.findElement(By.id("resetIconClick")).isDisplayed());
		return this;
	}	
	
}
