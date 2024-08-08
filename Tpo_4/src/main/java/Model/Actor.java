package Model;

public class Actor {
    private String nombre;
    private String apellido;
    private String personaje;

    public Actor(String nombre, String apellido, String personaje) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.personaje = personaje;
    }

    public Actor(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
}
