package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import wrappers.KMABase;

public class TC010_Maintenance extends KMABase{
	
	
	
	@Test(priority=1, dataProvider="fetchData")
	public void checkNextMaintenanceMiles(String emailId, String pwdLogin, String vehicleModel, String expectedValue) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel);
	}
}

