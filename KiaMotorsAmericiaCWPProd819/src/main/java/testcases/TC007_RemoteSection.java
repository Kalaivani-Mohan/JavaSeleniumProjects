package testcases;

import org.testng.annotations.Test;

import pages.P2_Login;
import pages.P4_MyVehicles;
import wrappers.KMABase;

public class TC007_RemoteSection extends KMABase {

	
	
	@Test(priority=1, dataProvider="fetchData")
	public void RemoteSectionDoorUnlockRS(String emailId, String pwdLogin, String vehicleModel) throws InterruptedException {
		
		new P2_Login(driver, test)
		
		.clickSignIn()
		.enterLoginEmailId(emailId)
		.enterLoginPassword(pwdLogin)
		.clkSignIn()
		.pickTheCar(vehicleModel);
				
	}

}
