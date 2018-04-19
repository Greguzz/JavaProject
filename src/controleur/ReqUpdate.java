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
public class ReqUpdate {
    //"UPDATE chambre SET surveillant = sur WHERE no_chambre = n_c"

    public String concatrequete(String table, String col, String var[], String modif, String val[]){
    String fullrequete = "UPDATE " + table + " SET " + col + " = " + modif + " WHERE ";
    for(int i=0; i<var.length; i++){
        fullrequete = fullrequete + var[i] + " = " + val[i];
        if(i<var.length-1){
            fullrequete = fullrequete + " AND ";
        }
    }
    return fullrequete;
    } 
}
