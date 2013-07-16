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
package org.github.teamq.selenium.lift.gxt;

import org.github.teamq.selenium.lift.gxt.finder.CardinalityElementFinder;
import org.github.teamq.selenium.lift.gxt.finder.LastElementFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.HamcrestWebDriverTestCase;
import org.openqa.selenium.lift.find.Finder;

/**
 * Derived {@link HamcrestWebDriverTestCase} to provide even more convenience
 * methods.
 * 
 * @author senk.christian@googlemail.com
 */
public abstract class GXTWebDriverTestCase extends HamcrestWebDriverTestCase {

    /**
     * Syntactic sugar to use with
     * {@link org.openqa.selenium.lift.HamcrestWebDriverTestCase type(String,
     * Finder<WebElement, WebDriver>)}, e.g. type("cheese", into(2, textbox()));
     * 
     * @param cardinality the cardinality of the element to find.
     * @param input the {@link Finder} to use.
     * @return a {@link Finder} that selects a certain element.
     */
    protected Finder<WebElement, WebDriver> into(final int cardinality, final Finder<WebElement, WebDriver> input) {
        return new CardinalityElementFinder<WebElement, WebDriver>(cardinality, input);
    }

    /**
     * Syntactic sugar to use with
     * {@link org.openqa.selenium.lift.HamcrestWebDriverTestCase type(String,
     * Finder<WebElement, WebDriver>)}, e.g. type("cheese",
     * intoFirst(textbox()));
     * 
     * @param input the {@link Finder} to use.
     * @return a {@link Finder} that selects the first element.
     */
    protected Finder<WebElement, WebDriver> intoFirst(final Finder<WebElement, WebDriver> input) {
        return into(1, input);
    }

    /**
     * Syntactic sugar to use with
     * {@link org.openqa.selenium.lift.HamcrestWebDriverTestCase type(String,
     * Finder<WebElement, WebDriver>)}, e.g. type("cheese",
     * intoLast(textbox()));
     * 
     * @param input the {@link Finder} to use.
     * @return a {@link Finder} that selects the last element.
     */
    protected Finder<WebElement, WebDriver> intoLast(final Finder<WebElement, WebDriver> input) {
        return new LastElementFinder<WebElement, WebDriver>(input);
    }

}
