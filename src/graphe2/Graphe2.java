/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe2;

//import java.util.ArrayList;

/**
 *
 * @author Cédric
 */
public class Graphe2 {
    
    public static final String IMGPATH = "content/dodecaedre.txt";
    //static Cla_GrapheList liste;
    static Cla_GrapheMatrix matrice;
    
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        /*liste = new Cla_GrapheList(new ArrayList(),false,true);
        liste.loadFile(IMGPATH);
        liste.showGraphe();*/
        matrice = new Cla_GrapheMatrix(false);
        matrice.loadFile(IMGPATH);
        matrice.showGraphe();
    }
}
