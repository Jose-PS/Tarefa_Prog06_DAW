/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javafx.scene.Scene;

/**
 *
 * @author DAW
 */
public class SceneFactory {

    enum SetScene {
        MAIN("/Interfaz/Taller.fxml"),
        NOVOVEHICULO("/Interfaz/NovoVehiculo.fxml"),
        MOSTRAINFO("/Interfaz/MostrarInfo.fxml");
        String url;
        SetScene(String url) {
            this.url = url;
        }

    }

    public static SceneFactory factory = null;
    Scene[] scene = new Scene[3];

    private SceneFactory() {
    }
    
    public static Scene get (SetScene scn)  {
        if (factory==null) factory=new SceneFactory();
        return factory.getScene(scn);
    }

    private Scene getScene(SetScene scn)  {
        if (scene[scn.ordinal()]==null) {
            scene[scn.ordinal()]=new Scene(new CreaUI().create(scn.url));
        }
        return scene[scn.ordinal()];
    }
}
