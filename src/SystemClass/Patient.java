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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HERU
 */
public class Patient extends PersonalInfo{
    
    private List<OccularRx> Rx = new ArrayList();
    private List<Transaction> Tx = new ArrayList();
    
    public Patient(){
    
    }
    
    /**
     * @param rx List of Occular Diagnostic Records
     */
    public void setOccularRx(List<OccularRx> rx){
        this.Rx = rx;
    }
    /**
     * @param rx Updated Occular Diagnostic Record
     * @param i Index of Record to be replaced
     */
    public void setOccularRx(OccularRx rx,int i){
        this.Rx.set(i, rx);
    }
    /**
     * @param rx adds new Occular Diagnostic Record
     */
    public void addOccularRx(OccularRx rx){
        this.Rx.add(rx);
    }
    /**
     * @return Occular Diagnostic Record List
     */
    public List<OccularRx> getOccularRx(){
        return Rx;
    }

    /**
     * @param i Index of record to be removed
     */
    public void RemoveOccularRx(int i){
        this.Rx.remove(i);
    }
    
    /**
     * @param tx List of Transaction Record
     */
    public void setTransactions(List<Transaction> tx){
        this.Tx = tx;
    }
    /**
     * @param tx Updated Transaction Record
     * @param i Index of Transaction Record to be replaced
     */
    public void setTransaction(Transaction tx,int i){
        this.Tx.set(i, tx);
    }
    /**
     * @param tx New Transaction Record to be Added
     */
    public void addTransaction(Transaction tx){
        this.Tx.add(tx);
    }
    /**
     * @return Transaction Record List
     */
    public List<Transaction> getTransactions(){
        return Tx;
    }
    /**
     * @param i Index of Transaction to be Removed
     */
    public void removeTransaction(int i){
        this.Tx.remove(i);
    }
    
}
