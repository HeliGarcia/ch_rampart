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
public class TowerFactory {
    private BulletFactory generator;
    private AssetManager assetManager;

    public TowerFactory(BulletFactory generator, AssetManager assetManager) {
        this.generator = generator;
        this.assetManager = assetManager;
    }
    
    

    public Tower createTower(String name, Vector3f loc, Geometry geom, float cooldown, float charge, BulletFactory generator, Node towerParentNode) {
        Tower tower = new Tower(towerParentNode, name, loc, geom, cooldown, charge, generator);
        attachTower(tower, towerParentNode); // Attach tower to the parent node
        return tower;
    }

    private void attachTower(Tower tower, Node towerParentNode) {
        towerParentNode.attachChild(tower.geom); // Attach tower geometry to the parent node
        tower.geom.setLocalTranslation(tower.loc); // Set tower's position
        // You may want to add more setup logic here, like attaching physics control
        // Example: tower.geom.addControl(new RigidBodyControl(0));
    }
    
    
    public Tower redTower(String name, Node towerParentNode){
        return createTower(
                name, 
                new Vector3f(1,1,0), 
                myBox("tower",  ColorRGBA.Red), 
                1f, 
                1f, 
                generator, 
                towerParentNode
        );

    }
        
    private Geometry myBox(String name,  ColorRGBA color){
        Geometry geom = new Geometry(name, new Box(Vector3f.ZERO, 1, 1, 1));
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        return geom;
    }
}