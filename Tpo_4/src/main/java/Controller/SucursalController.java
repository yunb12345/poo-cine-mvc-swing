package Controller;

import java.lang.reflect.Array;
import java.util.*;

import Model.*;

public class SucursalController {

	private List<Sucursal> sucursal;
    private static SucursalController instance = null;

    private SucursalController() {
    	sucursal = new ArrayList<Sucursal>();
        ArrayList<Sala> salas = new ArrayList<Sala>();
        salas.add(new Sala(2));
        salas.add(new Sala(1));

    	sucursal.add(new Sucursal(1,
                "Barracas",
                "Av Montes de Oca 1100",
                salas));
    }

    public static SucursalController getInstance(){
        if (instance== null){
            instance = new SucursalController();
        }
        return instance;
    }

    public Sala buscarSala(int salaID){
        Sala salaEncontrada = null;
        for (int i=0;i<sucursal.size();i++){
            for(int j=0;j<sucursal.get(i).getSalas().size();j++){
                if (sucursal.get(i).getSalas().get(j).getSucursalID() == salaID){
                    salaEncontrada = sucursal.get(i).getSalas().get(j);

                }
            }
        }
        return salaEncontrada;
    }
}