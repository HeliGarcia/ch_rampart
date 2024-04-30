/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
//import com.jme3.asset.AssetManager;

/**
 *
 * @author jt
 */
public class Tower {
    Node parent;
    String name;
    Vector3f loc;
    Geometry geom;
    float cooldown;
    float charge;
    BulletFactory generator;

    public Tower(Node parent, String name, Vector3f loc, Geometry geom, float cooldown, float charge, BulletFactory generator) {
        this.parent = parent;
        this.name = name;
        this.loc = loc;
        this.geom = geom;
        this.cooldown = cooldown;
        this.charge = charge;
        this.generator = generator;
    }
    
    
    
    public void update(float tpf){
        if((charge += tpf) >= cooldown){
            charge -= cooldown;
            shoot();
        }
    
    }
    
    public void shoot(){
        Vector3f vector = geom.getWorldTranslation();
        generator.createBullet(new Vector3f(vector.x ,vector.y, vector.z));
        //System.out.println("shoot");
    }
    


    
    
    
}
