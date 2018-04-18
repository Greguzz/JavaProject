/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe GRAPHIQUE qui hérite de JFrame et implémente ActionListener
 *
 *
 * @author Manu
 */
public class Graphique extends JFrame implements ActionListener {

    private final JPanel connexion;
    private final JTextField login;
    private final JTextField mdp;
    private final JButton connect;
    private final JPanel pan1;
    private final JPanel pan2;
    private final JButton choix1;
    private final JButton choix2;
    private final JButton choix3;
    private final JButton choix4;
    private final JSplitPane split;
    private Dimension d;    ///Pour la dimension des boutons

    /**
     * Constructeur de la classe Graphique : Initialise tous les attributs
     *
     * @param a représente la taille en X de la JFrame
     * @param b représente la taille en Y de la JFrame
     */
    public Graphique(int a, int b) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); ///Ferme le programme lorsqu'on ferme la fenêtre
        this.setSize(a, b);  ///Impose la taille selon les paramètres 
        connexion = new JPanel();

        login = new JTextField(10); ///10=taille du JTextField
        mdp = new JTextField(10);

        pan1 = new JPanel();
        pan1.setSize(200, 600);
        pan2 = new JPanel();
        pan2.setSize(600, 600);
//        
        connect = new JButton("Connexion");
        connect.addActionListener(this);
        choix1 = new JButton("Ajout ");
        choix1.addActionListener(this);
        choix2 = new JButton("Supression");
        choix2.addActionListener(this);
        choix3 = new JButton("Mise a Jour");
        choix3.addActionListener(this);
        choix4 = new JButton("Recherche");
        choix4.addActionListener(this);
        d = new Dimension(190, 30);
//        
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan1, pan2); ///Pour séparer les deux panneaux 
        split.setDividerSize(10);  ///Taille du JSplitPane
        split.setDividerLocation(200); ///Position du JSplitPane

        this.setVisible(true);   ///Rend la fenêtre visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == connect) {
            if ((login.getText().equals("r")) && (mdp.getText().equals("m"))) {
                System.out.println("lol");
            }
        }
        if (e.getSource() == choix1) {
            System.out.println("lol1");
        }
        if (e.getSource() == choix2) {
            System.out.println("lol2");
        }
        if (e.getSource() == choix3) {
            System.out.println("lol3");
        }
        if (e.getSource() == choix4) {
            System.out.println("lol4");
        }

    }

    /**
     * Méthode ConnexionBDD : Sert à afficher la fenêtre de connexion à la BDD.
     * Met la mise en page en Flow Layout. Rend la fenêtre visible à la fin.
     */
    public void ConnexionBDD() {
        this.setTitle("Connexion à la base de données");
        connexion.setLayout(new FlowLayout());
        this.getContentPane().add(connexion);
        connexion.add(login);
        connexion.add(mdp);
        connexion.add(connect);
        this.setVisible(true);
    }

    /**
     * Méthode menu Sert à afficher la fenêtre principale pour l'interaction.
     * Met la mise en page en FlowLayout Vertical pour que ça soit plus beau.
     * Rend la fenêtre visible à la fin.
     */
    public void Menu() {
        this.getContentPane().add(split, BorderLayout.CENTER);
//        this.getContentPane().add(pan1);
//        this.getContentPane().add(pan2);
        pan1.setLayout(new FlowLayout());

        choix1.setPreferredSize(d);
        choix2.setPreferredSize(d);
        choix3.setPreferredSize(d);
        choix4.setPreferredSize(d);
        pan1.add(choix1);
        pan1.add(choix2);
        pan1.add(choix3);
        pan1.add(choix4);
        this.setVisible(true);
    }

}
