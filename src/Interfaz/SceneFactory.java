/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
*
* @author DAW
*/
public class SceneFactory {

public enum SetScene {
MAIN("/Interfaz/Taller.fxml"),
NOVOVEHICULO("/Interfaz/NovoVehiculo.fxml"),
MOSTRAINFO("/Interfaz/MostraInfo.fxml");
String url;
SetScene(String url) {
this.url = url;
}

}

public static SceneFactory factory = null;
Scene[] scene = new Scene[3];
Pane[] pane = new Pane[3];

private SceneFactory() {
}

public static Scene get (SetScene scn) {
if (factory==null) factory=new SceneFactory();
return factory.getScene(scn);
}

public static Pane pane(SetScene scn) {
if (factory==null) factory=new SceneFactory();
return factory.getPane(scn);
}

private Pane getPane(SetScene scn) {
if (pane[scn.ordinal()]==null) {
pane[scn.ordinal()]=new CreaUI().create(scn.url);
}
return pane[scn.ordinal()];
}

private Scene getScene(SetScene scn) {
if (scene[scn.ordinal()]==null) {
scene[scn.ordinal()]=new Scene(getPane(scn));
}
return scene[scn.ordinal()];
}
}