package modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Set;

public class Servicios {
    
    private float costo;
    private String servicio;
    private int id_servicio, id_casa, num_mes;
    private String descripcion, pservicio;

    public Servicios() {
    }

    public Servicios(float costo, String servicio, int id_servicio, int id_casa, int num_mes, String descripcion, String pservicio) {
        this.costo = costo;
        this.servicio = servicio;
        this.id_servicio = id_servicio;
        this.id_casa = id_casa;
        this.num_mes = num_mes;
        this.descripcion = descripcion;
        this.pservicio = pservicio;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public int getNum_mes() {
        return num_mes;
    }

    public void setNum_mes(int num_mes) {
        this.num_mes = num_mes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPservicio() {
        return pservicio;
    }

    public void setPservicio(String pservicio) {
        this.pservicio = pservicio;
    }
    
    public int pagoServicios(){
        
        try {
            Conexion con = new Conexion();
            CallableStatement agregar = con.Conexion().prepareCall(
                    "{?= CALL pago_servicios(?,?,?,?)}");
            agregar.registerOutParameter(1, Types.INTEGER);
            agregar.setInt(2, getId_servicio());
            agregar.setInt(3, getId_casa());
            agregar.setInt(4, getNum_mes());
            agregar.setString(5, getDescripcion());
            System.out.println(getId_servicio() + " " + getId_casa() + getNum_mes() + getDescripcion());
            agregar.execute();
            return agregar.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}