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

package org.tectuinno.utils;


/**
 * Defines supported file type extensions used within the Tectuinno IDE.
 * 
 * This utility class centralizes file extension constants for use across the application,
 * such as in file filters, syntax highlighting, and file recognition logic.
 *
 * Example usage:
 * <pre>
 * if (fileName.endsWith(FileType.ASSEMBLY_FILE)) {
 *     // Handle .asm file
 * }
 * </pre>
 *
 * This class is not intended to be instantiated.
 */
public enum FileType {
	
	ASSEMBLY_FILE,
	CPP_FILE,
	TEXT_FILE;
	
}
