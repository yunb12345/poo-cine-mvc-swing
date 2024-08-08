package Dto;

import java.util.List;

public class FuncionDTO {
    private String fecha;
    private String funcionID;
    private String horario;
    //private List<String> entrada;
    private String salaID;
    private String pelicula;


    public FuncionDTO(String pelicula, String funcionID, String horario,
                      String salaID,String fecha) {
        this.fecha = fecha;
        this.funcionID = funcionID;
        this.horario = horario;
        //this.entrada = entrada;
        this.salaID = salaID;
        this.pelicula = pelicula;
    }

    public String getFecha() {return fecha;}
    public String getFuncionID() {return funcionID;}
    public String getHorario() {return horario;}
    //public List<String> getEntrada() {return entrada;}

    public String getPelicula() {return pelicula;}

    public void setFecha(String fecha) {this.fecha = fecha;}
    public void setFuncionID(String funcionID) {this.funcionID = funcionID;}
    public void setHorario(String horario) {this.horario = horario;}
    //public void setEntrada(List<String> entrada) {this.entrada = entrada;}
    public void setPelicula(String pelicula) {this.pelicula = pelicula;}
    public String getSalaID() {
        return salaID;
    }




}
