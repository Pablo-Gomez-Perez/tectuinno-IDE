/*
 * This file is part of Tectuinno IDE.
 *
 * Tectuinno IDE is free software: you can redistribute it and/or modify
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
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 * As a special exception, you may use this file as part of a free software
 * library without restriction. Specifically, if other files instantiate
 * templates or use macros or inline functions from this file, or you compile
 * this file and link it with other files to produce an executable, this
 * file does not by itself cause the resulting executable to be covered by
 * the GNU General Public License. This exception does not however
 * invalidate any other reasons why the executable file might be covered by
 * the GNU General Public License.
 *
 * Copyright 2025 Tectuinno Team (https://github.com/tectuinno)
 */

package org.tectuinno.compiler.assembler.utils;

/**
 * Defines constant identifiers for syntax highlighting style categories
 * used in the {@link org.tectuinno.view.assembler.AsmEditorPane}.
 *
 * These string constants are used as keys when registering and applying
 * styles in a {@code StyledDocument} via {@code addStyle(...)}.
 * 
 * Each key represents a category of lexical elements to be styled,
 * such as instructions, registers, or labels.
 *
 * @author PabloG
 * @version 1.0
 * @since 2025
 */
public final class AsmEditorStyleName {

	
	/** Style name for assembler keywords (e.g., add, lw, beq). */
    public static final String KEYWORD = "keywords";

    /** Style name for register identifiers (e.g., x0 to x31). */
    public static final String REGISTER = "register";

    /** Style name for regular/default text. */
    public static final String DEFAULT = "default";

    /** Style name for label or tag declarations (e.g., loop:, _start:). */
    public static final String TAG = "tag";
    
    /** Style name for inline comments. */
    public static final String COMMENT = "comment";    

    /**
     * Private constructor to prevent instantiation.
     */
    private AsmEditorStyleName() {
        // Utility class — no instantiation
    }
	
}
