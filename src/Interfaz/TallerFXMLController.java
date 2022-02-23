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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
    TextField nome;
    @FXML
    TextField dni;
    @FXML
    TextField marca;
    @FXML
    TextField precio;
    @FXML
    DatePicker data;
    @FXML
    TextField descripcion;
    @FXML
    public TextFlow textos;
    @FXML
    public SplitPane mainSplit;
    @FXML
    public Pane mainDer;
    @FXML
    public Pane novo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void novoVehiculo(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
        mainSplit.getItems().set(1, SceneFactory.pane(SceneFactory.SetScene.NOVOVEHICULO));
    }

    @FXML
    public void listarVehiculos(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
        mainSplit.getItems().set(1, SceneFactory.pane(SceneFactory.SetScene.MOSTRAINFO));
        StartMenu.conce.listarVehiculos();
    }

    @FXML
    public void buscaVehiculo(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
        mainSplit.getItems().set(1, SceneFactory.pane(SceneFactory.SetScene.MOSTRAINFO));
        StartMenu.conce.buscaVehiculo(mat.getText());
    }

    @FXML
    public void actualizaKms(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
        mainSplit.getItems().set(1, SceneFactory.pane(SceneFactory.SetScene.MOSTRAINFO));
        StartMenu.conce.actualizaKms(mat.getText(), Integer.parseInt(kms.getText()));
    }

    @FXML
    public void eliminaVehiculo(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
        mainSplit.getItems().set(1, SceneFactory.pane(SceneFactory.SetScene.MOSTRAINFO));
        StartMenu.conce.eliminaVehiculo(mat.getText());

    }

    @FXML
    public void gardar(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
        mainSplit.getItems().set(1, SceneFactory.pane(SceneFactory.SetScene.MAIN));
        StartMenu.conce.insertarVehiculo(marca.getText(), mat.getText(), Integer.parseInt(kms.getText()), data.toString(), descripcion.getText(), Integer.parseInt(precio.getText()), nome.getText(), dni.getText());
    }

    @FXML
    public void atras(ActionEvent ae) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        StartMenu.stage.setScene(scene);
        mainSplit.getItems().set(1, SceneFactory.pane(SceneFactory.SetScene.MAIN));
    }

    @FXML
    public void sair(ActionEvent ae) {
        System.exit(0);
    }

}
