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
        int i = 0, l = this.matrix.size();
        while (this.matrix.get(0).get(i) != info && i < l) {++i;}
        if (i < l) {return;}
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
        int i, n = 0, l = this.matrix.size();
        while (this.matrix.get(0).get(n) != node.info) {++n; if(n==l){return;}}
        this.matrix.remove(n);
        l = this.matrix.size();
        for (i = 0; i < l; ++i) {
            this.matrix.get(i).remove(n);
        }
    }
    
    @Override
    public void changeEdgeValue (Cla_Node node1, Cla_Node node2, float value) {
        int n = 0, p = 0, l = this.matrix.size();
        while(this.matrix.get(0).get(n) != node1.info || this.matrix.get(0).get(p) != node2.info) {
            if (this.matrix.get(0).get(n) != node1.info) {++n;}
            if (this.matrix.get(0).get(p) != node1.info) {++p;}
            if (n == l || p == l) {return;}
        }
        this.matrix.get(n).set(p, value);
        if (this.matrix.get(0).get(0) == -1) {this.matrix.get(p).set(n, value);}
    }
    
    @Override
    public void addEdge (Cla_Node node1, Cla_Node node2, float value) {
        this.changeEdgeValue(node1, node2, value);
    }
    
    @Override
    public void removeEdge (Cla_Node node1, Cla_Node node2) {
        this.changeEdgeValue(node1, node2, Float.POSITIVE_INFINITY);
    }
    
    @Override
    public void loadFile (String fileName) {
        int[][] file = Open_file.loadFile(fileName);
        int i = 0;
        Cla_Node node1 = new Cla_Node(0, new ArrayList<Float>(), new ArrayList<Float>());
        Cla_Node node2 = new Cla_Node(0, new ArrayList<Float>(), new ArrayList<Float>());
        while (i < file.length) {
            this.addNode(file[i][0]);
            node1.info = file[i][0];
            this.addNode(file[i][1]);
            node2.info = file[i][1];
            this.addEdge(node1, node2, file[i][2]);
        }
    }
}
