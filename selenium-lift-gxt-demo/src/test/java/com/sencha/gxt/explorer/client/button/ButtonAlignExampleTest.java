package com.sencha.gxt.explorer.client.button;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.lift.HamcrestWebDriverTestCase;

public class ButtonAlignExampleTest extends HamcrestWebDriverTestCase {

	@Override
	protected WebDriver createDriver() {
		return new FirefoxDriver();
	}

	public void testButtonClicking() {
		goTo("http://localhost:8080/selenium-lift-gxt-demo/#ExamplePlace:buttonaligning");
	}
	
}
