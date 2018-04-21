/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controleur.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.*;

/**
 * Classe GRAPHIQUE qui hérite de JFrame et implémente ActionListener
 *
 *
 * @author Manu
 */
public class Graphique extends JFrame implements ActionListener {

    private final JPanel connexion;

    private final JLabel question1, question4;
    private final JLabel code, nom, batiment, directeur; ///JLabel du formulaire de recherche Service
    private final JLabel code_service, no_chambre, surveillant, nb_lits; ///JLabel du formulaire de recherche Chambre
    private final JLabel numero, nom2, prenom, adresse, tel; ///JLabel du formulaire de recherche Employé
    private final JLabel numero2, specialité; ///JLabel du formulaire de recherche Docteur
    private final JLabel numero3, code_service2, rotation, salaire; ///JLabel du formulaire de recherche Infirmier
    private final JLabel numero4, nom3, prenom2, adresse2, tel2, mutuelle; ///JLabel du formulaire de recherche Malade
    private final JLabel no_malade, code_service3, no_chambre2, lit; ///JLabel du formulaire de recherche Hospitalisation
    private final JLabel no_docteur, no_malade2; ///JLabel du formulaire de recherche Soignage

    private final JTextField login;
    private final JTextField mdp;
    private final JTextField code_t, nom_t, batiment_t, directeur_t; ///JTextField du formulaire de recherche Service
    private final JTextField code_service_t, no_chambre_t, surveillant_t, nb_lits_t; ///JTextField du formulaire de recherche Chambre
    private final JTextField numero_t, nom2_t, prenom_t, adresse_t, tel_t; ///JTextField du formulaire de recherche Employé
    private final JTextField numero2_t, specialité_t; ///JTextField du formulaire de recherche Docteur
    private final JTextField numero3_t, code_service2_t, rotation_t, salaire_t; ///JTextField du formulaire de recherche Infirmier
    private final JTextField numero4_t, nom3_t, prenom2_t, adresse2_t, tel2_t, mutuelle_t; ///JTextField du formulaire de recherche Malade
    private final JTextField no_malade_t, code_service3_t, no_chambre2_t, lit_t; ///JTextField du formulaire de recherche Hospitalisation
    private final JTextField no_docteur_t, no_malade2_t; ///JTextField du formulaire de recherche Soignage

    //private final JTextArea service;
    private final JButton connect;
    private final JPanel pan1;
    private final JPanel pan2;
    private final JPanel pan3;
    private final JPanel pan4;
    private final JButton choix1;
    private final JButton choix2;
    private final JButton choix3;
    private final JButton choix4;

    private final JButton Service, Service2;
    private final JButton Chambre, Chambre2;
    private final JButton Employé, Employé2;
    private final JButton Docteur, Docteur2;
    private final JButton Infirmier, Infirmier2;
    private final JButton Malade, Malade2;
    private final JButton Hospitalisation, Hospitalisation2;
    private final JButton Soignage, Soignage2;
    private final JButton Rechercher_parametre_Service, Rechercher_parametre_Chambre, Rechercher_parametre_Employé, Rechercher_parametre_Docteur, Rechercher_parametre_Infirmier, Rechercher_parametre_Malade, Rechercher_parametre_Hospitalisation, Rechercher_parametre_Soignage;
    private final JButton Rechercher_tout_Service, Rechercher_tout_Chambre, Rechercher_tout_Employé, Rechercher_tout_Docteur, Rechercher_tout_Infirmier, Rechercher_tout_Malade, Rechercher_tout_Hospitalisation, Rechercher_tout_Soignage;

    private final JButton Ajouter_Service, Ajouter_Chambre, Ajouter_Employé, Ajouter_Docteur, Ajouter_Infirmier, Ajouter_Malade, Ajouter_Hospitalisation, Ajouter_Soignage;
    private final JSplitPane split;
    private final Dimension d, e;    ///Pour la dimension des boutons
    private Font font1, font2;

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

