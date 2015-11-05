/*
 * Copyright (C) 2015 HERU
 *
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
package Finalized;

import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author HERU
 */
public abstract interface VTheme {
    
    abstract void setVThemeColor(Color c);
    abstract Color getVThemeColor();
    abstract void setVThemeAlpha(int i);
    abstract int getVThemeAlpha();
    
    abstract void setVSubColor(Color c);
    abstract Color getVSubColor();
    abstract void setVSubAlpha(int i);
    abstract int getVSubAlpha();
    
    abstract void setVImage(Icon i);
    abstract Icon getVImage();
    
    abstract void setVThemeVisible(boolean b);
    abstract boolean isVThemeVisible();
    
    abstract void setVSubVisible(boolean b);
    abstract boolean isVSubVisible();
    
}
