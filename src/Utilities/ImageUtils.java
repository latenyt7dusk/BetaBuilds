/*
 * 
 * 
 * 
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
