/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.programa05cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author irvin
 */
public class Programa05CC {

    public static void main(String[] args) {
       
        DAOEmpleado dao = new DAOEmpleado();
        
        Empleado empleado = new Empleado();
        empleado.setClave(2);
        empleado.setNombre("Irving");
        empleado.setDireccion("Av 2");
        empleado.setTelefono("123");
        Empleado obj = dao.findByID(2L);
        Logger.getLogger(Programa05CC.class.getName()).log(Level.INFO, "Clave: {0}", String.valueOf(obj.getClave()));
        Logger.getLogger(Programa05CC.class.getName()).log(Level.INFO, "Nombre: {0}", obj.getNombre());
        Logger.getLogger(Programa05CC.class.getName()).log(Level.INFO, "Direccion: {0}", obj.getDireccion());
        Logger.getLogger(Programa05CC.class.getName()).log(Level.INFO, "Telefono: {0}" , obj.getTelefono());
        
    }
}
