/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Manu
 */
public class Graphique extends JFrame {
    
    private final JPanel pan1;
    private final JPanel pan2;
    private final JButton choix1;
    private final JButton choix2;
    private final JButton choix3;
    private final JSplitPane split;
    
    
    
    public Graphique() {
        this.setSize(800,600);
        this.setTitle("Gestion d'un hopital");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan1=new JPanel();
        pan1.setSize(200, 600);
        pan2=new JPanel();
        pan2.setSize(600, 600);
        
        choix1=new JButton("Ajout ");
        choix2=new JButton("Supression");
        choix3=new JButton("Mise a Jour");
        
        split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan1, pan2);
        split.setDividerSize(10);
        split.setDividerLocation(200);
        this.getContentPane().add(split, BorderLayout.CENTER);
//        this.getContentPane().add(pan1);
//        this.getContentPane().add(pan2);
        this.setVisible(true);
    } 
    
    public void afficher() {
        pan1.setLayout(new BoxLayout(pan1,BoxLayout.PAGE_AXIS));
        pan1.add(choix1);
        pan1.add(choix2);
        pan1.add(choix3);
    }
     
}
