package com.example.proyect;

import com.example.proyect.views.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
    private MenuItem mitLoteria, mitBuscaminas,mitParseador;


    @Override
    public void start(Stage stage) throws IOException {

        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));*/
        mnbMenu = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        mitLoteria = new MenuItem("Loteria");
        mitLoteria.setOnAction(actionEvent -> eventoLoteria(1));

        mitBuscaminas = new MenuItem("Buscaminas");
        mitBuscaminas.setOnAction(actionEvent -> eventoLoteria(3));



        mitParseador = new MenuItem("Código Morse");
        mitParseador.setOnAction(event->eventoLoteria(2));

        menCompetencia1.getItems().addAll(mitLoteria,mitParseador,mitBuscaminas);

        menCompetencia2 = new Menu("Competencia 2");
        mnbMenu.getMenus().addAll(menCompetencia1, menCompetencia2);

        vBox = new VBox();
        vBox.getChildren().addAll(mnbMenu);

        PrimaryStage = new Scene(vBox);
        stage.setTitle("Hello World");
        stage.setScene(PrimaryStage);
        stage.setMaximized(true);
        stage.show();



        //new Loteria();


        //Paneles();

    }

    private void Paneles(){
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
            case 2: new Parseador();
            break;

        }
    }


    public static void main(String[] args) {
        launch();


    }
}