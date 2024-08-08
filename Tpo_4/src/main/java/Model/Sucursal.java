package Model;

import java.util.*;

public class Sucursal {

    private int sucursalID;

    private String denominacion;

    private String direccion;

    private List<Sala> salas;

    public Sucursal(int sucursalID, String denominacion, String direccion, ArrayList<Sala> sala) {
    	this.denominacion = denominacion;
    	this.direccion = direccion;
    	this.sucursalID = sucursalID;
    	this.salas = sala;
    }

    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

    public List<Sala> getSalas() {
        return salas;
    }
}