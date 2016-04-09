/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe2;
import java.util.Vector;

/**
 *
 * @author dedrouas
 */
public class Cla_Edge implements Int_Edge{
    Cla_Node node1;
    Cla_Node node2;
    
    Cla_Edge (Cla_Node node1, Cla_Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}
