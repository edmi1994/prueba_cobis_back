/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.domain.Libro;

/**
 *
 * @author Familia Márquez
 */
@Stateless
public class LibroDataImpl implements LibroData{

    @PersistenceContext(unitName = "LibroPU")
    EntityManager em;
    
    @Override
    public List<Libro> encontrarTodosLibros() {
        return em.createNamedQuery("Libro.encontrarTodosLibros").getResultList();
    }

    @Override
    public Libro obtenerLibro(Libro libro) {
        return em.find(Libro.class, libro.getId());
    }

    @Override
    public void insertarLibro(Libro libro) {
        em.persist(libro);
        em.flush();
    }

    @Override
    public void actualizarLibro(Libro persona) {
        em.merge(persona);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        em.remove(em.merge(libro));
    }
    
}
