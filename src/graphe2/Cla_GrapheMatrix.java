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

    public Cla_GrapheMatrix(boolean directed) {
        matrix = new ArrayList();
        ArrayList<Float> aux = new ArrayList();
        if (directed)
            aux.add((float) 1);
        else
            aux.add((float) -1);
        matrix.add(aux);
    }

    @Override
    public void removeGraphe() {
        while (this.matrix.get(0) != null)
            this.matrix.remove(0);
    }

    @Override
    public void addNode(Cla_Node elt) {
        float info = elt.info;
        int i = 0, l = this.matrix.size();
        while (i < l && this.matrix.get(0).get(i) != info)
            ++i;
        if (i < l)
            return;
        this.matrix.get(0).add(info);
        ArrayList<Float> aux = new ArrayList();
        aux.add(info);
        aux.add(Float.POSITIVE_INFINITY);
        for (i = 1; i < l; ++i) {
            this.matrix.get(i).add(Float.POSITIVE_INFINITY);
            aux.add(Float.POSITIVE_INFINITY);
        }
        this.matrix.add(aux);
    }

    @Override
    public void removeNode(Cla_Node node) {
        int i, n = 0, l = this.matrix.size();
        while (this.matrix.get(0).get(n) != node.info) {
            ++n;
            if (n == l)
                return;
        }
        this.matrix.remove(n);
        l = this.matrix.size();
        for (i = 0; i < l; ++i)
            this.matrix.get(i).remove(n);
    }

    @Override
    public void changeEdgeValue(Cla_Node node1, Cla_Node node2, float value) {
        int n = 0, p = 0, l = this.matrix.size();
        while (this.matrix.get(0).get(n) != node1.info || this.matrix.get(0).get(p) != node2.info) {
            if (this.matrix.get(0).get(n) != node1.info)
                ++n;
            if (this.matrix.get(0).get(p) != node2.info)
                ++p;
            if (n >= l || p >= l)
                return;
        }
        this.matrix.get(n).set(p, value);
        if (this.matrix.get(0).get(0) == -1)
            this.matrix.get(p).set(n, value);
    }

    @Override
    public void addEdge(Cla_Node node1, Cla_Node node2, float value) {
        this.changeEdgeValue(node1, node2, value);
    }

    @Override
    public void removeEdge(Cla_Node node1, Cla_Node node2) {
        this.changeEdgeValue(node1, node2, Float.POSITIVE_INFINITY);
    }

    @Override
    public void loadFile(String fileName) {
        int[][] file = Open_file.loadFile(fileName);
        int i = 0;
        Cla_Node node1;
        Cla_Node node2;
        while (i < file.length) {
            node1 = new Cla_Node(file[i][0], new ArrayList<Float>(), new ArrayList<Float>());
            this.addNode(node1);
            node2 = new Cla_Node(file[i][1], new ArrayList<Float>(), new ArrayList<Float>());
            this.addNode(node2);
            this.addEdge(node1, node2, file[i][2]);
            ++i;
        }
    }

    @Override
    public void showGraphe() {
        int i = 1, j, l = this.matrix.size();
        while (i < l) {
            j = 1;
            System.out.println("Du noeud " + this.matrix.get(i).get(0));
            while (j < l) {
                if (this.matrix.get(i).get(j) != Float.POSITIVE_INFINITY) {
                    System.out.print("  Au noeud " + this.matrix.get(0).get(j));
                    System.out.println("  Value :" + this.matrix.get(i).get(j));
                }
                j++;
            }
            System.out.print("\n");
            i++;
        }
    }
    
    @Override
     public float[][] floyd() {
        int n = matrix.size();
        n--;
        float[][] ret = new float[n][2*n];
        int i, j;
        for (i = 1; i < n+1; ++i) {
            for (j = 1; j < n+1; ++j) {
                ret[i][j] = this.matrix.get(i).get(j);
                ret[i][n+j] = this.matrix.get(0).get(i);
            }
        }
        int k;/*nœud étudié*/
        float newVal;
        for (k = 0; k < n; ++k) {
            for (i = 0; i < n; ++i) {
                for (j = 0; j < n; ++j) {
                    newVal = ret[i][k] + ret[k][j];
                    if (ret[i][j] > newVal) {
                        ret[i][j] = newVal;
                        ret[i][n+j] = this.matrix.get(0).get(k);
                    }
                }
            }
        }
        return ret;
    }
}
