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

import org.hamcrest.Factory;

/**
 * {@link WidgetFinder} to locate text fields.
 * 
 * @author senk.christian@googlemail.com
 */
public class TextFieldFinder extends InputFieldFinder {

    /**
     * @return a default {@link TextFieldFinder}.
     */
    @Factory
    public static TextFieldFinder textField() {
        return new TextFieldFinder();
    }

    /**
     * Creates a new {@link TextFieldFinder}.
     */
    public TextFieldFinder() {
        super("TextField", "div/input[@type = 'text']");
    }

}
