/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.beans;

//import sv.com.hmcr.dominio.beans*;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TablaLocation  
{
    private String user;
    private String nombreLocation;
     private String supervisadoPor;
   public String getNombre() {
      return nombreLocation;
   }
   public void setNombre(String nombreLocation) {
      this.nombreLocation = nombreLocation;
   }
  public String getAgente() {
      return user;
   }
   public void setAgente(String user) {
      this.user = user;
   }
  public String getSupervisadoPor() {
      return supervisadoPor;
   }
   public void setSupervisadoPor(String supervisadoPor) {
      this.supervisadoPor = supervisadoPor;
   }

}