        question1 = new JLabel("Dans quelle section souhaitez-vous ajouter ?");
        question4 = new JLabel("Que souhaitez-vous rechercher ?");
        code = new JLabel("Code : ");
        nom = new JLabel("Nom : ");
        batiment = new JLabel("Bâtiment : ");
        directeur = new JLabel("Directeur : ");
        code_service = new JLabel("Code Service : ");
        no_chambre = new JLabel("Numéro de chambre : ");
        surveillant = new JLabel("Surveillant : ");
        nb_lits = new JLabel("Nombre de lits : ");
        numero = new JLabel("Numéro : ");
        nom2 = new JLabel("Nom : ");
        prenom = new JLabel("Prénom : ");
        adresse = new JLabel("Adresse : ");
        tel = new JLabel("Téléphone : ");
        numero2 = new JLabel("Numéro : ");
        specialité = new JLabel("Spécialité : ");
        numero3 = new JLabel("Numéro : ");
        code_service2 = new JLabel("Code Service : ");
        rotation = new JLabel("Rotation : ");
        salaire = new JLabel("Salaire : ");
        numero4 = new JLabel("Numéro : ");
        nom3 = new JLabel("Nom : ");
        prenom2 = new JLabel("Prénom : ");
        adresse2 = new JLabel("Adresse : ");
        tel2 = new JLabel("Téléphone : ");
        mutuelle = new JLabel("Mutuelle : ");
        no_malade = new JLabel("Numéro du Malade : ");
        code_service3 = new JLabel("Code Service : ");
        no_chambre2 = new JLabel("Numéro de la Chambre : ");
        lit = new JLabel("Lit : ");
        no_docteur = new JLabel("Numéro du docteur : ");
        no_malade2 = new JLabel("Numéro du malade : ");

