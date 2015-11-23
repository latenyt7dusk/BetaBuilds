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

    private String id, name, desc, tag, qty, prc;

    public void setID(String i) {
        this.id = i;
    }

    public String getID() {
        return id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String d) {
        this.desc = d;
    }

    public String getDescription() {
        return desc;
    }

    public void setQuantity(String q) {
        this.qty = q;
    }

    public String getQuantity() {
        return qty;
    }

    public void setPrice(String p) {
        this.prc = p;
    }

    public String getPrice() {
        return prc;
    }

    public double getTotalAmount() {
        double d = Double.parseDouble(qty)*Double.parseDouble(prc);
        return d;
    }
    
    /**
     * @param t Adds a new Tag for Flexible Search t
     */
    public void addTag(String t){
        this.tag = tag.concat(t);
    }

    /**
     * @param t Removes a Tag t
     */
    public void removeTag(String t){
        String tmp[] = tag.split(t);
        this.tag = "";
        for(int i = 0;i < tmp.length;i++){
            this.tag = tag.concat(tmp[i]);
        }
    }

    /**
     * @param t Replace Tag t
     * @param n Adds Tag n
     */
    public void replaceTag(String t,String n){
        removeTag(t);
        addTag(n);
    }

    

}
