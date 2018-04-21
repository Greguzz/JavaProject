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
    /**
     * Une méthode qui renvoie juste le string de requête SQL de modification donnée à une des tables
     *
     * @param table le nom de la table
     * @param modif la donnes a modifier
     * @param col la colonne correspondant a la donnée à modifier
     * @param var les colonnes de la table
     * @param val les valeurs des colonnes qui vont servir a savoir quelle valeur modifier
     * @return fullrequete la requête finis
     */
    public static String concatrequete(String table, String col, String var[], String modif, String val[]){
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
