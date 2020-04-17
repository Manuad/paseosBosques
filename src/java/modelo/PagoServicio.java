package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author manue
 */
public class PagoServicio {

    private long id_servicio, id_casa, id_mes;
    private String estadoPago, descripcion;
    private Date fechaPago;

    public PagoServicio() {
    }

    public PagoServicio(long id_servicio, long id_casa, long id_mes, String estadoPago, String descripcion, Date fechaPago) {
        this.id_servicio = id_servicio;
        this.id_casa = id_casa;
        this.id_mes = id_mes;
        this.estadoPago = estadoPago;
        this.descripcion = descripcion;
        this.fechaPago = fechaPago;
    }

    public long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public long getId_casa() {
        return id_casa;
    }

    public void setId_casa(long id_casa) {
        this.id_casa = id_casa;
    }

    public long getId_mes() {
        return id_mes;
    }

    public void setId_mes(long id_mes) {
        this.id_mes = id_mes;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public ArrayList<PagoServicio> obtenerPagos() {

        ArrayList<PagoServicio> ListPago = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            final String SQL = "SELECT * FROM servicio_pago";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PagoServicio pserv = new PagoServicio();
                pserv.setId_casa(rs.getLong("id_servicio"));
                pserv.setId_casa(rs.getLong("id_casa"));
                pserv.setId_mes(rs.getLong("id_mes"));
                pserv.setDescripcion(rs.getString("descripcion"));
                pserv.setFechaPago(rs.getDate("fecha_pago"));
                ListPago.add(pserv);
            }
            return ListPago;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPago;
    }

    public ArrayList<PagoServicio> pagoCasa() {

        ArrayList<PagoServicio> ListPagoCasa = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            final String SQL = "SELECT * FROM servicio_pago WHERE id_casa = ?";
            PreparedStatement ps = con.Conexion().prepareStatement(SQL);
            ps.setLong(1, id_casa);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                PagoServicio pagoS = new PagoServicio();
                pagoS.setId_servicio(rs.getLong("id_servicio"));
                pagoS.setId_casa(rs.getLong("id_casa"));
                pagoS.setId_mes(rs.getLong("id_mes"));
                pagoS.setDescripcion(rs.getString("descripcion"));
                pagoS.setFechaPago(rs.getDate("fecha_pago"));
                ListPagoCasa.add(pagoS);
            }
            return ListPagoCasa;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPagoCasa;
    }
}
