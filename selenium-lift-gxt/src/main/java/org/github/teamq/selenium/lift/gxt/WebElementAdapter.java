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

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

/**
 * @author senk.christian@googlemail.com
 */
public class WebElementAdapter implements WebElement {

    private final WebElement webElement;

    /**
     * @param webElement the adapted {@link WebElement}
     */
    public WebElementAdapter(final WebElement webElement) {
        this.webElement = webElement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void click() {
        webElement.click();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void submit() {
        webElement.submit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendKeys(final CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        webElement.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAttribute(final String name) {
        return webElement.getAttribute(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return webElement.getText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<WebElement> findElements(final By by) {
        return webElement.findElements(by);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebElement findElement(final By by) {
        return webElement.findElement(by);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCssValue(final String propertyName) {
        return webElement.getCssValue(propertyName);
    }

}
