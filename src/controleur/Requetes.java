
package controleur;

/**
 *
 * @author Grégoire
 */
public class Requetes {
    private String[] boutrequete;
    private int nbbtrequete;
    
    Requetes(String[] pboutrequete, int pnbbtrequete)
    {
        this.boutrequete = pboutrequete.clone();
        this.nbbtrequete = pnbbtrequete;
    }
    
    public String[] creationrequete(int a, String condition, String table, int nbcondition) {
        String requete[] = new String[nbcondition];
        if(boutrequete == null){
            requete[a] = null;
        }
        else {
            requete[a] = table + "AND" + "LIKE" + condition + " ";
            nbcondition ++;
        }
        return requete;
    }
    public String concatrequete(String requete[], int nbcondition){
        String fullrequete = "";
        for(int i = 0; i<nbcondition; i++){
            fullrequete = fullrequete + requete[i];
        }
        return fullrequete;
    }
}
