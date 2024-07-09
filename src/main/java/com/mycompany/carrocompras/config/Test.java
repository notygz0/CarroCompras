package com.mycompany.carrocompras.config;

public class Test {
    public static void main(String[] args){
        if (Conexion.getConnection() != null) {
            System.out.println("Conexión exitosa");
        } else {
            System.out.println("Error en la conexión");
        }
    }
}
