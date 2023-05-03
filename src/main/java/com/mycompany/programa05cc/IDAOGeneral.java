/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.programa05cc;

import java.util.List;

/**
 *
 * @author irvin
 * @param <T>
 * @param <I>
 */
public interface IDAOGeneral<T, I> {
    public T create(T p);
    public boolean delete(I id);
    public T update(I id, T p);
    
    public List<T> findAll();
    public T findByID(I id);
}
