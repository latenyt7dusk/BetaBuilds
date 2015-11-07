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
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author HERU
 */
public class VContainer extends VScrollPane {

    private VContainer CONTAINER = this;
    
    private VContainerLayout VCLayout = VContainerLayout.Y_AXIS;
    private Dimension size = new Dimension(250, 250);

    private JPanel ItemContainer = new JPanel() {
        {
            //setOpaque(false);
            setLayout(new BoxLayout(this,VCLayout.getValue()));
            setBounds(0, 0, size.width, size.height);
            setBackground(Color.black);
        }
    };

    public VContainer() {
        
        add(ItemContainer);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                setVContainerSize(getSize());
                ItemContainer.setBounds(0, 0, size.width, size.height);
            }
        });

    }
    
    public void addItem(Component e){
        if(VCLayout == VContainerLayout.X_AXIS){
            e.setPreferredSize(new Dimension(e.getPreferredSize().width,size.height));
        }else{
            e.setPreferredSize(new Dimension(size.width,e.getPreferredSize().height));
        }
        ItemContainer.add(e);
        updateUI();
    }
    
    public void addVItem(VItem e){
        if(VCLayout == VContainerLayout.X_AXIS){
            e.setPreferredSize(new Dimension(e.getPreferredSize().width,size.height));
        }else{
            e.setPreferredSize(new Dimension(size.width,e.getPreferredSize().height));
        }
        ItemContainer.add(e);
        updateUI();
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

    
    
    private class VItem extends JPanel{
    
    public static final int NORMAL = 0;
    public static final int EXPANDING_RIGHT = 1;
    public static final int EXPANDING_BOTTOM = 2;
    public static final int EXPANDING_TOP = 3;
    public static final int EXPANDING_LEFT = 4;
    
    private int TYPE = NORMAL;
    
    public VItem(){
    
    }
    
   
    
}
    
    
    public enum VContainerLayout {
        X_AXIS(0), Y_AXIS(1);
        
        private int val;
        private VContainerLayout(int i){
            this.val = i;
        }
        
        public int getValue(){
            return val;
        }

    }

}
