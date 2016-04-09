/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe2;
import java.util.ArrayList;

/**
 *
 * @author Cédric
 */
public class Cla_GrapheMatrix implements Int_Graphe {
    
    ArrayList<ArrayList<Float>> matrix;
    
    public Cla_GrapheMatrix(boolean directed){
        matrix = new ArrayList();
        ArrayList<Float> aux = new ArrayList();
        if (directed) {aux.add((float)1);}
        else {aux.add((float)-1);}
        matrix.add(aux);
    }
    
    @Override
    public void removeGraphe() {
        while (this.matrix.get(0) != null) {
            this.matrix.remove(0);
        }
    }
    
    @Override
    public void addNode(float info) {
        int i, l = this.matrix.size();
        this.matrix.get(0).add(info);
        ArrayList<Float> aux = new ArrayList();
        aux.add(info);
        for (i = 1; i < l; ++i) {
            this.matrix.get(i).add(Float.POSITIVE_INFINITY);
            aux.add(Float.POSITIVE_INFINITY);
        }
        this.matrix.add(aux);
    }
    
    @Override
    public void removeNode (Cla_Node node) {
        int i, n = 0;
        while (this.matrix.get(0).get(n) != node.info) {++n;}
        this.matrix.remove(n);
        int l = this.matrix.size();
        for (i = 0; i < l; ++i) {
            this.matrix.get(i).remove(n);
        }
    }
    
    @Override
    public void addEdge (Cla_Node node1, Cla_Node node2, float value) {
        
    }
}
