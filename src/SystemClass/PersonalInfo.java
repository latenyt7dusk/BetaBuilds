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
public abstract class PersonalInfo {
    
    private String id,sname,fname,mname,age,gen,cstat,add,email,number;
    
    public void setID(String i){
        this.id = i;
    }
    public String getID(){
        return id;
    }
    
    public void setSurname(String s){
        this.sname = s;
    }
    public String getSurname(){
        return sname;
        
    }
    
    public void setFirstname(String f){
        this.fname = f;
    }
    public String getFirstname(){
        return fname;
    }
    
    public void setMiddlename(String m){
        this.mname = m;
    }
    
    public String getMiddlename(){
        return mname;
    }
    
    public String getFullname(){
        return sname+", "+fname+" "+mname;
    }
    
    public void setAge(String a){
        this.age = a;
    }
    public String getAge(){
        return age;
    }
    
    public void setGender(String g){
        this.gen = g;
    }
    public String getGender(){
        return gen;
    }
    
    public void setCivilStatus(String c){
        this.cstat = c;
    }
    public String getCivilStatus(){
        return cstat;
    }
    
    public void setAddress(String a){
        this.add = a;
    }
    public String getAddress(){
        return add;
    }
    
    public void setEmail(String e){
        this.email = e;
    }
    public String getEmail(){
        return email;
    }
    
    public void setContactNumber(String c){
        this.number = c;
    }
    public String getContactNumber(){
        return number;
    }
    
    /**
     * @return Entry context of elements where it is delimited by ","
     */
    public String getInfoEntry(){
        return sname+","+fname+","+mname+","+age+","+gen+","+cstat+","+add+","+number+","+email;
    }
    
}
