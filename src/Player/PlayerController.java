/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import Commands.Command;
import com.jme3.input.InputManager;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;

/**
 *
 * @author jt
 */
public class PlayerController implements ActionListener{
    
    private InputManager inputManager;
    private Command ptower;
    
    public PlayerController(InputManager inputManager, Command ptower){
        this.inputManager = inputManager;
        init_keys();
        this.ptower = ptower;
    }
    
    private void init_keys(){
        this.inputManager.addMapping("PlaceTower", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        this.inputManager.addMapping("unknown", new MouseButtonTrigger(MouseInput.BUTTON_RIGHT));
        this.inputManager.addListener(this, "PlaceTower");
    }

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (name.equals("PlaceTower") && !isPressed) {
                ptower.execute();
            }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody    
    }
    
    
}
