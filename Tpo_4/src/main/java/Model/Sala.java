package Model;

public class Sala {

    private int salaID;

    private String denominacion;

    private int asientos;

    public Sala(int salaID, String denominacion, int asientos) {
    	this.asientos = asientos;
    	this.denominacion = denominacion;
    	this.salaID = salaID;
    }

    public Sala(int salaID){
        this.salaID = salaID;
    }

    public int getSucursalID() {
        // TODO implement here
        return 0;
    }

    public int getSalaID() {
        // TODO implement here
        return 0;
    }

    public int getAsientos() {
        return this.asientos;
    }
}