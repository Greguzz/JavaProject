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
        Graphique graphique=new Graphique();
        graphique.afficher();
        System.out.println("Veuillez entrer votre identifiant");
        Scanner sc = new Scanner(System.in);
        String id=sc.next();
        System.out.println("Veuillez entrer votre mot de passe");
        String password= sc.next();
        System.out.println("Veuillez entrer le nom de la base de donnée");
        String db = sc.next();
        Connexion C = new Connexion(db, id, password);
        String requete;
        
        System.out.println("1 recherche, 2 supprimer, 3 ajouter, 4 modifier");
        int menu = sc.nextInt();
        
        switch(menu){
            
            case 1:
                System.out.println("Vous recherchez ? 1 Service, 2 Chambre, 3 Employé, 4 Docteur, 5 Infirmier, 6 Malade, 7 Une hospitalisation, 8 Un soignage ?");
                int menu2 = sc.nextInt();
                
                switch(menu2){
                    case 1 :
                        String tab[] = new String[3];
                        System.out.println("Code ?");
                        tab[0]=sc.next();
                        System.out.println("Nom ?");
                        tab[1]=sc.next();
                        System.out.println("Batiment ?");
                        tab[2]=sc.next();
                        System.out.println("Directeur ?");
                        tab[3]=sc.next();
                        requete = "SELECT * FROM service WHERE code LIKE" +tab[0] + "AND nom LIKE "+ tab[1] + "AND batiment LIKE" + tab[2] + "AND directeur LIKE" + tab[3];
                        C.executeUpdate(requete);
                
                }
                
        
        
        
        }
    }
    
}