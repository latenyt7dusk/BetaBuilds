/*
 * 
 * 
 * 
 */
package BetaTest;

import Finalized.VTheme;
import Utilities.ImageUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 *
 * @author HERU
 */
public class VPanel extends JPanel implements VTheme {

    private int ThemeAlpha = 255;
    private Color ThemeColor = new Color(51, 153, 255, ThemeAlpha);
    private int SubAlpha = 255;
    private Color SubColor = new Color(35, 35, 35, SubAlpha);
    private Icon VImage = null;
    private boolean ThemeVisible = true;
    private boolean SubVisible = true;
    private Icon VLabelIcon = null;
    private String VLabel = null;
    private int VLabelAlpha = 230;
    private Color VLabelColor = new Color(0, 0, 0, VLabelAlpha);
    private Color VLabelForeground = Color.WHITE;
    private Font VLabelFont = getFont();
    private BufferedImage myImage = null;
    private int VLabelHeight = 24;

    public VPanel() {
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                repaint();
            }
        });
    }

    public void setVLabel(String i) {
        this.VLabel = ((i.isEmpty()) ? null : i);
    }

    public String getVLabel() {
        return VLabel;
    }

    public void setVLabelIcon(Icon i) {
        this.VLabelIcon = i;
    }

    public Icon getVLabelIcon() {
        return VLabelIcon;
    }

    public void setVLabelColor(Color c) {
        this.VLabelColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), VLabelAlpha);
    }

    public Color getVLabelColor() {
        return VLabelColor;
    }

    public void setVLabelApha(int i) {
        this.VLabelAlpha = ((i > 255 || i < 0) ? 255 : i);
        this.VLabelColor = new Color(VLabelColor.getRed(), VLabelColor.getGreen(), VLabelColor.getBlue(), VLabelAlpha);
    }

    public int getVLabelAlpha() {
        return VLabelAlpha;
    }

    public void setVLabelFont(Font f) {
        this.VLabelFont = f;
    }

    public Font getVLabelFont() {
        return VLabelFont;
    }

    public void setVLabelForeground(Color c) {
        this.VLabelForeground = c;
    }

    public Color getVLabelForeground() {
        return VLabelForeground;
    }

    public void setVLabelHeight(int i) {
        this.VLabelHeight = i;
    }

    public int getVLabelHeight() {
        return VLabelHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        if (VImage != null) {
            g2d.drawImage(myImage.getScaledInstance(w, h, Image.SCALE_DEFAULT), 0, 0, null);
        }
        if (VLabel != null) {
            g2d.setColor(VLabelColor);
            g2d.fillRect(0, 0, w, 24);
            g2d.setColor(VLabelForeground);
            Font e = new Font(getFont().getName(), 1, getFont().getSize());
            g2d.setFont(e);
            FontMetrics fm = g.getFontMetrics();
            //int x = (getWidth() - fm.stringWidth(VLabel)) / 2;
            int y = (fm.getAscent() + ((VLabelHeight) - (fm.getAscent() + fm.getDescent())) / 2);
            g2d.drawString(VLabel, ((VLabelIcon != null) ? VLabelHeight + 4 : 4), y);
            if (VLabelIcon != null) {
                g2d.drawImage(ImageUtils.Colorize(VLabelIcon, VLabelForeground).getScaledInstance(VLabelHeight - 2, VLabelHeight - 4, Image.SCALE_SMOOTH), 1, 2, null);
            }
        }

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
        this.myImage = ((VImage != null) ? ImageUtils.Convert(i) : null);
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
