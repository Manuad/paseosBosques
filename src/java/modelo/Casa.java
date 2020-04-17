package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Casa {
    
    private long id_casa;
    private String direccion, telefono;

    public Casa() {
    }

    public Casa(long id_casa, String direccion, String telefono) {
        this.id_casa = id_casa;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getId_casa() {
        return id_casa;
    }

    public void setId_casa(long id_casa) {
        this.id_casa = id_casa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public ArrayList<Integer> obtenerCasas() {

        ArrayList<Integer> ListResidentes = new ArrayList<>();
        Conexion con = new Conexion();

        try {
            final String SQL = "SELECT id_casa FROM casa";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ListResidentes.add(rs.getInt("id_casa"));
            }
            return ListResidentes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
