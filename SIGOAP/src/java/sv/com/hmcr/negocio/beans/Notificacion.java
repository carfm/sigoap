/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

import sv.com.hmcr.dominio.*;

@ManagedBean
public class Notificacion  
{
     private ResultSet resultado;
    private Statement sentencia;
    private Connection conexion;
    String Conexion = "jdbc:mysql://localhost:3306/pruebadsi?user=root";
    String Driver1 = "com.mysql.jdbc.Driver";
   private LinkedList<TablaNotificacion> datos=null;

   public Notificacion() {
      
      int y=0;
        datos = new LinkedList<TablaNotificacion>();
        try {
            Class.forName(Driver1).newInstance();
            conexion = DriverManager.getConnection(Conexion);
            sentencia = conexion.createStatement();
             resultado = sentencia.executeQuery("select a.fecha,u.nombre,u.apellido,b.advertencia from mensaje a,gestiona b,gestiona c,usuario u where a.idMensaje=b.idMensaje\n" +
"and b.idMensaje=c.idMensaje and c.visto='"+y+"' and u.user=b.user");
        
 while (resultado.next()) {
 String fecha = resultado.getString("fecha");
 String nombre = resultado.getString("nombre");
  String apellido = resultado.getString("apellido");
  
  int i = resultado.getInt("advertencia");
 //String str = rs.getString("username");
  String ad;
if(i==0)
{ ad="SI";
}
else
{  ad="NO";
}
String agente=nombre+" "+apellido; 
  //Assuming you have a user object
  TablaNotificacion tabla= new TablaNotificacion();
tabla.setFecha(fecha);
tabla.setAgente(agente);
tabla.setAdvertencia(ad);
//ll.add(user);
datos.add(tabla);

}          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 1 " + e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error 2 " + e.getMessage());
        } catch (InstantiationException e) {
            JOptionPane.showMessageDialog(null, "Error 3 " + e.getMessage());
        } catch (IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Error 3 " + e.getMessage());
        }
        //JOptionPane.showMessageDialog(null, "no retorna nada ");
   
   }

   public LinkedList<TablaNotificacion> getDatos() {
      return datos;
   }
   public void setDatos(LinkedList<TablaNotificacion> datos) {
      this.datos = datos;
   }
 

}
