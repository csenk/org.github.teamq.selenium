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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.find.Finder;
import org.openqa.selenium.lift.find.XPathFinder;

/**
 * {@link WidgetFinder} to locate combo boxes.
 * 
 * @author senk.christian@googlemail.com
 */
public class ComboBoxFinder extends InputFieldFinder {

    /**
     * {@link Finder} that finds the trigger nested in a combo box.
     */
    private class ComboBoxTriggerFinder implements ChildFinder<WebElement, WebDriver> {

        /**
         * {@inheritDoc}
         */
        @Override
        public void describeTo(final Description description) {
            description.appendText("ComboBox Trigger");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Collection<WebElement> findFrom(final WebDriver context) {
            final Collection<WebElement> comboBoxElements = ComboBoxFinder.this.findFrom(context);

            final Set<WebElement> result = new HashSet<WebElement>();
            for (WebElement comboBoxElement : comboBoxElements) {
                result.add(comboBoxElement.findElement(By.xpath("./div/table/tbody/tr/td[2]/div")));
            }

            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ChildFinder<WebElement, WebDriver> with(final Matcher<WebElement> textMatcher) {
            ComboBoxFinder.this.with(textMatcher);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ChildFinder<WebElement, WebDriver> in(final Finder<WebElement, WebDriver> finder) {
            ComboBoxFinder.this.in(finder);
            return this;
        }

    }

    /**
     * {@link Finder} that finds list view associated with a combo box. You
     * should use this finder only immedately after you clicked on the trigger.
     */
    private class ComboBoxListViewFinder extends ListViewFinder {

        /**
         * Creates a new {@link ComboBoxListViewFinder}.
         */
        public ComboBoxListViewFinder() {
            super.in(new XPathFinder("//body/div[last()]"));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void describeTo(final Description description) {
            description.appendText("ComboBox ListView");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ChildFinder<WebElement, WebDriver> with(final Matcher<WebElement> textMatcher) {
            ComboBoxFinder.this.with(textMatcher);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ChildFinder<WebElement, WebDriver> in(final Finder<WebElement, WebDriver> finder) {
            ComboBoxFinder.this.in(finder);
            return this;
        }

    }

    /**
     * @return a default {@link ComboBoxFinder}.
     */
    @Factory
    public static ComboBoxFinder comboBox() {
        return new ComboBoxFinder();
    }

    /**
     * Creates a new {@link ComboBoxFinder}.
     */
    public ComboBoxFinder() {
        super("ComboBox", "div/table/tbody/tr/td[1]/input[@type = 'text']");
    }

    /**
     * @return a {@link Finder} that locates the trigger of this combo box.
     */
    public ChildFinder<WebElement, WebDriver> trigger() {
        return new ComboBoxTriggerFinder();
    }

    /**
     * @return a {@link ListViewFinder} that locates the list view associated
     *         with the combo box.
     */
    public ListViewFinder listView() {
        return new ComboBoxListViewFinder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComboBoxFinder with(final Matcher<WebElement> matcher) {
        super.with(matcher);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComboBoxFinder in(final Finder<WebElement, WebDriver> finder) {
        super.in(finder);
        return this;
    }

}
