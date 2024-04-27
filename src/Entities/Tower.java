/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
//import com.jme3.asset.AssetManager;

/**
 *
 * @author jt
 */
public class Tower {
    String name;
    Vector3f loc;
    Geometry geom;
    
    

    public Tower(String name, Vector3f loc, Geometry geom) {
        this.name = name;
        this.loc = loc;
        this.geom = geom;  
    }
    
    


    
    
    
}
