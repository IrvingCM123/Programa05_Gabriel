/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa05cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author irvin
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado create(Empleado p) {
        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            session.save(p);

            t.commit();
        } catch (HibernateException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;

    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        Empleado obj = session.get(Empleado.class, id);

        if (obj != null) {
            session.delete(obj);
            t.commit();
            session.close();
            return true;
        } else {
            t.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public Empleado update(Long id, Empleado p) {
        try {
            Empleado obj;
            try ( Session session = HibernateUtil.getSession()) {
                Transaction t = session.beginTransaction();
                obj = session.get(Empleado.class, id);
                obj.setNombre(p.getNombre());
                obj.setDireccion(p.getDireccion());
                obj.setTelefono(p.getTelefono());
                session.update(obj);
                t.commit();
            }

            return obj;

        } catch (HibernateException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> lstRes;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            lstRes = session.createQuery("from Empleado", Empleado.class).list();
            t.commit();
        }
        return lstRes;
    }

    @Override
    public Empleado findByID(Long id) {
        Empleado obj;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
            obj = session.get(Empleado.class, id);
            //get es para obtener un objeto referenciado, ya sea qu exista o sea null
            //load es para obtener en caché
            t.commit();
            session.close();
            
        }
        
        return obj;
    }

}
