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

/**
 *
 * @author HERU
 */
public class OccularRx {
    
    private String OD,OS,PD,CASE,REMARKS;
    
    public void setOD(String od){
        this.OD = od;
    }
    public String getOD(){
        return OD;
    }
    public void setOS(String os){
        this.OS = os;
    }
    public String getOS(){
        return OS;
    }
    public void setPD(String pd){
        this.PD = pd;
    }
    public String getPD(){
        return PD;
    }
    public void setCase(String c){
        this.CASE = c;
    }
    public String getCase(){
        return CASE;
    }
    public void setRemarks(String r){
        this.REMARKS = r;
    }
    public String getRemarks(){
        return REMARKS;
    }
    
}
