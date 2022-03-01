package com.example.proyect;

import com.example.proyect.views.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {

    private Scene PrimaryStage;

    private VBox vBox;
    private MenuBar mnbMenu;
    private Menu menCompetencia1;
    private Menu menCompetencia2;
    private MenuItem mitLoteria, mitBuscaminas;


    @Override
    public void start(Stage stage) throws IOException {

        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));*/
        mnbMenu = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        mitLoteria = new MenuItem("Loteria");
        mitLoteria.setOnAction(actionEvent -> eventoLoteria(1));

        mitBuscaminas = new MenuItem("Buscaminas");
        mitBuscaminas.setOnAction(actionEvent -> eventoLoteria(2));


        menCompetencia1.getItems().addAll(mitLoteria);

        menCompetencia2 = new Menu("Competencia 2");
        mnbMenu.getMenus().addAll(menCompetencia1, menCompetencia2);

        vBox = new VBox();
        vBox.getChildren().addAll(mnbMenu);

        Group root = new Group();
        PrimaryStage = new Scene(vBox);
        stage.setTitle("Hello World");
        stage.setScene(PrimaryStage);
        stage.setMaximized(true);
        stage.show();



        new Loteria();
        //new BorderPaneTest();
        //new FlowPaneTest();
        //new GridPaneTest();
        //new StackPaneTest();
        //new TilePaneTest();
        //new AnchorPaneTest();
    }

    private void eventoLoteria(int opc) {
        switch (opc){
            case 1: new Loteria()   ;
            break;

        }
    }


    public static void main(String[] args) {
        launch();


    }
}