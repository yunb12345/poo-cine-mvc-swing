package Model;

import java.util.*;

public class CondicionesDescuento {



    private float porcentaje;

    private TipoTarjeta tipoTarjeta;

    public CondicionesDescuento(float porcentaje, TipoTarjeta tipoTarjeta, ArrayList<TarjetaDescuento> TarjetaDescuento) {
    	this.porcentaje = porcentaje;
    	this.tipoTarjeta = tipoTarjeta;
    	this.TarjetaDescuento = TarjetaDescuento;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }


    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public List<TarjetaDescuento> getTarjetaDescuento() {
        return TarjetaDescuento;
    }

    private List<TarjetaDescuento> TarjetaDescuento;

    public float getDescuento(){
        float descuento = 0.0f;
        for (TarjetaDescuento tarjetaDescuento: getTarjetaDescuento()) {
            descuento += getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta());
        }
        descuento=descuento+porcentaje;
        return descuento;
    }

    public static float getDescuentoPorTarjeta(TipoTarjeta tipoTarjeta){
        switch (tipoTarjeta){
            case PAMI -> { return 0.25f; }
            case UADE,MovieClub ->{ return 0.15f;}
            case LaNacion,Clarin365 -> {return 0.5f;}
            default -> {return 0.0f;}
        }
    }
}