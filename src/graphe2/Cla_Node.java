package graphe2;
import java.util.ArrayList;

public class Cla_Node implements Int_Node{
    float info;
    ArrayList <Cla_Edge> succ;
    ArrayList <Cla_Edge> prec;
    
    Cla_Node (float info, ArrayList succ, ArrayList prec) {
        this.info = info;
        this.succ = succ;
        this.prec = prec;
    }
    
    @Override
    public void changeNodeInfo(float newInfo) {
        this.info = newInfo;
    }
}
