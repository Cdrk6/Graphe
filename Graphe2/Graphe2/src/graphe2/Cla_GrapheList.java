package graphe2;
import java.util.ArrayList;

public class Cla_GrapheList implements Int_Graphe {
    ArrayList <Cla_Node> nodes;
    
    Cla_GrapheList (ArrayList nodes) {                                          //Copie
        this.nodes = nodes;
    }
}
