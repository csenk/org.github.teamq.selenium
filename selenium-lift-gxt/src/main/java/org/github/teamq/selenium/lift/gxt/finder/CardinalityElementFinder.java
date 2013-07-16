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
import org.openqa.selenium.lift.find.Finder;

/**
 * A {@link Finder} that wraps around another {@link Finder} and restricts the
 * found elements to a certain element with the supplied cardinality. NOTE: The
 * cardinality is 1-based.
 * 
 * @param <S> the elements to be found
 * @param <T> the context where the elements should be found
 * @author senk.christian@googlemail.com
 */
public class CardinalityElementFinder<S, T> implements Finder<S, T> {

    private final int cardinality;
    private final Finder<S, T> finder;

    /**
     * @param cardinality the element cardinality
     * @param finder the wrapped {@link Finder}.
     */
    public CardinalityElementFinder(final int cardinality, final Finder<S, T> finder) {
        this.cardinality = cardinality;
        this.finder = finder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void describeTo(final Description description) {
        finder.describeTo(description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<S> findFrom(final T context) {
        final Collection<S> found = finder.findFrom(context);
        if (found == null || found.isEmpty()) {
            return found;
        }

        final List<S> items = new ArrayList<S>(found);

        final Set<S> result = new HashSet<S>();
        result.add(items.get(cardinality - 1));

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Finder<S, T> with(final Matcher<S> textMatcher) {
        finder.with(textMatcher);
        return this;
    }

}
