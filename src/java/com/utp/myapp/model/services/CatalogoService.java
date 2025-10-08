package com.utp.myapp.model.services;

import com.utp.myapp.dtos.CategoriaDTO; // Suponiendo que existe un DTO simple
import com.utp.myapp.dtos.HabilidadDTO; // Suponiendo que existe un DTO simple
//import com.utp.myapp.mappers.CatalogoMapper;
import com.utp.myapp.model.dao.CategoriaDAO;
import com.utp.myapp.model.dao.HabilidadDAO;
import java.util.List;
import java.util.stream.Collectors;


public class CatalogoService {
    
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private final HabilidadDAO habilidadDAO = new HabilidadDAO();

    public List<CategoriaDTO> listarCategorias() {
        return null; /*categoriaDAO.list().stream()
                .map(CatalogoMapper::toCategoriaDTO)
                .collect(Collectors.toList());*/
    }

    public List<HabilidadDTO> listarHabilidades() {
        return null;/*habilidadDAO.findAll().stream()
                .map(CatalogoMapper::toHabilidadDTO)
                .collect(Collectors.toList());*/
    }
}