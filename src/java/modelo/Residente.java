package modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

public class Residente {

    Conexion con = new Conexion();
    private int id_residente, tipo_residente, id_casa;
    private String nombre, apellidos, curp;

    public Residente() {
    }

    public Residente(int id_residente, int tipo_residente, int id_casa, String nombre, String apellidos, String curp) {
        this.id_residente = id_residente;
        this.tipo_residente = tipo_residente;
        this.id_casa = id_casa;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
    }

    public long getId_residente() {
        return id_residente;
    }

    public void setId_residente(int id_residente) {
        this.id_residente = id_residente;
    }

    public long getTipo_residente() {
        return tipo_residente;
    }

    public void setTipo_residente(int tipo_residente) {
        this.tipo_residente = tipo_residente;
    }

    public long getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int insertaResidente() {

        try {
            
            CallableStatement agregar = con.Conexion().prepareCall("{?= CALL insertaresidente(?,?,?,?,?)}");
            agregar.registerOutParameter(1, Types.INTEGER);
            agregar.setInt(2, (int) getTipo_residente());
            agregar.setInt(3, (int) getId_casa());
            agregar.setString(4, getNombre());
            agregar.setString(5, getApellidos());
            agregar.setString(6, getCurp());
            System.out.println(getTipo_residente() + "" + getId_casa() + getNombre() + getApellidos() + getCurp());
            agregar.execute();
            return agregar.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Residente> obtenerResidente() {

        ArrayList<Residente> ListResidente = new ArrayList();
        try {
            final String SQL = "SELECT * FROM residente WHERE id_casa = ?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setLong(1, id_casa);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Residente res = new Residente();
                res.setNombre(rs.getString("nombres"));
                res.setApellidos(rs.getString("apellidos"));
                res.setCurp(rs.getString("curp"));
                ListResidente.add(res);
            }
            return ListResidente;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListResidente;
    }
    
    public void actualizarResidente(){
        
        try {
            final String SQL = "UDPATE residente SET  WHERE curp = ?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setInt(1, (int)getTipo_residente());
            ps.setInt(2, (int)getId_casa());
            ps.setString(3, getNombre());
            ps.setString(4, getApellidos());
            ps.setString(5, getCurp());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
