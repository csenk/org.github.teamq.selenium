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

import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.find.Finder;

/**
 * A extended {@link Finder} contract which is able to restrict it's scope to
 * the found elements of {@link Finder}s supplied with {@link #in(Finder)}.
 * 
 * @param <S> the elements to be found
 * @param <T> the context where the elements should be found
 * @author senk.christian@googlemail.com
 */
public interface ChildFinder<S, T> extends Finder<S, T> {

    /**
     * {@inheritDoc}
     */
    @Override
    ChildFinder<S, T> with(Matcher<S> textMatcher);

    /**
     * Restricts the scope of this finder to elements found by the supplied
     * {@link Finder}.
     * 
     * @param finder the parent {@link Finder}.
     * @return this instance to make subsequent calls.
     */
    ChildFinder<S, T> in(final Finder<WebElement, WebDriver> finder);

}
