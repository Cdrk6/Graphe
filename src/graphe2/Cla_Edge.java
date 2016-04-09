/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphe2;

/**
 *
 * @author dedrouas
 */
public class Cla_Edge implements Int_Edge{
    Cla_Node nodeDir;
    float value;
    
    Cla_Edge (Cla_Node nodeDir, float value) {
        this.nodeDir = nodeDir;
        this.value = value;
    }
    
    @Override
    public void changeEdgeDir (Cla_Node newDir, float newValue) {
        this.nodeDir = newDir;
        this.value = newValue;
    }
    
    @Override
    public void changeEdgeValue (float newValue) {
        this.changeEdgeDir(this.nodeDir, newValue);
    }
}
