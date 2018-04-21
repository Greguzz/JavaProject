
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
        int tn=0;
        String fullrequete = "SELECT * FROM " + table + " WHERE " ;
        //on recherche la premiere condition non nulle
        while(condition[pnn].equals("")) {
            pnn++;
            System.out.println("blblb" + pnn);
            if(pnn>nbbtrequete)
            {
                System.out.println("ttt");
                tn = 1;
                break;
            }
            
        }
        if(tn == 1)
        {
            fullrequete = "SELECT * FROM " + table;
            return fullrequete;
        }
        if(condition[pnn] != "")
        {
            condition[pnn] = ligne[pnn] + " LIKE " + "'" + condition[pnn] + "'";
        }
        
        
        //on concatene les conditions non nulles à partir de la deuxième condition non nulle
        for (int i = pnn+1; i<nbbtrequete; i++) {
            System.out.println("");
            //on ne concatène que les conditions non nulles
            if(condition[i] != "") {
                condition[i] = " AND " + ligne[i] + " LIKE " + "'" + condition[i] + "'" + " ";
            }
        }
        for(int i = pnn; i<nbbtrequete; i++){
            fullrequete = fullrequete + condition[i];
        }
        return fullrequete;
    }
}
