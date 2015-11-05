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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.text.Utilities;

/**
 *
 * @author HERU
 */
public class VScrollBarUI {

    public static final int ROUNDED = 0;
    public static final int SIMPLE_LINE = 1;
    public static final int SIMPLE_LINE_ROUND = 2;
    public static final int SIMPLE_RECTANGLE = 3;

    public MetalScrollBarUI GreyScrollbar = new VScrollbarUI();

    public MetalScrollBarUI createVerticalScrollBar(Color bg, Color Track, Color Thumbnormal, Color Thumbhover, int style) {
        return new VScrollbarUI(bg, Track, Thumbnormal, Thumbhover, style);
    }
    
    

    private class VScrollbarUI extends MetalScrollBarUI {

        private Image imageThumb, imageTrack;
        private Color TrackBG = Color.WHITE;
        private Color TrackColor = Color.BLACK;
        private Color CurrentThumbColor = Color.GRAY;
        private Color ThumbHover = new Color(51, 153, 155);
        private Color ThumbNormal = Color.GRAY;

        private int STYLE = ROUNDED;

        private JButton b = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(12, 0);
            }

        };
        private JButton c = new JButton() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(12, 0);
            }
        };

        public VScrollbarUI() {
            //imageThumb = FauxImage.create(32, 32, new Color(153,153,153));
            //imageTrack = FauxImage.create(32, 32, new Color(0,0,0,200));
        }

        public VScrollbarUI( Color bg, Color Track, Color Thumbnormal, Color Thumbhover, int style) {
            this.TrackBG = bg;
            this.TrackColor = Track;
            this.CurrentThumbColor = Thumbnormal;
            this.ThumbHover = Thumbhover;
            this.ThumbNormal = Thumbnormal;
            this.STYLE = style;
        }
        
        
                    
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
            //super.paintThumb(g, c, r);
            if (CurrentThumbColor != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setColor(CurrentThumbColor);
                if (STYLE == SIMPLE_LINE) {
                    g2d.fillRect(r.x + 2, r.y + 4, r.width - 4, r.height - 8);
                } else if (STYLE == SIMPLE_LINE_ROUND) {
                    g2d.fillRoundRect(r.x + 2, r.y + 4, r.width - 4, r.height - 8, 6, 6);
                } else if (STYLE == SIMPLE_RECTANGLE) {
                    g2d.fillRect(r.x+2, r.y+2, r.width-4, r.height-4);
                } else {
                    g2d.fillRoundRect(r.x + 2, r.y + 4, r.width - 4, r.height - 8, 8, 8);
                    //g2d.drawImage(imageThumb,r.x, r.y, r.width, r.height, null);
                }

            }
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
            //super.paintTrack(g, c, r);
            if (TrackBG != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setColor(TrackBG);
                g2d.fillRect(r.x, r.y, r.width, r.height);
                g2d.setColor(TrackColor);
                if (STYLE == SIMPLE_LINE) {
                    g2d.fillRect(r.x + 4, r.y + 4, r.width - 8, r.height - 8);
                } else if (STYLE == SIMPLE_LINE_ROUND) {
                    g2d.fillRect(r.x + 4, r.y + 4, r.width - 8, r.height - 8);
                } else if (STYLE == SIMPLE_RECTANGLE) {
                    g2d.fillRect(r.x+2, r.y+2, r.width-4, r.height-4);
                } else {
                    g2d.fillRoundRect(r.x + 2, r.y + 4, r.width - 4, r.height - 8, 8, 8);
                }

            }
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return c;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return b;
        }

        @Override
        protected void installListeners() {
            super.installListeners();
            CustomListener listener = new CustomListener();
            scrollbar.addMouseListener(listener);
            scrollbar.addMouseMotionListener(listener);
        }

        protected class CustomListener extends MouseAdapter {

            boolean isInsideThumb = false;

            @Override
            public void mouseEntered(MouseEvent e) {
                handleMouseEvent(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                handleMouseEvent(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                handleMouseEvent(e);
            }

            private void handleMouseEvent(MouseEvent e) {
                if (getThumbBounds().contains(e.getX(), e.getY())) {
                    if (!isInsideThumb) {
                        isInsideThumb = true;
                        CurrentThumbColor = ThumbHover;
                    }
                } else {
                    if (isInsideThumb) {
                        isInsideThumb = false;
                        CurrentThumbColor = ThumbNormal;
                    }
                }
            }
        }

    }

    private static class FauxImage {

        static public Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                    w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }

    public enum VScrollBarStyle {

        STYLE_ROUNDED(ROUNDED),
        STYLE_SIMPLE_LINE(SIMPLE_LINE),
        STYLE_SIMPLE_LINE_ROUND(SIMPLE_LINE_ROUND),
        STYLE_SIMPLE_RECTANGLE(SIMPLE_RECTANGLE);

        private final int val;

        private VScrollBarStyle(int i) {
            this.val = i;
        }

        public int Value() {
            return val;
        }

    }

    public abstract interface VScrollTheme {

        public abstract void setScrollWidth(int i);

        public abstract int getScrollWidth();

        public abstract void setScrollTrackColor(Color c);

        public abstract Color getScrollTrackColor();

        public abstract void setScrollThumbNormalColor(Color c);

        public abstract Color getScrollThumbNormalColor();

        public abstract void setScrollThumbHoverColor(Color c);

        public abstract Color getScrollThumbHoverColor();

        public abstract void setVScrollBarStyle(VScrollBarStyle s);

        public abstract VScrollBarStyle getVScrollBarStyle();

        public abstract void setScrollBackground(Color c);

        public abstract Color getScrollBackground();

    }

}
