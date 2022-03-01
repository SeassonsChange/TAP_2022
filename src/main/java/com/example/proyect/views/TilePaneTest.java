package com.example.proyect.views;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneTest extends Stage {
    private TilePane tile;
    private Scene scene;

    public TilePaneTest(){
        CrearUI();
        this.setTitle("TilePane");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        tile = new TilePane(Orientation.VERTICAL);
        tile.setPrefColumns(6);
        tile.setPrefRows(4);

        for (int i = 0; i < 20; i++){
            tile.getChildren().add(new Button("button"+i));

        }

        scene = new Scene(tile);

    }
}
