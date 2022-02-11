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

   public enum SetScene {
        MAIN("/Interfaz/TallerFXML.fxml"),
        NOVOVEHICULO("/Interfaz/NovoVehiculoFXML.fxml"),
        MOSTRAINFO("/Interfaz/MostrarInfo.fxml");
        String url;
        private SetScene(String url) {
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
            scene[scn.ordinal()]=new Scene(CreaUI.create(scn.url));
        }
        return scene[scn.ordinal()];
    }
}
