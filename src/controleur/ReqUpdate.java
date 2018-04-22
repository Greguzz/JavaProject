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
        int size = 0;
        for(int j = 0; j<var.length; j++){
            if (val[j]!=""){
                size++;
            }
        }
        String newvar[] = new String[size];
        String newval[] = new String[size];
        int a = 0;
        for(int k = 0; k<var.length; k++){
            if (val[k]!=""){
                newvar[a]=var[k];
                newval[a]=val[k];
                a++;
            }
        }
        
        String fullrequete = "UPDATE " + table + " SET " + col + " = " + modif + " WHERE ";
        for(int i=0; i<newvar.length; i++){
            fullrequete = fullrequete + newvar[i] + " = " + newval[i];
            if(i<newvar.length-1){
                fullrequete = fullrequete + " AND ";
            }
        }
        return fullrequete;
    } 
}
