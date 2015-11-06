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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author late7dusk
 */
public class VThemeManager {
    
    private static final String pp = System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"NSoftwares"+File.separator+"VThemeProps.properties";
    private static Properties props = LoadProperties(pp);
    
    public static Properties LoadProperties(String loc){
        try{
            System.out.println(loc);
            InputStream is = new FileInputStream(loc);
            Properties i = new Properties();
            i.load(is);
            return i;
        }catch(Exception er){
            return null;
        }
    }
    
    private static Color fetchColorProps(String p){
        try{
            String e = props.getProperty(p);
            String es[] = e.split("[,]");
            if(es.length > 3){
                return new Color(Integer.parseInt(es[0]),Integer.parseInt(es[1]),Integer.parseInt(es[2]),Integer.parseInt(es[3]));
            }else{
                return new Color(Integer.parseInt(es[0]),Integer.parseInt(es[1]),Integer.parseInt(es[2]));
            }
        }catch(Exception er){
            return Color.WHITE;
        }
    }
    
    
    private static final Color VThemeColor = fetchColorProps("VThemeColor");//Default Base 51,153,255
    private static final Color VSubColor = fetchColorProps("VSubColor");//Default Sub 153,153,153
    
    private static final Color VBackground = fetchColorProps("VBackground");//Default Background 255,255,255
    private static final Color VForeground = fetchColorProps("VForeground");//Default Foreground 35,35,35
    private static final Color VTrackground = fetchColorProps("VTrackground");//Default Trackground 35,35,35
    private static final Color VNormalground = fetchColorProps("VNormalground");//Default Normal act 153,153,153
    private static final Color VHoverground = fetchColorProps("VHoverground");//Default Hover act 51,153,255
    private static final Color VErrorground = fetchColorProps("VErrorground");//Default Error act 220,0,0
    private static final Color VPassground = fetchColorProps("VPassground");//Default Pass act 0,190,0
    
    private static final Color VTransparent = fetchColorProps("VTransparent");//Transparent 0,0,0,0
    
    
    
    
    
    
    
    public static Color ScrollBackground = VTransparent;
    public static Color ScrollTrackColor = VTrackground;
    public static Color ScrollThumbNormalColor = VNormalground;
    public static Color ScrollThumbHoverColor = VThemeColor;
    public static int ScrollWidth = 10;
    
    public static VScrollBarUI.VScrollBarStyle VScrollStyle = VScrollBarUI.VScrollBarStyle.STYLE_ROUNDED;
    
    public static Color HeaderBackgound = VThemeColor;
    
    
}
