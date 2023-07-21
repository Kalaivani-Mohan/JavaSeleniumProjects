package testcases;

import org.testng.annotations.Test;

import pages.P1_CreateAccount;
import wrappers.KMABase;

//@Test(groups= {"smoke"})
public class TC001_CreateAccount extends KMABase {

	
	@Test(priority=1, groups= {"smoke"})
	public void verifyCreateAccount() throws InterruptedException{
	new P1_CreateAccount(driver, test)	
	.clickCreateAccountButton();
	}
}


	