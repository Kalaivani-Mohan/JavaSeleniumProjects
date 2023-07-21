package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import wrappers.KMABase;

public class TC009_Locations extends KMABase{
	
	
	
	@Test(priority=1, dataProvider="fetchData")
	public void LocationsSearchIsPresent(String emailId, String pwdLogin, String vehicleModel, String locationPOI, String tripTags) throws InterruptedException {
		new P2_Login(driver,test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel);
	}
}

