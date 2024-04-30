package mygame;

import Commands.PlaceTower;
import Entities.Bullet;
import Entities.BulletFactory;
import Entities.Tower;
import Entities.TowerFactory;
import Player.PlayerController;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.system.AppSettings;
import java.util.ArrayList;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    PlayerController controller;
    ArrayList<Tower> towerCollection;
    ArrayList<Bullet> collection;
    
    public static void main(String[] args) {
        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Chinchilla\'s rampart");
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
        
        Box b = new Box(33, 33, 0);
        Geometry geom = new Geometry("Box", b);
        

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        Node creepNode = new Node("creeps");
        Node playerNode = new Node("player");
        Node towerNode = new Node("tower"); 
        Node grid = new Node("grid");
        grid.setLocalTranslation(-17,-17,-40);
        createGrid(17,2f,grid);
        
        rootNode.attachChild(creepNode);
        rootNode.attachChild(playerNode);
        rootNode.attachChild(towerNode);
        rootNode.attachChild(grid);
        //grid.attachChild(geom);
        
        BulletFactory bfactory = new BulletFactory(playerNode, this.assetManager);
        TowerFactory tfactory = new TowerFactory(bfactory,this.assetManager);
        PlaceTower ptower = new PlaceTower(grid,this.cam, this.getInputManager(), tfactory);
        controller = new PlayerController(this.getInputManager(),ptower);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    public void createGrid(int GRID_SIZE, float CELL_SIZE, Node grid){
     for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Quad quad = new Quad(CELL_SIZE, CELL_SIZE);
                Node nodo = new Node("cell_" + i + "_" + j);
                Geometry cell = new Geometry("Ground", quad);
                nodo.setLocalTranslation(i * CELL_SIZE, j * CELL_SIZE, 0);

                Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
                mat.setColor("Color", ColorRGBA.Blue);
                cell.setMaterial(mat);

                
                nodo.attachChild(cell);
                grid.attachChild(nodo);
            }
        }
    }
}
