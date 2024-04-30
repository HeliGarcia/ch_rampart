/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author jt
 */
public class BulletFactory {
    private Node bulletParentNode;
    private AssetManager assetManager;

    public BulletFactory(Node bulletParentNode, AssetManager assetManager) {
        this.bulletParentNode = bulletParentNode;
        this.assetManager = assetManager;
    }

    

    public Bullet createBullet(String name, Vector3f pos, Vector3f acceleration, Geometry shape) {
        Bullet bullet = new Bullet(name, bulletParentNode, pos, acceleration, shape);
        attachBullet(bullet); 
        return bullet;
    }

    private void attachBullet(Bullet bullet) {
        bulletParentNode.attachChild(bullet.shape); 
        bullet.shape.setLocalTranslation(bullet.poss); 
    }
    
    public Bullet createBullet(Vector3f cordinates){
        return createBullet("", cordinates, new Vector3f(1,1,0), myBox("tower",  ColorRGBA.White));
    
    }
    private Geometry myBox(String name,  ColorRGBA color){
        Geometry geom = new Geometry(name, new Box(Vector3f.ZERO, 1, 1, 1));
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        return geom;
    }
}