/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe2;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Cédric
 */
public class Cla_GrapheMatrix implements Int_Graphe {
    
    public Cla_GrapheMatrix(float value){
        ArrayList<ArrayList<Float>> matrix = new ArrayList();
        ArrayList<Float> aux = new ArrayList<Float>();
        aux.add(value);
        matrix.add(aux);
    }
    
}
