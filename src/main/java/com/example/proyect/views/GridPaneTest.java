package com.example.proyect.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneTest extends Stage {
    private Scene scene;
    private GridPane grid;

    public GridPaneTest(){
        CrearUI();
        this.setTitle("GridPane");
        this.setScene(scene);
        this.show();

    }

    private void CrearUI() {
        grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Button("Posición 0,0"),0,0);
        grid.add(new Button("Posición 0,0"),1,0);
        grid.add(new Button("Posición 0,0"),0,1);
        grid.add(new Button("Posición 0,0"),1,1);
        grid.add(new Button("Posición 0,0"),0,2);
        grid.add(new Button("Posición 0,0"),2,0);
        grid.add(new Button("Posición 0,0"),1,2);

        grid.add(new Button("Posicion 9,2"), 9, 2);

        scene = new Scene(grid);


    }

}
