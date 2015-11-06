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
package BetaTest;


import java.awt.Color;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author late7dusk
 */
public class VThemeManager {
    
    private Properties props = new Properties();
    
    public VThemeManager(String loc){
        try{
            InputStream is = new FileInputStream(loc);
            props.load(is);
            
            
        }catch(Exception er){
            System.exit(1);
        }
    }
    
    
    private static Color VThemeColor = new Color(51, 153, 255);//Default Base
    private static Color VSubColor = new Color(15, 15, 15);//Default Sub
    
    private static Color VBackground = new Color(255,255,255);//Default Background
    private static Color VForeground = new Color(35,35,35);//Default Foreground
    
    private static Color VNormalground = new Color(153,153,153);//Default Normal act
    private static Color VHoverground = new Color(51,153,255);//Default Hover act
    private static Color VErrorground = Color.RED.darker();//Default Error act
    private static Color VPassground = Color.GREEN.darker();//Default Pass act
    
    private static Color VTransparent = new Color(0,0,0,0);//Transparent
    
    
    
    
    
    
    
    public static Color ScrollBackground = VTransparent;
    public static Color ScrollTrackColor = VForeground;
    public static Color ScrollThumbNormalColor = VNormalground;
    public static Color ScrollThumbHoverColor = VThemeColor;
    public static int ScrollWidth = 10;
    
    public static VScrollBarUI.VScrollBarStyle VScrollStyle = VScrollBarUI.VScrollBarStyle.STYLE_ROUNDED;
    
    
    
    
}
