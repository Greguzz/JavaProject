/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFrame;

/**
 *
 * @author Aurelio
 */
public class Graphes {
    
    public static void maladieGraphe (String nom[], int nbMalade[]) {
    DefaultPieDataset maladie = new DefaultPieDataset();
    for (int i=0; i<nom.length; i++){
        maladie.setValue(nom[i], nbMalade[i]);
    }
    JFreeChart chart = ChartFactory.createPieChart("Maladie", maladie, true, true, false);
    ChartFrame frame = new ChartFrame("Fenetre", chart);//je savais pas trop quoi mettre a la place de fenetre
    frame.pack();
    frame.setVisible(true);
    }
    
}
