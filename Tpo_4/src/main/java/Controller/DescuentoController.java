package Controller;

import java.util.*;
import Model.*;

public class DescuentoController {
	
	private List<CondicionesDescuento> Descuento;

	private static DescuentoController instance = null;
	
    private DescuentoController() {
    	Descuento = new ArrayList<CondicionesDescuento>();
    	CondicionesDescuento CondicionesDescuento = new CondicionesDescuento(5, TipoTarjeta.PAMI, new ArrayList<TarjetaDescuento>());
    	Descuento.add(CondicionesDescuento);
    	
    }

	public static DescuentoController getInstance(){
		if (instance == null){
			instance = new DescuentoController();
		}
		return instance;
	}
	//el primero que encuentra
	public CondicionesDescuento getCondicionDescuento(){
		for (int i=0;i<Descuento.size();i++){
			return Descuento.get(i);
		}
		return null;

	}
	public List<CondicionesDescuento> getTodosCondiciones(){
		return Descuento;
	}
}