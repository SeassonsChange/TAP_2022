package com.example.proyect.views;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class Loteria extends Stage implements EventHandler {

    private VBox vBox;
    private HBox hBox1, hBox2;
    private Button btnAnt, btnSig, btnJugar, btnCarta;
    private Label lblTiempo;
    private Label lblCartaFalt;
    private GridPane gdpPlantilla;
    private BorderPane brpCarta;
    private Image imgCarta;
    private ImageView imvCarta;
    private Image imgBorradoTemp;
    private ImageView imvBorrado;
    Timeline animacion = new Timeline();
    private int n;
    private int vectoraux = 0;
    int cont = 0;
    int control = 0;
    private Scene escena;
    private String[][] arImagenes2 = {{"bandolon.jpg", "barril.jpeg", "botella.jpeg", "campana.jpg", "catrin.jpeg", "chalupa.jpg", "chavorruco.jpeg", "concha.jpeg", "corazon.jpg", "corona.jpg", "cotorro.jpg", "estrella.jpg", "graduada.jpeg", "luchador.jpeg", "maceta.jpeg", "negro.jpg"},
            {"venado.jpeg", "valiente.jpg", "tambor.jpg", "tacos.jpeg", "soldado.jpg", "sandia.jpg", "rosa.jpeg", "rana.jpg", "pescado.jpg", "negro.jpg", "maceta.jpeg", "luchador.jpeg", "graduada.jpeg", "estrella.jpg", "cotorro.jpg", "corona.jpg"}, {"corazon.jpg", "concha.jpeg", "chavorruco.jpeg", "chalupa.jpg", "catrin.jpeg", "campana.jpg", "botella.jpeg", "barril.jpeg", "bandolon.jpg", "venado.jpeg", "valiente.jpg", "tambor.jpg", "tacos.jpeg", "soldado.jpg", "sandia.jpg", "rosa.jpeg"},
            {"rana.jpg", "pescado.jpg", "negro.jpg", "maceta.jpeg", "luchador.jpeg", "graduada.jpeg", "estrella.jpg", "cotorro.jpg", "corona.jpg", "corazon.jpg", "concha.jpeg", "chavorruco.jpeg", "chalupa.jpg", "catrin.jpeg", "campana.jpg", "botella.jpeg"}, {"barril.jpeg", "bandolon.jpg", "venado.jpeg", "valiente.jpg", "tambor.jpg", "tacos.jpeg", "soldado.jpg", "sandia.jpg", "rosa.jpeg", "rana.jpg", "pescado.jpg", "negro.jpg", "maceta.jpeg", "luchador.jpeg", "graduada.jpeg", "estrella.jpg"}};
    private String[] arImages = new String[]{"bandolon.jpg", "barril.jpeg", "botella.jpeg", "campana.jpg", "catrin.jpeg", "chalupa.jpg", "chavorruco.jpeg", "concha.jpeg", "corazon.jpg", "corona.jpg", "cotorro.jpg", "estrella.jpg", "graduada.jpeg", "luchador.jpeg", "maceta.jpeg", "negro.jpg", "pescado.jpg", "rana.jpg", "rosa.jpeg", "sandia.jpg", "soldado.jpg", "tacos.jpeg", "tambor.jpg", "valiente.jpg", "venado.jpeg"};
    private Button[][] arBtnPlantilla = new Button[4][4];
    private Image imgCartaP;
    private ImageView imv;
    private ImageView imgJ;
    private int CartasFaltantes = 16;
    int[] cartas;
    private Timer tmRegresivo;
    private TimerTask tmtTarea;

    public Loteria(){
        cartas = new int[arImages.length];
        CrearUI();
        setTitle("Loteria");
        setScene(escena);
        show();
    }

    private void CrearUI() {
        //Area de selección de plantilla
        btnAnt=new Button("atras");
        btnAnt.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (cont > 0 ){
                    cont--;
                    CrearPlantilla(cont);
                }else{
                    cont = 4;
                    CrearPlantilla(cont);
                }
            }
        });
        btnAnt.setPrefWidth(250);
        btnSig = new Button("Siguiente");
        btnSig.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("Evento desde un objeto anónimo :)");
                if (cont < 4) {
                    cont++;
                    CrearPlantilla(cont);
                } else {
                    cont = 0;
                    CrearPlantilla(cont);
                }
            }
        });
        btnSig.setPrefWidth(250);
        lblTiempo = new Label("Tiempo:");
        lblCartaFalt = new Label();
        String cartaF = "";
        cartaF = cartaF + CartasFaltantes;
        lblCartaFalt.setText("Cartas Faltantes: "+ cartaF);
        hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.getChildren().addAll(btnAnt,lblTiempo,btnSig,lblCartaFalt);

        tmRegresivo = new Timer();

        //hBox1.setPadding(new Insets(15));

        gdpPlantilla = new GridPane();
        PlantillaInicio();

        btnCarta = new Button();
        imgCarta = new Image("D:\\proyect\\src\\main\\java\\com\\example\\proyect\\images\\dorso.jpg");
        imvCarta = new ImageView(imgCarta);
        imvCarta.setFitWidth(540); //360
        imvCarta.setFitHeight(960); //640
        btnCarta.setGraphic(imvCarta);

        brpCarta = new BorderPane(btnCarta);
        brpCarta.setCenter(btnCarta);

        btnJugar = new Button("Jugar");
        btnJugar.setPrefWidth(580);
        btnJugar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

        hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(gdpPlantilla,brpCarta,btnJugar);

        vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(hBox1,hBox2);

        arBtnPlantilla[0][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 0, 0);
            }
        });
        arBtnPlantilla[0][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                control(n, 0, 1);
            }
        });
        arBtnPlantilla[0][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 0, 2);
            }
        });
        arBtnPlantilla[0][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 0, 3);
            }
        });
        arBtnPlantilla[1][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 1, 0);
            }
        });
        arBtnPlantilla[1][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 1, 1);
            }
        });
        arBtnPlantilla[1][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 1, 2);
            }
        });
        arBtnPlantilla[1][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 1, 3);
            }
        });
        arBtnPlantilla[2][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 2, 0);
            }
        });
        arBtnPlantilla[2][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 2, 1);
            }
        });
        arBtnPlantilla[2][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 2, 2);
            }
        });
        arBtnPlantilla[2][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 2, 3);
            }
        });
        arBtnPlantilla[3][0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 3, 0);
            }
        });
        arBtnPlantilla[3][1].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 3, 1);
            }
        });
        arBtnPlantilla[3][2].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 3, 2);
            }
        });
        arBtnPlantilla[3][3].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                control(n, 3, 3);
            }
        });

        escena = new Scene(vBox, 550, 800);

    }

    private void control(int n, int reg, int col) {
        int aux = 0;
        for (int i = 0; i < arBtnPlantilla.length; i++) {
            for (int j = 0; j <arBtnPlantilla[0].length; j++) {
                if (i == reg && j == col){
                    if (arImages[n].equalsIgnoreCase(arImagenes2[cont][aux])) {
                        CartasFaltantes--;
                        String cartaF = "";
                        cartaF = cartaF + CartasFaltantes;
                        lblCartaFalt.setText(cartaF);
                        BorraCarta(i, j);
                        NuevaTarjeta();
                        animacion.playFromStart();
                    }
                }
                aux++;
                System.out.println("Aux: "+aux);
            }
        }
    }

    private void BorraCarta(int cont, int aux) {
        imgBorradoTemp = new Image("D:\\proyect\\src\\main\\java\\com\\example\\proyect\\images\\dorso.jpg");
        imvBorrado = new ImageView(imgBorradoTemp);
        imvBorrado.setFitHeight(230);
        imvBorrado.setFitWidth(125);
        arBtnPlantilla[cont][aux].setGraphic(imvBorrado);
        arBtnPlantilla[cont][aux].setDisable(true);

    }

    private void PlantillaInicio() {
        int carta = 0;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                arBtnPlantilla[i][j] = new Button();
                imgCartaP = new Image("D:\\proyect\\src\\main\\java\\com\\example\\proyect\\images\\" + arImagenes2[0][carta]);
                imv = new ImageView(imgCartaP);
                imv.setFitWidth(125);
                imv.setFitHeight(230);
                arBtnPlantilla[i][j].setGraphic(imv);
                gdpPlantilla.add(arBtnPlantilla[i][j], j, i);
                carta++;
                gdpPlantilla.setHgap(5);
                gdpPlantilla.setVgap(5);
            }
        }
    }


    private void CrearPlantilla(int pos) {
        int carta = 0;


            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    //arBtnPlantilla[j][i] = new Button();

                    imgCartaP = new Image("D:\\proyect\\src\\main\\java\\com\\example\\proyect\\images\\"+this.arImagenes2[pos][carta]);
                    imv = new ImageView(imgCartaP);
                    imv.setFitWidth(125);
                    imv.setFitHeight(230);
                    arBtnPlantilla[j][i].setGraphic(imv);
                    //gdpPlantilla.add(arBtnPlantilla[j][i], i, j);
                    carta++;

                    gdpPlantilla.setHgap(5);
                    gdpPlantilla.setVgap(5);


                }
            }

            //Imagen enorme que cambia con un timer
        }





    @Override
    public void handle(Event event) {
        btnSig.setDisable(true);
        btnAnt.setDisable(true);

        int[] v_tiempo = {10};
        tmRegresivo = new Timer();
        tmtTarea = new TimerTask() {
            @Override
            public void run() {
                if (v_tiempo[0]>0){
                    int conserva = v_tiempo[0];
                    Platform.runLater(() -> lblTiempo.setText("00:"+conserva));
                    v_tiempo[0]++;

                }else{

                    v_tiempo[0] = 0;

                }
                tmRegresivo.scheduleAtFixedRate(tmtTarea,1000,1000);
                NuevaTarjeta();
                animacion = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Entro Animacion");
                        NuevaTarjeta();

                        if(CartasFaltantes == 0){
                            System.out.println("animacion stop");
                            animacion.stop();
                        }

                        if (vectoraux == 25){
                            System.out.println("animacion stop");
                            animacion.stop();
                        }

                    }
                }));
                animacion.setCycleCount(Timeline.INDEFINITE);
                animacion.play();


            }
        };

       // tmRegresivo.scheduleAtFixedRate(tmtTarea,1000,1000);

        //System.out.println("Mi primer evento FoviFest :)");
    }

    public void NuevaTarjeta(){
        boolean opc;
        /*System.out.println("Nueva Tarjeta Entro");
        n = (int)(Math.random()* 24 + 0);
        System.out.println("Aleatorio : "+n);
        imgCarta = new Image("D:\\proyect\\src\\main\\java\\com\\example\\proyect\\images\\"+arImages[n]);
        imgJ = new ImageView(imgCarta);
        imgJ.setFitWidth(540);
        imgJ.setFitHeight(960);
        btnCarta.setGraphic(imgJ);*/
        do{
            n = (int)(Math.random()* 24 + 0);
            opc = verificar(cartas,n,control);
            if (n == 0 && control==0){
                control++;
            }
            if (opc == true){
                System.out.println("ok verificar");
                cartas[vectoraux] = n;
                vectoraux++;
                imgCarta = new Image("D:\\proyect\\src\\main\\java\\com\\example\\proyect\\images\\"+arImages[n]);
                imgJ = new ImageView(imgCarta);
                imgJ.setFitWidth(540);
                imgJ.setFitHeight(960);
                btnCarta.setGraphic(imgJ);
            }

        }while(opc!=true);
        imprimirVec(cartas);
    }

    private void imprimirVec(int[] cartas) {
        for (int i = 0; i < cartas.length; i++) {
            System.out.println(cartas[i]);
        }

    }

    private boolean verificar(int[] cartas, int n, int control) {
        for(int i = 0; i < cartas.length;i++){
            if(n == 0 && control == 0){
                control++;
                return  true;
            }

            if (cartas[i] == n){
                return false;
            }
        }

        return false;
    }
}
