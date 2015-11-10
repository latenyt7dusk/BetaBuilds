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
package SystemClass;

import java.text.DecimalFormat;

/**
 *
 * @author HERU
 */
public abstract class ItemInfo {
    
    private String id,name,desc;
    private Amount qty,prc;
    
    public void setID(String i){
        this.id = i;
    }
    public String getID(){
        return id;
    }
    
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return name;
    }
    
    public void setDescription(String d){
        this.desc = d;
    }
    public String getDescription(){
        return desc;
    }
    
    public void setQuantity(String q){
        this.qty = new Amount(q);
    }
    public Amount getQuantity(){
        return qty;
    }
    
    public void setPrice(String p){
        this.prc = new Amount(p);
    }
    public Amount getPrice(){
        return prc;
    }
    
    public double getTotalAmount(){
        return prc.DOUBLE * qty.INT;
    }
    
    
    protected class Amount {
    public final String STRING;
    public final double DOUBLE;
    public final int INT;
    
    private Amount(String v){
        this.STRING = v;
        this.DOUBLE = Double.parseDouble(v);
        this.INT = Integer.parseInt(v);
    }
    
    public double getDouble(int d){
        String e = "";
        for(int i = 0;i < d;i++){
            e = e.concat("0");
        }
        DecimalFormat f = new DecimalFormat("##0."+e);
        double num = Double.valueOf(f.format(DOUBLE));
        return num;
    }
    
    
}
    
}
