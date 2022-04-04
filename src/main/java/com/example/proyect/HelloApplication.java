package com.example.proyect;

import com.example.proyect.models.Conexion;
import com.example.proyect.views.*;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application implements EventHandler{

    private Scene PrimaryStage;

    private VBox vBox;
    private MenuBar mnbMenu;
    private Menu menCompetencia1;
    private Menu menCompetencia2;
    private MenuItem mitLoteria, mitBuscaminas,mitParseador, mitClientes;


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

        mitClientes = new MenuItem("Taqueria");
        mitClientes.setOnAction(event -> eventoLoteria(3));


        menCompetencia1.getItems().addAll(mitLoteria,mitParseador,mitBuscaminas,mitClientes);

        menCompetencia2 = new Menu("Competencia 2");
        mnbMenu.getMenus().addAll(menCompetencia1, menCompetencia2);

        vBox = new VBox();
        vBox.getChildren().addAll(mnbMenu);

        stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Bienvenidos :)");
                alerta.setHeaderText("Mensaje del Sistema :)");
                alerta.setContentText("Manejo de eventos de la ventana usando dialogos");
                alerta.showAndWait();
            }
        });
        stage.addEventHandler(WindowEvent.WINDOW_SHOWING, this);
        PrimaryStage = new Scene(vBox,300,200);
        stage.setTitle("Hello World");
        stage.setScene(PrimaryStage);
        stage.setMaximized(true);
        stage.show();

        //Abrir la conexión de la base de datos de manera global
        Conexion.crearConexion();
        //PrimaryStage.getStylesheets().add(getClass().getResource("CSS/styles.css").toExternalForm());

        File file = new File("CSS/styles.css");


        //PrimaryStage.getStylesheets().add(getClass().getResource("resources/CSS/styles.css").toExternalForm());


        //new Loteria();
        //Paneles();

    }

    private void Paneles(){
        new BorderPaneTest();
        new FlowPaneTest();
        new GridPaneTest();
        new StackPaneTest();
        new TilePaneTest();
        new AnchorPaneTest();
    }

    private void eventoLoteria(int opc) {
        switch (opc){
            case 1: new Loteria()   ;
            break;
            case 2: new Parseador();
            break;
            case 3: new ClientesBD();
            break;
        }
    }


    public static void main(String[] args) {
        launch();


    }

    @Override
    public void handle(Event event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Bienvenidos :)");
        alerta.setHeaderText("Mensade del Sistema :)");
        alerta.setContentText("Manejo de eventos de la ventana usando dialogos");
        alerta.showAndWait();

    }


}