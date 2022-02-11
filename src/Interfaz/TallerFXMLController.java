/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author DAW
 */
public class TallerFXMLController implements Initializable {

    @FXML
    public TextField mat;
    @FXML
    public TextField kms;
    @FXML
    public TextFlow mostraTextoinfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void novoVehiculo(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.NOVOVEHICULO);
        StartMenu.stage.setScene(scene);
    }

    @FXML
    public void listarVehiculos(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MOSTRAINFO);
        StartMenu.stage.setScene(scene);
        StartMenu.conce.listarVehiculos();
    }

    @FXML
    public void buscaVehiculo(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MOSTRAINFO);
        StartMenu.stage.setScene(scene);
        StartMenu.conce.buscaVehiculo(mat.getText());
    }

    @FXML
    public void actualizaKms(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MOSTRAINFO);
        StartMenu.stage.setScene(scene);
        StartMenu.conce.actualizaKms(mat.getText(), Integer.parseInt(kms.getText()));
    }

    @FXML
    public void eliminaVehiculo(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MOSTRAINFO);
        StartMenu.stage.setScene(scene);
        StartMenu.conce.eliminaVehiculo(mat.getText());
    }

    @FXML
    public void sair(ActionEvent ae) {
        System.exit(0);
    }

}
