package com.datamato.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.datamato.core.Driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Existing_User_Login extends Driver { 
    
    private static AndroidDriver<MobileElement> androidDriver; 
    
    public Existing_User_Login() throws MalformedURLException { 
            androidDriver = super.getDriver(); 
            PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this); 
    } 
    
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]") 
    static WebElement welcomeText; 
    
    @AndroidFindBy(id="ap_email_login") 
    static WebElement mobileNoEmailID; 
    
    @AndroidFindBy(id="login_accordion_header")
    static WebElement loginTap; 
    
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.widget.Button") 
    static WebElement continueButton; 
    
    
    public String didWelcomePageLoad() throws InterruptedException
    { 
    	String welcomeTxt= welcomeText.getText();
    	System.out.println("Welcm mayur: " +welcomeTxt);
        return welcomeTxt; 
    } 
    
    @SuppressWarnings("deprecation")
	public void mobileNumberOREmail() throws InterruptedException
    { 
    	   	
    	mobileNoEmailID.sendKeys("9403293156"); 
    	continueButton.click();
    	Thread.sleep(3000);
    }
    
    
}
