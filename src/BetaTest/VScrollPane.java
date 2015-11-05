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

import Finalized.VTheme;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 *
 * @author late7dusk
 */
public class VScrollPane extends JScrollPane implements VTheme,VScrollBarUI.VScrollTheme{
    
    private int ThemeAlpha = 255;
    private Color ThemeColor = new Color(51, 153, 255, ThemeAlpha);
    private int SubAlpha = 255;
    private Color SubColor = new Color(35, 35, 35, SubAlpha);
    private Icon VImage = null;
    private boolean ThemeVisible = true;
    private boolean SubVisible = true;
    
    private static Color ScrollBackground;
    private static Color ScrollTrackColor;
    private static Color ScrollThumbNormalColor;
    private static Color ScrollThumbHoverColor;
    private static int ScrollWidth = 10;
    
    private static VScrollBarUI.VScrollBarStyle VScrollStyle = VScrollBarUI.VScrollBarStyle.STYLE_ROUNDED;
    
    
    public VScrollPane(){
        
        setScrollBackground(new Color(0,0,0,0));
        setScrollTrackColor(new Color(35, 35, 35));
        setScrollThumbNormalColor(new Color(153, 153, 153));
        setScrollThumbHoverColor(new Color(51, 153, 255));
        
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getVerticalScrollBar().setUI(new VScrollBarUI().createVerticalScrollBar(ScrollBackground, ScrollTrackColor, ScrollThumbNormalColor, ScrollThumbHoverColor, VScrollStyle.Value()));//VScrollBarUI.SIMPLE_LINE
        getVerticalScrollBar().setPreferredSize(new Dimension(ScrollWidth, 0));
        getVerticalScrollBar().setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder());
        setOpaque(false);
        
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });
        
        
    }
    
    
    
    @Override
    public void setScrollWidth(int i) {
        ScrollWidth = i;
    }

    @Override
    public int getScrollWidth() {
        return ScrollWidth;
    }

    @Override
    public void setScrollTrackColor(Color c) {
        ScrollTrackColor = c;
    }

    @Override
    public Color getScrollTrackColor() {
        return ScrollTrackColor;
        
    }

    @Override
    public void setScrollThumbNormalColor(Color c) {
        ScrollThumbNormalColor = c;
    }

    @Override
    public Color getScrollThumbNormalColor() {
        return ScrollThumbNormalColor;
    }

    @Override
    public void setScrollThumbHoverColor(Color c) {
        ScrollThumbHoverColor = c;
    }

    @Override
    public Color getScrollThumbHoverColor() {
        return ScrollThumbHoverColor;
    }

    @Override
    public void setVScrollBarStyle(VScrollBarUI.VScrollBarStyle s) {
        VScrollStyle = s;
    }

    @Override
    public VScrollBarUI.VScrollBarStyle getVScrollBarStyle() {
        return VScrollStyle;
    }

    @Override
    public void setScrollBackground(Color c) {
        ScrollBackground = c;
    }

    @Override
    public Color getScrollBackground() {
        return ScrollBackground;
    }
    
    
    @Override
    public void setVThemeColor(Color c) {
        this.ThemeColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), ThemeAlpha);
    }

    @Override
    public Color getVThemeColor() {
        return ThemeColor;
    }

    @Override
    public void setVThemeAlpha(int i) {
        this.ThemeAlpha = ((i > 255 || i < 0) ? 255 : i);
        this.ThemeColor = new Color(ThemeColor.getRed(), ThemeColor.getGreen(), ThemeColor.getBlue(), ThemeAlpha);
    }

    @Override
    public int getVThemeAlpha() {
        return ThemeAlpha;
    }

    @Override
    public void setVSubColor(Color c) {
        this.SubColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), SubAlpha);
    }

    @Override
    public Color getVSubColor() {
        return SubColor;
    }

    @Override
    public void setVSubAlpha(int i) {
        this.SubAlpha = ((i > 255 || i < 0) ? 255 : i);
        this.SubColor = new Color(SubColor.getRed(), SubColor.getGreen(), SubColor.getBlue(), SubAlpha);
    }

    @Override
    public int getVSubAlpha() {
        return SubAlpha;
    }

    @Override
    public void setVImage(Icon i) {
        this.VImage = i;
    }

    @Override
    public Icon getVImage() {
        return VImage;
    }

    @Override
    public void setVThemeVisible(boolean b) {
        this.ThemeVisible = b;
    }

    @Override
    public boolean isVThemeVisible() {
        return ThemeVisible;
    }

    @Override
    public void setVSubVisible(boolean b) {
        this.SubVisible = b;
    }

    @Override
    public boolean isVSubVisible() {
        return SubVisible;
    }
}
