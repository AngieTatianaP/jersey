package javeriana.mc.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello")
    public String hello(@QueryParam("name") String nombre){
        return "hola " + nombre;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello/{name}")
    public String hello2(@PathParam("name") String nombre){
        return "hola " + nombre;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("user")
    public String hello3(@QueryParam("name") String nombre){
        return "hola " + nombre;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("user")
    public String hello4(@QueryParam("name") String nombre){
        return "<p>&nbsp;</p>\n" +
                "<h3 style=\"text-align: center; color: #3f7320;\">REST SERVER </h3>\n" +
                "<!-- Este comentario es visible solo en el editor fuente -->\n" +
                "<p><strong>BIENVENIDO " + nombre.toUpperCase() + "</strong></p> ";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("operations/{dos}")
    public Double hello5(@QueryParam("uno") String uno, @PathParam("dos") String dos){
        return Double.parseDouble(uno)*Double.parseDouble(dos);
    }
}
