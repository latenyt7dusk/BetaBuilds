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
public class LogRecord {
    
    private final String ID,Desc,time,cat,user;
    
    public LogRecord(String i,String d,String t,String c,String u){
        this.ID = i;
        this.Desc = d;
        this.time = t;
        this.cat = c;
        this.user = u;
    }
    
    public String getID(){
        return ID;
    }
    public String getDescription(){
        return Desc;
    }
    public String getTimeStamp(){
        return time;
    }
    public String getCategory(){
        return cat;
    }
    public String getUser(){
        return user;
    }
    
    public String getEntry(){
        return "("+ID+","+Desc+","+time+","+cat+","+user+")";
    }
}
