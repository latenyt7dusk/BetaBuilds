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
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author late7dusk
 */
public class VScrollPane extends JScrollPane {
    
    
    
    private static final Color ScrollBackground = VThemeManager.ScrollBackground;
    private static final Color ScrollTrackColor = VThemeManager.ScrollTrackColor;
    private static final Color ScrollThumbNormalColor = VThemeManager.ScrollThumbNormalColor;
    private static final Color ScrollThumbHoverColor = VThemeManager.ScrollThumbHoverColor;
    private static final int ScrollWidth = VThemeManager.ScrollWidth;
    
    private static final VScrollBarUI.VScrollBarStyle VScrollStyle = VThemeManager.VScrollStyle;
    
    
    public VScrollPane(){
        
        
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getVerticalScrollBar().setUI(new VScrollBarUI().createVerticalScrollBar(ScrollBackground, ScrollTrackColor, ScrollThumbNormalColor, ScrollThumbHoverColor, VScrollStyle.Value()));//VScrollBarUI.SIMPLE_LINE
        getVerticalScrollBar().setPreferredSize(new Dimension(ScrollWidth, 0));
        getVerticalScrollBar().setOpaque(false);
        
        getHorizontalScrollBar().setUI(new VScrollBarUI().createVerticalScrollBar(ScrollBackground, ScrollTrackColor, ScrollThumbNormalColor, ScrollThumbHoverColor, VScrollStyle.Value()));//VScrollBarUI.SIMPLE_LINE
        getHorizontalScrollBar().setPreferredSize(new Dimension(0,ScrollWidth));
        getHorizontalScrollBar().setOpaque(false);
        
        getViewport().setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder());
        setOpaque(false);
        
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });
        
        
    }
    
}
