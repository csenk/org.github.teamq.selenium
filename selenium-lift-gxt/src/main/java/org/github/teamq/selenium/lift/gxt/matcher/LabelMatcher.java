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
package org.github.teamq.selenium.lift.gxt.matcher;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * A {@link TypeSafeMatcher} that delegates to another {@link Matcher} after
 * searching for a &lt;label&gt; {@link WebElement} and supplying this as the
 * context for the next {@link Matcher}.
 * 
 * @author senk.christian@googlemail.com
 */
public class LabelMatcher extends TypeSafeMatcher<WebElement> {

    private final Matcher<WebElement> matcher;

    /**
     * @param matcher the next {@link Matcher}.
     * @return a {@link LabelMatcher}.
     */
    @Factory
    public static Matcher<WebElement> label(final Matcher<WebElement> matcher) {
        return new LabelMatcher(matcher);
    }

    /**
     * @param matcher the next {@link Matcher}.
     */
    public LabelMatcher(final Matcher<WebElement> matcher) {
        this.matcher = matcher;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void describeTo(final Description description) {
        description.appendText("label ");
        matcher.describeTo(description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean matchesSafely(final WebElement item) {
        final List<WebElement> labels = item.findElements(By.xpath("./label"));
        if (labels.isEmpty() || labels.size() > 1) {
            return false;
        }

        return matcher.matches(labels.get(0));
    }
}
