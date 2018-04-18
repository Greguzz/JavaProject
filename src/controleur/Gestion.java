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
    }
    
}
