package sv.com.hmcr.negocio.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

@ManagedBean
public class Location {

    private ResultSet resultado;
    private Statement sentencia;
    private Connection conexion;
    String Conexion = "jdbc:mysql://localhost:3306/pruebadsi?user=root&password=grupoESA";
    String Driver1 = "com.mysql.jdbc.Driver";
    private LinkedList<TablaLocation> datos = null;

    public Location() {

        int i = 1;
        String hora = "00:00:00";
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String cadenaFecha = formato.format(fecha);
        datos = new LinkedList<>();
        try {
            Class.forName(Driver1).newInstance();
            conexion = DriverManager.getConnection(Conexion);
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery("select a.user,d.nombrelocation,a.supervisadoPor from usuario a,procesa_audita b,location d,orden o where b.tipoOperacion='" + i + "'and b.horaFin is null and o.specimen=b.specimen and o.codigolocation=d.codigolocation and  b.fecha='" + cadenaFecha + "'");

            while (resultado.next()) {
                String user = resultado.getString("user");
                String nombre = resultado.getString("nombreLocation");
                String supervisor = resultado.getString("supervisadoPor");
 //String str = rs.getString("username");

                //Assuming you have a user object
                TablaLocation tabla = new TablaLocation();
                tabla.setAgente(user);
                tabla.setNombre(nombre);
                tabla.setSupervisadoPor(supervisor);
//ll.add(user);
                datos.add(tabla);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 1 " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error 2 " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Error 3 " + e.getMessage());
        }
        //JOptionPane.showMessageDialog(null, "fecha: "+cadenaFecha);
    }

    public LinkedList<TablaLocation> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<TablaLocation> datos) {
        this.datos = datos;
    }

}
