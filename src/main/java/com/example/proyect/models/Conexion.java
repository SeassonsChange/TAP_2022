package com.example.proyect.models;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    //Datos de entrada del usuario
    private static String server = "127.0.0.1";
    private static String user = "patron";
    private static String pwd = "123456";
    private static String bd = "taqueriadb";

    //para recuperar los datos de la conexión
    public static Connection conexion;


    //metodo de conexión hacia la base de datos
    public static void crearConexion(){
        //recurso externo debe ser monitoreado por un try catch
        //tambien al leer un archivo se aplica un try catch
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //cadena de conexión
            conexion = DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+bd,user,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
