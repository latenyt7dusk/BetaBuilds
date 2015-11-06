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
public class VTable extends JTable {
    
    private Color HeaderBackground = VThemeManager.HeaderBackgound;

    public VTable() {

        getTableHeader().setBackground(HeaderBackground);
        getTableHeader().setForeground(getSelectionForeground());
        getTableHeader().setFont(new Font("Sanserif", 1, 11));
        getTableHeader().setOpaque(false);
        setOpaque(false);

        DefaultTableModel Model = (DefaultTableModel) getModel();
        
        ((DefaultTableCellRenderer) getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        setAutoCreateRowSorter(true);
        

        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                getTableHeader().setBackground(HeaderBackground);
                getTableHeader().setForeground(getSelectionForeground());
                getTableHeader().repaint();
            }
        });
        

    }
    
    public void setHeaderBackground(Color c){
        this.HeaderBackground = c;
        getTableHeader().setBackground(HeaderBackground);
    }
    
    public Color getHeaderBackground(){
        return HeaderBackground;
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
        DefaultTableModel Model = (DefaultTableModel) getModel();
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
        DefaultTableModel Model = (DefaultTableModel) getModel();
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
        DefaultTableModel Model = (DefaultTableModel) getModel();
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

    public int[] SearchColumnData(String e, int j, boolean b) {
        DefaultTableModel Model = (DefaultTableModel) getModel();
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
            int tst[] = new int[rows.size()];
            return tst;
        } catch (Exception er) {
            return null;
        }
    }
    
    
    
}