        login = new JTextField(10); ///10=taille du JTextField
        mdp = new JTextField(10);
        code_t = new JTextField(15);
        nom_t = new JTextField(15);
        batiment_t = new JTextField(15);
        directeur_t = new JTextField(15);
        code_service_t = new JTextField(15);
        no_chambre_t = new JTextField(15);
        surveillant_t = new JTextField(15);
        nb_lits_t = new JTextField(15);
        numero_t = new JTextField(15);
        nom2_t = new JTextField(15);
        prenom_t = new JTextField(15);
        adresse_t = new JTextField(15);
        tel_t = new JTextField(15);
        numero2_t = new JTextField(15);
        specialité_t = new JTextField(15);
        numero3_t = new JTextField(15);
        code_service2_t = new JTextField(15);
        rotation_t = new JTextField(15);
        salaire_t = new JTextField(15);
        numero4_t = new JTextField(15);
        nom3_t = new JTextField(15);
        prenom2_t = new JTextField(15);
        adresse2_t = new JTextField(15);
        tel2_t = new JTextField(15);
        mutuelle_t = new JTextField(15);
        no_malade_t = new JTextField(15);
        code_service3_t = new JTextField(15);
        no_chambre2_t = new JTextField(15);
        lit_t = new JTextField(15);
        no_docteur_t = new JTextField(15);
        no_malade2_t = new JTextField(15);

//        service = new JTextArea();
        pan1 = new JPanel();
        pan1.setSize(200, 600);
        pan2 = new JPanel();
        pan2.setSize(500, 500);
        pan3 = new JPanel();
        pan3.setSize(300, 300);
        pan4 = new JPanel();
        pan4.setSize(300, 300);

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
        Service = new JButton("Service");
        Service.addActionListener(this);
        Chambre = new JButton("Chambre");
        Chambre.addActionListener(this);
        Employé = new JButton("Employé");
        Employé.addActionListener(this);
        Docteur = new JButton("Docteur");
        Docteur.addActionListener(this);
        Infirmier = new JButton("Infirmier");
        Infirmier.addActionListener(this);
        Malade = new JButton("Malade");
        Malade.addActionListener(this);
        Hospitalisation = new JButton("Hospitalisation");
        Hospitalisation.addActionListener(this);
        Soignage = new JButton("Soignage");
        Soignage.addActionListener(this);
        Service2 = new JButton("Service");
        Service2.addActionListener(this);
        Chambre2 = new JButton("Chambre");
        Chambre2.addActionListener(this);
        Employé2 = new JButton("Employé");
        Employé2.addActionListener(this);
        Docteur2 = new JButton("Docteur");
        Docteur2.addActionListener(this);
        Infirmier2 = new JButton("Infirmier");
        Infirmier2.addActionListener(this);
        Malade2 = new JButton("Malade");
        Malade2.addActionListener(this);
        Hospitalisation2 = new JButton("Hospitalisation");
        Hospitalisation2.addActionListener(this);
        Soignage2 = new JButton("Soignage");
        Soignage2.addActionListener(this);
        Rechercher_parametre_Service = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Service.addActionListener(this);
        Rechercher_parametre_Chambre = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Chambre.addActionListener(this);
        Rechercher_parametre_Employé = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Employé.addActionListener(this);
        Rechercher_parametre_Docteur = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Docteur.addActionListener(this);
        Rechercher_parametre_Infirmier = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Infirmier.addActionListener(this);
        Rechercher_parametre_Malade = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Malade.addActionListener(this);
        Rechercher_parametre_Hospitalisation = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Hospitalisation.addActionListener(this);
        Rechercher_parametre_Soignage = new JButton("Rechercher Par Paramètre");
        Rechercher_parametre_Soignage.addActionListener(this);
        Rechercher_tout_Service = new JButton("Afficher tout");
        Rechercher_tout_Service.addActionListener(this);
        Rechercher_tout_Chambre = new JButton("Afficher tout");
        Rechercher_tout_Chambre.addActionListener(this);
        Rechercher_tout_Employé = new JButton("Afficher tout");
        Rechercher_tout_Employé.addActionListener(this);
        Rechercher_tout_Docteur = new JButton("Afficher tout");
        Rechercher_tout_Docteur.addActionListener(this);
        Rechercher_tout_Infirmier = new JButton("Afficher tout");
        Rechercher_tout_Infirmier.addActionListener(this);
        Rechercher_tout_Malade = new JButton("Afficher tout");
        Rechercher_tout_Malade.addActionListener(this);
        Rechercher_tout_Hospitalisation = new JButton("Afficher tout");
        Rechercher_tout_Hospitalisation.addActionListener(this);
        Rechercher_tout_Soignage = new JButton("Afficher tout");
        Rechercher_tout_Soignage.addActionListener(this);
        Ajouter_Service = new JButton("Ajouter");
        Ajouter_Service.addActionListener(this);
        Ajouter_Chambre = new JButton("Ajouter");
        Ajouter_Chambre.addActionListener(this);
        Ajouter_Employé = new JButton("Ajouter");
        Ajouter_Employé.addActionListener(this);
        Ajouter_Docteur = new JButton("Ajouter");
        Ajouter_Docteur.addActionListener(this);
        Ajouter_Infirmier = new JButton("Ajouter");
        Ajouter_Infirmier.addActionListener(this);
        Ajouter_Malade = new JButton("Ajouter");
        Ajouter_Malade.addActionListener(this);
        Ajouter_Hospitalisation = new JButton("Ajouter");
        Ajouter_Hospitalisation.addActionListener(this);
        Ajouter_Soignage = new JButton("Ajouter");
        Ajouter_Soignage.addActionListener(this);

