package Dto;

import java.util.ArrayList;
import java.util.List;

public class PeliculaDto {
    private String peliculaID;
    private String tipoGenero;
    private String director;
    private String duracion;
    private String nombrePelicula;
    private String tipoProyeccion;
    private String descuento;
    private List<String> listaActores;


    public PeliculaDto(String peliculaID,
                       String tipoGenero,
                       String director,
                       String duracion,
                       String nombrePelicula,
                       String tipoProyeccion,
                       String descuento,
                       List<String> listaActores) {
        this.peliculaID = peliculaID;
        this.tipoGenero = tipoGenero;
        this.director = director;
        this.duracion = duracion;
        this.nombrePelicula = nombrePelicula;
        this.tipoProyeccion = tipoProyeccion;
        this.descuento = descuento;
        this.listaActores = listaActores;
    }

    public String getTipoGenero() {return tipoGenero;}
    public String getDirector() {return director;}
    public String getDuracion() {return duracion;}
    public String getNombrePelicula() {return nombrePelicula;}
    public String getTipoProyeccion() {return tipoProyeccion;}
    public String getDescuento() {return descuento;}

    public void setTipoGenero(String tipoGenero) {this.tipoGenero = tipoGenero;}
    public void setDirector(String director) {this.director = director;}
    public void setDuracion(String duracion) {this.duracion = duracion;}
    public void setNombrePelicula(String nombrePelicula) {this.nombrePelicula = nombrePelicula;}
    public void setTipoProyeccion(String tipoProyeccion) {this.tipoProyeccion = tipoProyeccion;}
    public void setDescuento(String descuento) {this.descuento = descuento;}

    public List<String> getListaActores() {
        return listaActores;
    }

    public String getPeliculaID() {
        return peliculaID;
    }
}
