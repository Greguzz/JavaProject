/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;
/**
 *
 * @author Aurelio
 */
public class Graphes {
    
    public static void maladieGraphe (String nom[], int nbMalade[]) {
    DefaultPieDataset data = new DefaultPieDataset();
    for (int i=0; i<nom.length; i++){
        data.setValue(nom[i], nbMalade[i]);
    }
    JFreeChart chart = ChartFactory.createPieChart("Maladie", data, true, true, false);
    ChartFrame frame = new ChartFrame("Fenetre", chart);//je savais pas trop quoi mettre a la place de fenetre
    frame.pack();
    frame.setVisible(true);
    }
    
    public static void patientGraphe (String service[], int nbPatient[]) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i=0; i<service.length; i++){
            data.addValue(nbPatient[i], service[i], "");
        }
        JFreeChart chart = ChartFactory.createBarChart("Nombre de patient par service", "Service", "Nombre de Patient", data, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame = new ChartFrame("Fenetre", chart);//je savais pas trop quoi mettre a la place de fenetre
        frame.pack();
        frame.setVisible(true);
    }
}
