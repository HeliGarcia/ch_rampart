/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

//import static Entities.Tower.mesh;
import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.input.InputManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author jt
 */
public class PlaceTower implements Command{
    private Node grid;
    private Node towers;
    private Camera cam;
    InputManager inputManager;
    public Box mesh = new Box(Vector3f.ZERO, 1, 1, 1);
    private AssetManager assetManager;
    //private float i=0;
    
    
    public PlaceTower(Node grid, Node towers, Camera cam, InputManager inputManager, AssetManager assetManager) {
        this.grid = grid;
        this.cam = cam;
        this.inputManager = inputManager;
        this.assetManager = assetManager;
        this.towers = towers;
    }
    
    public void execute(){
    CollisionResults results = new CollisionResults();
        Vector2f click2d = inputManager.getCursorPosition();
        Vector3f click3d = cam.getWorldCoordinates(
            new Vector2f(click2d.getX(), click2d.getY()), 0f);
        Vector3f dir = cam.getWorldCoordinates(
        new Vector2f(click2d.getX(), click2d.getY()), 1f).
        subtractLocal(click3d);
        Ray ray = new Ray(click3d, dir);
        grid.collideWith(ray, results);
        //Si el usuario ha hecho click en algo, identificaremos la geometria seleccionada
        if (results.size()>0){
            Node nodo = results.getClosestCollision().getGeometry().getParent();
            if (nodo.getChild("tower") != null ) {
                return;
            } else {
                nodo.attachChild(myBox("tower",  ColorRGBA.Red));
            } 
        }
    
    
    }
    
    private Geometry myBox(String name,  ColorRGBA color){
        Geometry geom = new Geometry(name, mesh);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(1,1,0);
        return geom;
    }
    
}
