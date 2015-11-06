/*
 * Copyright (C) 2015 late7dusk
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
package Utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.Icon;

/**
 *
 * @author HERU
 */
public class ImageUtils {

    public static BufferedImage Convert(Icon icon) {
        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bi;
    }
    
    public static BufferedImage Colorize(Icon icon,Color c){
        BufferedImage i = Convert(icon);
        Colorizer.doRGB(c, i);
        return i;
    }
    
    public static BufferedImage Colorize(Icon icon,int r,int g,int b){
        BufferedImage i = Convert(icon);
        Colorizer.doRGB(new Color(r,g,b), i);
        return i;
    }
    
    public static BufferedImage Colorize(Icon icon,int r,int g,int b,int a){
        BufferedImage i = Convert(icon);
        Colorizer.doRGB(new Color(r,g,b,a), i);
        return i;
    }
   

}
