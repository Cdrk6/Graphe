package graphe2;
import java.util.ArrayList;

public class Cla_Node implements Int_Node{
    int info;
    ArrayList <Cla_Node> linked;
    
    Cla_Node (int info, ArrayList linked) {
        this.info = info;
        this.linked = linked;
    }
}
