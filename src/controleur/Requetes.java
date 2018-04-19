
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
    

    public String concatrequete(String condition[], String table, String[] ligne){
        int pnn=0;
        String fullrequete = "SELECT * FROM " + table + " WHERE " ;
        for(int i = 0; i<nbbtrequete; i++) {
            if(condition[i].equals("")){
                pnn ++;
            }
        }
        condition[pnn] = ligne[pnn] + " LIKE " + condition[pnn];
        for (int i = pnn+1; i<nbbtrequete; i++) {
            if(condition[i].equals("")){
                //nothing to do
            }
            else {
            condition[i] = " AND " + ligne[i] + " LIKE " + condition[i] + " ";
            }
        }
        for(int i = pnn; i<nbbtrequete; i++){
            fullrequete = fullrequete + condition[i];
        }
        return fullrequete;
    }
}
