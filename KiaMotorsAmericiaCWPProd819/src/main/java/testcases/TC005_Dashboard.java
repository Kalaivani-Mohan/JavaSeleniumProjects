package testcases;

import org.testng.annotations.Test;
import pages.P2_Login;
import wrappers.KMABase;

public class TC005_Dashboard extends KMABase {
	

	
	@Test()
	public void DashboardClickDoorUnLock( ) throws InterruptedException{
	
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId("sson@mailinator.com")
	.enterLoginPassword("Password1")
	.clkSignIn()
	.pickTheCar("My TELLURIDE")
	.clickDoorUnLock()
	.clickDashboardIcon()
	.clickDoorUnLock();
	
	}
}


	