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

/**
 * Classe GRAPHIQUE qui hérite de JFrame et implémente ActionListener. Ouvre la
 * fenêtre principale de la gestion du personnel de l'hopital.
 *
 * @author Manu
 */
public class Graphique extends JFrame implements ActionListener {

    ///JLABEL
    private final JLabel question1, question2, question3, question4; ///Question dépendant de l'action : 1. Ajout 2. Supression 3. MAJ 4.Recherche
    private final JLabel code, nom, batiment, directeur; ///JLabel du formulaire de recherche Service
    private final JLabel code_service, no_chambre, surveillant, nb_lits; ///JLabel du formulaire de recherche Chambre
    private final JLabel numero, nom2, prenom, adresse, tel; ///JLabel du formulaire de recherche Employé
    private final JLabel numero2, specialité; ///JLabel du formulaire de recherche Docteur
    private final JLabel numero3, code_service2, rotation, salaire; ///JLabel du formulaire de recherche Infirmier
    private final JLabel numero4, nom3, prenom2, adresse2, tel2, mutuelle; ///JLabel du formulaire de recherche Malade
    private final JLabel no_malade, code_service3, no_chambre2, lit; ///JLabel du formulaire de recherche Hospitalisation
    private final JLabel no_docteur, no_malade2; ///JLabel du formulaire de recherche Soignage
    private final JLabel critères_de_recherche, modification; ///JLabel pour indiquer quels sont les JLabel à compléter

    ///JTEXTFIELD
    private final JTextField code_t, nom_t, batiment_t, directeur_t; ///JTextField du formulaire de recherche Service
    private final JTextField code_service_t, no_chambre_t, surveillant_t, nb_lits_t; ///JTextField du formulaire de recherche Chambre
    private final JTextField numero_t, nom2_t, prenom_t, adresse_t, tel_t; ///JTextField du formulaire de recherche Employé
    private final JTextField numero2_t, specialité_t; ///JTextField du formulaire de recherche Docteur
    private final JTextField numero3_t, code_service2_t, rotation_t, salaire_t; ///JTextField du formulaire de recherche Infirmier
    private final JTextField numero4_t, nom3_t, prenom2_t, adresse2_t, tel2_t, mutuelle_t; ///JTextField du formulaire de recherche Malade
    private final JTextField no_malade_t, code_service3_t, no_chambre2_t, lit_t; ///JTextField du formulaire de recherche Hospitalisation
    private final JTextField no_docteur_t, no_malade2_t; ///JTextField du formulaire de recherche Soignage
    ///Pour la modification, on a besoin d'un critère de recherche
    private final JTextField code_old, nom_old, batiment_old, directeur_old; ///JTextField du formulaire de recherche Service
    private final JTextField code_service_old, no_chambre_old, surveillant_old, nb_lits_old; ///JTextField du formulaire de recherche Chambre
    private final JTextField numero_old, nom2_old, prenom_old, adresse_old, tel_old; ///JTextField du formulaire de recherche Employé
    private final JTextField numero2_old, specialité_old; ///JTextField du formulaire de recherche Docteur
    private final JTextField numero3_old, code_service2_old, rotation_old, salaire_old; ///JTextField du formulaire de recherche Infirmier
    private final JTextField numero4_old, nom3_old, prenom2_old, adresse2_old, tel2_old, mutuelle_old; ///JTextField du formulaire de recherche Malade
    private final JTextField no_malade_old, code_service3_old, no_chambre2_old, lit_old; ///JTextField du formulaire de recherche Hospitalisation
    private final JTextField no_docteur_old, no_malade2_old; ///JTextField du formulaire de recherche Soignage

    ///JPANEL
    private final JPanel pan1;
    private final JPanel pan2;
    private final JPanel pan3;
    private final JPanel pan4;
    private final JPanel pan5;

    ///JBUTTON
    ///Boutons principaux de gauche (choix 1=ajout, choix 2=supression, choix3=MAJ, choix4=Recherche, Statistiques=JFreeChart
    private final JButton choix1;
    private final JButton choix2;
    private final JButton choix3;
    private final JButton choix4;
    private final JButton Statistiques;

    ///Boutons secondaires des menus secondaires
    //Pour les secteurs
    private final JButton Service1, Service2, Service3, Service4;
    private final JButton Chambre1, Chambre2, Chambre3, Chambre4;
    private final JButton Employé1, Employé2, Employé3, Employé4;
    private final JButton Docteur1, Docteur2, Docteur3, Docteur4;
    private final JButton Infirmier1, Infirmier2, Infirmier3, Infirmier4;
    private final JButton Malade1, Malade2, Malade3, Malade4;
    private final JButton Hospitalisation1, Hospitalisation2, Hospitalisation3, Hospitalisation4;
    private final JButton Soignage1, Soignage2, Soignage3, Soignage4;
    //Pour les actions
    private final JButton Rechercher_parametre_Service, Rechercher_parametre_Chambre, Rechercher_parametre_Employé, Rechercher_parametre_Docteur, Rechercher_parametre_Infirmier, Rechercher_parametre_Malade, Rechercher_parametre_Hospitalisation, Rechercher_parametre_Soignage;
    private final JButton Rechercher_tout_Service, Rechercher_tout_Chambre, Rechercher_tout_Employé, Rechercher_tout_Docteur, Rechercher_tout_Infirmier, Rechercher_tout_Malade, Rechercher_tout_Hospitalisation, Rechercher_tout_Soignage;
    private final JButton Ajouter_Service, Ajouter_Chambre, Ajouter_Employé, Ajouter_Docteur, Ajouter_Infirmier, Ajouter_Malade, Ajouter_Hospitalisation, Ajouter_Soignage;
    private final JButton Supprimer_Service, Supprimer_Chambre, Supprimer_Employé, Supprimer_Docteur, Supprimer_Infirmier, Supprimer_Malade, Supprimer_Hospitalisation, Supprimer_Soignage;
    private final JButton Modifier_Service, Modifier_Chambre, Modifier_Employé, Modifier_Docteur, Modifier_Infirmier, Modifier_Malade, Modifier_Hospitalisation, Modifier_Soignage;
    private final JButton Répartition_des_malades_par_chambre, Répartition_des_docteurs_par_service, Salaires;
    ///JSPLITPANE
    //Pour séparer l'écran des actions de gauche et l'affichage de droite
    private final JSplitPane split;

    ///DIMENSIONS (pour les boutons)
    private final Dimension d, e;

    ///STYLE (pour les écritures)
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
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(false); ///Redimensionnement impossible

        ///INITIALISATION DES JLABEL
        question1 = new JLabel("Dans quelle section souhaitez-vous ajouter ?");
        question2 = new JLabel("Dans quelle section souhaitez-vous supprimer ?");
        question3 = new JLabel("Dans quelle section souhaitez-vous mettre à jour une donnée ?");
        question4 = new JLabel("Dans quelle section souhaitez-vous rechercher ?");
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
        critères_de_recherche = new JLabel("Critère de recherche : ");
        modification = new JLabel("Modification : ");

        ///INITIALISATION DES JTEXTFIELD
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

        code_old = new JTextField(15);
        code_old.setText("lel");
        nom_old = new JTextField(15);
        batiment_old = new JTextField(15);
        directeur_old = new JTextField(15);
        code_service_old = new JTextField(15);
        no_chambre_old = new JTextField(15);
        surveillant_old = new JTextField(15);
        nb_lits_old = new JTextField(15);
        numero_old = new JTextField(15);
        nom2_old = new JTextField(15);
        prenom_old = new JTextField(15);
        adresse_old = new JTextField(15);
        tel_old = new JTextField(15);
        numero2_old = new JTextField(15);
        specialité_old = new JTextField(15);
        numero3_old = new JTextField(15);
        code_service2_old = new JTextField(15);
        rotation_old = new JTextField(15);
        salaire_old = new JTextField(15);
        numero4_old = new JTextField(15);
        nom3_old = new JTextField(15);
        prenom2_old = new JTextField(15);
        adresse2_old = new JTextField(15);
        tel2_old = new JTextField(15);
        mutuelle_old = new JTextField(15);
        no_malade_old = new JTextField(15);
        code_service3_old = new JTextField(15);
        no_chambre2_old = new JTextField(15);
        lit_old = new JTextField(15);
        no_docteur_old = new JTextField(15);
        no_malade2_old = new JTextField(15);

