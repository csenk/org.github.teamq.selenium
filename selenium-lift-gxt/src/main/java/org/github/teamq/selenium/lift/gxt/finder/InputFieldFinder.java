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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * A {@link WidgetFinder} that finds widgets containing one input element.
 * 
 * @author senk.christian@googlemail.com
 */
public class InputFieldFinder extends WidgetFinder {

    /**
     * {@link WebElement} to delegate methods like {@link #click()} or
     * {@link #sendKeys(CharSequence...)} to a nested input element.
     */
    private class InputFieldWebElement extends WebElementAdapter {

        private final WebElement inputElement;

        /**
         * @param webElement the adapted {@link WebElement}.
         */
        public InputFieldWebElement(final WebElement webElement) {
            super(webElement);
            this.inputElement = webElement.findElement(By.xpath(xpath));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void click() {
            inputElement.click();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getText() {
            return inputElement.getText();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void sendKeys(final CharSequence... keysToSend) {
            inputElement.sendKeys(keysToSend);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            inputElement.clear();
        }

    }

    private final String xpath;

    /**
     * @param name the name of the widget.
     * @param xpath the xpath locator for the input element.
     */
    public InputFieldFinder(final String name, final String xpath) {
        super(name, ".//div[" + xpath + "]");
        this.xpath = xpath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected WebElement transformElement(final WebElement element) {
        return new InputFieldWebElement(element);
    }

}
