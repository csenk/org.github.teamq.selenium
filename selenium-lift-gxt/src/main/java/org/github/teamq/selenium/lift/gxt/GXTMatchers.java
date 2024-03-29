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

import org.github.teamq.selenium.lift.gxt.matcher.LabelMatcher;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

/**
 * Access facade to create gxt related {@link Matcher}.
 * 
 * @author senk.christian@googlemail.com
 */
public final class GXTMatchers {

    /**
     * Private constructor to prevent instantiation.
     */
    private GXTMatchers() {}

    /**
     * @param matcher the next {@link Matcher}.
     * @return a {@link LabelMatcher}
     */
    public static Matcher<WebElement> label(final Matcher<WebElement> matcher) {
        return LabelMatcher.label(matcher);
    }

}
