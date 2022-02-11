package Interfaz;

import ClasesConce.Concesionario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author DAW
 */
public class StartMenu extends Application {
    public static Stage stage;
    public static Concesionario conce = new Concesionario();
    @Override
    public void start(Stage stage) {
        Scene scene = SceneFactory.get(SceneFactory.SetScene.MAIN);
        stage.setTitle("Benvidxs a Talleres Null!!");
        this.stage=stage;
        stage.setScene(scene);
        StartMenu.stage=stage;
        stage.show();
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