        ///INITIALISATION DES JPANEL + TAILLE
        pan1 = new JPanel();
        pan1.setSize(200, 600);
        pan2 = new JPanel();
        pan2.setSize(500, 500);
        pan3 = new JPanel();
        pan3.setSize(200, 200);
        pan4 = new JPanel();
        pan4.setSize(200, 200);
        pan5 = new JPanel();
        pan5.setSize(100, 100);

        ///INITIALISATION DES JBUTTON + AJOUT DES ECOUTEURS
        choix1 = new JButton("Ajout ");
        choix1.addActionListener(this);
        choix2 = new JButton("Supression");
        choix2.addActionListener(this);
        choix3 = new JButton("Mise a Jour");
        choix3.addActionListener(this);
        choix4 = new JButton("Recherche");
        choix4.addActionListener(this);
        Service1 = new JButton("Service");
        Service1.addActionListener(this);
        Chambre1 = new JButton("Chambre");
        Chambre1.addActionListener(this);
        Employé1 = new JButton("Employé");
        Employé1.addActionListener(this);
        Docteur1 = new JButton("Docteur");
        Docteur1.addActionListener(this);
        Infirmier1 = new JButton("Infirmier");
        Infirmier1.addActionListener(this);
        Malade1 = new JButton("Malade");
        Malade1.addActionListener(this);
        Hospitalisation1 = new JButton("Hospitalisation");
        Hospitalisation1.addActionListener(this);
        Soignage1 = new JButton("Soignage");
        Soignage1.addActionListener(this);
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
        Service3 = new JButton("Service");
        Service3.addActionListener(this);
        Chambre3 = new JButton("Chambre");
        Chambre3.addActionListener(this);
        Employé3 = new JButton("Employé");
        Employé3.addActionListener(this);
        Docteur3 = new JButton("Docteur");
        Docteur3.addActionListener(this);
        Infirmier3 = new JButton("Infirmier");
        Infirmier3.addActionListener(this);
        Malade3 = new JButton("Malade");
        Malade3.addActionListener(this);
        Hospitalisation3 = new JButton("Hospitalisation");
        Hospitalisation3.addActionListener(this);
        Soignage3 = new JButton("Soignage");
        Soignage3.addActionListener(this);
        Service4 = new JButton("Service");
        Service4.addActionListener(this);
        Chambre4 = new JButton("Chambre");
        Chambre4.addActionListener(this);
        Employé4 = new JButton("Employé");
        Employé4.addActionListener(this);
        Docteur4 = new JButton("Docteur");
        Docteur4.addActionListener(this);
        Infirmier4 = new JButton("Infirmier");
        Infirmier4.addActionListener(this);
        Malade4 = new JButton("Malade");
        Malade4.addActionListener(this);
        Hospitalisation4 = new JButton("Hospitalisation");
        Hospitalisation4.addActionListener(this);
        Soignage4 = new JButton("Soignage");
        Soignage4.addActionListener(this);
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
        Supprimer_Service = new JButton("Supprimer");
        Supprimer_Service.addActionListener(this);
        Supprimer_Chambre = new JButton("Supprimer");
        Supprimer_Chambre.addActionListener(this);
        Supprimer_Employé = new JButton("Supprimer");
        Supprimer_Employé.addActionListener(this);
        Supprimer_Docteur = new JButton("Supprimer");
        Supprimer_Docteur.addActionListener(this);
        Supprimer_Infirmier = new JButton("Supprimer");
        Supprimer_Infirmier.addActionListener(this);
        Supprimer_Malade = new JButton("Supprimer");
        Supprimer_Malade.addActionListener(this);
        Supprimer_Hospitalisation = new JButton("Supprimer");
        Supprimer_Hospitalisation.addActionListener(this);
        Supprimer_Soignage = new JButton("Supprimer");
        Supprimer_Soignage.addActionListener(this);
        Modifier_Service = new JButton("Modifier");
        Modifier_Service.addActionListener(this);
        Modifier_Chambre = new JButton("Modifier");
        Modifier_Chambre.addActionListener(this);
        Modifier_Employé = new JButton("Modifier");
        Modifier_Employé.addActionListener(this);
        Modifier_Docteur = new JButton("Modifier");
        Modifier_Docteur.addActionListener(this);
        Modifier_Infirmier = new JButton("Modifier");
        Modifier_Infirmier.addActionListener(this);
        Modifier_Malade = new JButton("Modifier");
        Modifier_Malade.addActionListener(this);
        Modifier_Hospitalisation = new JButton("Modifier");
        Modifier_Hospitalisation.addActionListener(this);
        Modifier_Soignage = new JButton("Modifier");
        Modifier_Soignage.addActionListener(this);
        Statistiques = new JButton("Statistiques");
        Statistiques.addActionListener(this);
        Répartition_des_malades_par_chambre = new JButton("Répartition des malades par chambre du premier étage");
        Répartition_des_malades_par_chambre.addActionListener(this);
        Répartition_des_docteurs_par_service = new JButton("Répartiton des docteurs par service");
        Répartition_des_docteurs_par_service.addActionListener(this);
        Salaires = new JButton("Moyenne des salaires des infirmiers selon l'horaire");
        Salaires.addActionListener(this);

        ///INITIALISATION DES DIMENSIONS DES JBUTTONS
        d = new Dimension(190, 30);
        e = new Dimension(500, 40);

