/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import vue.Graphique;

/**
 *
 * @author Manu
 */
public class Gestion {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
  //    Graphique connexion=new Graphique(300,400);
//      connexion.ConnexionBDD();
        Graphique graphique=new Graphique(800,600);
        graphique.Menu();
        Scanner sc = new Scanner(System.in);
        Connexion C = new Connexion("hopital", "root", "1234");
        String requete;
        ArrayList<String> liste = new ArrayList<String>();
        
        System.out.println("1 recherche, 2 supprimer, 3 ajouter, 4 modifier");
        int menu = sc.nextInt();
        
        
    }
    
    
    
}
