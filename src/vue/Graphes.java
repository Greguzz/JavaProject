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
     * Une méthode qui fait un camembert montrant la répartition des malades par chambre au premier étage
     *
     *  no_chambre le numéro de la chambre
     *  nbMalade le nombre de malades
     */
    public static void chambreGraphe () {
        String no_chambre[] = {"101", "102", "103", "104"};
        int nbMalade[] = {12, 12, 22, 22};
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i=0; i<no_chambre.length; i++){
            data.setValue(no_chambre[i], nbMalade[i]);
        }
        JFreeChart chart = ChartFactory.createPieChart("Répartition des malades pour les chambres du premier étage", data, true, true, false);
        ChartFrame frame = new ChartFrame("Fenetre", chart);//je savais pas trop quoi mettre a la place de fenetre
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Une méthode qui fait un graphes en barre pour montrer la répartition des malades par services
     *
     *  service le nom des services
     *  nbDocteur le nombre de docteurs
     */
    public static void docteurGraphe () {
        String service[] = {"Réanimation et Traumatologie", "Chirurgie Générale", "Cardiologie"};
        int nbDocteur[] = {7, 8, 5};
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i=0; i<service.length; i++){
            data.addValue(nbDocteur[i], service[i], "");
        }
        JFreeChart chart = ChartFactory.createBarChart("Nombre de docteurs par service", "Service", "Nombre de Docteurs", data, PlotOrientation.VERTICAL, true, true, false);
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
    public static void salaireGraphe (String service[], float moyenne[]) {//inutile au vu des données que nous avons dans la bdd
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
