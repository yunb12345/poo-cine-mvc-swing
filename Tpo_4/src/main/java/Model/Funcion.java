package Model;

import java.util.*;

public class Funcion {

    private Pelicula pelicula;
    private int funcionID;
    private String horario;
    private String fecha;
    private List<Entrada> entradas;
    private Sala sala;

    public Funcion(Pelicula pelicula, int funcionID, String horario, List<Entrada> entradas, Sala sala, String fecha) {

    	this.entradas = entradas;
    	this.fecha = fecha;
    	this.funcionID = funcionID;
    	this.horario = horario;
    	this.sala = sala;
    	this.pelicula = pelicula;

    }

    public Funcion(Pelicula pelicula, int funcionID, String horario, Sala sala, String fecha) {

        this.fecha = fecha;
        this.funcionID = funcionID;
        this.horario = horario;
        this.sala = sala;
        this.pelicula = pelicula;

    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public int getSalaID() {
        // TODO implement here
        return 0;
    }

    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

    public int getPeliculaID() {
        // TODO implement here
        if(Objects.nonNull(getPelicula())){
            return pelicula.getPeliculaID();
        }
        return 0;
    }

    public int getCantidadAsientosDisponibles() {
    	
		return 0;
        // TODO implement here
    }

    public int getFuncionID() {

        return this.funcionID;
    }

    public String getFecha() {
		return fecha;
        // TODO implement here
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public float calcularMontoPorEntradaDeLaPelicula(){
        float total = 0.0f;
        for (Entrada entrada:getEntradas()) {
            total = total+ (entrada.getPrecio() -
                    (entrada.getPrecio()*pelicula.getCondicionesDescuento().getDescuento()));
        }
        return total;
    }

    public String getHorario() {
        return horario;
    }
}