        d = new Dimension(190, 30);
        e = new Dimension(500, 40);

//        
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan1, pan2); ///Pour séparer les deux panneaux 
        split.setDividerSize(10);  ///Taille du JSplitPane
        split.setDividerLocation(200); ///Position du JSplitPane

        this.setVisible(true);   ///Rend la fenêtre visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == connect) {
            if ((login.getText().equals("root")) && (mdp.getText().equals("0"))) {
                System.out.println("lol");
            }
        }
        if (e.getSource() == choix1) {
            System.out.println("lol1");
            ChoixSecteur(1, false);
        }
        if (e.getSource() == choix2) {
            System.out.println("lol2");
        }
        if (e.getSource() == choix3) {
            System.out.println("lol3");
        }
        if (e.getSource() == choix4) {
            System.out.println("lol4");
            ChoixSecteur(4, true);
        }

        if (e.getSource() == Service) {
            System.out.println("lol5");
            FormulaireRecherche(1, true);
        }
        if (e.getSource() == Chambre) {
            System.out.println("lol6");
            FormulaireRecherche(2, true);
        }
        if (e.getSource() == Employé) {
            System.out.println("lol7");
            FormulaireRecherche(3, true);
        }

        if (e.getSource() == Docteur) {
            System.out.println("lol8");
            FormulaireRecherche(4, true);
        }

        if (e.getSource() == Infirmier) {
            System.out.println("lol9");
            FormulaireRecherche(5, true);
        }

        if (e.getSource() == Malade) {
            System.out.println("lol10");
            FormulaireRecherche(6, true);
        }
        if (e.getSource() == Hospitalisation) {
            System.out.println("lol11");
            FormulaireRecherche(7, true);
        }

        if (e.getSource() == Soignage) {
            System.out.println("lol12");
            FormulaireRecherche(8, true);
        }

        if (e.getSource() == Service2) {
            System.out.println("lol5");
            FormulaireRecherche(1, false);
        }
        if (e.getSource() == Chambre2) {
            System.out.println("lol6");
            FormulaireRecherche(2, false);
        }
        if (e.getSource() == Employé2) {
            System.out.println("lol7");
            FormulaireRecherche(3, false);
        }

        if (e.getSource() == Docteur2) {
            System.out.println("lol8");
            FormulaireRecherche(4, false);
        }

        if (e.getSource() == Infirmier2) {
            System.out.println("lol9");
            FormulaireRecherche(5, false);
        }

        if (e.getSource() == Malade2) {
            System.out.println("lol10");
            FormulaireRecherche(6, false);
        }
        if (e.getSource() == Hospitalisation2) {
            System.out.println("lol11");
            FormulaireRecherche(7, false);
        }

        if (e.getSource() == Soignage2) {
            System.out.println("lol12");
            FormulaireRecherche(8, false);
        }

        if (e.getSource() == Rechercher_tout_Service) {
            JTextArea lol;
            System.out.println("lol1");
            String[] tab_colonnes1 = new String[4];
            tab_colonnes1[0] = "code";
            tab_colonnes1[1] = "nom";
            tab_colonnes1[2] = "batiment";
            tab_colonnes1[3] = "directeur";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");
                String affichage = "";
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("service", tab_colonnes1));
                for (int i = 0; i < liste.size(); i++) {
//                    System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == Rechercher_tout_Chambre) {
            System.out.println("lol2");
            String[] tab_colonnes2 = new String[4];
            tab_colonnes2[0] = "code_service";
            tab_colonnes2[1] = "no_chambre";
            tab_colonnes2[2] = "surveillant";
            tab_colonnes2[3] = "nb_lits";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("chambre", tab_colonnes2));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
//                      System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == Rechercher_tout_Employé) {
            System.out.println("lol3");
            String[] tab_colonnes3 = new String[5];
            tab_colonnes3[0] = "numero";
            tab_colonnes3[1] = "nom";
            tab_colonnes3[2] = "prenom";
            tab_colonnes3[3] = "adresse";
            tab_colonnes3[4] = "tel";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("employe", tab_colonnes3));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
//                      System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == Rechercher_tout_Docteur) {
            System.out.println("lol4");
            String[] tab_colonnes4 = new String[2];
            tab_colonnes4[0] = "numero";
            tab_colonnes4[1] = "specialite";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("docteur", tab_colonnes4));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
//                      System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getSource() == Rechercher_tout_Infirmier) {
            System.out.println("lol5");
            String[] tab_colonnes5 = new String[4];
            tab_colonnes5[0] = "numero";
            tab_colonnes5[1] = "code_service";
            tab_colonnes5[2] = "rotation";
            tab_colonnes5[3] = "salaire";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("infirmier", tab_colonnes5));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
//                      System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == Rechercher_tout_Malade) {
            System.out.println("lol6");
            String[] tab_colonnes6 = new String[6];
            tab_colonnes6[0] = "numero";
            tab_colonnes6[1] = "nom";
            tab_colonnes6[2] = "prenom";
            tab_colonnes6[3] = "adresse";
            tab_colonnes6[4] = "tel";
            tab_colonnes6[5] = "mutuelle";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("malade", tab_colonnes6));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
//                      System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == Rechercher_tout_Hospitalisation) {
            System.out.println("lol7");
            String[] tab_colonnes7 = new String[4];
            tab_colonnes7[0] = "no_malade";
            tab_colonnes7[1] = "code_service";
            tab_colonnes7[2] = "no_chambre";
            tab_colonnes7[3] = "lit";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("hospitalisation", tab_colonnes7));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
