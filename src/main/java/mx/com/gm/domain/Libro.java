/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NamedQueries({
    @NamedQuery(name = "Libro.encontrarTodosLibros",query = "SELECT p FROM Libro p ORDER BY p.id")
})
/**
 *
 * @author Familia Márquez
 */
public class Libro implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String autor;
    @Column
    private String fecha_publicacion;
    @Column
    private int n_ejemplares;
    @Column
    private double costo;
    
    public Libro(){
    
    }
    
    public Libro(int id){
        this.id=id;
    }
    
    public Libro(int id, String nombre, String descripcion, String autor, String fecha_publicacion,int n_ejemplares, double costo){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.autor=autor;
        this.fecha_publicacion=fecha_publicacion;
        this.n_ejemplares=n_ejemplares;
        this.costo=costo;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getN_ejemplares() {
        return n_ejemplares;
    }

    public void setN_ejemplares(int n_ejemplares) {
        this.n_ejemplares = n_ejemplares;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
}
