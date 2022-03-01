package com.example.proyect.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StackPaneTest extends Stage {

    private StackPane stack;
    private Button btn1,btn2,btn3;
    private Scene scene;

    public StackPaneTest(){
        CrearUI();
        this.setTitle("StackPane");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        stack = new StackPane();

        btn1 = new Button("Button 1");
        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");

        stack.setAlignment(btn1, Pos.CENTER);
        stack.setAlignment(btn2, Pos.BOTTOM_CENTER);
        stack.setAlignment(btn3, Pos.TOP_RIGHT);


        stack.getChildren().addAll(new Rectangle(150,150, Color.DARKBLUE),btn1,btn2,btn3);
        scene = new Scene(stack);

    }
}
