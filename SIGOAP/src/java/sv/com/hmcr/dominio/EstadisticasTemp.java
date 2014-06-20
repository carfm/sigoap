/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "estadisticas_temp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadisticasTemp.findAll", query = "SELECT e FROM EstadisticasTemp e"),
    @NamedQuery(name = "EstadisticasTemp.findByIDes", query = "SELECT e FROM EstadisticasTemp e WHERE e.iDes = :iDes"),
    @NamedQuery(name = "EstadisticasTemp.findByTipoorden", query = "SELECT e FROM EstadisticasTemp e WHERE e.tipoorden = :tipoorden"),
    @NamedQuery(name = "EstadisticasTemp.findByMesAnt", query = "SELECT e FROM EstadisticasTemp e WHERE e.mesAnt = :mesAnt"),
    @NamedQuery(name = "EstadisticasTemp.findByPrimerQuin", query = "SELECT e FROM EstadisticasTemp e WHERE e.primerQuin = :primerQuin"),
    @NamedQuery(name = "EstadisticasTemp.findBySegundaQuin", query = "SELECT e FROM EstadisticasTemp e WHERE e.segundaQuin = :segundaQuin"),
    @NamedQuery(name = "EstadisticasTemp.findByMes", query = "SELECT e FROM EstadisticasTemp e WHERE e.mes = :mes"),
    @NamedQuery(name = "EstadisticasTemp.findByPorcentaje", query = "SELECT e FROM EstadisticasTemp e WHERE e.porcentaje = :porcentaje"),
    @NamedQuery(name = "EstadisticasTemp.findByPromedioOrden", query = "SELECT e FROM EstadisticasTemp e WHERE e.promedioOrden = :promedioOrden"),
    @NamedQuery(name = "EstadisticasTemp.findByTipoerror", query = "SELECT e FROM EstadisticasTemp e WHERE e.tipoerror = :tipoerror"),
    @NamedQuery(name = "EstadisticasTemp.findByMesAntE", query = "SELECT e FROM EstadisticasTemp e WHERE e.mesAntE = :mesAntE"),
    @NamedQuery(name = "EstadisticasTemp.findByPrimerQuinE", query = "SELECT e FROM EstadisticasTemp e WHERE e.primerQuinE = :primerQuinE"),
    @NamedQuery(name = "EstadisticasTemp.findBySegundaQuinE", query = "SELECT e FROM EstadisticasTemp e WHERE e.segundaQuinE = :segundaQuinE"),
    @NamedQuery(name = "EstadisticasTemp.findByMesE", query = "SELECT e FROM EstadisticasTemp e WHERE e.mesE = :mesE"),
    @NamedQuery(name = "EstadisticasTemp.findByPorcentajeE", query = "SELECT e FROM EstadisticasTemp e WHERE e.porcentajeE = :porcentajeE"),
    @NamedQuery(name = "EstadisticasTemp.findByPromedioError", query = "SELECT e FROM EstadisticasTemp e WHERE e.promedioError = :promedioError")})
public class EstadisticasTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_es")
    private Integer iDes;
    @Size(max = 80)
    @Column(name = "tipoorden")
    private String tipoorden;
    @Column(name = "mesAnt")
    private Integer mesAnt;
    @Column(name = "primerQuin")
    private Integer primerQuin;
    @Column(name = "segundaQuin")
    private Integer segundaQuin;
    @Column(name = "mes")
    private Integer mes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private BigDecimal porcentaje;
    @Column(name = "promedioOrden")
    private BigDecimal promedioOrden;
    @Size(max = 80)
    @Column(name = "tipoerror")
    private String tipoerror;
    @Column(name = "mesAntE")
    private Integer mesAntE;
    @Column(name = "primerQuinE")
    private Integer primerQuinE;
    @Column(name = "segundaQuinE")
    private Integer segundaQuinE;
    @Column(name = "mesE")
    private Integer mesE;
    @Column(name = "porcentajeE")
    private BigDecimal porcentajeE;
    @Column(name = "promedioError")
    private BigDecimal promedioError;

    public EstadisticasTemp() {
    }

    public EstadisticasTemp(Integer iDes) {
        this.iDes = iDes;
    }

    public Integer getIDes() {
        return iDes;
    }

    public void setIDes(Integer iDes) {
        this.iDes = iDes;
    }

    public String getTipoorden() {
        return tipoorden;
    }

    public void setTipoorden(String tipoorden) {
        this.tipoorden = tipoorden;
    }

    public Integer getMesAnt() {
        return mesAnt;
    }

    public void setMesAnt(Integer mesAnt) {
        this.mesAnt = mesAnt;
    }

    public Integer getPrimerQuin() {
        return primerQuin;
    }

    public void setPrimerQuin(Integer primerQuin) {
        this.primerQuin = primerQuin;
    }

    public Integer getSegundaQuin() {
        return segundaQuin;
    }

    public void setSegundaQuin(Integer segundaQuin) {
        this.segundaQuin = segundaQuin;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public BigDecimal getPromedioOrden() {
        return promedioOrden;
    }

    public void setPromedioOrden(BigDecimal promedioOrden) {
        this.promedioOrden = promedioOrden;
    }

    public String getTipoerror() {
        return tipoerror;
    }

    public void setTipoerror(String tipoerror) {
        this.tipoerror = tipoerror;
    }

    public Integer getMesAntE() {
        return mesAntE;
    }

    public void setMesAntE(Integer mesAntE) {
        this.mesAntE = mesAntE;
    }

    public Integer getPrimerQuinE() {
        return primerQuinE;
    }

    public void setPrimerQuinE(Integer primerQuinE) {
        this.primerQuinE = primerQuinE;
    }

    public Integer getSegundaQuinE() {
        return segundaQuinE;
    }

    public void setSegundaQuinE(Integer segundaQuinE) {
        this.segundaQuinE = segundaQuinE;
    }

    public Integer getMesE() {
        return mesE;
    }

    public void setMesE(Integer mesE) {
        this.mesE = mesE;
    }

    public BigDecimal getPorcentajeE() {
        return porcentajeE;
    }

    public void setPorcentajeE(BigDecimal porcentajeE) {
        this.porcentajeE = porcentajeE;
    }

    public BigDecimal getPromedioError() {
        return promedioError;
    }

    public void setPromedioError(BigDecimal promedioError) {
        this.promedioError = promedioError;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDes != null ? iDes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticasTemp)) {
            return false;
        }
        EstadisticasTemp other = (EstadisticasTemp) object;
        if ((this.iDes == null && other.iDes != null) || (this.iDes != null && !this.iDes.equals(other.iDes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.EstadisticasTemp[ iDes=" + iDes + " ]";
    }
    
}
