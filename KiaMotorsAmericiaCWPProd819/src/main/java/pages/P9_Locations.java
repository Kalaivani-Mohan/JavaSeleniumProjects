package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P9_Locations extends KMABase {
	
	public P9_Locations(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
		if(!verifyTitle("Locations")) {
			reportStep("This is not Locations Page", "FAIL");
		}
		
	}
	
	
		public P9_Locations vehicleCurrentLocation() {
			waitUntilElementVisisble("//*[@id='autoSearchInput']");
			Assert.assertTrue(driver.findElement(By.id("pinrefresh")).isDisplayed());
			return this;
		}
}


