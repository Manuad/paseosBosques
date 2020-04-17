package modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class Usuario {

    Conexion con = new Conexion();
    
    private long idu;
    private String nombres, apellidos, curp, contra;
    private Date fecha_alta;

    public Usuario() {
    }

    public Usuario(long idu, String nombres, String apellidos, String curp, String contra, Date fecha_alta) {
        this.idu = idu;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.curp = curp;
        this.contra = contra;
        this.fecha_alta = fecha_alta;
    }

    public long getIdu() {
        return idu;
    }

    public void setIdu(long idu) {
        this.idu = idu;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    /*
    Este método se crea de tipo entero para poder recibir de alguna manera el
    dato que envía la función creada en la base de datos y no marque ningun error
    a la hora de realizar la consulta desde JAVA
     */
    
    public int insertaUsuario() {

        try {
            Usuario u = new Usuario();
            CallableStatement insert = con.Conexion().prepareCall(
                    "{?= CALL insertusuario(?,?,?,?)}");
            insert.registerOutParameter(1, Types.INTEGER);
            insert.setString(2, getNombres());
            insert.setString(3, getApellidos());
            insert.setString(4, getCurp());
            insert.setString(5, getContra());
            System.out.println(getNombres() + getApellidos() + getCurp() + getContra());
            insert.execute();
            return insert.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Usuario> obtenerUsuario() {

        ArrayList<Usuario> ListUsuarios = new ArrayList<>();
        try {

            final String SQL = "SELECT *  FROM usuario";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario us = new Usuario();
                us.setNombres(rs.getString("nombres"));
                us.setApellidos(rs.getString("apellidos"));
                us.setCurp(rs.getString("curp"));
                us.setFecha_alta(rs.getDate("fecha_alta"));
                us.setIdu(rs.getInt("id_usuario"));
                ListUsuarios.add(us);
                System.out.println(ListUsuarios);
            }
            return ListUsuarios;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListUsuarios;
    }

    public ArrayList<Usuario> obtenerUsuario2() {

        ArrayList<Usuario> ListUsuarios = new ArrayList<>();
        try {
            final String SQL = "SELECT * FROM usuario WHERE id_usuario=?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setLong(1, getIdu());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario us = new Usuario();
                us.setNombres(rs.getString("nombres"));
                us.setApellidos(rs.getString("apellidos"));
                us.setCurp(rs.getString("curp"));
                us.setFecha_alta(rs.getDate("fecha_alta"));
                us.setIdu(rs.getInt("id_usuario"));
                ListUsuarios.add(us);
                System.out.println(ListUsuarios);
            }
            return ListUsuarios;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListUsuarios;
    }

    public void actualizarUsuario() {
        
        try {
            final String SQL = "UPDATE usuario SET nombres = ?, apellidos =?, "
                    + "curp =?, password =? , fecha_alta = NOW() WHERE id_usuario=?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setString(1, getNombres());
            ps.setString(2, getApellidos());
            ps.setString(3, getCurp());
            ps.setString(4, getContra());
            ps.setInt(5, (int) getIdu());
            ps.executeUpdate();
            //El resultset sirve para realizar consultas a diferencia del 
            //execute, este sirve para hacer actualizaciones o incerciones
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario() {

        try {
            final String SQL = "DELETE FROM usuarios WHERE curp = ?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setString(1, curp);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int loginUsuarios() {

        int o = 0;
        try {
            final String SQL = "SELECT COUNT(nombres) AS entrada FROM usuario WHERE "
                    + "nombres =? AND password =?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setString(1, getNombres());
            ps.setString(2, getContra());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                o = rs.getInt("entrada");
            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
}
