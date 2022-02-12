/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class NovoVehiculoFXMLController implements Initializable {

    @FXML
    TextField nome;
    @FXML
    TextField dni;
    @FXML
    TextField marca;
    @FXML
    TextField mat;
    @FXML
    TextField kms;
    @FXML
    TextField precio;
    @FXML
    DatePicker data;
    @FXML
    TextField descripcion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void gardar() {
        StartMenu.conce.insertarVehiculo(marca.getText(), mat.getText(), Integer.parseInt(kms.getText()), data.toString(), descripcion.getText(), Integer.parseInt(precio.getText()), nome.getText(), dni.getText());
    }

    @FXML
    public void sair() {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
    }

}
