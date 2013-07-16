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

import org.github.teamq.selenium.lift.gxt.finder.ButtonFinder;
import org.github.teamq.selenium.lift.gxt.finder.ComboBoxFinder;
import org.github.teamq.selenium.lift.gxt.finder.FieldLabelFinder;
import org.github.teamq.selenium.lift.gxt.finder.TextFieldFinder;
import org.openqa.selenium.lift.find.Finder;

/**
 * Access facade to create gxt related {@link Finder}.
 * 
 * @author senk.christian@googlemail.com
 */
public final class GXTFinders {

    /**
     * Private constructor to prevent instantiation.
     */
    private GXTFinders() {}

    /**
     * @return a default {@link ButtonFinder}.
     */
    public static ButtonFinder button() {
        return ButtonFinder.button();
    }

    /**
     * @return a default {@link TextFieldFinder}.
     */
    public static TextFieldFinder textField() {
        return TextFieldFinder.textField();
    }

    /**
     * @return a default {@link ComboBoxFinder}.
     */
    public static ComboBoxFinder comboBox() {
        return ComboBoxFinder.comboBox();
    }

    /**
     * @return a default {@link FieldLabelFinder}.
     */
    public static FieldLabelFinder fieldLabel() {
        return FieldLabelFinder.fieldLabel();
    }

}
