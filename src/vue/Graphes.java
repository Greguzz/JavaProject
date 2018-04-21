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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Aurelio
 */
public class Graphes {
    /**
     * Une méthode qui fait un camembert montrant la répartition des malades par maladies
     *
     * @param nom le nom des maladies
     * @param nbMalade le nombre de malades
     */
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
    
    /**
     * Une méthode qui fait un graphes en barre pour montrer la répartition des malades par services
     *
     * @param service le nom des services
     * @param nbPatient le nombre de patients
     */
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
    
    /**
     * Une méthode qui fait un graphes en barre pour montrer la répartition des moyennes des salaires par services
     *
     * @param service le nom des services
     * @param moyenne la moyenne des saliares par service
     */
    public static void salaireGraphe (String service[], float moyenne[]) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i=0; i<service.length; i++){
            data.addValue(moyenne[i], service[i], "");
        }
        JFreeChart chart = ChartFactory.createBarChart("Nombre de patient par service", "Service", "Nombre de Patient", data, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame = new ChartFrame("Fenetre", chart);//je savais pas trop quoi mettre a la place de fenetre
        frame.pack();
        frame.setVisible(true);
    }
}
