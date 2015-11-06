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
package BetaTest;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author HERU
 */
public class VContainer extends JScrollPane {

    private static final Color ScrollBackground = VThemeManager.ScrollBackground;
    private static final Color ScrollTrackColor = VThemeManager.ScrollTrackColor;
    private static final Color ScrollThumbNormalColor = VThemeManager.ScrollThumbNormalColor;
    private static final Color ScrollThumbHoverColor = VThemeManager.ScrollThumbHoverColor;
    private static final int ScrollWidth = VThemeManager.ScrollWidth;

    private static final VScrollBarUI.VScrollBarStyle VScrollStyle = VThemeManager.VScrollStyle;

    private VContainerLayout VCLayout = VContainerLayout.Y_AXIS;
    private Dimension size = new Dimension(250, 250);

    private JPanel ItemContainer = new JPanel() {
        {
            //setOpaque(false);
            setBounds(0, 0, size.width, size.height);
            setBackground(Color.black);
        }
    };

    public VContainer() {

        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getVerticalScrollBar().setUI(new VScrollBarUI().createVerticalScrollBar(ScrollBackground, ScrollTrackColor, ScrollThumbNormalColor, ScrollThumbHoverColor, VScrollStyle.Value()));//VScrollBarUI.SIMPLE_LINE
        getVerticalScrollBar().setPreferredSize(new Dimension(ScrollWidth, 0));
        getVerticalScrollBar().setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(javax.swing.BorderFactory.createEmptyBorder());
        setOpaque(false);
        add(ItemContainer);

        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                setVContainerSize(getSize());
                ItemContainer.setBounds(0, 0, size.width, size.height);
            }
        });

    }

    public void setVContainerSize(Dimension e) {
        this.size = e;
    }

    public Dimension getVContainerSize() {
        return size;
    }

    public void setVContainerLayout(VContainerLayout vcl) {
        this.VCLayout = vcl;
    }

    public VContainerLayout getVContainerLayout() {
        return VCLayout;
    }

    public enum VContainerLayout {

        GRID, X_AXIS, Y_AXIS

    }

}
