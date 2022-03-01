package com.example.proyect.views;

import com.example.proyect.events.EventoLoteria;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Loteria extends Stage implements EventHandler {

    private VBox vBox;
    private HBox hBox1, hBox2;
    private Button btnAnt, btnSig, btnJugar;
    private Label lblTiempo;
    private GridPane gdpPlantilla;

    private Image imgCarta;

    private Scene escena;

    private String[] arImagenes = {"barril.jpeg", "chavorruco.jpeg","luchador.jpeg","tacos.jpeg","tacos.jpeg"};
    private Button[][] arBtnPlantilla = new Button[4][2];

    private Image imgCartaP;
    private ImageView imv;

    public Loteria(){
        CrearUI();
        this.setTitle("Loteria");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        //Area de selección de plantilla
        btnAnt=new Button("atras");
        btnAnt.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoLoteria());
        btnAnt.setPrefWidth(100);
        btnSig = new Button("Siguiente");
        btnSig.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Evento desde un objeto anónimo :)");
            }
        });
        btnSig.setPrefWidth(100);
        lblTiempo = new Label("00:00");
        hBox1 = new HBox();
        hBox1.setSpacing(5);
        hBox1.getChildren().addAll(btnAnt,btnSig,lblTiempo);

        //hBox1.setPadding(new Insets(15));

        gdpPlantilla = new GridPane();
        CrearPlantilla();

        //imgCarta = new Image("");

        hBox2 = new HBox();
        hBox2.getChildren().addAll(gdpPlantilla);

        btnJugar = new Button("Jugar");
        btnJugar.setPrefWidth(250);
        btnJugar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

        vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(hBox1,hBox2,btnJugar);

        escena = new Scene(vBox, 550, 800);

    }

    private void CrearPlantilla() {
        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 4; j++) {
                arBtnPlantilla[j][i] = new Button();

                imgCartaP = new Image("D:\\proyect\\src\\main\\java\\com\\example\\proyect\\images\\barril.jpeg");
                imv = new ImageView(imgCartaP);
                imv.setFitWidth(75);
                imv.setFitHeight(150);
                arBtnPlantilla[j][i].setGraphic(imv);
                gdpPlantilla.add(arBtnPlantilla[j][i],i,j);

                gdpPlantilla.setHgap(5);
                gdpPlantilla.setVgap(5);

            }
        }
    }

    @Override
    public void handle(Event event) {
        System.out.println("Mi primer evento FoviFest :)");
    }
}
