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
        
        switch(menu){
            
            case 1:
                System.out.println("Vous recherchez ? 1 Service, 2 Chambre, 3 Employé, 4 Docteur, 5 Infirmier, 6 Malade, 7 Une hospitalisation, 8 Un soignage ?");
                int menu2 = sc.nextInt();
                
                switch(menu2){
                    case 1 :
                        String ligne[] = new String[4];
                        String tab[] = new String[4];
                        System.out.println("Code ?");
                        tab[0]=sc.next();
                        ligne[0]="Code";
                        
                        if(tab[0].equals("0")) {
                            tab[0]="";
                        }
                        
                        System.out.println("Nom ?");
                        tab[1]=sc.next();
                        ligne[1] = "Nom";
                       /* if(tab[1].equals("0")) {
                            tab[1]=null;
                        }*/
                        
                        System.out.println("Batiment ?");
                        tab[2]=sc.next();
                        ligne[2]="Batiment";
                        if(tab[2].equals("0")) {
                            tab[2]="";
                        }
                        
                        System.out.println("Directeur ?");
                        tab[3]=sc.next();
                        ligne[3]="Directeur";
                        if(tab[3].equals("0")) {
                            tab[3]="";
                        }
                        
                        Requetes R = new Requetes(tab, tab.length);
                        String fullreq = R.concatrequete(tab, "Service", ligne);
                        System.out.println(fullreq);
                        liste = C.remplirChampsRequete(fullreq);
                        for(int i=0; i<liste.size(); i++){
                            System.out.println(liste.get(i));
                        }
                        break;
                        
                    //case 2:
                        
                }
                
        
        
        
        }
        
    }
    
    
    
}
