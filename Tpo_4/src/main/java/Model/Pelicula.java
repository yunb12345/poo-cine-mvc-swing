package Model;

import java.util.*;

public class Pelicula {

    public String getNombrePelicula() {return nombrePelicula;}
    public int getDuracionEnMinutos() {return duracionEnMinutos;}
    public String getDirector() {return director;}
    public List<String> getActores() {return actores;}
    public TipoProyeccion getTipo() {return tipo;}
    public TipoGenero getGeneroID() {
        return generoID;
    }

    public Pelicula(int peliculaID,TipoGenero generoID,
                    String director,
                    int duracionEnMinutos,
                    String nombrePelicula,
                    TipoProyeccion tipo,
                    List<String> actores,
                    CondicionesDescuento descuento) {
        this.peliculaID = peliculaID;
        this.actores = actores;
        this.director = director;
        this.duracionEnMinutos = duracionEnMinutos;
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.tipo = tipo;
        this.condicionesDescuento = descuento;
    
    }

    public void setGeneroID(TipoGenero generoID) {
        this.generoID = generoID;
    }
    private int peliculaID;
    private TipoGenero generoID;
    private String nombrePelicula;
    private int duracionEnMinutos;
    private String director;
    private List<String> actores;
    private TipoProyeccion tipo;
    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }
    private CondicionesDescuento condicionesDescuento;

    public void setNombrePelicula(String nombrePelicula) {this.nombrePelicula = nombrePelicula;}
    public void setDuracionEnMinutos(int duracionEnMinutos) {this.duracionEnMinutos = duracionEnMinutos;}
    public void setDirector(String director) {this.director = director;}
    public void setActores(List<String> actores) {this.actores = actores;}
    public void setTipo(TipoProyeccion tipo) {this.tipo = tipo;}
    public void setCondicionesDescuento(CondicionesDescuento condicionesDescuento) {this.condicionesDescuento = condicionesDescuento;}

    public TipoGenero getTipoGenero(){return getGeneroID();}
    public boolean PeliculaID() {return this.getGeneroID()!=null;}

    public int getPeliculaID() {
        return peliculaID;
    }
}