package Test;
import Controller.DescuentoController;
import Controller.FuncionController;
import Controller.PeliculasController;
import Controller.VentasController;
import Dto.PeliculaDto;
import Dto.FuncionDTO;
import Model.Pelicula;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UnitTest {
    private PeliculasController peliculasController;
    private FuncionController funcionController;
    private VentasController ventasController;
    PeliculaDto dto0;
    FuncionDTO dto1;

    @Test
    public void agregarPeli() {
        peliculasController = peliculasController.getInstance();
        dto0 = new PeliculaDto("5","Romance","Agus Yoon","25","Modelo MVC",
                "CuatroD",null,null);
        peliculasController.agregarPeli(dto0);
        Assert.assertEquals(3,peliculasController.listaPeliculas().size());
    }

    @Test
    public void agregarFuncion(){
        funcionController = funcionController.getInstance();
        dto1 = new FuncionDTO("Jhon Wick","2","20","14","12 de Agosto de 2023");
        funcionController.agregarFuncion(dto1);
        Assert.assertEquals(2,funcionController.listaFunciones().size());
    }

    @Test
    public void recaudacionPorPelicula(){
        ventasController = ventasController.getInstance();
        Assert.assertEquals(0.0f,ventasController.recaudacionPorPelicula(190));
    }

    @Test
    public void listarPelicula(){
        peliculasController = peliculasController.getInstance();
        List<PeliculaDto> peliculasdto = peliculasController.listaPeliculas();
        Assert.assertEquals(2,peliculasdto.size());
    }
}