        ///INITIALISATION DU JSPLITPANE
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan1, pan2); ///Pour séparer les deux panneaux 
        split.setDividerSize(10);  ///Taille du JSplitPane
        split.setDividerLocation(200); ///Position du JSplitPane

        this.setTitle("Gestion informatique d'un centre hospitalier");
        this.setVisible(true);   ///Rend la fenêtre visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Connexion C;
        try {
            C = new Connexion("hopital", "root", "1234"); ///Connexion à la base de données grâce à la classe Connexion.java
            if (e.getSource() == choix1) { ///=AJOUT               
                ChoixSecteur(1);
            }
            if (e.getSource() == choix2) { ///=SUPRESSION
                ChoixSecteur(2);
            }
            if (e.getSource() == choix3) { ///=MISE A JOUR                
                ChoixSecteur(3);
            }
            if (e.getSource() == choix4) { ///=RECHERCHER
                ChoixSecteur(4);
            }

            if (e.getSource() == Statistiques) { ///=JFREECHART
                Camembert();
            }
            
            if (e.getSource() == Répartition_des_malades_par_chambre) { ///=JFREECHART
                Graphes.chambreGraphe();                   
            }
            
            if (e.getSource() == Répartition_des_docteurs_par_service) { ///=JFREECHART
                Graphes.docteurGraphe();
            }
            
            if (e.getSource() == Salaires) { ///=JFREECHART
                Graphes.salaireGraphe();
            }

            ///////////////////////////////////////////////////
            if (e.getSource() == Service1) {
                FormulaireRecherche(1, 1);
            }
            if (e.getSource() == Chambre1) {
                FormulaireRecherche(2, 1);
            }
            if (e.getSource() == Employé1) {
                FormulaireRecherche(3, 1);
            }
            if (e.getSource() == Docteur1) {
                FormulaireRecherche(4, 1);
            }
            if (e.getSource() == Infirmier1) {
                FormulaireRecherche(5, 1);
            }
            if (e.getSource() == Malade1) {
                FormulaireRecherche(6, 1);
            }
            if (e.getSource() == Hospitalisation1) {
                FormulaireRecherche(7, 1);
            }
            if (e.getSource() == Soignage1) {
                FormulaireRecherche(8, 1);
            }
            /////////////////////////////////////////

            if (e.getSource() == Service2) {
                FormulaireRecherche(1, 2);
            }
            if (e.getSource() == Chambre2) {
                FormulaireRecherche(2, 2);
            }
            if (e.getSource() == Employé2) {
                FormulaireRecherche(3, 2);
            }
            if (e.getSource() == Docteur2) {
                FormulaireRecherche(4, 2);
            }
            if (e.getSource() == Infirmier2) {
                FormulaireRecherche(5, 2);
            }
            if (e.getSource() == Malade2) {
                FormulaireRecherche(6, 2);
            }
            if (e.getSource() == Hospitalisation2) {
                FormulaireRecherche(7, 2);
            }
            if (e.getSource() == Soignage2) {
                FormulaireRecherche(8, 2);
            }

            ////////////////////////////////////////////////
            if (e.getSource() == Service3) {
                FormulaireRecherche(1, 3);
            }
            if (e.getSource() == Chambre3) {
                FormulaireRecherche(2, 3);
            }
            if (e.getSource() == Employé3) {
                FormulaireRecherche(3, 3);
            }
            if (e.getSource() == Docteur3) {
                FormulaireRecherche(4, 3);
            }
            if (e.getSource() == Infirmier3) {
                FormulaireRecherche(5, 3);
            }
            if (e.getSource() == Malade3) {
                FormulaireRecherche(6, 3);
            }
            if (e.getSource() == Hospitalisation3) {
                FormulaireRecherche(7, 3);
            }
            if (e.getSource() == Soignage3) {
                FormulaireRecherche(8, 3);
            }

            /////////////////////////////////////////////
            if (e.getSource() == Service4) {
                FormulaireRecherche(1, 4);
            }
            if (e.getSource() == Chambre4) {
                FormulaireRecherche(2, 4);
            }
            if (e.getSource() == Employé4) {
                FormulaireRecherche(3, 4);
            }
            if (e.getSource() == Docteur4) {
                FormulaireRecherche(4, 4);
            }
            if (e.getSource() == Infirmier4) {
                FormulaireRecherche(5, 4);
            }
            if (e.getSource() == Malade4) {
                FormulaireRecherche(6, 4);
            }
            if (e.getSource() == Hospitalisation4) {
                FormulaireRecherche(7, 4);
            }
            if (e.getSource() == Soignage4) {
                FormulaireRecherche(8, 4);
            }

            //////////////////////////////////////////////////////
            if (e.getSource() == Ajouter_Service) {
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
                    ReqAjout.concatrequete("service", tab_colonnes1, tab_valeurs1);
                    System.out.println("" + ReqAjout.concatrequete("service", tab_colonnes1, tab_valeurs1));
                    C.executeUpdate(ReqAjout.concatrequete("service", tab_colonnes1, tab_valeurs1));
                }

            }

            if (e.getSource() == Ajouter_Chambre) {
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
                    ReqAjout.concatrequete("chambre", tab_colonnes2, tab_valeurs2);
                    System.out.println("" + ReqAjout.concatrequete("chambre", tab_colonnes2, tab_valeurs2));
                    C.executeUpdate(ReqAjout.concatrequete("chambre", tab_colonnes2, tab_valeurs2));

                }
            }

            if (e.getSource() == Ajouter_Employé) {
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
                    ReqAjout.concatrequete("employe", tab_colonnes3, tab_valeurs3);
                    C.executeUpdate(ReqAjout.concatrequete("employe", tab_colonnes3, tab_valeurs3));

                }
            }

            if (e.getSource() == Ajouter_Docteur) {
                String[] tab_valeurs4 = new String[2];
                String[] tab_colonnes4 = new String[2];
                if (numero2_t.getText().equals("") || specialité_t.getText().equals("")) {
                    System.out.println("Un de vos champs est vide");
                } else {
                    tab_valeurs4[0] = numero2_t.getText();
                    tab_valeurs4[1] = specialité_t.getText();
                    tab_colonnes4[0] = "numero";
                    tab_colonnes4[1] = "specialite";

                    ReqAjout.concatrequete("docteur", tab_colonnes4, tab_valeurs4);
                    C.executeUpdate(ReqAjout.concatrequete("docteur", tab_colonnes4, tab_valeurs4));

                }
            }

            if (e.getSource() == Ajouter_Infirmier) {
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
                    ReqAjout.concatrequete("infirmier", tab_colonnes5, tab_valeurs5);
                    C.executeUpdate(ReqAjout.concatrequete("infirmier", tab_colonnes5, tab_valeurs5));

                }
            }

            if (e.getSource() == Ajouter_Malade) {
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
                    ReqAjout.concatrequete("malade", tab_colonnes6, tab_valeurs6);
                    C.executeUpdate(ReqAjout.concatrequete("malade", tab_colonnes6, tab_valeurs6));

                }
            }

            if (e.getSource() == Ajouter_Hospitalisation) {
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
                    ReqAjout.concatrequete("hospitalisation", tab_colonnes7, tab_valeurs7);
                    C.executeUpdate(ReqAjout.concatrequete("hospitalisation", tab_colonnes7, tab_valeurs7));

                }
            }
            if (e.getSource() == Ajouter_Soignage) {
                String[] tab_valeurs8 = new String[2];
                String[] tab_colonnes8 = new String[2];
                if (no_docteur_t.getText().equals("") || no_malade2_t.getText().equals("")) {
                    System.out.println("Un de vos champs est vide");
                } else {
                    tab_valeurs8[0] = no_docteur_t.getText();
                    tab_valeurs8[1] = no_malade2_t.getText();
                    tab_colonnes8[0] = "no_docteur";
                    tab_colonnes8[1] = "no_malade";
                    ReqAjout.concatrequete("soigne", tab_colonnes8, tab_valeurs8);
                    C.executeUpdate(ReqAjout.concatrequete("soigne", tab_colonnes8, tab_valeurs8));
                }

            }

            if (e.getSource() == Supprimer_Service) {
                String[] tab_valeurs1 = new String[4];
                String[] tab_colonnes1 = new String[4];

                if (code_t.getText().equals("")) {
                    tab_valeurs1[0] = "";
                } else {
                    tab_valeurs1[0] = code_t.getText();
                }
                if (nom_t.getText().equals("")) {
                    tab_valeurs1[1] = "";
                } else {
                    tab_valeurs1[1] = nom_t.getText();
                }

                if (batiment_t.getText().equals("")) {
                    tab_valeurs1[2] = "";
                } else {
                    tab_valeurs1[2] = batiment_t.getText();
                }

                if (directeur_t.getText().equals("")) {
                    tab_valeurs1[3] = "";
                } else {
                    tab_valeurs1[3] = directeur_t.getText();
                }
                tab_colonnes1[0] = "code";
                tab_colonnes1[1] = "nom";
                tab_colonnes1[2] = "batiment";
                tab_colonnes1[3] = "directeur";
                System.out.println("" + ReqSupprimer.concatrequete("service", tab_colonnes1, tab_valeurs1));
                C.executeUpdate(ReqSupprimer.concatrequete("service", tab_colonnes1, tab_valeurs1));

            }

            if (e.getSource() == Supprimer_Chambre) {
                String[] tab_valeurs2 = new String[4];
                String[] tab_colonnes2 = new String[4];
                if (code_service_t.getText().equals("")) {
                    tab_valeurs2[0] = "";
                } else {
                    tab_valeurs2[0] = code_service_t.getText();
                }
                if (no_chambre_t.getText().equals("")) {
                    tab_valeurs2[1] = "";
                } else {
                    tab_valeurs2[1] = no_chambre_t.getText();
                }

                if (surveillant_t.getText().equals("")) {
                    tab_valeurs2[2] = "";
                } else {
                    tab_valeurs2[2] = surveillant_t.getText();
                }

                if (nb_lits_t.getText().equals("")) {
                    tab_valeurs2[3] = "";
                } else {
                    tab_valeurs2[3] = nb_lits_t.getText();
                }
                tab_colonnes2[0] = "code_service";
                tab_colonnes2[1] = "no_chambre";
                tab_colonnes2[2] = "surveillant";
                tab_colonnes2[3] = "nb_lits";
                System.out.println("" + ReqSupprimer.concatrequete("chambre", tab_colonnes2, tab_valeurs2));
                C.executeUpdate(ReqSupprimer.concatrequete("chambre", tab_colonnes2, tab_valeurs2));

            }

            if (e.getSource() == Supprimer_Employé) {
                String[] tab_valeurs3 = new String[5];
                String[] tab_colonnes3 = new String[5];
                if (numero_t.getText().equals("")) {
                    tab_valeurs3[0] = "";
                } else {
                    tab_valeurs3[0] = numero_t.getText();
                }
                if (nom2_t.getText().equals("")) {
                    tab_valeurs3[1] = "";
                } else {
                    tab_valeurs3[1] = nom2_t.getText();
                }

                if (prenom_t.getText().equals("")) {
                    tab_valeurs3[2] = "";
                } else {
                    tab_valeurs3[2] = prenom_t.getText();
                }

                if (adresse_t.getText().equals("")) {
                    tab_valeurs3[3] = "";
                } else {
                    tab_valeurs3[3] = adresse_t.getText();
                }
                if (tel_t.getText().equals("")) {
                    tab_valeurs3[4] = "";
                } else {
                    tab_valeurs3[4] = tel_t.getText();
                }

                tab_colonnes3[0] = "numero";
                tab_colonnes3[1] = "nom";
                tab_colonnes3[2] = "prenom";
                tab_colonnes3[3] = "adresse";
                tab_colonnes3[4] = "tel";
                C.executeUpdate(ReqSupprimer.concatrequete("employe", tab_colonnes3, tab_valeurs3));

            }

            if (e.getSource() == Supprimer_Docteur) {
                String[] tab_valeurs4 = new String[2];
                String[] tab_colonnes4 = new String[2];
                if (numero2_t.getText().equals("")) {
                    tab_valeurs4[0] = "";
                } else {
                    tab_valeurs4[0] = numero2_t.getText();
                }
                if (specialité_t.getText().equals("")) {
                    tab_valeurs4[1] = "";
                } else {
                    tab_valeurs4[1] = specialité_t.getText();
                }
                tab_colonnes4[0] = "numero";
                tab_colonnes4[1] = "specialite";

                C.executeUpdate(ReqSupprimer.concatrequete("docteur", tab_colonnes4, tab_valeurs4));

            }

            if (e.getSource() == Supprimer_Infirmier) {
                String[] tab_valeurs5 = new String[4];
                String[] tab_colonnes5 = new String[4];
                if (numero3_t.getText().equals("")) {
                    tab_valeurs5[0] = "";
                } else {
                    tab_valeurs5[0] = numero3_t.getText();
                }
                if (code_service2_t.getText().equals("")) {
                    tab_valeurs5[1] = "";
                } else {
                    tab_valeurs5[1] = code_service2_t.getText();
                }
                if (rotation_t.getText().equals("")) {
                    tab_valeurs5[2] = "";
                } else {
                    tab_valeurs5[2] = rotation_t.getText();
                }
                if (salaire_t.getText().equals("")) {
                    tab_valeurs5[3] = "";
                } else {
                    tab_valeurs5[3] = salaire_t.getText();
                }
                tab_colonnes5[0] = "numero";
                tab_colonnes5[1] = "code_service";
                tab_colonnes5[2] = "rotation";
                tab_colonnes5[3] = "salaire";
                C.executeUpdate(ReqSupprimer.concatrequete("infirmier", tab_colonnes5, tab_valeurs5));

            }

            if (e.getSource() == Supprimer_Malade) {
                String[] tab_valeurs6 = new String[6];
                String[] tab_colonnes6 = new String[6];
                if (numero4_t.getText().equals("")) {
                    tab_valeurs6[0] = "";
                } else {
                    tab_valeurs6[0] = numero4_t.getText();
                }
                if (nom3_t.getText().equals("")) {
                    tab_valeurs6[1] = "";
                } else {
                    tab_valeurs6[1] = nom3_t.getText();
                }
                if (prenom2_t.getText().equals("")) {
                    tab_valeurs6[2] = "";
                } else {
                    tab_valeurs6[2] = prenom2_t.getText();
                }
                if (adresse2_t.getText().equals("")) {
                    tab_valeurs6[3] = "";
                } else {
                    tab_valeurs6[3] = adresse2_t.getText();
                }
                if (tel2_t.getText().equals("")) {
                    tab_valeurs6[4] = "";
                } else {
                    tab_valeurs6[4] = tel2_t.getText();
                }
                if (mutuelle_t.getText().equals("")) {
                    tab_valeurs6[5] = "";
                } else {
                    tab_valeurs6[5] = mutuelle_t.getText();
                }

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
                C.executeUpdate(ReqSupprimer.concatrequete("malade", tab_colonnes6, tab_valeurs6));

            }

            if (e.getSource() == Supprimer_Hospitalisation) {
                String[] tab_valeurs7 = new String[4];
                String[] tab_colonnes7 = new String[4];
                if (no_malade_t.getText().equals("")) {
                    tab_valeurs7[0] = "";
                } else {
                    tab_valeurs7[0] = no_malade_t.getText();
                }
                if (code_service3_t.getText().equals("")) {
                    tab_valeurs7[1] = "";
                } else {
                    tab_valeurs7[1] = code_service3_t.getText();
                }
                if (no_chambre2_t.getText().equals("")) {
                    tab_valeurs7[2] = "";
                } else {
                    tab_valeurs7[2] = no_chambre2_t.getText();
                }
                if (lit_t.getText().equals("")) {
                    tab_valeurs7[3] = "";
                } else {
                    tab_valeurs7[3] = lit_t.getText();
                }
                tab_colonnes7[0] = "no_malade";
                tab_colonnes7[1] = "code_service";
                tab_colonnes7[2] = "no_chambre";
                tab_colonnes7[3] = "lit";
                C.executeUpdate(ReqSupprimer.concatrequete("hospitalisation", tab_colonnes7, tab_valeurs7));

            }
            if (e.getSource() == Supprimer_Soignage) {
                String[] tab_valeurs8 = new String[2];
                String[] tab_colonnes8 = new String[2];
                if (no_docteur_t.getText().equals("")) {
                    tab_valeurs8[0] = "";
                } else {
                    tab_valeurs8[0] = no_docteur_t.getText();
                }
                if (no_malade2_t.getText().equals("")) {
                    tab_valeurs8[1] = "";
                } else {
                    tab_valeurs8[1] = no_malade2_t.getText();
                }
                tab_colonnes8[0] = "no_docteur";
                tab_colonnes8[1] = "no_malade";
                C.executeUpdate(ReqSupprimer.concatrequete("soigne", tab_colonnes8, tab_valeurs8));

            }

            if (e.getSource() == Modifier_Service) {
                String[] tab_valeurs1 = new String[4];
                String[] tab_colonnes1 = new String[4];
                String[] tab_valeurs1_old = new String[4];
                String modification = null;
                String colonne = null;
                if (code_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = code_old.getText();
                }
                if (nom_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = nom_old.getText();
                }
                if (batiment_old.getText().equals("")) {
                    tab_valeurs1_old[2] = "";
                } else {
                    tab_valeurs1_old[2] = batiment_old.getText();
                }
                if (directeur_old.getText().equals("")) {
                    tab_valeurs1_old[3] = "";
                } else {
                    tab_valeurs1_old[3] = directeur_old.getText();
                }

                if (!code_t.getText().equals("")) {
                    modification = code_t.getText();
                    colonne = "code";
                } else if (!nom_t.getText().equals("")) {
                    modification = nom_t.getText();
                    colonne = "nom";
                } else if (!batiment_t.getText().equals("")) {
                    modification = batiment_t.getText();
                    colonne = "batiment";
                } else if (!directeur_t.getText().equals("")) {
                    modification = directeur_t.getText();
                    colonne = "directeur";
                } else {
                    modification = "";
                    colonne = "";
                }
                tab_colonnes1[0] = "code";
                tab_colonnes1[1] = "nom";
                tab_colonnes1[2] = "batiment";
                tab_colonnes1[3] = "directeur";
                System.out.println("" + ReqUpdate.concatrequete("service", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("service", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }
            //code_service_t, no_chambre_t, surveillant_t, nb_lits_t
            if (e.getSource() == Modifier_Chambre) {
                String[] tab_valeurs1 = new String[4];
                String[] tab_colonnes1 = new String[4];
                String[] tab_valeurs1_old = new String[4];
                String modification = null;
                String colonne = null;
                if (code_service_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = code_service_old.getText();
                }
                if (no_chambre_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = no_chambre_old.getText();
                }
                if (surveillant_old.getText().equals("")) {
                    tab_valeurs1_old[2] = "";
                } else {
                    tab_valeurs1_old[2] = surveillant_old.getText();
                }
                if (nb_lits_old.getText().equals("")) {
                    tab_valeurs1_old[3] = "";
                } else {
                    tab_valeurs1_old[3] = nb_lits_old.getText();
                }

                if (!code_service_t.getText().equals("")) {
                    modification = code_service_t.getText();
                    colonne = "code_service";
                } else if (!no_chambre_t.getText().equals("")) {
                    modification = no_chambre_t.getText();
                    colonne = "no_chambre";
                } else if (!surveillant_t.getText().equals("")) {
                    modification = surveillant_t.getText();
                    colonne = "surveillant";
                } else if (!nb_lits_t.getText().equals("")) {
                    modification = nb_lits_t.getText();
                    colonne = "nb_lits";
                } else {
                    System.out.println("Vous n'avez pas rempli le champ de modification");
                }
                tab_colonnes1[0] = "code_service";
                tab_colonnes1[1] = "no_chambre";
                tab_colonnes1[2] = "surveillant";
                tab_colonnes1[3] = "nb_lits";
                System.out.println("" + ReqUpdate.concatrequete("chambre", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("chambre", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }

            if (e.getSource() == Modifier_Employé) {
                String[] tab_valeurs1 = new String[5];
                String[] tab_colonnes1 = new String[5];
                String[] tab_valeurs1_old = new String[5];
                String modification = null;
                String colonne = null;
                if (numero_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = numero_old.getText();
                }
                if (nom2_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = nom2_old.getText();
                }
                if (prenom_old.getText().equals("")) {
                    tab_valeurs1_old[2] = "";
                } else {
                    tab_valeurs1_old[2] = prenom_old.getText();
                }
                if (adresse_old.getText().equals("")) {
                    tab_valeurs1_old[3] = "";
                } else {
                    tab_valeurs1_old[3] = adresse_old.getText();
                }
                if (tel_old.getText().equals("")) {
                    tab_valeurs1_old[4] = "";
                } else {
                    tab_valeurs1_old[4] = tel_old.getText();
                }

                if (!numero_t.getText().equals("")) {
                    modification = numero_t.getText();
                    colonne = "numero";
                } else if (!nom2_t.getText().equals("")) {
                    modification = nom2_t.getText();
                    colonne = "nom";
                } else if (!prenom_t.getText().equals("")) {
                    modification = prenom_t.getText();
                    colonne = "prenom";
                } else if (!adresse_t.getText().equals("")) {
                    modification = adresse_t.getText();
                    colonne = "adresse";
                } else if (!tel_t.getText().equals("")) {
                    modification = tel_t.getText();
                    colonne = "tel";
                } else {
                    System.out.println("Vous n'avez pas rempli le champ de modification");
                }
                tab_colonnes1[0] = "numero";
                tab_colonnes1[1] = "nom";
                tab_colonnes1[2] = "prenom";
                tab_colonnes1[3] = "adresse";
                tab_colonnes1[4] = "tel";
                System.out.println("" + ReqUpdate.concatrequete("employe", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("employe", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }

            if (e.getSource() == Modifier_Docteur) {
                String[] tab_valeurs1 = new String[2];
                String[] tab_colonnes1 = new String[2];
                String[] tab_valeurs1_old = new String[2];
                String modification = null;
                String colonne = null;
                if (numero2_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = numero2_old.getText();
                }
                if (specialité_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = specialité_old.getText();
                }

                if (!numero2_t.getText().equals("")) {
                    modification = numero2_t.getText();
                    colonne = "numero";
                } else if (!specialité_t.getText().equals("")) {
                    modification = specialité_t.getText();
                    colonne = "specialite";
                } else {
                    System.out.println("Vous n'avez pas rempli le champ de modification");
                }
                tab_colonnes1[0] = "numero";
                tab_colonnes1[1] = "specialite";

                System.out.println("" + ReqUpdate.concatrequete("docteur", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("docteur", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }

            if (e.getSource() == Modifier_Infirmier) {
                String[] tab_valeurs1 = new String[4];
                String[] tab_colonnes1 = new String[4];
                String[] tab_valeurs1_old = new String[4];
                String modification = null;
                String colonne = null;
                if (numero3_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = numero3_old.getText();
                }
                if (code_service2_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = code_service2_old.getText();
                }
                if (rotation_old.getText().equals("")) {
                    tab_valeurs1_old[2] = "";
                } else {
                    tab_valeurs1_old[2] = rotation_old.getText();
                }
                if (salaire_old.getText().equals("")) {
                    tab_valeurs1_old[3] = "";
                } else {
                    tab_valeurs1_old[3] = salaire_old.getText();
                }

                if (!numero3_t.getText().equals("")) {
                    modification = numero3_t.getText();
                    colonne = "numero";
                } else if (!code_service2_t.getText().equals("")) {
                    modification = code_service2_t.getText();
                    colonne = "code_service";
                } else if (!rotation_t.getText().equals("")) {
                    modification = rotation_t.getText();
                    colonne = "rotation";
                } else if (!salaire_t.getText().equals("")) {
                    modification = salaire_t.getText();
                    colonne = "salaire";
                } else {
                    System.out.println("Vous n'avez pas rempli le champ de modification");
                }
                tab_colonnes1[0] = "numero";
                tab_colonnes1[1] = "code_service";
                tab_colonnes1[2] = "rotation";
                tab_colonnes1[3] = "salaire";

                System.out.println("" + ReqUpdate.concatrequete("infirmier", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("infirmier", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }

            if (e.getSource() == Modifier_Malade) {
                String[] tab_valeurs1 = new String[6];
                String[] tab_colonnes1 = new String[6];
                String[] tab_valeurs1_old = new String[6];
                String modification = null;
                String colonne = null;
                if (numero4_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = numero4_old.getText();
                }
                if (nom3_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = nom3_old.getText();
                }
                if (prenom2_old.getText().equals("")) {
                    tab_valeurs1_old[2] = "";
                } else {
                    tab_valeurs1_old[2] = prenom2_old.getText();
                }
                if (adresse2_old.getText().equals("")) {
                    tab_valeurs1_old[3] = "";
                } else {
                    tab_valeurs1_old[3] = adresse2_old.getText();
                }
                if (tel2_old.getText().equals("")) {
                    tab_valeurs1_old[4] = "";
                } else {
                    tab_valeurs1_old[4] = tel2_old.getText();
                }
                if (mutuelle_old.getText().equals("")) {
                    tab_valeurs1_old[5] = "";
                } else {
                    tab_valeurs1_old[5] = mutuelle_old.getText();
                }

                if (!numero4_t.getText().equals("")) {
                    modification = numero4_t.getText();
                    colonne = "numero";
                } else if (!nom3_t.getText().equals("")) {
                    modification = nom3_t.getText();
                    colonne = "nom";
                } else if (!prenom2_t.getText().equals("")) {
                    modification = prenom2_t.getText();
                    colonne = "prenom";
                } else if (!adresse2_t.getText().equals("")) {
                    modification = adresse2_t.getText();
                    colonne = "adresse";
                } else if (!tel2_t.getText().equals("")) {
                    modification = tel2_t.getText();
                    colonne = "tel";
                } else if (!mutuelle_t.getText().equals("")) {
                    modification = mutuelle_t.getText();
                    colonne = "mutuelle";
                } else {
                    System.out.println("Vous n'avez pas rempli le champ de modification");
                }
                tab_colonnes1[0] = "numero";
                tab_colonnes1[1] = "nom";
                tab_colonnes1[2] = "prenom";
                tab_colonnes1[3] = "adresse";
                tab_colonnes1[4] = "tel";
                tab_colonnes1[5] = "mutuelle";

                System.out.println("" + ReqUpdate.concatrequete("malade", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("malade", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }

            if (e.getSource() == Modifier_Hospitalisation) {
                String[] tab_valeurs1 = new String[4];
                String[] tab_colonnes1 = new String[4];
                String[] tab_valeurs1_old = new String[4];
                String modification = null;
                String colonne = null;
                if (no_malade_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = no_malade_old.getText();
                }
                if (code_service3_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = code_service3_old.getText();
                }
                if (no_chambre2_old.getText().equals("")) {
                    tab_valeurs1_old[2] = "";
                } else {
                    tab_valeurs1_old[2] = no_chambre2_old.getText();
                }
                if (lit_old.getText().equals("")) {
                    tab_valeurs1_old[3] = "";
                } else {
                    tab_valeurs1_old[3] = lit_old.getText();
                }

                if (!no_malade_t.getText().equals("")) {
                    modification = no_malade_t.getText();
                    colonne = "no_malade";
                } else if (!code_service3_t.getText().equals("")) {
                    modification = code_service3_t.getText();
                    colonne = "code_service";
                } else if (!no_chambre2_t.getText().equals("")) {
                    modification = no_chambre2_t.getText();
                    colonne = "no_chambre";
                } else if (!lit_t.getText().equals("")) {
                    modification = lit_t.getText();
                    colonne = "lit";
                } else {
                    System.out.println("Vous n'avez pas rempli le champ de modification");
                }
                tab_colonnes1[0] = "no_malade";
                tab_colonnes1[1] = "code_service";
                tab_colonnes1[2] = "no_chambre";
                tab_colonnes1[3] = "lit";

                System.out.println("" + ReqUpdate.concatrequete("hospitalisation", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("hospitalisation", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }

            if (e.getSource() == Modifier_Soignage) {
                String[] tab_valeurs1 = new String[2];
                String[] tab_colonnes1 = new String[2];
                String[] tab_valeurs1_old = new String[2];
                String modification = null;
                String colonne = null;
                if (no_docteur_old.getText().equals("")) {
                    tab_valeurs1_old[0] = "";
                } else {
                    tab_valeurs1_old[0] = no_docteur_old.getText();
                }
                if (no_malade2_old.getText().equals("")) {
                    tab_valeurs1_old[1] = "";
                } else {
                    tab_valeurs1_old[1] = no_malade2_old.getText();
                }

                if (!no_docteur_t.getText().equals("")) {
                    modification = no_docteur_t.getText();
                    colonne = "no_docteur";
                } else if (!no_malade2_t.getText().equals("")) {
                    modification = no_malade2_t.getText();
                    colonne = "no_malade";
                } else {
                    System.out.println("Vous n'avez pas rempli le champ de modification");
                }
                tab_colonnes1[0] = "no_docteur";
                tab_colonnes1[1] = "no_malade";

                System.out.println("" + ReqUpdate.concatrequete("soigne", colonne, tab_colonnes1, modification, tab_valeurs1_old));
                C.executeUpdate(ReqUpdate.concatrequete("soigne", colonne, tab_colonnes1, modification, tab_valeurs1_old));

            }

            if (e.getSource() == Rechercher_tout_Service) {
                String[] tab_colonnes1 = new String[4];
                tab_colonnes1[0] = "code";
                tab_colonnes1[1] = "nom";
                tab_colonnes1[2] = "batiment";
                tab_colonnes1[3] = "directeur";

                String affichage = "";
                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("service", tab_colonnes1));
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);
            }

            if (e.getSource() == Rechercher_tout_Chambre) {
                String[] tab_colonnes2 = new String[4];
                tab_colonnes2[0] = "code_service";
                tab_colonnes2[1] = "no_chambre";
                tab_colonnes2[2] = "surveillant";
                tab_colonnes2[3] = "nb_lits";

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("chambre", tab_colonnes2));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_tout_Employé) {
                String[] tab_colonnes3 = new String[5];
                tab_colonnes3[0] = "numero";
                tab_colonnes3[1] = "nom";
                tab_colonnes3[2] = "prenom";
                tab_colonnes3[3] = "adresse";
                tab_colonnes3[4] = "tel";

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("employe", tab_colonnes3));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_tout_Docteur) {
                String[] tab_colonnes4 = new String[2];
                tab_colonnes4[0] = "numero";
                tab_colonnes4[1] = "specialite";

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("docteur", tab_colonnes4));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_tout_Infirmier) {
                String[] tab_colonnes5 = new String[4];
                tab_colonnes5[0] = "numero";
                tab_colonnes5[1] = "code_service";
                tab_colonnes5[2] = "rotation";
                tab_colonnes5[3] = "salaire";

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("infirmier", tab_colonnes5));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_tout_Malade) {
                String[] tab_colonnes6 = new String[6];
                tab_colonnes6[0] = "numero";
                tab_colonnes6[1] = "nom";
                tab_colonnes6[2] = "prenom";
                tab_colonnes6[3] = "adresse";
                tab_colonnes6[4] = "tel";
                tab_colonnes6[5] = "mutuelle";

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("malade", tab_colonnes6));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_tout_Hospitalisation) {
                String[] tab_colonnes7 = new String[4];
                tab_colonnes7[0] = "no_malade";
                tab_colonnes7[1] = "code_service";
                tab_colonnes7[2] = "no_chambre";
                tab_colonnes7[3] = "lit";

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("hospitalisation", tab_colonnes7));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_tout_Soignage) {
                String[] tab_colonnes8 = new String[2];
                tab_colonnes8[0] = "no_docteur";
                tab_colonnes8[1] = "no_malade";

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(ReqLectureTable.concatrequete("soigne", tab_colonnes8));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Service) {
                String[] tab_colonnes1 = new String[4];
                String[] tab_valeurs1 = new String[4];
                if (code_t.getText().equals("")) {
                    tab_valeurs1[0] = "";
                } else {
                    tab_valeurs1[0] = code_t.getText();
                }
                if (nom_t.getText().equals("")) {
                    tab_valeurs1[1] = "";
                } else {
                    tab_valeurs1[1] = nom_t.getText();
                }

                if (batiment_t.getText().equals("")) {
                    tab_valeurs1[2] = "";
                } else {
                    tab_valeurs1[2] = batiment_t.getText();
                }

                if (directeur_t.getText().equals("")) {
                    tab_valeurs1[3] = "";
                } else {
                    tab_valeurs1[3] = directeur_t.getText();
                }

                tab_colonnes1[0] = "code";
                tab_colonnes1[1] = "nom";
                tab_colonnes1[2] = "batiment";
                tab_colonnes1[3] = "directeur";
                Requetes requete = new Requetes(tab_valeurs1, tab_valeurs1.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs1, "service", tab_colonnes1));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Chambre) {
                String[] tab_valeurs2 = new String[4];
                String[] tab_colonnes2 = new String[4];
                if (code_service_t.getText().equals("")) {
                    tab_valeurs2[0] = "";
                } else {
                    tab_valeurs2[0] = code_service_t.getText();
                }
                if (no_chambre_t.getText().equals("")) {
                    tab_valeurs2[1] = "";
                } else {
                    tab_valeurs2[1] = no_chambre_t.getText();
                }

                if (surveillant_t.getText().equals("")) {
                    tab_valeurs2[2] = "";
                } else {
                    tab_valeurs2[2] = surveillant_t.getText();
                }

                if (nb_lits_t.getText().equals("")) {
                    tab_valeurs2[3] = "";
                } else {
                    tab_valeurs2[3] = nb_lits_t.getText();
                }
                tab_colonnes2[0] = "code_service";
                tab_colonnes2[1] = "no_chambre";
                tab_colonnes2[2] = "surveillant";
                tab_colonnes2[3] = "nb_lits";
                Requetes requete = new Requetes(tab_valeurs2, tab_valeurs2.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs2, "chambre", tab_colonnes2));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Employé) {
                String[] tab_valeurs3 = new String[5];
                String[] tab_colonnes3 = new String[5];
                if (numero_t.getText().equals("")) {
                    tab_valeurs3[0] = "";
                } else {
                    tab_valeurs3[0] = numero_t.getText();
                }
                if (nom2_t.getText().equals("")) {
                    tab_valeurs3[1] = "";
                } else {
                    tab_valeurs3[1] = nom2_t.getText();
                }

                if (prenom_t.getText().equals("")) {
                    tab_valeurs3[2] = "";
                } else {
                    tab_valeurs3[2] = prenom_t.getText();
                }

                if (adresse_t.getText().equals("")) {
                    tab_valeurs3[3] = "";
                } else {
                    tab_valeurs3[3] = adresse_t.getText();
                }
                if (tel_t.getText().equals("")) {
                    tab_valeurs3[4] = "";
                } else {
                    tab_valeurs3[4] = tel_t.getText();
                }
                tab_colonnes3[0] = "numero";
                tab_colonnes3[1] = "nom";
                tab_colonnes3[2] = "prenom";
                tab_colonnes3[3] = "adresse";
                tab_colonnes3[4] = "tel";
                Requetes requete = new Requetes(tab_valeurs3, tab_valeurs3.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs3, "employe", tab_colonnes3));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Docteur) {
                String[] tab_valeurs4 = new String[2];
                String[] tab_colonnes4 = new String[2];
                if (numero2_t.getText().equals("")) {
                    tab_valeurs4[0] = "";
                } else {
                    tab_valeurs4[0] = numero2_t.getText();
                }
                if (specialité_t.getText().equals("")) {
                    tab_valeurs4[1] = "";
                } else {
                    tab_valeurs4[1] = specialité_t.getText();
                }
                tab_colonnes4[0] = "numero";
                tab_colonnes4[1] = "specialité";
                Requetes requete = new Requetes(tab_valeurs4, tab_valeurs4.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs4, "docteur", tab_colonnes4));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Infirmier) {
                String[] tab_valeurs5 = new String[4];
                String[] tab_colonnes5 = new String[4];
                if (numero3_t.getText().equals("")) {
                    tab_valeurs5[0] = "";
                } else {
                    tab_valeurs5[0] = numero3_t.getText();
                }
                if (code_service2_t.getText().equals("")) {
                    tab_valeurs5[1] = "";
                } else {
                    tab_valeurs5[1] = code_service2_t.getText();
                }
                if (rotation_t.getText().equals("")) {
                    tab_valeurs5[2] = "";
                } else {
                    tab_valeurs5[2] = rotation_t.getText();
                }
                if (salaire_t.getText().equals("")) {
                    tab_valeurs5[3] = "";
                } else {
                    tab_valeurs5[3] = salaire_t.getText();
                }
                tab_colonnes5[0] = "numero";
                tab_colonnes5[1] = "code_service";
                tab_colonnes5[2] = "rotation";
                tab_colonnes5[3] = "salaire";
                Requetes requete = new Requetes(tab_valeurs5, tab_valeurs5.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs5, "infirmier", tab_colonnes5));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Malade) {
                String[] tab_valeurs6 = new String[6];
                String[] tab_colonnes6 = new String[6];
                if (numero4_t.getText().equals("")) {
                    tab_valeurs6[0] = "";
                } else {
                    tab_valeurs6[0] = numero4_t.getText();
                }
                if (nom3_t.getText().equals("")) {
                    tab_valeurs6[1] = "";
                } else {
                    tab_valeurs6[1] = nom3_t.getText();
                }
                if (prenom2_t.getText().equals("")) {
                    tab_valeurs6[2] = "";
                } else {
                    tab_valeurs6[2] = prenom2_t.getText();
                }
                if (adresse2_t.getText().equals("")) {
                    tab_valeurs6[3] = "";
                } else {
                    tab_valeurs6[3] = adresse2_t.getText();
                }
                if (tel2_t.getText().equals("")) {
                    tab_valeurs6[4] = "";
                } else {
                    tab_valeurs6[4] = tel2_t.getText();
                }
                if (mutuelle_t.getText().equals("")) {
                    tab_valeurs6[5] = "";
                } else {
                    tab_valeurs6[5] = mutuelle_t.getText();
                }
                tab_colonnes6[0] = "numero";
                tab_colonnes6[1] = "nom";
                tab_colonnes6[2] = "prenom";
                tab_colonnes6[3] = "adresse";
                tab_colonnes6[4] = "tel";
                tab_colonnes6[5] = "mutuelle";
                Requetes requete = new Requetes(tab_valeurs6, tab_valeurs6.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs6, "malade", tab_colonnes6));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Hospitalisation) {
                String[] tab_valeurs7 = new String[4];
                String[] tab_colonnes7 = new String[4];
                if (no_malade_t.getText().equals("")) {
                    tab_valeurs7[0] = "";
                } else {
                    tab_valeurs7[0] = no_malade_t.getText();
                }
                if (code_service3_t.getText().equals("")) {
                    tab_valeurs7[1] = "";
                } else {
                    tab_valeurs7[1] = code_service3_t.getText();
                }
                if (no_chambre2_t.getText().equals("")) {
                    tab_valeurs7[2] = "";
                } else {
                    tab_valeurs7[2] = no_chambre2_t.getText();
                }
                if (lit_t.getText().equals("")) {
                    tab_valeurs7[3] = "";
                } else {
                    tab_valeurs7[3] = lit_t.getText();
                }
                tab_colonnes7[0] = "no_malade";
                tab_colonnes7[1] = "code_service";
                tab_colonnes7[2] = "no_chambre";
                tab_colonnes7[3] = "lit";
                Requetes requete = new Requetes(tab_valeurs7, tab_valeurs7.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs7, "hospitalisation", tab_colonnes7));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

            if (e.getSource() == Rechercher_parametre_Soignage) {
                String[] tab_valeurs8 = new String[2];
                String[] tab_colonnes8 = new String[2];
                if (no_docteur_t.getText().equals("")) {
                    tab_valeurs8[0] = "";
                } else {
                    tab_valeurs8[0] = no_docteur_t.getText();
                }
                if (no_malade2_t.getText().equals("")) {
                    tab_valeurs8[1] = "";
                } else {
                    tab_valeurs8[1] = no_malade2_t.getText();
                }
                tab_colonnes8[0] = "no_docteur";
                tab_colonnes8[1] = "no_malade";
                Requetes requete = new Requetes(tab_valeurs8, tab_valeurs8.length);

                ArrayList<String> liste = new ArrayList<String>();
                liste = C.remplirChampsRequete(requete.concatrequete(tab_valeurs8, "soigne", tab_colonnes8));
                String affichage = "";
                for (int i = 0; i < liste.size(); i++) {
                    affichage += "" + i + ". " + liste.get(i);
                }
                affiche(affichage);

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        Statistiques.setPreferredSize(d);

        pan1.add(choix1);
        pan1.add(choix2);
        pan1.add(choix3);
        pan1.add(choix4);
        pan1.add(Statistiques);
        this.setVisible(true);
    }

    /**
     * Méthode ChoixSecteur : Sert à afficher les différents secteurs pour
     * effectuer une action. Rend la fenêtre visible à la fin
     *
     * @param action en fonction de l'action demandée : 1 ajout, 2 supprimer, 3
     * mise à jour, 4 rechercher
     */
    public void ChoixSecteur(int action) {
        ///Effacement du panel 2 pour l'actualisation
        pan2.removeAll();
        pan2.repaint();
        ///Redessine le panel 2

        pan2.setLayout(new FlowLayout());
        font1 = new Font("Times New Roman", Font.BOLD, 18);
        question1.setFont(font1);
        question2.setFont(font1);
        question3.setFont(font1);
        question4.setFont(font1);
        Service1.setPreferredSize(e);
        Chambre1.setPreferredSize(e);
        Employé1.setPreferredSize(e);
        Docteur1.setPreferredSize(e);
        Infirmier1.setPreferredSize(e);
        Malade1.setPreferredSize(e);
        Hospitalisation1.setPreferredSize(e);
        Soignage1.setPreferredSize(e);
        Service2.setPreferredSize(e);
        Chambre2.setPreferredSize(e);
        Employé2.setPreferredSize(e);
        Docteur2.setPreferredSize(e);
        Infirmier2.setPreferredSize(e);
        Malade2.setPreferredSize(e);
        Hospitalisation2.setPreferredSize(e);
        Soignage2.setPreferredSize(e);
        Service3.setPreferredSize(e);
        Chambre3.setPreferredSize(e);
        Employé3.setPreferredSize(e);
        Docteur3.setPreferredSize(e);
        Infirmier3.setPreferredSize(e);
        Malade3.setPreferredSize(e);
        Hospitalisation3.setPreferredSize(e);
        Soignage3.setPreferredSize(e);
        Service4.setPreferredSize(e);
        Chambre4.setPreferredSize(e);
        Employé4.setPreferredSize(e);
        Docteur4.setPreferredSize(e);
        Infirmier4.setPreferredSize(e);
        Malade4.setPreferredSize(e);
        Hospitalisation4.setPreferredSize(e);
        Soignage4.setPreferredSize(e);

        switch (action) {
            case 1:
                pan2.add(question1);
                pan2.add(Service1);
                pan2.add(Chambre1);
                pan2.add(Employé1);
                pan2.add(Docteur1);
                pan2.add(Infirmier1);
                pan2.add(Malade1);
                pan2.add(Hospitalisation1);
                pan2.add(Soignage1);
                break;
            case 2:
                pan2.add(question2);
                pan2.add(Service2);
                pan2.add(Chambre2);
                pan2.add(Employé2);
                pan2.add(Docteur2);
                pan2.add(Infirmier2);
                pan2.add(Malade2);
                pan2.add(Hospitalisation2);
                pan2.add(Soignage2);
                break;
            case 3:
                pan2.add(question3);
                pan2.add(Service3);
                pan2.add(Chambre3);
                pan2.add(Employé3);
                pan2.add(Docteur3);
                pan2.add(Infirmier3);
                pan2.add(Malade3);
                pan2.add(Hospitalisation3);
                pan2.add(Soignage3);
                break;
            case 4:
                pan2.add(question4);
                pan2.add(Service4);
                pan2.add(Chambre4);
                pan2.add(Employé4);
                pan2.add(Docteur4);
                pan2.add(Infirmier4);
                pan2.add(Malade4);
                pan2.add(Hospitalisation4);
                pan2.add(Soignage4);
                break;
        }
        this.setVisible(true);
    }

    /**
     * Méthode formulaire de recherche : Efface le panel 2, 3, 4 et 5 puis les
     * redessine pour réactualiser la page. Efface aussi les JLabel pour les
     * réinitialiser
     *
     * @param choix qui est un int --> Détermine le service concerné (1 Service,
     * 2 Chambre, 3 Employé etc.)
     * @param action qui est un int --> Change selon l'action demandée (1 Ajout,
     * 2 Suppression, 3 Mise à jour, 4 Recherche)
     */
    public void FormulaireRecherche(int choix, int action) {

        pan2.removeAll();
        pan2.repaint();
        pan3.removeAll();
        pan3.repaint();
        pan4.removeAll();
        pan4.repaint();
        pan5.removeAll();
        pan5.repaint();

        ///Réinitialisation des JLabel
        code_t.setText("");
        nom_t.setText("");
        batiment_t.setText("");
        directeur_t.setText("");
        code_service_t.setText("");
        no_chambre_t.setText("");
        surveillant_t.setText("");
        nb_lits_t.setText("");
        numero_t.setText("");
        nom2_t.setText("");
        prenom_t.setText("");
        adresse_t.setText("");
        tel_t.setText("");
        numero2_t.setText("");
        specialité_t.setText("");
        numero3_t.setText("");
        code_service2_t.setText("");
        rotation_t.setText("");
        salaire_t.setText("");
        numero4_t.setText("");
        nom3_t.setText("");
        prenom2_t.setText("");
        adresse2_t.setText("");
        tel2_t.setText("");
        mutuelle_t.setText("");
        no_malade_t.setText("");
        code_service3_t.setText("");
        no_chambre2_t.setText("");
        lit_t.setText("");
        no_docteur_t.setText("");
        no_malade2_t.setText("");

        code_old.setText("");
        code_old.setText("lel");
        nom_old.setText("");
        batiment_old.setText("");
        directeur_old.setText("");
        code_service_old.setText("");
        no_chambre_old.setText("");
        surveillant_old.setText("");
        nb_lits_old.setText("");
        numero_old.setText("");
        nom2_old.setText("");
        prenom_old.setText("");
        adresse_old.setText("");
        tel_old.setText("");
        numero2_old.setText("");
        specialité_old.setText("");
        numero3_old.setText("");
        code_service2_old.setText("");
        rotation_old.setText("");
        salaire_old.setText("");
        numero4_old.setText("");
        nom3_old.setText("");
        prenom2_old.setText("");
        adresse2_old.setText("");
        tel2_old.setText("");
        mutuelle_old.setText("");
        no_malade_old.setText("");
        code_service3_old.setText("");
        no_chambre2_old.setText("");
        lit_old.setText("");
        no_docteur_old.setText("");
        no_malade2_old.setText("");

        pan2.setLayout(new FlowLayout());
        pan2.add(pan3);
        pan2.add(pan4);
        pan2.add(pan5);
        pan3.setLayout(new BoxLayout(pan3, BoxLayout.PAGE_AXIS));
        pan4.setLayout(new BoxLayout(pan4, BoxLayout.PAGE_AXIS));
        pan5.setLayout(new BoxLayout(pan5, BoxLayout.PAGE_AXIS));
        font2 = new Font("Times New Roman", Font.BOLD, 16);
        critères_de_recherche.setFont(font2);
        modification.setFont(font2);

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
                if (action == 1) {
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
                if (action == 2) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(code_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(batiment_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(directeur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Supprimer_Service);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 20)));
                    pan4.add(critères_de_recherche);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(batiment_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(directeur_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Service);
                    pan5.add(modification);
                    pan5.add(Box.createRigidArea(new Dimension(0, 5)));
                    pan5.add(code_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(nom_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(batiment_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(directeur_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
//                    pan5.add(Modifier_Service);
                }
                if (action == 4) {
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
                if (action == 1) {
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
                if (action == 2) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(code_service_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(surveillant_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nb_lits_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Supprimer_Chambre);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 20)));
                    pan4.add(critères_de_recherche);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(surveillant_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nb_lits_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Chambre);

                    pan5.add(Box.createRigidArea(new Dimension(0, 24)));
                    pan5.add(code_service_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(no_chambre_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(surveillant_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(nb_lits_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                if (action == 4) {
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
                if (action == 1) {
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
                if (action == 2) {
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
                    pan4.add(Supprimer_Employé);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(prenom_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(adresse_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(tel_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Employé);
                    pan5.add(Box.createRigidArea(new Dimension(0, 14)));
                    pan5.add(numero_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(nom2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(prenom_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(adresse_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(tel_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                if (action == 4) {
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
                }

                break;

            case 4:
                numero2.setFont(font2);
                specialité.setFont(font2);
                pan3.add(numero2);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(specialité);
                if (action == 1) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(specialité_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Docteur);
                }
                if (action == 2) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(specialité_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Supprimer_Docteur);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(specialité_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Docteur);
                    pan5.add(Box.createRigidArea(new Dimension(0, 14)));
                    pan5.add(numero2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(specialité_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));

                }
                if (action == 4) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(numero2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(specialité_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Docteur);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Docteur);
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
                if (action == 1) {
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
                if (action == 2) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(rotation_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(salaire_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Supprimer_Infirmier);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero3_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(rotation_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(salaire_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Infirmier);
                    pan5.add(Box.createRigidArea(new Dimension(0, 14)));
                    pan5.add(numero3_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(code_service2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(rotation_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(salaire_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                if (action == 4) {
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
                if (action == 1) {
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
                if (action == 2) {
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
                    pan4.add(Supprimer_Malade);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(numero4_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(nom3_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(prenom2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(adresse2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(tel2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(mutuelle_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Malade);
                    pan5.add(Box.createRigidArea(new Dimension(0, 14)));
                    pan5.add(numero4_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(nom3_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(prenom2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(adresse2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(tel2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(mutuelle_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                }
                if (action == 4) {
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
                if (action == 1) {
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
                if (action == 2) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(no_malade_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service3_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(lit_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Supprimer_Hospitalisation);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(no_malade_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(code_service3_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_chambre2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(lit_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Hospitalisation);
                    pan5.add(Box.createRigidArea(new Dimension(0, 14)));
                    pan5.add(no_malade_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(code_service3_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(no_chambre2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(lit_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));

                }
                if (action == 4) {
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
                }
                break;

            case 8:
                no_docteur.setFont(font2);
                no_malade2.setFont(font2);
                pan3.add(no_docteur);
                pan3.add(Box.createRigidArea(new Dimension(0, 10)));
                pan3.add(no_malade2);
                if (action == 1) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(no_docteur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_malade2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Ajouter_Soignage);
                }
                if (action == 2) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(no_docteur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_malade2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Supprimer_Soignage);
                }
                if (action == 3) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 40)));
                    pan4.add(no_docteur_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_malade2_old);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Modifier_Soignage);
                    pan5.add(Box.createRigidArea(new Dimension(0, 14)));
                    pan5.add(no_docteur_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan5.add(no_malade2_t);
                    pan5.add(Box.createRigidArea(new Dimension(0, 10)));

                }
                if (action == 4) {
                    pan4.add(Box.createRigidArea(new Dimension(0, 80)));
                    pan4.add(no_docteur_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(no_malade2_t);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_tout_Soignage);
                    pan4.add(Box.createRigidArea(new Dimension(0, 10)));
                    pan4.add(Rechercher_parametre_Soignage);
                }
                break;

        }

        this.setVisible(true);
    }

    /**
     * Méthode affiche pour afficher les informations de la base de données
     * récupérées.
     *
     * @param affichage contient toutes les données récupérées de la base de données dans un String
     */
    public void affiche(String affichage) {
        pan2.removeAll();
        pan2.repaint();
        
        JTextArea panneau = new JTextArea(affichage, 33, 50);
        
        JScrollPane paneTextArea1 = new JScrollPane(panneau); 
        paneTextArea1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panneau.setBackground(pan2.getBackground());
        
        pan2.add(paneTextArea1,BorderLayout.EAST);
        this.setVisible(true);
    }
    
    /** Méthode Camembert() appelée lorsqu'on appuie sur le bouton statistique.
     *  Permet d'afficher le menu secondaire avec 3 boutons, pour afficher les graphes JFreeChart.
     *  Rend la fenêtre visible à la fin
     */

    public void Camembert() {
        pan2.removeAll();
        pan2.repaint();
        pan2.setLayout(new FlowLayout());
        Dimension v = new Dimension (500, 100);
        Répartition_des_malades_par_chambre.setPreferredSize(v);
        Répartition_des_docteurs_par_service.setPreferredSize(v);
        Salaires.setPreferredSize(v);
        pan2.add(Répartition_des_malades_par_chambre);
        pan2.add(Répartition_des_docteurs_par_service);
        pan2.add(Salaires);
        this.setVisible(true);
    }

}
