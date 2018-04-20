/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 *
 * @author Aurelio
 */
public class ReqLectureTable {
    
    public static String concatrequete(String table, String var[], String val[]){
    String fullrequete = "SELECT ";
    for(int i=0; i<var.length; i++){
        fullrequete = fullrequete + var[i] + " ";
        if(i<var.length-1){
            fullrequete = fullrequete + ", ";
        }
        else {
            fullrequete = fullrequete + " FROM " + table;
        }
    }
    return fullrequete;
    }
}
