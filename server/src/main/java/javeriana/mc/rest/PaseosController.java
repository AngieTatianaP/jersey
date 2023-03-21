package javeriana.mc.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.*;

@Path("paseos")
public class PaseosController {

    @GET
    @Path("getAll")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() throws IOException {
        // Obtener el archivo y recorrer los paseos
        File file = new File("src/main/java/javeriana/mc/rest/antigua/bdPaseos");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String paseos = "";
        while ((line = br.readLine()) != null){
            String[] parts = line.split(",");
            if(parts.length >= 3) paseos = paseos + new Paseo(parts[0], parts[1], parts[2]).toString();
        }
        br.close();

        return paseos;
    }


    @GET
    @Path("deleteById")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteByID(@QueryParam("id") String ID) throws IOException {

        File file = new File("src/main/java/javeriana/mc/rest/antigua/bdPaseos");
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.split(",")[0].equals(ID)) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.close();
        br.close();
        file.delete();
        tempFile.renameTo(file);

        return "El paseo con ID: " + ID + " fue eliminado con exito";
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String add(Paseo paseo) throws IOException {
        Writer output = new BufferedWriter(new FileWriter("src/main/java/javeriana/mc/rest/antigua/bdPaseos", true));
        output.append(paseo.getId()+","+paseo.getOrigen()+","+paseo.getDestino()+"\n");
        output.close();
        return paseo.toString() + " -- adicionado con exito --";
    }

    @POST
    @Path("edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String modify(Paseo paseo) throws IOException {
        File file = new File("src/main/java/javeriana/mc/rest/antigua/bdPaseos");
        File tempFile = new File(file.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.split(",")[0].equals(paseo.getId())) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.println(paseo.getId()+","+paseo.getOrigen()+","+paseo.getDestino()+"\n");
        pw.flush();
        pw.close();
        br.close();
        file.delete();
        tempFile.renameTo(file);
        return paseo.toString() + "---Editado con exito---";
    }
}
