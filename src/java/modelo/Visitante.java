package modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Types;
import java.util.Date;

public class Visitante {

    Conexion con = new Conexion();
    private long id_casa;
    private String nombres, apellidos;
    private long id_visitante, id_pase_vis;
    private String documento, descripcion;
    private String medio;

    public Visitante() {
    }

    public long getId_pase_vis() {
        return id_pase_vis;
    }

    public void setId_pase_vis(long id_pase_vis) {
        this.id_pase_vis = id_pase_vis;
    }

    public Visitante(long id_casa, String nombres, String apellidos) {
        this.id_casa = id_casa;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Visitante(long id_casa, long id_visitante, String documento, String descripcion, String medio) {
        this.id_casa = id_casa;
        this.id_visitante = id_visitante;
        this.documento = documento;
        this.descripcion = descripcion;
        this.medio = medio;
    }

    public long getId_casa() {
        return id_casa;
    }

    public void setId_casa(long id_casa) {
        this.id_casa = id_casa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(long id_visitante) {
        this.id_visitante = id_visitante;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    public int regsitraVisitante() {

        try {

            CallableStatement insertar = con.Conexion().prepareCall(
                    "{?= CALL insertvisitante(?,?,?)}");
            insertar.registerOutParameter(1, Types.INTEGER);
            insertar.setInt(2, (int) getId_casa());
            insertar.setString(3, getNombres());
            insertar.setString(4, getApellidos());
            System.out.println(getId_casa() + getNombres() + getApellidos());
            insertar.execute();
            return insertar.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int registraPaseVisitante() {

        try {
            CallableStatement agregar = con.Conexion().prepareCall(
                    "{?= CALL altapasevisitante(?,?,?,?)}");
            agregar.registerOutParameter(1, Types.INTEGER);
            agregar.setInt(2, (int) getId_casa());
            agregar.setString(3, getDocumento());
            agregar.setString(4, getDescripcion());
            agregar.setString(5, getMedio());
            agregar.execute();
            return agregar.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void main(String[] args) {

        Visitante vi = new Visitante();
        vi.setId_casa((long) 10112);
        vi.setDocumento("INE");
        vi.setDescripcion("Folio 10101 Entra con cuatro personas");
        vi.setMedio("Mazda 3 Hatchback rojo");
        //vi.registrarPase();
        System.out.println(vi.registraPaseVisitante());
    }

}
