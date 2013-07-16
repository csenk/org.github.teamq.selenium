package com.sencha.gxt.explorer.client.button;

import static org.github.teamq.selenium.lift.gxt.GXTFinders.button;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.lift.Matchers.text;

import org.github.teamq.selenium.lift.gxt.GXTWebDriverTestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ButtonAlignExampleTest extends GXTWebDriverTestCase {

    @Override
    protected WebDriver createDriver() {
        return new FirefoxDriver();
    }

    public void testClickOn() {
        goTo("http://localhost:8080/selenium-lift-gxt-demo/#ExamplePlace:buttonaligning");

        clickOn(button().with(text(equalTo("Button 1"))));
        clickOn(button().with(text(equalTo("Button 5"))));
        clickOn(button().with(text(equalTo("Button 8"))));
    }

}
