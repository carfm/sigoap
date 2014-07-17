/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.hmcr.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import sv.com.hmcr.dominio.DetalleOrden;
import sv.com.hmcr.dominio.Empleado;
import sv.com.hmcr.util.HibernateUtil;

public class DetalleDAO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<DetalleOrden> obtenerDetalle(int tipo, String empleado, String fechaini, String fechafin) throws HibernateException {
        HibernateUtil.buildSessionFactory();
        List<DetalleOrden> listaUsuarios=new ArrayList<DetalleOrden>();
        DetalleOrden det=new DetalleOrden();
        String squery="";
        try {           
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            if (tipo==1)
                squery="select "
                        + "o.specimen as specimen, case when o.tipoorden=1 then "
                        + "'completa' when o.tipoorden=2 then 'incompleta' when "
                        + "o.tipoorden=3 then 'sin hacer nada' end as tipoOrden "
                        + "from Orden o, Procesa_Audita p where o.specimen=p.specimen "
                        + "and p.idempleado='"+empleado+"' and fecha between '"+fechaini+"' and '"+fechafin+"' order by o.tipoorden";
            else
                squery="select "
                        + "o.specimen as specimen, case when r.categoriaerror=1 "
                        + "then 'Leve' when r.categoriaerror=2 then 'Mediano' when "
                        + "r.categoriaerror=3 then 'Grave' end as tipoOrden from "
                        + "procesa_audita o, Registro_Error r where o.specimen=r.specimen "
                        + "and o.idempleado='"+empleado+"' and r.fecha between '"+fechaini+"' and '"+fechafin+"' order by r.categoriaerror";
            SQLQuery query=session.createSQLQuery(squery);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            Map<String,Object> row = null;
            List data = query.list();
            if (data.isEmpty())
                listaUsuarios=null;
            else{
            for (Object object : data) {
            row= (Map<String,Object>)object;
            det.setSpecimen(row.get("specimen").toString());
            det.setTipoOrden(row.get("tipoOrden").toString());
            listaUsuarios.add(det);
            }
            }
            
            session.close();
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        return listaUsuarios;
    }

    public String recuperarId(String nombre) {
        String idUser="";
        HibernateUtil.buildSessionFactory();
        try {           
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
                idUser = (String) session.createQuery("select idempleado from Empleado where nombreempleado='"+nombre+"'").list().get(0);
            System.out.println("id de empleado: "+idUser);
                session.close();
        } finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }
        return idUser;

    }
    
}

/*if (tipo==1)
                listaUsuarios = (List<DetalleOrden>) session.createQuery("select "
                        + "o.specimen as specimen, case when o.tipoorden=1 then "
                        + "'completa' when o.tipoorden=2 then 'incompleta' when "
                        + "o.tipoorden=3 then 'sin hacer nada' end as tipoOrden "
                        + "from Orden o, ProcesaAudita p where o.specimen=p.specimen "
                        + "and p.idempleado='"+empleado+"' order by o.tipoorden").list();
            else
                listaUsuarios = (List<DetalleOrden>) session.createQuery("select "
                        + "o.specimen as specimen, case when r.categoriaerror=1 "
                        + "then 'Leve' when r.categoriaerror=2 then 'Mediano' when "
                        + "r.categoriaerror=3 then 'Grave' end as tipoOrden from "
                        + "Orden o, RegistroError r where o.specimen=r.specimen "
                        + "and r.idempleado='"+empleado+"' order by r.categoriaerror").list();*/