package graphe2;
import java.util.Vector;

public class Cla_Node implements Int_Node{
    int info;
    Vector linked;
    
    Cla_Node (int info, Vector linked) {
        this.info = info;
        this.linked = linked;
    }
}
