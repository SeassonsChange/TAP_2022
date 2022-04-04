package com.example.proyect.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clientesDAO {

    //declaración de los atributos de nuestra tabla en la bd
    private int cvecte;
    private String nomcte;
    private String telcte;
    private String dircte;


    //Declaración de los metodos get y set de los atributos
    public int getCvecte() {
        return cvecte;
    }

    public void setCvecte(int cvecte) {
        this.cvecte = cvecte;
    }

    public String getNomcte() {
        return nomcte;
    }

    public void setNomcte(String nomcte) {
        this.nomcte = nomcte;
    }

    public String getTelcte() {
        return telcte;
    }

    public void setTelcte(String telcte) {
        this.telcte = telcte;
    }

    public String getDircte() {
        return dircte;
    }

    public void setDircte(String dircte) {
        this.dircte = dircte;
    }

    public void INSERTAR(){
        String query = "insert into tblclientes (nomcte,telcte,dircte) " +
                "values('"+this.nomcte+"','"+telcte+"','"+dircte+"') ";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void ACTUALIZAR(){
        String query = "update tblclientes set nombre='"+this.nomcte+"', telcte = '"+this.telcte+"', " +
            "dircte = '"+this.dircte+"' where cvecte = "+this.cvecte;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ELIMINAR(){
        String query = "delete from tblclientes where cvecte ="+this.cvecte;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Seleccionar todos los registros
    public ObservableList<clientesDAO> SELECCIONAR(){

        ObservableList<clientesDAO> listaC = FXCollections.observableArrayList();

        clientesDAO objC;
        String query = "select * from tblclientes order by nomcte "; //agregar "desc" para que ordene de manera descendiente
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next()){
                objC = new clientesDAO();
                objC.setCvecte(res.getInt("cvecte"));
                objC.setNomcte(res.getString("nomcte"));
                objC.setTelcte(res.getString("telcte"));
                objC.setDircte(res.getString("dircte"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;
    }


    public void SELECCIONARBYID(){
        String query = "select from tblclientes";
    }

}