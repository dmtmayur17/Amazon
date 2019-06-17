package com.datamato.core;

/**
 * @author Datamato
 * @version 1.0
 */

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseSetup {
	private final String appiumPort = "4723";
	private final String serverIp = "0.0.0.0";
	// String workingDevice = "a315e67c";
	String workingDevice = "d6f08719";
	private static AndroidDriver<MobileElement> driver;

	/**
	 * The @BeforeSuite annotated method will be run only once before all tests
	 * in this suite have run
	 */
	@BeforeSuite
	public void setup() throws MalformedURLException {
		init();
	}

	public AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
		return driver;
	}

	/**
	 * - init() Methods used to initialize Desired Capabilitiies and Android
	 * driver - This method generate communication of Mobile Device with Appium
	 * Studio Server.
	 */
	public void init() throws MalformedURLException {
		System.out.println("Application Started..");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "OnePlus5T");
		capabilities.setCapability("udid", workingDevice);
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		capabilities.setCapability("noReset", true);
		String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";

		try {
			System.out.println("Argument to driver object : " + serverUrl);
			driver = new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (NullPointerException | MalformedURLException ex) {
			throw new RuntimeException("appium driver could not be initialised for device ");
		}
	}

	/*
	 * @BeforeClass public void beforeClass(String className){
	 * System.out.println("-----------------------------------------");
	 * System.out.println("Starting Class :" + this.getClass().getName());
	 * System.out.println("-----------------------------------------");
	 * 
	 * }
	 * 
	 * @AfterClass public void afterClass(String className){
	 * System.out.println("-----------------------------------------");
	 * System.out.println("Ending Class :" + this.getClass().getName());
	 * System.out.println("-----------------------------------------"); }
	 */

	/**
	 * The @BeforeMethod annotated method will be run before each test method
	 */
	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("-----------------------------------------");
		System.out.println("Starting Method :" + method.getName());
		System.out.println("-----------------------------------------");
	}

	/**
	 * The @AfterMethod annotated method will be run after each test method
	 */
	@AfterMethod
	public void afterMethod(Method method) {
		System.out.println("-----------------------------------------");
		System.out.println("Ending Method :" + method.getName());
		System.out.println("-----------------------------------------");
	}

	/**
	 * The @AfterSuite annotated method will be run only once after all tests in
	 * this suite have run.
	 */
	@AfterSuite
	public void tearDown() {
		System.out.println("Application Closed..");
		driver.quit();
	}
}
