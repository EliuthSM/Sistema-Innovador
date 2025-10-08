/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.utp.myapp.model.repositories;

import java.util.List;

/**
 *
 * @author Administrador
 */
public interface ICRUD <T> {
    Boolean insert(T t);
    Boolean update(T t);
    Boolean delete(Integer id);
    T listById(Integer id);
    List<T> list();
}
