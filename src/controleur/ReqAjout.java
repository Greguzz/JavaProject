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
public class ReqAjout {
    
    public String concatrequete(String table,  String var[], String ajout[]){
    String fullrequete = "INSERT INTO " + table + " (" ;
    for(int i=0; i<ajout.length; i++){
        fullrequete = fullrequete + var[i];
        if(i<ajout.length-1){
            fullrequete = fullrequete + ", ";
        }
        else {
            fullrequete = fullrequete + ") VALUES (";
        }
    }
    for(int i=0; i<ajout.length; i++){
        
        fullrequete = fullrequete + "'" + ajout[i] + "'";
        if(i<ajout.length-1){
            fullrequete = fullrequete + ", ";
        }
        else {
            fullrequete = fullrequete + ");";
        }
    }
    
    return fullrequete;
    } 
}
