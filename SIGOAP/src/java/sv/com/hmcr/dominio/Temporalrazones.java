/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dominio;

import java.io.Serializable;
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
 * @author Carlos y Jose
 */
@Entity
@Table(name = "temporalrazones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temporalrazones.findAll", query = "SELECT t FROM Temporalrazones t"),
    @NamedQuery(name = "Temporalrazones.findByAgente", query = "SELECT t FROM Temporalrazones t WHERE t.agente = :agente"),
    @NamedQuery(name = "Temporalrazones.findByC1", query = "SELECT t FROM Temporalrazones t WHERE t.c1 = :c1"),
    @NamedQuery(name = "Temporalrazones.findByC2", query = "SELECT t FROM Temporalrazones t WHERE t.c2 = :c2"),
    @NamedQuery(name = "Temporalrazones.findByC3", query = "SELECT t FROM Temporalrazones t WHERE t.c3 = :c3"),
    @NamedQuery(name = "Temporalrazones.findByC4", query = "SELECT t FROM Temporalrazones t WHERE t.c4 = :c4"),
    @NamedQuery(name = "Temporalrazones.findByC5", query = "SELECT t FROM Temporalrazones t WHERE t.c5 = :c5"),
    @NamedQuery(name = "Temporalrazones.findByC6", query = "SELECT t FROM Temporalrazones t WHERE t.c6 = :c6"),
    @NamedQuery(name = "Temporalrazones.findByC7", query = "SELECT t FROM Temporalrazones t WHERE t.c7 = :c7"),
    @NamedQuery(name = "Temporalrazones.findByC8", query = "SELECT t FROM Temporalrazones t WHERE t.c8 = :c8"),
    @NamedQuery(name = "Temporalrazones.findByC9", query = "SELECT t FROM Temporalrazones t WHERE t.c9 = :c9"),
    @NamedQuery(name = "Temporalrazones.findByC10", query = "SELECT t FROM Temporalrazones t WHERE t.c10 = :c10"),
    @NamedQuery(name = "Temporalrazones.findByC11", query = "SELECT t FROM Temporalrazones t WHERE t.c11 = :c11"),
    @NamedQuery(name = "Temporalrazones.findByC12", query = "SELECT t FROM Temporalrazones t WHERE t.c12 = :c12"),
    @NamedQuery(name = "Temporalrazones.findByC13", query = "SELECT t FROM Temporalrazones t WHERE t.c13 = :c13"),
    @NamedQuery(name = "Temporalrazones.findByC14", query = "SELECT t FROM Temporalrazones t WHERE t.c14 = :c14"),
    @NamedQuery(name = "Temporalrazones.findByC15", query = "SELECT t FROM Temporalrazones t WHERE t.c15 = :c15"),
    @NamedQuery(name = "Temporalrazones.findByC16", query = "SELECT t FROM Temporalrazones t WHERE t.c16 = :c16"),
    @NamedQuery(name = "Temporalrazones.findByC17", query = "SELECT t FROM Temporalrazones t WHERE t.c17 = :c17"),
    @NamedQuery(name = "Temporalrazones.findByC18", query = "SELECT t FROM Temporalrazones t WHERE t.c18 = :c18"),
    @NamedQuery(name = "Temporalrazones.findByTotales", query = "SELECT t FROM Temporalrazones t WHERE t.totales = :totales")})
public class Temporalrazones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "AGENTE")
    private String agente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C1")
    private int c1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C2")
    private int c2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C3")
    private int c3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C4")
    private int c4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C5")
    private int c5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C6")
    private int c6;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C7")
    private int c7;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C8")
    private int c8;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C9")
    private int c9;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C10")
    private int c10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C11")
    private int c11;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C12")
    private int c12;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C13")
    private int c13;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C14")
    private int c14;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C15")
    private int c15;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C16")
    private int c16;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C17")
    private int c17;
    @Basic(optional = false)
    @NotNull
    @Column(name = "C18")
    private int c18;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALES")
    private int totales;

    public Temporalrazones() {
    }

    public Temporalrazones(String agente) {
        this.agente = agente;
    }

    public Temporalrazones(String agente, int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9, int c10, int c11, int c12, int c13, int c14, int c15, int c16, int c17, int c18, int totales) {
        this.agente = agente;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
        this.c8 = c8;
        this.c9 = c9;
        this.c10 = c10;
        this.c11 = c11;
        this.c12 = c12;
        this.c13 = c13;
        this.c14 = c14;
        this.c15 = c15;
        this.c16 = c16;
        this.c17 = c17;
        this.c18 = c18;
        this.totales = totales;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public int getC3() {
        return c3;
    }

    public void setC3(int c3) {
        this.c3 = c3;
    }

    public int getC4() {
        return c4;
    }

    public void setC4(int c4) {
        this.c4 = c4;
    }

    public int getC5() {
        return c5;
    }

    public void setC5(int c5) {
        this.c5 = c5;
    }

    public int getC6() {
        return c6;
    }

    public void setC6(int c6) {
        this.c6 = c6;
    }

    public int getC7() {
        return c7;
    }

    public void setC7(int c7) {
        this.c7 = c7;
    }

    public int getC8() {
        return c8;
    }

    public void setC8(int c8) {
        this.c8 = c8;
    }

    public int getC9() {
        return c9;
    }

    public void setC9(int c9) {
        this.c9 = c9;
    }

    public int getC10() {
        return c10;
    }

    public void setC10(int c10) {
        this.c10 = c10;
    }

    public int getC11() {
        return c11;
    }

    public void setC11(int c11) {
        this.c11 = c11;
    }

    public int getC12() {
        return c12;
    }

    public void setC12(int c12) {
        this.c12 = c12;
    }

    public int getC13() {
        return c13;
    }

    public void setC13(int c13) {
        this.c13 = c13;
    }

    public int getC14() {
        return c14;
    }

    public void setC14(int c14) {
        this.c14 = c14;
    }

    public int getC15() {
        return c15;
    }

    public void setC15(int c15) {
        this.c15 = c15;
    }

    public int getC16() {
        return c16;
    }

    public void setC16(int c16) {
        this.c16 = c16;
    }

    public int getC17() {
        return c17;
    }

    public void setC17(int c17) {
        this.c17 = c17;
    }

    public int getC18() {
        return c18;
    }

    public void setC18(int c18) {
        this.c18 = c18;
    }

    public int getTotales() {
        return totales;
    }

    public void setTotales(int totales) {
        this.totales = totales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agente != null ? agente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporalrazones)) {
            return false;
        }
        Temporalrazones other = (Temporalrazones) object;
        if ((this.agente == null && other.agente != null) || (this.agente != null && !this.agente.equals(other.agente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.hmcr.dominio.Temporalrazones[ agente=" + agente + " ]";
    }
    
}
