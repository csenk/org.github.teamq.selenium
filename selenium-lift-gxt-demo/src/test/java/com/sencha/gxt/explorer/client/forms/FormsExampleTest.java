/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sencha.gxt.explorer.client.forms;

import static org.github.teamq.selenium.lift.gxt.GXTFinders.comboBox;
import static org.github.teamq.selenium.lift.gxt.GXTFinders.fieldLabel;
import static org.github.teamq.selenium.lift.gxt.GXTMatchers.label;
import static org.github.teamq.selenium.lift.gxt.finder.TextFieldFinder.textField;
import static org.hamcrest.Matchers.startsWith;
import static org.openqa.selenium.lift.Matchers.text;

import org.github.teamq.selenium.lift.gxt.GXTWebDriverTestCase;
import org.github.teamq.selenium.lift.gxt.finder.ComboBoxFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author senk.christian@googlemail.com
 */
public class FormsExampleTest extends GXTWebDriverTestCase {

    /**
     * {@inheritDoc}
     */
    @Override
    protected WebDriver createDriver() {
        return new FirefoxDriver();
    }

    public void testTextField() {
        goTo("http://localhost:8080/selenium-lift-gxt-demo/#ExamplePlace:formsexample");

        type("Kevin", into(textField().in(fieldLabel().with(label(text(startsWith("Name")))))));
        type("kevin@minion.me", into(1, textField().in(fieldLabel().with(label(text(startsWith("Email")))))));
    }

    public void testComboBox() {
        goTo("http://localhost:8080/selenium-lift-gxt-demo/#ExamplePlace:formsexample");

        final ComboBoxFinder comboBox = comboBox().in(fieldLabel().with(label(text(startsWith("Company")))));
        clickOn(comboBox.trigger());
        clickOn(comboBox.listView().item(3));
    }
}
