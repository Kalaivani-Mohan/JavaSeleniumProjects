package testcases;

import org.testng.annotations.Test;


import pages.P2_Login;
import wrappers.KMABase;

public class TC000_Settings extends KMABase{
	

	@Test(priority=1, dataProvider="fetchData")
	public void personalDetails(String emailId, String pwdLogin, String address, String zipCode) throws InterruptedException{
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId(emailId)	
	.enterLoginPassword(pwdLogin)
	.clkSignIn(); 
	}	
}
	
	
	
	
	
