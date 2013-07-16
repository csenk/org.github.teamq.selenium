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

package org.github.teamq.selenium.lift.gxt.finder;

import org.github.teamq.selenium.lift.gxt.WebElementAdapter;
import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * {@link WidgetFinder} to locate buttons.
 * 
 * @author senk.christian@googlemail.com
 */
public class ButtonFinder extends WidgetFinder {

    private static final String CLICK_ELEMENT_PATH = "div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div";

    /**
     * {@link WebElement} to delegate methods like {@link #click()} to a nested
     * element.
     */
    private static class ButtonWebElement extends WebElementAdapter {

        private final WebElement clickElement;

        /**
         * @param webElement the adapted {@link WebElement}.
         */
        public ButtonWebElement(final WebElement webElement) {
            super(webElement);
            this.clickElement = webElement.findElement(By.xpath(CLICK_ELEMENT_PATH));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void click() {
            clickElement.click();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getText() {
            return clickElement.getText();
        }

    }

    /**
     * @return a default {@link ButtonFinder}.
     */
    @Factory
    public static ButtonFinder button() {
        return new ButtonFinder();
    }

    /**
     * Creates a new {@link ButtonFinder}.
     */
    public ButtonFinder() {
        super("Button", ".//div[" + CLICK_ELEMENT_PATH + "]");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected WebElement transformElement(final WebElement element) {
        return new ButtonWebElement(element);
    }

}
