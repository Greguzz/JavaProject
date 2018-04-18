/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.SQLException;
import java.util.Scanner;

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
        System.out.println("Veuillez entrer votre identifiant");
        Scanner sc = new Scanner(System.in);
        String id=sc.next();
        System.out.println("Veuillez entrer votre mot de passe");
        String password= sc.next();
        System.out.println("Veuillez entrer le nom de la base de donnée");
        String db = sc.next();
        Connexion C = new Connexion(db, id, password);
        
        System.out.println("1 recherche, 2 supprimer, 3 ajouter, 4 modifier");
        int menu = sc.nextInt();
        
        switch(menu){
            
            case 1:
        
                String tab[] = new String[7];
                System.out.println("Service ?");
                tab[0]=sc.next();
                System.out.println("Chambre ?");
                tab[1]=sc.next();
                System.out.println("Employe ?");
                tab[2]=sc.next();
                System.out.println("Docteur ?");
                tab[3]=sc.next();
                System.out.println("Infirmer ?");
                tab[4]=sc.next();
                System.out.println("Malade ?");
                tab[5]=sc.next();
                System.out.println("Hospitalisation ?");
                tab[6]=sc.next();
                System.out.println("Soigne ?");
                tab[7]=sc.next();
                
                for(int i=0; i<7; i++)
                {
                                        
                }
        
        
        
        }
    }
    
}