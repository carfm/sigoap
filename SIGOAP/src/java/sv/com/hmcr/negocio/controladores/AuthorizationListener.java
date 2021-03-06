/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.hmcr.negocio.controladores;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import sv.com.hmcr.dominio.Usuario;

/**
 *
 * @author Carlos y Jose
 */
public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        try {
            FacesContext facesContext = event.getFacesContext();
            String currentPage = facesContext.getViewRoot().getViewId();
            boolean isLoginPage = (currentPage.lastIndexOf("index.xhtml") > -1);
            Object usuario = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
            if (!isLoginPage && usuario == null) {
                NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                nh.handleNavigation(facesContext, null, "/index.xhtml");
            } else {
                if (usuario == null) {
                    //System.out.println("Usuario nulo");
                } else {
                    Usuario u = (Usuario) usuario;
                    int tipo = u.getIdtipousuario().getIdtipousuario();
                    boolean Permiso = true;
                    switch (tipo) {
                        case 1://
                            Permiso = ((currentPage.lastIndexOf("menu_supervisor.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("crearOrdenesProcNuevos.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("OrdenesProcesadasNuevos.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("crearComparativo.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("Comparativo.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("crearTiempoPromedio.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("tiempoPromedio.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("crearRazonesEnvio.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("razonesEnvio.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("location.xhtml") > -1)
                                    || ((currentPage.lastIndexOf("primer_ingreso.xhtml") > -1)));
                            break;
                        case 2:
                            Permiso = (currentPage.lastIndexOf("menu_gerente.xhtml") > -1)
                                    || (currentPage.lastIndexOf("crearAnalisisEficiencia.xhtml") > -1)
                                    || (currentPage.lastIndexOf("AnalisisEficiencia.xhtml") > -1)
                                    || (currentPage.lastIndexOf("crearOrdenesAuditadas.xhtml") > -1)
                                    || (currentPage.lastIndexOf("OrdenesAuditadas.xhtml") > -1)
                                    || (currentPage.lastIndexOf("EstadisticasAgente.xhtml") > -1)
                                    || (currentPage.lastIndexOf("crearEstadisticas.xhtml") > -1)
                                    || (currentPage.lastIndexOf("ErrorEncontrado.xhtml") > -1)
                                    || (currentPage.lastIndexOf("crearErrorEncontrado.xhtml") > -1)
                                    || (currentPage.lastIndexOf("notificaciones.xhtml") > -1)
                                    || (currentPage.lastIndexOf("OrdenProcesada.xhtml") > -1)
                                    || (currentPage.lastIndexOf("crearOrdenProcesada.xhtml") > -1
                                    || ((currentPage.lastIndexOf("primer_ingreso.xhtml") > -1))
                                    || ((currentPage.lastIndexOf("modal.xhtml") > -1)));
                            break;
                        case 3:
                            Permiso = (currentPage.lastIndexOf("menu_admin.xhtml") > -1)
                                    || (currentPage.lastIndexOf("generar_etl.xhtml") > -1)
                                    || (currentPage.lastIndexOf("AgregarUsuario.xhtml") > -1)
                                    || (currentPage.lastIndexOf("ConsultarUsuario.xhtml") > -1
                                    || ((currentPage.lastIndexOf("primer_ingreso.xhtml") > -1)));
                            break;
                    }
                    isLoginPage = (currentPage.lastIndexOf("index.xhtml") > -1);
                    if (!Permiso && !isLoginPage) {
                        NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                        nh.handleNavigation(facesContext, null, "/error.xhtml");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
