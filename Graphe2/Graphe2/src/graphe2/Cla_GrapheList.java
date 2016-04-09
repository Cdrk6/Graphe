package graphe2;
import java.util.ArrayList;

public class Cla_GrapheList implements Int_Graphe {
    ArrayList <Cla_Node> nodes;
    ArrayList <Cla_Edge> edges;
    
    Cla_GrapheList (ArrayList nodes, ArrayList edges) {                         //Copie
        this.nodes = nodes;
        this.edges = edges;
    }
}
