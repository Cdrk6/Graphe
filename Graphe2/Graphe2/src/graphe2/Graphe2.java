/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe2;

/**
 *
 * @author Cédric
 */
public class Graphe2 {
    
    //Cla_GrapheList liste;
    static Cla_GrapheMatrix matrice;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        matrice = new Cla_GrapheMatrix(false);
        matrice.loadFile(Open_file.IMGPATH);
        matrice.showGraphe();
    }
}
