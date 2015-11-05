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

import Finalized.VTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HERU
 */
public class VTable extends JTable implements VTheme{
    
    private int ThemeAlpha = 255;
    private Color ThemeColor = new Color(51, 153, 255, ThemeAlpha);
    private int SubAlpha = 255;
    private Color SubColor = new Color(35, 35, 35, SubAlpha);
    private Icon VImage = null;
    private boolean ThemeVisible = true;
    private boolean SubVisible = true;
    
    private DefaultTableModel Model = (DefaultTableModel) getModel();

    public VTable() {

        getTableHeader().setBackground(getSelectionBackground());
        getTableHeader().setForeground(getSelectionForeground());
        getTableHeader().setFont(new Font("Sanserif", 1, 11));
        getTableHeader().setOpaque(false);
        setOpaque(false);

        ((DefaultTableCellRenderer) getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        setAutoCreateRowSorter(true);
        setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                getTableHeader().setBackground(getSelectionBackground());
                getTableHeader().setForeground(getSelectionForeground());
                Model = (DefaultTableModel) getModel();
                getTableHeader().repaint();
            }
        });
        
        //taeng yan

    }
    
    public void ScrollTo(int rowIndex, int vColIndex) {
        if (!(this.getParent() instanceof JViewport)) {
            return;
        }
        JViewport viewport = (JViewport) this.getParent();

        // This rectangle is relative to the table where the
        // northwest corner of cell (0,0) is always (0,0).
        Rectangle rect = this.getCellRect(rowIndex, vColIndex, true);

        // The location of the viewport relative to the table
        Point pt = viewport.getViewPosition();

        // Translate the cell location so that it is relative
        // to the view, assuming the northwest corner of the
        // view is (0,0)
        rect.setLocation(rect.x - pt.x, rect.y - pt.y);

        this.scrollRectToVisible(rect);
        this.setRowSelectionInterval(rowIndex, rowIndex);

        // Scroll the area into view
        //viewport.scrollRectToVisible(rect);
    }

    public void AddRowData(List<String> e) {
        try {
            if (e.size() == Model.getColumnCount()) {
                Model.addRow(e.toArray());
            } else {
                System.out.println(getName() + " " + "Incorrect Data Entry lenght");
            }
        } catch (Exception er) {

        }
    }

    public void AddTableData(List<String> title, List<List> e) {
        try {
            if (e.get(0).size() == Model.getColumnCount()) {
                Model.setColumnIdentifiers(title.toArray());
                for (int i = 0; i < e.size(); i++) {
                    Object data[] = e.get(i).toArray();
                    Model.addRow(data);
                }
            } else {
                System.out.println(getName() + " " + "Incorrect Data Entry lenght");
            }
        } catch (Exception er) {

        }
    }

    public int[] SearchData(String e, boolean b) {
        try {
            List<Integer> rows = new ArrayList();
            int rowss[] = {};
            if (Model.getRowCount() > 0) {
                for (int i = 0; i < Model.getRowCount(); i++) {
                    for (int j = 0; j < Model.getColumnCount(); j++) {
                        if (b) {
                            if (e.equalsIgnoreCase(Model.getValueAt(i, j).toString())) {

                            }
                        } else {
                            if (Model.getValueAt(i, j).toString().toUpperCase().contains(e.toUpperCase())) {
                                rows.add(i);
                            }
                        }
                    }
                }
            }

            return null;
        } catch (Exception er) {
            return null;
        }
    }

    public Integer[] SearchColumnData(String e, int j, boolean b) {
        try {
            List<Integer> rows = new ArrayList();
            if (Model.getRowCount() > 0) {
                for (int i = 0; i < Model.getRowCount(); i++) {
                    if (b) {
                        if (e.equalsIgnoreCase(Model.getValueAt(i, j).toString())) {
                            rows.add(i);
                        }
                    } else {
                        if (Model.getValueAt(i, j).toString().toUpperCase().contains(e.toUpperCase())) {
                            rows.add(i);
                        }
                    }
                }
            }
            Integer tst[] = new Integer[rows.size()];
            return tst;
        } catch (Exception er) {
            return null;
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
