package com.datamato.tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.datamato.core.Driver;
import com.datamato.pages.Existing_User_Login;

public class Exisiting_User_Login_Test extends Driver{
	
	@Test(priority = 1)
	public void existingUserLoginPageLoadedTest() throws MalformedURLException, InterruptedException{
		Existing_User_Login existingUserLogin= new Existing_User_Login();
		Assert.assertEquals(existingUserLogin.didWelcomePageLoad(), "Welcome","Welcome Page did not load..");
	}
	
	//@Test(priority = 2)
	@Test(dependsOnMethods = "existingUserLoginPageLoadedTest")
	 public void mobileNumberOREmailTest() throws InterruptedException, MalformedURLException
	 { 
		Existing_User_Login existingUserLogin1= new Existing_User_Login();
		existingUserLogin1.mobileNumberOREmail();
		//Assert.assertEquals(arg0, arg1);
	 }
	    
} 
