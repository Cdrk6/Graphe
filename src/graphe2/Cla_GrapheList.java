package graphe2;

import java.util.ArrayList;

public class Cla_GrapheList implements Int_Graphe {

    ArrayList<Cla_Node> nodes;
    boolean oriented;
    boolean IsValued;

    Cla_GrapheList(ArrayList nodes, boolean isOriented, boolean IsValued) {                       //Copie
        this.nodes = nodes;
        this.oriented = isOriented;
        this.IsValued=IsValued;
    }

    @Override
    public void removeGraphe() {
        nodes.removeAll(nodes);
    }

    @Override
    public void addNode(Cla_Node elt) {
        if(existNode(elt))
            return;
        nodes.add(elt);
    }

    @Override
    public void removeNode(Cla_Node node) {
        while (node.succ.isEmpty() == false)
            removeEdge(node, node.succ.get(0).nodeDir);
        while (node.prec.isEmpty() == false)
            removeEdge(node.prec.get(0).nodeDir, node);
        nodes.remove(node);
    }

    /**
     * Add an edge from n1 to n2
     *
     * @param n1 : Node de départ
     * @param n2 : Node d'arrivée
     * @param value : Valeur de l'arc
     */
    @Override
    public void addEdge(Cla_Node n1, Cla_Node n2, float value) {
        int i = 0, j = 0;
        while (i < nodes.size() && nodes.get(i).info != n1.info)
            ++i;
        while (j < nodes.size() && nodes.get(j).info != n2.info)
            ++j;
        nodes.get(i).succ.add(new Cla_Edge(n2, value));
        if (oriented)
            nodes.get(j).prec.add(new Cla_Edge(n1, value));
        else
            nodes.get(j).succ.add(new Cla_Edge(n1, value));
    }
    
    private boolean existNode(Cla_Node n1){
        boolean exist=false;
        for(int i=0;i<nodes.size();++i)
            exist=(exist||nodes.get(i).info==n1.info);
        return exist;
    }
    
    /**
     * remove the edge frome n1 to n2
     *
     * @param n1 : Node de départ
     * @param n2 : Node d'arrivée
     */
    @Override
    public void removeEdge(Cla_Node n1, Cla_Node n2) {
        int i = 0, j = 0, k = 0, l = 0;
        while (i < nodes.size() && nodes.get(i) != n1)
            ++i;
        while (k < nodes.get(i).succ.size() && nodes.get(i).succ.get(k).nodeDir != n2)
            ++k;
        nodes.get(i).succ.remove(k);
        while (j < nodes.size() && nodes.get(j) != n2)
            ++j;
        if (oriented) {
            while (l < nodes.get(i).prec.size() && nodes.get(i).prec.get(l).nodeDir != n1)
                ++k;
            nodes.get(j).prec.remove(l);
        }
        else {
            while (l < nodes.get(i).succ.size() && nodes.get(i).succ.get(l).nodeDir != n1)
                ++k;
            nodes.get(j).succ.remove(l);
        }
    }

    /**
     * @param n1 : Node précedent
     * @param n2 : Node Suivant
     * @param value : Nouvelle valeur
     */
    @Override
    public void changeEdgeValue(Cla_Node n1, Cla_Node n2, float value) {        //à Revoir
        int i = 0, j = 0, k = 0;
        while (i < nodes.size() && nodes.get(i) != n1)
            ++i;
        if (i == nodes.size())
            return;
        while (j < n1.succ.size() && n1.succ.get(j).nodeDir != n2)
            ++j;
        if (j == nodes.size())
            return;
        while (k < n1.succ.get(j).nodeDir.prec.size() && n1.succ.get(j).nodeDir.prec.get(k).nodeDir != n2)
            ++k;
        if (k == nodes.size())
            return;
        n1.succ.get(j).nodeDir.prec.get(k).value = value;
        n1.succ.get(j).value = value;
    }

    @Override
    public void loadFile(String fileName) {
        int[][] file = Open_file.loadFile(fileName);
        int i = 0;
        Cla_Node node1;
        Cla_Node node2 ;
        while (i < file.length) {
            node1 = new Cla_Node(file[i][0], new ArrayList<Float>(), new ArrayList<Float>());
            this.addNode(node1);
            node2 = new Cla_Node(file[i][1], new ArrayList<Float>(), new ArrayList<Float>());
            this.addNode(node2);
            if(IsValued)
                this.addEdge(node1, node2, file[i][2]);
            else
                this.addEdge(node1, node2, 1);
            ++i;
        }
    }

    @Override
    public void showGraphe() {
       int i = 0, j, l = this.nodes.size();
        while (i < l) {
            j=0;
            System.out.println(nodes.get(i).info);
            while (j < nodes.get(i).succ.size()) {
                System.out.println("  to :"+ this.nodes.get(i).succ.get(j).nodeDir.info + " Value:" +  this.nodes.get(i).succ.get(j).value);
                j++;
            }
            i++;
        }
    }
    
    public float[][] floyd() {
        return this.ListToMatrix().floyd();
    }
}
