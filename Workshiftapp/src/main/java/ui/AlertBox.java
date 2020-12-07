/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/**
 *
 * @author jeoleivo
 */
public class AlertBox {
    
    public static void display(String title, String labelText){
    
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(300);
    
    Label message = new Label(labelText);
    
    Button closeButton = new Button("Sulje");
    closeButton.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(message, closeButton);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
  
    }    
}
