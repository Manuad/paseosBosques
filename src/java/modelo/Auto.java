package modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

public class Auto {
    
    private long id_auto, id_casa;
    private String placa, folio, tipo;
    Conexion con = new Conexion();

    public Auto() {
    }

    public Auto(long id_auto, long id_casa, String placa, String folio, String tipo) {
        this.id_auto = id_auto;
        this.id_casa = id_casa;
        this.placa = placa;
        this.folio = folio;
        this.tipo = tipo;
    }

    public long getId_auto() {
        return id_auto;
    }

    public void setId_auto(long id_auto) {
        this.id_auto = id_auto;
    }

    public long getId_casa() {
        return id_casa;
    }

    public void setId_casa(long id_casa) {
        this.id_casa = id_casa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int insertAuto(){
        
        try {
            CallableStatement agregar = con.Conexion().prepareCall("{?= CALL insertauto(?,?,?,?)}");
            agregar.registerOutParameter(1, Types.INTEGER);
            agregar.setInt(2, (int) getId_casa());
            agregar.setString(3,getPlaca());
            agregar.setString(4, getFolio());
            agregar.setString(5, getTipo());
            agregar.execute();
            return agregar.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }       
    }
    public void updateAuto(){
        
        try {
            final String SQL = "UPDATE automovil SET placa =?, folio =?, tipo =? WHERE id_casa =?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setString(1, getPlaca());
            ps.setString(2, getFolio());
            ps.setString(3, getTipo());
            ps.setLong(4, getId_casa());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Auto> obtenerAuto(){
        
        ArrayList<Auto> ListAuto = new ArrayList<>();
        try {
            
            final String SQL ="SELECT * FROM automovil";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Auto au = new Auto();
                au.setId_casa((int) rs.getInt("id_casa"));
                au.setPlaca(rs.getString("placa"));
                au.setFolio(rs.getString("folio"));
                au.setTipo(rs.getString("tipo"));
                ListAuto.add(au);
                System.out.println(ListAuto);
            }
            return ListAuto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAuto;
    }
    
    public ArrayList<Auto> visualizarAuto(){
        
        ArrayList<Auto> ListAutos = new ArrayList();
        try {
            final String SQL = "SELECT * FROM automovil WHERE id_automovil=?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setLong(1, getId_auto());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Auto a = new Auto();
                a.setId_casa(rs.getLong("id_casa"));
                a.setPlaca(rs.getString("placa"));
                a.setFolio(rs.getString("folio"));
                a.setTipo(rs.getString("tipo"));
                ListAutos.add(a);
                System.out.println(ListAutos);
            }
            return ListAutos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAutos;
    }
    
    public static void main(String[] args) {
        Auto a = new Auto();
        a.obtenerAuto();
    }
}
