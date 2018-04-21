
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
        //on recherche la premiere condition non nulle
        for(int i = 0; i<nbbtrequete; i++) {
            if(condition[i].equals("")){
                pnn ++;
            }
            System.out.println(pnn);
        }
        condition[pnn] ="'" + ligne[pnn] + "'" + " LIKE " + "'" + condition[pnn] + "'";
        
        //on concatene les conditions non nulles à partir de la deuxième condition non nulle
        for (int i = pnn+1; i<nbbtrequete; i++) {
            System.out.println("");
            if(condition[i].equals("")){
                //nothing to do
                System.out.println("blabla");
            }
            else {
                condition[i] = " AND " + "'" + ligne[i] + "'" + " LIKE " + "'" + condition[i] + "'" + " ";
            }
        }
        for(int i = pnn; i<nbbtrequete; i++){
            fullrequete = fullrequete + condition[i];
        }
        return fullrequete;
    }
}