//                      System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == Rechercher_tout_Soignage) {
            System.out.println("lol8");
            String[] tab_colonnes8 = new String[2];
            tab_colonnes8[0] = "no_docteur";
            tab_colonnes8[1] = "no_malade";
            Connexion C;
            try {
                C = new Connexion("hopital", "root", "");
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("soigne", tab_colonnes8));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
//                      System.out.println(liste.get(i));
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == Rechercher_parametre_Service) {
            System.out.println("lol12");
            String[] tab_colonnes1 = new String[4];
            String[] tab_valeurs1 = new String[4];

            tab_valeurs1[0] = code_t.getText();
            tab_valeurs1[1] = nom_t.getText();
            tab_valeurs1[2] = batiment_t.getText();
            tab_valeurs1[3] = directeur_t.getText();
            tab_colonnes1[0] = "code";
            tab_colonnes1[1] = "nom";
            tab_colonnes1[2] = "batiment";
            tab_colonnes1[3] = "directeur";
            Requetes requete = new Requetes(tab_valeurs1, tab_valeurs1.length);
            requete.concatrequete(tab_valeurs1, "service", tab_colonnes1);
            System.out.println("" + requete.concatrequete(tab_valeurs1, "service", tab_colonnes1));
//            Connexion C;
//            try {
//                C = new Connexion("hopital", "root", "");
//                ArrayList<String> liste = new ArrayList<String>();
//                liste = C.remplirChampsRequete(ReqAjout.concatrequete("service", tab_colonnes1, tab_valeurs1));
//                for (int i = 0; i < liste.size(); i++) {
//                    System.out.println(liste.get(i));
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }

        if (e.getSource() == Ajouter_Service) {
            System.out.println("lol13");
            String[] tab_valeurs1 = new String[4];
            String[] tab_colonnes1 = new String[4];
            if (code_t.getText().equals("") || nom_t.getText().equals("") || batiment_t.getText().equals("") || directeur_t.getText().equals("")) {
                System.out.println("Un de vos champs est vide");
            } else {
                tab_valeurs1[0] = code_t.getText();
                tab_valeurs1[1] = nom_t.getText();
                tab_valeurs1[2] = batiment_t.getText();
                tab_valeurs1[3] = directeur_t.getText();
                tab_colonnes1[0] = "code";
                tab_colonnes1[1] = "nom";
                tab_colonnes1[2] = "batiment";
                tab_colonnes1[3] = "directeur";
//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("service", tab_colonnes1, tab_valeurs1);
                System.out.println("" + ReqAjout.concatrequete("service", tab_colonnes1, tab_valeurs1));
//                Connexion C;
//                try {
//                    C = new Connexion("hopital", "root", "");
//                    //String affichage = "";
//                    ArrayList<String> liste = new ArrayList<String>();
//                    liste = C.remplirChampsRequete(ReqAjout.concatrequete("service", tab_colonnes1, tab_valeurs1));
//                    for (int i = 0; i < liste.size(); i++) {
//                        System.out.println(liste.get(i));
////                        affichage += "" + i + ". " + liste.get(i);
//                    }
////                    affiche(affichage);
//                } catch (SQLException | ClassNotFoundException ex) {
//                    Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }

        }

        if (e.getSource() == Ajouter_Chambre) {
            System.out.println("lol13");
            String[] tab_valeurs2 = new String[4];
            String[] tab_colonnes2 = new String[4];
            if (code_service_t.getText().equals("") || no_chambre_t.getText().equals("") || surveillant_t.getText().equals("") || nb_lits_t.getText().equals("")) {
                System.out.println("Un de vos champs est vide");
            } else {
                tab_valeurs2[0] = code_service_t.getText();
                tab_valeurs2[1] = no_chambre_t.getText();
                tab_valeurs2[2] = surveillant_t.getText();
                tab_valeurs2[3] = nb_lits_t.getText();
                tab_colonnes2[0] = "code_service";
                tab_colonnes2[1] = "no_chambre";
                tab_colonnes2[2] = "surveillant";
                tab_colonnes2[3] = "nb_lits";
//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("chambre", tab_colonnes2, tab_valeurs2);
                System.out.println("" + ReqAjout.concatrequete("chambre", tab_colonnes2, tab_valeurs2));
            }
        }

        if (e.getSource() == Ajouter_Employé) {
            System.out.println("lol13");
            String[] tab_valeurs3 = new String[5];
            String[] tab_colonnes3 = new String[5];
            if (numero_t.getText().equals("") || nom2_t.getText().equals("") || prenom_t.getText().equals("") || adresse_t.getText().equals("") || tel_t.getText().equals("")) {
                System.out.println("Un ou plusieurs de vos champs sont vides");
            } else {
                tab_valeurs3[0] = numero_t.getText();
                tab_valeurs3[1] = nom2_t.getText();
                tab_valeurs3[2] = prenom_t.getText();
                tab_valeurs3[3] = adresse_t.getText();
                tab_valeurs3[4] = tel_t.getText();
                tab_colonnes3[0] = "numero";
                tab_colonnes3[1] = "nom";
                tab_colonnes3[2] = "prenom";
                tab_colonnes3[3] = "adresse";
                tab_colonnes3[4] = "tel";
//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("employe", tab_colonnes3, tab_valeurs3);
            }
        }

        if (e.getSource() == Ajouter_Docteur) {
            System.out.println("lol13");
            String[] tab_valeurs4 = new String[2];
            String[] tab_colonnes4 = new String[2];
            if (numero2_t.getText().equals("") || specialité_t.getText().equals("")) {
                System.out.println("Un de vos champs est vide");
            } else {
                tab_valeurs4[0] = code_t.getText();
                tab_valeurs4[1] = nom_t.getText();
                tab_colonnes4[0] = "code";
                tab_colonnes4[1] = "nom";

//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("docteur", tab_colonnes4, tab_valeurs4);
            }
        }

        if (e.getSource() == Ajouter_Infirmier) {
            System.out.println("lol13");
            String[] tab_valeurs5 = new String[4];
            String[] tab_colonnes5 = new String[4];
            if (numero3_t.getText().equals("") || code_service2_t.getText().equals("") || rotation_t.getText().equals("") || salaire_t.getText().equals("")) {
                System.out.println("Un de vos champs est vide");
            } else {
                tab_valeurs5[0] = numero3_t.getText();
                tab_valeurs5[1] = code_service2_t.getText();
                tab_valeurs5[2] = rotation_t.getText();
                tab_valeurs5[3] = salaire_t.getText();
                tab_colonnes5[0] = "numero";
                tab_colonnes5[1] = "code_service";
                tab_colonnes5[2] = "rotation";
                tab_colonnes5[3] = "salaire";
//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("infirmier", tab_colonnes5, tab_valeurs5);
            }
        }

        if (e.getSource() == Ajouter_Malade) {
            System.out.println("lol13");
            String[] tab_valeurs6 = new String[6];
            String[] tab_colonnes6 = new String[6];
            if (numero4_t.getText().equals("") || nom3_t.getText().equals("") || prenom2_t.getText().equals("") || adresse2_t.getText().equals("") || tel2_t.getText().equals("") || mutuelle_t.getText().equals("")) {
                System.out.println("Un de vos champs est vide");
            } else {
                tab_valeurs6[0] = numero4_t.getText();
                tab_valeurs6[1] = nom3_t.getText();
                tab_valeurs6[2] = prenom2_t.getText();
                tab_valeurs6[3] = adresse2_t.getText();
                tab_valeurs6[4] = tel2_t.getText();
                tab_valeurs6[5] = mutuelle_t.getText();
                tab_colonnes6[0] = "numero";
                tab_colonnes6[1] = "nom";
                tab_colonnes6[2] = "prenom";
                tab_colonnes6[3] = "adresse";
                tab_colonnes6[4] = "tel";
                tab_colonnes6[5] = "mutuelle";
//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("malade", tab_colonnes6, tab_valeurs6);
            }
        }

        if (e.getSource() == Ajouter_Hospitalisation) {
            System.out.println("lol13");
            String[] tab_valeurs7 = new String[4];
            String[] tab_colonnes7 = new String[4];
            if (no_malade_t.getText().equals("") || code_service3_t.getText().equals("") || no_chambre2_t.getText().equals("") || lit_t.getText().equals("")) {
                System.out.println("Un de vos champs est vide");
            } else {
                tab_valeurs7[0] = no_malade_t.getText();
                tab_valeurs7[1] = code_service3_t.getText();
                tab_valeurs7[2] = no_chambre2_t.getText();
                tab_valeurs7[3] = lit_t.getText();
                tab_colonnes7[0] = "no_malade";
                tab_colonnes7[1] = "code_service";
                tab_colonnes7[2] = "no_chambre";
                tab_colonnes7[3] = "lit";
//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("hospitalisation", tab_colonnes7, tab_valeurs7);
            }
        }
        if (e.getSource() == Ajouter_Soignage) {
            System.out.println("lol13");
            String[] tab_valeurs8 = new String[2];
            String[] tab_colonnes8 = new String[2];
            if (no_docteur_t.getText().equals("") || no_malade2_t.getText().equals("")) {
                System.out.println("Un de vos champs est vide");
            } else {
                tab_valeurs8[0] = no_docteur_t.getText();
                tab_valeurs8[1] = no_malade2_t.getText();
                tab_colonnes8[0] = "no_docteur";
                tab_colonnes8[1] = "no_malade";
//                ReqAjout requete_ajout = new ReqAjout();
                ReqAjout.concatrequete("soigne", tab_colonnes8, tab_valeurs8);
            }
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

    /**
     * Méthode Recherche : Sert à afficher le menu de recherche pour
     * séléctionner l'élément à rechercher à l'aide des 8 boutons Rend la
     * fenêtre visible à la fin
     *
     * @param menu
     * @param a
     */
    public void ChoixSecteur(int menu, boolean a) {
        pan2.removeAll();
        pan2.repaint();
        pan2.setLayout(new FlowLayout());
        font1 = new Font("Times New Roman", Font.BOLD, 18);
        question1.setFont(font1);
        question4.setFont(font1);
        switch (menu) {
            case 1:
                pan2.add(question1);
                break;

            case 4:
                pan2.add(question4);
                break;
        }
        Service.setPreferredSize(e);
        Chambre.setPreferredSize(e);
        Employé.setPreferredSize(e);
        Docteur.setPreferredSize(e);
        Infirmier.setPreferredSize(e);
        Malade.setPreferredSize(e);
        Hospitalisation.setPreferredSize(e);
        Soignage.setPreferredSize(e);
        Service2.setPreferredSize(e);
        Chambre2.setPreferredSize(e);
        Employé2.setPreferredSize(e);
        Docteur2.setPreferredSize(e);
        Infirmier2.setPreferredSize(e);
        Malade2.setPreferredSize(e);
        Hospitalisation2.setPreferredSize(e);
        Soignage2.setPreferredSize(e);

        if (a == true) {
            pan2.add(Service);
            pan2.add(Chambre);
            pan2.add(Employé);
            pan2.add(Docteur);
            pan2.add(Infirmier);
            pan2.add(Malade);
            pan2.add(Hospitalisation);
            pan2.add(Soignage);
        } else {
            pan2.add(Service2);
            pan2.add(Chambre2);
            pan2.add(Employé2);
            pan2.add(Docteur2);
            pan2.add(Infirmier2);
            pan2.add(Malade2);
            pan2.add(Hospitalisation2);
            pan2.add(Soignage2);
        }

        this.setVisible(true);
    }

    public void FormulaireRecherche(int choix, boolean a) {
        pan2.removeAll();
        pan2.repaint();
        pan3.removeAll();
        pan3.repaint();
        pan4.removeAll();
        pan4.repaint();
        pan2.setLayout(new FlowLayout());
        pan2.add(pan3);
        pan2.add(pan4);
        pan3.setLayout(new BoxLayout(pan3, BoxLayout.PAGE_AXIS));
        pan4.setLayout(new BoxLayout(pan4, BoxLayout.PAGE_AXIS));
        font2 = new Font("Times New Roman", Font.BOLD, 16);

        switch (choix) {

            case 1:
                code.setFont(font2);
                nom.setFont(font2);
                batiment.setFont(font2);
                directeur.setFont(font2);

                pan3.add(code);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(nom);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(batiment);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(directeur);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(code_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(batiment_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(directeur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Service);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Service);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(code_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(batiment_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(directeur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Service);
                }

                break;

            case 2:
                code_service.setFont(font2);
                no_chambre.setFont(font2);
                surveillant.setFont(font2);
                nb_lits.setFont(font2);
                pan3.add(code_service);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(no_chambre);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(surveillant);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(nb_lits);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(code_service_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(surveillant_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nb_lits_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Chambre);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Chambre);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(code_service_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(surveillant_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nb_lits_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Chambre);
                }

                break;

            case 3:
                numero.setFont(font2);
                nom2.setFont(font2);
                prenom.setFont(font2);
                adresse.setFont(font2);
                tel.setFont(font2);
                pan3.add(numero);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(nom2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(prenom);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(adresse);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(tel);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(numero_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(prenom_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(adresse_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(tel_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Employé);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Employé);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(prenom_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(adresse_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(tel_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Employé);
                }

                break;

            case 4:
                numero2.setFont(font2);
                specialité.setFont(font2);
                pan3.add(numero2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(specialité);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(numero2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(specialité_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Docteur);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Docteur);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(specialité_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Docteur);
                }

                break;

            case 5:
                numero3.setFont(font2);
                code_service2.setFont(font2);
                rotation.setFont(font2);
                salaire.setFont(font2);
                pan3.add(numero3);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(code_service2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(rotation);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(salaire);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(numero3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(rotation_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(salaire_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Infirmier);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Infirmier);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(rotation_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(salaire_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Infirmier);
                }

                break;

            case 6:
                numero4.setFont(font2);
                nom3.setFont(font2);
                prenom2.setFont(font2);
                adresse2.setFont(font2);
                tel2.setFont(font2);
                mutuelle.setFont(font2);
                pan3.add(numero4);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(nom3);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(prenom2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(adresse2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(tel2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(mutuelle);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(numero4_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(prenom2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(adresse2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(tel2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(mutuelle_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Malade);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Malade);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero4_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(prenom2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(adresse2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(tel2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(mutuelle_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Malade);
                }

                break;

            case 7:
                no_malade.setFont(font2);
                code_service3.setFont(font2);
                no_chambre2.setFont(font2);
                lit.setFont(font2);
                pan3.add(no_malade);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(code_service3);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(no_chambre2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(lit);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(no_malade_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(lit_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Hospitalisation);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Hospitalisation);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(no_malade_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(lit_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Hospitalisation);
                }

                break;

            case 8:
                no_docteur.setFont(font2);
                no_malade2.setFont(font2);
                pan3.add(no_docteur);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(no_malade2);
                if (a == true) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(no_docteur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_malade2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Soignage);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Soignage);
                } else {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(no_docteur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_malade2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Soignage);
                }

                break;

        }

        this.setVisible(true);
    }

    /**
     * Méthode affiche pour afficher les informations de la base de données
     * récupérées. Très inspiré du code de l'upmf de Grenoble :
     * https://imss-www.upmf-grenoble.fr/prevert/Prog/Java/swing/JTextPane.html
     *
     * @param affichage
     */
    public void affiche(String affichage) {
        pan2.removeAll();
        pan2.repaint();
        JTextArea panneau = new JTextArea(affichage);
        JScrollPane paneTextArea1 = new JScrollPane(panneau); ///Bug
        paneTextArea1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
// définition des styles
//        StyleContext okay = StyleContext.getDefaultStyleContext();
//        Style defaut = okay.getStyle(StyleContext.DEFAULT_STYLE);
//        Style style1 = panneau.addStyle("style1", defaut);
//        StyleConstants.setFontFamily(style1, "Comic MS");
//        StyledDocument sDoc = (StyledDocument) panneau.getDocument();
        panneau.setBackground(pan2.getBackground());
//        panneau.setSize(1000,1000);
//        try {
//            int pos=0;
//            sDoc.insertString(pos, affichage, style1);
//            
//        } catch (BadLocationException l) {
//        }
        pan2.add(paneTextArea1);
        //pan2.add(panneau);

        this.setVisible(true);
    }

}
