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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.find.Finder;
import org.openqa.selenium.lift.find.XPathFinder;

/**
 * Base class for a widget {@link Finder}.
 * 
 * @author senk.christian@googlemail.com
 */
public abstract class WidgetFinder extends XPathFinder implements ChildFinder<WebElement, WebDriver> {

    private final String name;
    private final String xpath;

    private final List<Finder<WebElement, WebDriver>> finders = new ArrayList<Finder<WebElement, WebDriver>>();

    /**
     * @param name the widget name.
     * @param xpath the xpath matching the widget.
     */
    public WidgetFinder(final String name, final String xpath) {
        super(xpath);
        this.name = name;
        this.xpath = xpath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChildFinder<WebElement, WebDriver> with(final Matcher<WebElement> matcher) {
        super.with(matcher);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChildFinder<WebElement, WebDriver> in(final Finder<WebElement, WebDriver> finder) {
        finders.add(finder);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void describeTargetTo(final Description description) {
        description.appendText(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Collection<WebElement> extractFrom(final WebDriver context) {
        final Collection<WebElement> elements = findElements(context);
        if (elements == null) {
            return null;
        }

        final Set<WebElement> transformedElements = new HashSet<WebElement>();
        for (WebElement element : elements) {
            transformedElements.add(transformElement(element));
        }

        return transformedElements;
    }

    /**
     * Finds {@link WebElement}s either in the supplied {@link WebDriver}
     * context or if previously {@link #in(Finder)} was called in the elements
     * found by the supplied {@link Finder}s.
     * 
     * @param context the root {@link WebDriver} context.
     * @return a {@link Collection} of {@link WebElement}.
     */
    private Collection<WebElement> findElements(final WebDriver context) {
        if (finders.isEmpty()) {
            return super.extractFrom(context);
        }

        final Set<WebElement> parentElements = new HashSet<WebElement>();
        for (Finder<WebElement, WebDriver> finder : finders) {
            parentElements.addAll(finder.findFrom(context));
        }

        final Set<WebElement> resultElements = new HashSet<WebElement>();
        for (WebElement parentElement : parentElements) {
            resultElements.addAll(parentElement.findElements(By.xpath(xpath)));
        }

        return resultElements;
    }

    /**
     * Override this if you need to transform the supplied {@link WebElement}
     * into another {@link WebElement} instance.
     * 
     * @param element the {@link WebElement} which should be transformed.
     * @return the transformed {@link WebElement}.
     */
    protected WebElement transformElement(final WebElement element) {
        return element;
    }
}
