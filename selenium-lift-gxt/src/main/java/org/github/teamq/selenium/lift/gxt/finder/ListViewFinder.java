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

/**
 * A {@link WidgetFinder} to locate list views.
 * 
 * @author senk.christian@googlemail.com
 */
public class ListViewFinder extends WidgetFinder {

    /**
     * {@link Finder} that finds an item nested in a list view.
     */
    private class ListViewItemFinder implements ChildFinder<WebElement, WebDriver> {

        private final String xpath;

        /**
         * @param xpath the xpath used to locate a single item.
         */
        public ListViewItemFinder(final String xpath) {
            this.xpath = xpath;
        }

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
            final Collection<WebElement> comboBoxElements = ListViewFinder.this.findFrom(context);

            final Set<WebElement> result = new HashSet<WebElement>();
            for (WebElement comboBoxElement : comboBoxElements) {
                result.add(comboBoxElement.findElement(By.xpath(xpath)));
            }

            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ChildFinder<WebElement, WebDriver> with(final Matcher<WebElement> textMatcher) {
            ListViewFinder.this.with(textMatcher);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ChildFinder<WebElement, WebDriver> in(final Finder<WebElement, WebDriver> finder) {
            ListViewFinder.this.in(finder);
            return this;
        }

    }

    /**
     * @return a default {@link ListViewFinder}.
     */
    @Factory
    public static ListViewFinder listView() {
        return new ListViewFinder();
    }

    /**
     * Creates a new {@link ListViewFinder}.
     */
    public ListViewFinder() {
        super("ListView", ".//div[div[last()]/input[@type = 'text']]");
    }

    /**
     * A {@link Finder} that locates a certain item of this list view.
     * 
     * @param cardinality the cardinality of the item with a 1-based index.
     * @return a {@link Finder}.
     */
    public ChildFinder<WebElement, WebDriver> item(final int cardinality) {
        return new ListViewItemFinder("div[" + cardinality + "]");
    }

}
