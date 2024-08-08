package Controller;

import Dto.FuncionDTO;

import java.util.*;

import Dto.PeliculaDto;
import Model.*;

public class FuncionController {
	
	private List<Funcion> funciones;

	private static FuncionController instance= null;
    private SucursalController sucursalController = SucursalController.getInstance();
    private PeliculasController peliculaController = PeliculasController.getInstance();

	private FuncionController() {
    	funciones = new ArrayList<Funcion>();
        List<Entrada> entradas = new ArrayList<Entrada>();
        Sala sala1 = new Sala(4);
        Funcion funcion1 = new Funcion(peliculaController.buscarPelicula("Director X"),2,"20",
                sala1,"12 de Agosto de 2023");
        Entrada entrada1 = new Entrada(21,funcion1,23.2f);
        entradas.add(entrada1);
        funcion1.setEntradas(entradas);
        funciones.add(funcion1);
    }

    public static FuncionController getInstance(){
        if(instance == null) {
            instance = new FuncionController();
        }
        return instance;
    }

    public List<Funcion> buscarPeliculaPorFuncion(int peliculaID) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPeliculaID() == peliculaID){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funcionesDeLaPelicula;
    }

    public List<Funcion> buscarPeliculaPorGenerosFuncion(TipoGenero genero) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPelicula().getGeneroID() == genero){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funciones;
    }

    public Funcion tofuncionModel(FuncionDTO dto){
        Sala sala = sucursalController.buscarSala(Integer.parseInt(dto.getSalaID()));
        Pelicula pelicula = peliculaController.buscarPelicula(dto.getPelicula());

        Funcion funcion = new Funcion(
                pelicula,
                Integer.parseInt(dto.getFuncionID()),
                dto.getHorario(),
                sala,
                dto.getFecha()
        );
        return funcion;
    }

    public void agregarFuncion(FuncionDTO dto){
        if(dto.getPelicula()==null){
            String msj = "Error no existe pelicula";
        }
        else{
            funciones.add(tofuncionModel(dto));
            String msj = "Se agrego la funcion correctamente";
        }
    }

    public  Funcion buscarFuncion(int funcionID){
        for(int i = 0; funciones.size() >i;i++){
            if(funciones.get(i).getFuncionID() == funcionID){
                return funciones.get(i);
            }
        }
        return null;
    }
    private FuncionDTO toFuncionDto(Funcion Model){
        FuncionDTO dto = new FuncionDTO(
                String.valueOf(Model.getPelicula()),
                String.valueOf(Model.getFuncionID()),
                String.valueOf(Model.getHorario()),
                String.valueOf(Model.getSalaID()),
                String.valueOf(Model.getFecha()));
        return dto;
    }

    public List<FuncionDTO> listaFunciones(){
        List<FuncionDTO> funcionesMostrar = new ArrayList<FuncionDTO>();
        for(int i=0; funciones.size()>i;i++){
            if(funciones.get(i).getFuncionID() != -1){
                funcionesMostrar.add(toFuncionDto(funciones.get(i)));
            }
        }
        return funcionesMostrar;
    }
}