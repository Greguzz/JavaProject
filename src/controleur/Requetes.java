
package controleur;

/**
 *
 * @author Grégoire
 */
public class Requetes {
    private String boutrequete[];
    private int nbbtrequete;
    
    Requetes(String[] pboutrequete, int pnbbtrequete)
    {
        this.boutrequete = pboutrequete.clone();
        this.nbbtrequete = pnbbtrequete;
    }
    

    public String concatrequete(String condition[], int nbbtrequete, String table, String[] ligne){
        String fullrequete = "SELECT * FROM " + table + "WHERE " ;
        for(int i = 0; i<nbbtrequete; i++) {
            
        }
        condition[0] = ligne[0] + "LIKE" + condition[0];
        for (int i = 1; i<nbbtrequete; i++) {
            condition[i] = "AND" + ligne[i] + "LIKE" + condition[i] + " ";
        }
        for(int i = 0; i<nbbtrequete; i++){
            fullrequete = fullrequete + condition[i];
        }
        return fullrequete;
    }
}
