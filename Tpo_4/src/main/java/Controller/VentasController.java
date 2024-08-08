package Controller;

import Dto.FuncionDTO;
import Dto.VentaDto;

import java.util.*;
import Model.*;

public class VentasController {

    public List<Venta> getVentas() {
        return ventas;
    }
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    private static VentasController instance = null;
    private List<Venta> ventas;
    private FuncionController funcionController =  FuncionController.getInstance();


    private VentasController(){
        ventas = new ArrayList<Venta>();
        Venta venta = new Venta(
                1,
                new Date(),
                null,funcionController.buscarFuncion(2)
                );
        ventas.add(venta);
    }

    public static VentasController getInstance() {
        if (instance == null) {
            instance = new VentasController();
        }
        return instance;
    }

    public float recaudacionPorFuncion(int funcionID) {
        // TODO implement here
        return 0.0f;
    }

    public float recaudacionPorPelicula(int peliculaID) {
        List<Funcion> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if(funciones.isEmpty()){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(!Objects.isNull(venta)){
                totalrecuadado+=venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
    	return totalrecuadado;
    }

    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        // TODO implement here
        return 0.0f;
    }

    private Venta buscarVentaPorFuncion(Funcion funcion){
        for (Venta venta:getVentas()) {
            if(Objects.equals(funcion,venta.getFuncion())){
                return venta;
            }
        }
        return null;
    }
}