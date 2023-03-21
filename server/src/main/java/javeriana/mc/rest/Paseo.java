package javeriana.mc.rest;

public class Paseo {

    String id;
    String origen;
    String destino;

    public Paseo() {
    }

    public Paseo(String id, String origen, String destino) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String toString(){
        return "Paseo:\n con Id: " + this.id +
                "\n\tOrigen: " + this.origen +
                "\n\tDestino: " + this.destino +
                "\n";
    }
}
