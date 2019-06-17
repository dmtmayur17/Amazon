package com.datamato.core;

import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver extends BaseSetup {
	protected AndroidDriver<MobileElement> driver;

    public Driver() {
        try {
			this.driver = super.getDriver();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
}
