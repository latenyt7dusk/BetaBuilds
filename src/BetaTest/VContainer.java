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
    
    private static final int NORMAL = 0;
    private static final int EXPANDING_RIGHT = 1;
    private static final int EXPANDING_BOTTOM = 2;
    private static final int EXPANDING_TOP = 3;
    private static final int EXPANDING_LEFT = 4;
    
    private final int TYPE;
    private final VContainer cont;
    
    public VItem(VContainer e,Component m,Component ex,int type){
        this.TYPE = type;
        this.cont = e;
        setOpaque(false);
        if(TYPE == EXPANDING_BOTTOM){
            
        }else if(TYPE == EXPANDING_RIGHT){
            
        }else if(TYPE == EXPANDING_LEFT){
            
        }else if(TYPE == EXPANDING_TOP){
            
        }else{
            setLayout(new CardLayout());
        }
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
