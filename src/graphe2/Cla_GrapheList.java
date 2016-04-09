package graphe2;
import java.util.Vector;

public class Cla_GrapheList implements Int_Graphe {
    Vector nodes;
    Vector edges;
    
    Cla_GrapheList (Vector nodes, Vector edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
