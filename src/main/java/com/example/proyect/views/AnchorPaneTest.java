package com.example.proyect.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneTest extends Stage{

    private Scene scene;
    private AnchorPane anchor;
    private Button btn1,btn2,btn3;

    public AnchorPaneTest(){
        CrearUI();
        this.setTitle("AnchorPane");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        anchor = new AnchorPane();

        btn1 = new Button("boton 1");
        btn2 = new Button("boton 2");
        btn3 = new Button("boton 3");

        AnchorPane.setTopAnchor(btn2, 10.0);
        AnchorPane.setRightAnchor(btn2, 10.0);

        AnchorPane.setBottomAnchor(btn3, 10.0);
        AnchorPane.setLeftAnchor(btn3, 10.0);

        anchor.getChildren().addAll(btn1,btn2,btn3);

        scene = new Scene(anchor);

    }
}
