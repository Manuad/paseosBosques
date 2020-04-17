package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;
    String url = "jdbc:postgresql://localhost:5432/bosques";
    String user = "postgres";
    String pass = "Azcm1992";

    public Connection Conexion() {
        
        try {
            
            Class.forName("org.postgresql.Driver");
            return con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
            return con = null;
        }

    }

    public static void main(String[] args) {
        
        Conexion con = new Conexion();
        con.Conexion();
        
    }
}
