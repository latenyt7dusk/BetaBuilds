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
import java.awt.image.BufferedImage;

/**
 *
 * @author Kelvin Nakpil
 */
public class Colorizer
{
    public static final int MAX_COLOR = 256;

    public static final float LUMINANCE_RED = 0.2126f;
    public static final float LUMINANCE_GREEN = 0.7152f;
    public static final float LUMINANCE_BLUE = 0.0722f;

    private static double hue = 180;
    private static double saturation = 50;
    private static double lightness = 0;

    private static int[] lum_red_lookup;
    private static int[] lum_green_lookup;
    private static int[] lum_blue_lookup;

    private static int[] final_red_lookup;
    private static int[] final_green_lookup;
    private static int[] final_blue_lookup;

    public Colorizer()
    {
        doInit();
    }

    public void doHSB(double t_hue, double t_sat, double t_bri, BufferedImage image)
    {
        hue = t_hue;
        saturation = t_sat;
        lightness = t_bri;
        doInit();
        doColorize(image);
    }
    
    public static void doRGB(Color c,BufferedImage img){
        HSLColor e = new HSLColor(c);
        hue = e.getHue();
        saturation = e.getSaturation();
        lightness = e.getLuminance();
        doInit();
        doColorize(img);
    }
    
    

    private static void doInit()
    {
        lum_red_lookup = new int[MAX_COLOR];
        lum_green_lookup = new int[MAX_COLOR];
        lum_blue_lookup = new int[MAX_COLOR];

        double temp_hue = hue / 360f;
        double temp_sat = saturation / 100f;

        final_red_lookup = new int[MAX_COLOR];
        final_green_lookup = new int[MAX_COLOR];
        final_blue_lookup = new int[MAX_COLOR];

        for (int i = 0; i < MAX_COLOR; ++i)
        {
            lum_red_lookup[i] = (int) (i * LUMINANCE_RED);
            lum_green_lookup[i] = (int) (i * LUMINANCE_GREEN);
            lum_blue_lookup[i] = (int) (i * LUMINANCE_BLUE);

            double temp_light = (double) i / 255f;

            Color color = new Color(Color.HSBtoRGB((float) temp_hue, (float) temp_sat, (float) temp_light));

            final_red_lookup[i] = (int) (color.getRed());
            final_green_lookup[i] = (int) (color.getGreen());
            final_blue_lookup[i] = (int) (color.getBlue());
        }
    }
    
    

    private static  void doColorize(BufferedImage image)
    {
        int height = image.getHeight();
        int width;

        while (height-- != 0)
        {
            width = image.getWidth();

            while (width-- != 0)
            {
                Color color = new Color(image.getRGB(width, height), true);

                int lum = lum_red_lookup[color.getRed()] + lum_green_lookup[color.getGreen()] + lum_blue_lookup[color.getBlue()];

                if (lightness > 0)
                {
                    lum = (int) ((double) lum * (100f - lightness) / 100f);
                    lum += 255f - (100f - lightness) * 255f / 100f;
                }
                else if (lightness < 0)
                {
                    lum = (int) (((double) lum * (lightness + 100f)) / 100f);
                }
                Color final_color = new Color(final_red_lookup[lum], final_green_lookup[lum], final_blue_lookup[lum], color.getAlpha());
                image.setRGB(width, height, final_color.getRGB());
            }
        }
    }

    private static  BufferedImage changeContrast(BufferedImage inImage, float increasingFactor)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                float fr, fg, fb;

                r = color.getRed();
                fr = (r - 128) * increasingFactor + 128;
                r = (int) fr;
                r = keep256(r);

                g = color.getGreen();
                fg = (g - 128) * increasingFactor + 128;
                g = (int) fg;
                g = keep256(g);

                b = color.getBlue();
                fb = (b - 128) * increasingFactor + 128;
                b = (int) fb;
                b = keep256(b);

                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }

    private static  BufferedImage changeRGB(BufferedImage inImage, Color col)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(col.getRed(), col.getGreen(), col.getBlue(), a).getRGB());
            }
        }
        return outImage;
    }
    
    private static  BufferedImage changeGreen(BufferedImage inImage, int increasingFactor)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                r = color.getRed();
                g = keep256(color.getGreen() + increasingFactor);
                b = color.getBlue();
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }

    private static  BufferedImage changeBlue(BufferedImage inImage, int increasingFactor)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                r = color.getRed();
                g = color.getGreen();
                b = keep256(color.getBlue() + increasingFactor);
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }

    private static  BufferedImage changeRed(BufferedImage inImage, int increasingFactor)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                r = keep256(color.getRed() + increasingFactor);
                g = color.getGreen();
                b = color.getBlue();
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }

    private static  BufferedImage changeBrightness(BufferedImage inImage, int increasingFactor)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);

                int r, g, b, a;

                r = keep256(color.getRed() + increasingFactor);
                g = keep256(color.getGreen() + increasingFactor);
                b = keep256(color.getBlue() + increasingFactor);
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }
    
    private static BufferedImage setGreen(BufferedImage inImage, int val)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                r = color.getRed();
                g = keep256(val);
                b = color.getBlue();
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }

    private static BufferedImage setBlue(BufferedImage inImage, int val)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                r = color.getRed();
                g = color.getGreen();
                b = keep256(val);
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }

    private static  BufferedImage setRed(BufferedImage inImage, int val)
    {
        int w = inImage.getWidth();
        int h = inImage.getHeight();

        BufferedImage outImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                Color color = new Color(inImage.getRGB(i, j), true);
                int r, g, b, a;
                r = keep256(val);
                g = color.getGreen();
                b = color.getBlue();
                a = color.getAlpha();

                outImage.setRGB(i, j, new Color(r, g, b, a).getRGB());
            }
        }
        return outImage;
    }
    
    
    
    

    private static int keep256(int i)
    {
        if (i <= 255 && i >= 0)
            return i;
        if (i > 255)
            return 255;
        return 0;
    }
    
}