/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** Classe IDENTIFICATION qui hérite de JFrame et implémente Action Listener.
 *  Fenêtre de connexion locale à la base de données à l'aide des identifiants : login = root, mot de passe = 1234
 *
 * @author Manu
 */
public class Identification extends JFrame implements ActionListener {

    private final JButton connect; ///Bouton pour se connecter
    private final JTextField login; ///Pour entrer son login
    private final JTextField mdp; ///Pour entrer son mot de passe
    private final JPanel pan1; ///Panel principal

    
    /** Constructeur de la classe Identification. 
     *  Rend la fenêtre visible à la fin.
     * 
     */
    public Identification() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ///Ferme le programme si on ferme la fenêtre
        this.setSize(500, 100); 
        this.setTitle("Connexion à la base de données"); 
        setLocationRelativeTo(null); //On centre la fenêtre 
        setResizable(false); ///Impossibilité de modifier la taille de la fenêtre
        
        ///Instanciation des éléments de Identification
        login = new JTextField(10); 
        mdp = new JTextField(10);
        connect = new JButton("Connexion");
        connect.addActionListener(this); ///Ajout d'un écouteur pour se connecter
        pan1 = new JPanel();
        pan1.add(login);
        pan1.add(mdp);
        pan1.add(connect);
        this.add(pan1);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connect) {
            if (login.getText().equals("root") && (mdp.getText().equals("1234"))) {
                this.removeAll();
                
                ///Appel de la fenêtre principale de gestion
                Graphique graphique = new Graphique(800, 600); 
                graphique.Menu();

            } else {
                System.out.println("Vous ne pouvez pas vous connecter à la base de données");
            }
        }
    }
}
