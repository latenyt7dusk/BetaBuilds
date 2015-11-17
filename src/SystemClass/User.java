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
public class User extends PersonalInfo{
    
    private String uname,upass,role;
    
    public User(){
        this(null,null,null);
    }
    public User(String u,String p,String r){
        this.uname = u;
        this.upass = p;
        this.role = r;
    }
    
    public void setUsername(String u){
        this.uname = u;
    }
    public String getUsername(){
        return uname;
    }
    
    public void setPassword(String p){
        this.upass = p;
    }
    public String getPassword(){
        return upass;
    }
    
    public void setRole(String r){
        this.role = r;
    }
    public String getRole(){
        return role;
    }
    
    public String getUserEntry(){
        return getID()+","+uname+","+upass+","+role;
    }
    
    
}
