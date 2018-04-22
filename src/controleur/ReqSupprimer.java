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
public class ReqSupprimer {
        /**
     * Une méthode qui renvoie juste le string de requête SQL de suppression de donnée à une des tables
     *
     * @param table le nom de la table
     * @param var les colonnes de la table
     * @param supp les données à supprimer
     * @return fullrequete la requête finis
     */
    public static String concatrequete(String table, String var[], String supp[]){
        
        int size = 0;
        for(int j = 0; j<var.length; j++){
            if (var[j]!=""){
                size++;
            }
        }
        String newvar[] = new String[size];
        String newsupp[] = new String[size];
        int a = 0;
        for(int k = 0; k<var.length; k++){
            if (var[k]!=""){
                newvar[a]=var[k];
                newsupp[a]=supp[k];
                a++;
            }
        }
        
        String fullrequete = "DELETE FROM " + table + " WHERE ";
        for(int i=0; i<newsupp.length; i++){
            fullrequete = fullrequete + newvar[i] + " = " + "'" + newsupp[i] + "'";
            if(i<supp.length-1){
                fullrequete = fullrequete + " AND ";
            }
            else {
                fullrequete = fullrequete + ";";
            }
        }
        return fullrequete;
    }
}
