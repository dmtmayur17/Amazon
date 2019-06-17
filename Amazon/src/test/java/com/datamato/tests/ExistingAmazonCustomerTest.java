package com.datamato.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.datamato.core.Driver;
import com.datamato.pages.ExistingAmazonCustomer;

public class ExistingAmazonCustomerTest extends Driver{
	
	@Test(priority = 0)
	public void homePageLoadedTest() throws MalformedURLException, InterruptedException{
		ExistingAmazonCustomer existCust= new ExistingAmazonCustomer();
		Assert.assertEquals(existCust.didHomePageLoad(), "Sign in to your account","Home Page did not load..");
	}
	
	@Test(dependsOnMethods = "homePageLoadedTest")
	 public void clickOnAlreadyACustomerButtonTest() throws InterruptedException, MalformedURLException
	 { 
		ExistingAmazonCustomer existCust= new ExistingAmazonCustomer();
		Assert.assertEquals(existCust.clickOnAlreadyACustomerButton(), "Clicked","Successfully clicked on Existing Customer Button..");
	 }
	    
} 
