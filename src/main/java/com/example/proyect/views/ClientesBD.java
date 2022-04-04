package com.example.proyect.views;

import com.example.proyect.models.clientesDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientesBD extends Stage{
    //Crean los elementos
    private Scene escena;
    private TableView<clientesDAO> tbvClientes;
    private Button btnGuardar,btnAgregar;
    private VBox vBox;
    private clientesDAO cteDAO;

    public ClientesBD(){
        cteDAO = new clientesDAO();
        CrearUI();
        this.setTitle("Crear Taqueria: ");
        this.setScene(escena);
        this.show();

    }

    private void CrearUI() {
        tbvClientes = new TableView<>();
        btnAgregar = new Button("Agregar Cliente");
        btnAgregar.setOnAction(event -> {});
        vBox = new VBox();
        vBox.getChildren().addAll(tbvClientes,btnAgregar);
        
        escena = new Scene(vBox,700,200);
        
        CrearTabla();
    }

    private void CrearTabla() {
        TableColumn<clientesDAO,Integer> tbcIdCliente = new TableColumn<>("ID");
        tbcIdCliente.setCellValueFactory(new PropertyValueFactory<>("cvecte"));

        TableColumn<clientesDAO,String> tbcNomCliente = new TableColumn<>("NOMBRE");
        tbcNomCliente.setCellValueFactory(new PropertyValueFactory<>("nomcte"));

        TableColumn<clientesDAO,String> tbcTelCliente = new TableColumn<>("TELEFONO");
        tbcTelCliente.setCellValueFactory(new PropertyValueFactory<>("telcte"));

        TableColumn<clientesDAO,String> tbcDirliente = new TableColumn<>("DIRECCION");
        tbcDirliente.setCellValueFactory(new PropertyValueFactory<>("dircte"));



        tbvClientes.getColumns().addAll(tbcIdCliente,tbcNomCliente,tbcTelCliente,tbcDirliente);
         tbvClientes.setItems(cteDAO.SELECCIONAR());

    }
}
