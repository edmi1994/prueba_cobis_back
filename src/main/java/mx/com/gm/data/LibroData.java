/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.data;

import java.util.List;
import mx.com.gm.domain.Libro;

/**
 *
 * @author Familia Márquez
 */
public interface LibroData {
    public List<Libro> encontrarTodosLibros();
    
    public Libro obtenerLibro(Libro libro);
    
    public void insertarLibro(Libro libro);
    
    public void actualizarLibro(Libro persona);
    
    public void eliminarLibro(Libro libro);
}
