package com.mycompany.javafxview;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.Locale;
import java.util.ResourceBundle;
import java.net.URL;

/**
 * Summary of a class in JavaDoc.
 * 
 * @author Maciej
 */
public class FxMain extends Application {
    
    Button button1;

    @Override
    public void start(Stage primaryStage) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
        //messages dziala, trzeba reszte dorobic
        
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        //primaryStage.setTitle("Sudoku Game");
        primaryStage.titleProperty().bind(I18N.createStringBinding("title"));
        primaryStage.setScene(new Scene(root, 600, 650));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> closeProgram(primaryStage));
        /*
        URL location = getClass().getResource("/FXML.fxml");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
        
        FXMLLoader fxmlLoader = new FXMLLoader(location, bundle);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent, 600, 650);
        
        primaryStage.titleProperty().bind(I18N.createStringBinding("title"));
        primaryStage.setScene(scene);
        */
        //MainView controller = fxmlLoader.getController();
        //controller.setStage(primaryStage);
        
        primaryStage.show();
        
    }

    /**
     * Summary of a class in JavaDoc. 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void closeProgram(Stage stage) {
        stage.close();
    }
    
    

}
