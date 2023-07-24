package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import wrappers.KMABase;

public class TC013_AdditionalDrivers extends KMABase {

		
	@Test(priority=1, dataProvider="fetchData")
	public void addSecondaryDriver(String emailId, String pwdLogin, String secondaryDriverEmailId) throws InterruptedException {
		new P2_Login(driver, test)
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn();
		
	}	
}
