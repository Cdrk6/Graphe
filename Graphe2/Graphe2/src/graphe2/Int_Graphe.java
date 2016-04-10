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
public interface Int_Graphe {
    void removeGraphe();
    void addNode(float info);
    void removeNode(Cla_Node node);
    void addEdge(Cla_Node node1, Cla_Node node2, float value);
    void removeEdge(Cla_Node node1, Cla_Node node2);
    void changeEdgeValue(Cla_Node node1, Cla_Node node2, float value);
    void loadFile (String fileName);
    void showGraphe();
    //void floyd();
}
