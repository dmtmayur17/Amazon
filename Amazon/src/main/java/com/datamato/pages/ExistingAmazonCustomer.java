package com.datamato.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.datamato.core.Driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExistingAmazonCustomer extends Driver { 
    
    private static AndroidDriver<MobileElement> androidDriver; 
    
    public ExistingAmazonCustomer() throws MalformedURLException { 
            androidDriver = super.getDriver(); 
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this); 
    } 
    
    @AndroidFindBy(id="signin_to_yourAccount") 
    static WebElement SignInToAmazon; 
    
    @AndroidFindBy(id="sign_in_button") 
    static WebElement alreadyACustomerButton; 
    
    
    public String didHomePageLoad() throws InterruptedException
    { 
    	String str= SignInToAmazon.getText(); 
        return str; 
    } 
    
    public String clickOnAlreadyACustomerButton() throws InterruptedException
    { 
    	
    	alreadyACustomerButton.click();  
    	Thread.sleep(3000);
    	return "Clicked";
    }
    
    
}
