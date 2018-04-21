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
    /**
     * Une méthode qui renvoie juste le string de requête SQL d'ajout de donnée à une des tables
     *
     * @param table le nom de la table
     * @param var les colonnes de la table
     * @param ajout les données à ajouter
     * @return fullrequete la requête finis
     */
    public static String concatrequete(String table,  String var[], String ajout[]){
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
