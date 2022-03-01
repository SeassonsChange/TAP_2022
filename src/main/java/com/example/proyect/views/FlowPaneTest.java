package com.example.proyect.views;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneTest extends Stage {
    private Scene scene;
    private FlowPane flow;
    private Button btn1, btn2, btn3;

    public FlowPaneTest(){
        CrearUI();
        this.setTitle("FlowPane");
        this.setScene(scene);
        this.show();

    }

    private void CrearUI() {
        //Si cambiamos la orientacion a "HORIZONTAL" el pane nos daria un resultado horizontal
        flow = new FlowPane(Orientation.VERTICAL);
        btn1 = new Button("button 1");
        btn2 = new Button("button 2");
        btn3 = new Button("button 3");
        flow.setVgap(10);

        flow.getChildren().addAll(btn1,btn2,btn3);

        scene = new Scene(flow);

    }
}
