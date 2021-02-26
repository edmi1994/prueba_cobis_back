package mx.com.gm.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.data.LibroData;
import mx.com.gm.domain.Libro;

/**
 *
 * @author Familia Márquez
 */
@Stateless
@Path("/libros")
public class LibroServiceRS {
    @Inject
    private LibroData librodata;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    
    public List<Libro> listarLibros(){
        List<Libro> libros= librodata.encontrarTodosLibros();
        System.out.println("Libros: " + libros);
        return libros;
    }
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("(id)") // referencia al path: /libros/{id}
    
    public Libro encontrarLibro(@PathParam("id") int id){
        Libro libro = librodata.obtenerLibro( new Libro(id));
        System.out.println("Libro: " +libro);
        return libro;
    }
    
    @POST
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    
    public Libro insertarLibro(Libro libro){
        librodata.insertarLibro(libro);
        System.out.println("Libro agregado: "+libro);
        return libro;
    }
    
    @PUT
    @Consumes(value=MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("(id)")
    public Response actualizarPersona(@PathParam("id") int id, Libro libro_modificado){
        Libro libro = librodata.obtenerLibro(new Libro(id));
        System.out.println(libro);
        if(libro != null){
            librodata.actualizarLibro(libro_modificado);
            System.out.println("Libro modificado: " +libro_modificado);
            return Response.ok().entity(libro_modificado).build();
        }
        else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("(id)")
    public Response eliminarLibro(@PathParam("id") int id){
        System.out.println("mx.com.gm.service.LibroServiceRS.eliminarLibro()");
        librodata.eliminarLibro(new Libro(id));
        System.out.println("libro eliminado con id:" +id);
        return Response.ok().build();
    }
}
