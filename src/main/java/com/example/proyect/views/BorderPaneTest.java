package com.example.proyect.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneTest extends Stage{

    private BorderPane raiz;
    private Scene scene;
    private Button top, bottom, center,right,left;


    public BorderPaneTest(){
        CrearUI();
        this.setTitle("BorderPane");
        this.setScene(scene);
        this.show();

    }

    private void CrearUI() {
        raiz = new BorderPane();
        top = new Button("TOP");
        bottom = new Button("BOTTOM");
        left = new Button ("LEFT");
        right = new Button("RIGHT");
        center = new Button("CENTER");

        raiz.setTop(top);
        raiz.setBottom(bottom);
        raiz.setLeft(left);
        raiz.setRight(right);
        raiz.setCenter(center);

        scene = new Scene(raiz);


    }



}
