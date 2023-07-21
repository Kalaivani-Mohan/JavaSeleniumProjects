package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KMABase;

public class P2_Login extends KMABase{

		public P2_Login(RemoteWebDriver driver, ExtentTest test){
			this.driver = driver;
			this.test =test;
			waitUntilElementVisisble("//*[@id='header-signIn']");
			if(!verifyTitle("Kia Owners Portal")){
				reportStep("This is not Kia Owners Portal", "FAIL");	
			}		
		}
		
		
		public P2_Login clickSignIn() {
			clickByXpath("//*[text()=' SIGN IN ']");
			Assert.assertTrue(driver.findElement(By.id("resetIconClick")).isDisplayed());
			return this;	
		}
		
		
		public P2_Login enterLoginEmailId(String emailId) {
			waitVisibilityOfElementLocatedByName("userLoginId");
			enterByName("userLoginId", emailId );
			return this;
		}		
		
		public P2_Login enterLoginPassword(String pwdLogin) throws InterruptedException{
			waitVisibilityOfElementLocatedByName("userLoginPwd");
			enterByName("userLoginPwd", pwdLogin);
			return this;
		}
			
		
		public P4_MyVehicles clkSignIn() throws InterruptedException{
			clickByXpath("//*[@class='button full main has-spinner sign-in']");
			return new P4_MyVehicles(driver, test);
			
		}
//		public P2_Login clickVechiles() throws InterruptedException{
//			clickByXpath("//strong[contains(text(),'My TELLURIDE')]/ancestor::div[@class='my-vehicles-grid-item-card']");
//			return this;
//		}
		
		
		
}
		

