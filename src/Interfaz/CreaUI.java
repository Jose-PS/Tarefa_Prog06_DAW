/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author DAW
 */
public class CreaUI {

    public static Pane create(String url)  {
        Pane pane=null;
        try {
            FXMLLoader loader= new FXMLLoader (CreaUI.class.getResource(url));
            pane=loader.load();
        } catch (IOException io) {
            System.out.println(io.getMessage());
            System.out.println("Non se pudo cargar o FXML.");
            System.exit(0);
        }
        return pane;
    }
    
}
