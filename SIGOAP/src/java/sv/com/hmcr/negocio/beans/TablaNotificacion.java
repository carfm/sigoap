/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

//import sv.com.hmcr.dominio.beans*;
import javax.faces.bean.ManagedBean;
/**
 *
 * bean muy sencillo, debe tener la anotacion ManagedBean y ademas SessionScoped para poder enviar parametros
 * ademas debe implementar Serializable
 * debe tener los siguientes atributos: una lista para guardar la data de la tabla temporal,
 * el dao TablasTempDAO; deben crear sus propios metodos en dicho dao
 * String de encabezado del reporte, y los atributos correspondientes a los parametros
 * todos deben tener metodos get y set y un constructor sin parametros, 
 */
@ManagedBean
public class TablaNotificacion  
{
    private String fecha;
    private String agente;
     private String advertencia;
     
   public String getFecha() {
      return fecha;
   }
   public void setFecha(String fecha) {
      this.fecha = fecha;
   }
  public String getAgente() {
      return agente;
   }
   public void setAgente(String agente) {
      this.agente = agente;
   }
  public String getAdvertencia() {
      return advertencia;
   }
   public void setAdvertencia(String advertencia) {
      this.advertencia = advertencia;
   }

}
