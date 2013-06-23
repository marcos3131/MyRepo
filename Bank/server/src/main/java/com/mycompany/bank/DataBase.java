/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank;

/**
 *
 * @author mark2
 */
public interface DataBase {
    /*
     * saves all records into database.
     */
    void save ();
    /*
     * updates record in the app.
     */
    void update ();
    /* 
     * removes single record.
     */
    void remove (Integer Id);
    /* 
     * find record
     */
    void find (Integer Id);
}
