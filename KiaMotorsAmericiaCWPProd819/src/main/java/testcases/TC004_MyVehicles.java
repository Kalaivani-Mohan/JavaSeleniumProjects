package testcases;


import org.testng.annotations.Test;
import pages.P2_Login;
import wrappers.KMABase;

public class TC004_MyVehicles extends KMABase {
	
	@Test()
	public void myVehiclesPickTheVehicle() throws InterruptedException{
		
	new P2_Login(driver, test)
	
	.clickSignIn()
	.enterLoginEmailId("sson@mailinator.com")
	.enterLoginPassword("Password1")
	.clkSignIn()
	.verifyMyVechileScreen()
	.enterInvalidDataInSearchBox()
	.clickAndVerifyAddVechilesButton()
	.verifyAddYourVehiclePopUp();
	
//	.enterVehicle("My Telluride")
//	.pickTheCar("My Telluride");
	
	}
	}


	