package Controller;

import java.util.*;

import Dto.FuncionDTO;
import Dto.PeliculaDto;
import Model.*;

public class PeliculasController {

	private List<Pelicula> peliculas;
    private static PeliculasController instance=null;

    private PeliculasController() {
    	
    	peliculas= new ArrayList<Pelicula>();
    	Pelicula peliculax = new Pelicula(
                10,
                TipoGenero.Suspenso,
                "Pelicula1",
                180 ,
                "Director X",
                TipoProyeccion.DosD,
                Arrays.asList("Actriz Principal", "Actor Secundario"),
                null);
        Pelicula peliculay = new Pelicula(
                190,
                TipoGenero.Romance,
                "Pelicula1",
                180 ,
                "Director Y",
                TipoProyeccion.DosD,
                Arrays.asList("Actriz Principal", "Actor Secundario"),
                null);
        TarjetaDescuento tarjeta = new TarjetaDescuento(1,TipoTarjeta.PAMI,"123");
        ArrayList<TarjetaDescuento> tarjetas = new ArrayList<TarjetaDescuento>();
        tarjetas.add(tarjeta);

        CondicionesDescuento condicionDescuento = new CondicionesDescuento(2.5f,TipoTarjeta.PAMI,tarjetas);
        peliculax.setCondicionesDescuento(condicionDescuento);
        peliculas.add(peliculax);
        peliculas.add(peliculay);
    }

    public static PeliculasController getInstance(){
        if(instance==null){
            instance = new PeliculasController();
        }
        return instance;
    }

    public List<PeliculaDto> listaPeliculas(){
        List<PeliculaDto> peliculasMostrar = new ArrayList<PeliculaDto>();
        for(int i=0; peliculas.size()>i;i++){
            if(peliculas.get(i).PeliculaID()){
                peliculasMostrar.add(toPeliculasDto(peliculas.get(i)));
            }
        }
        return peliculasMostrar;
    }

    public List<PeliculaDto> filtrarPeliPorGenero(List<PeliculaDto> listaPeli,TipoGenero genero){
        List<PeliculaDto> peliculas = new ArrayList<PeliculaDto>();
        for (int i=0;listaPeli.size()>i;i++){
            if (TipoGenero.valueOf(listaPeli.get(i).getTipoGenero()) == genero){
                peliculas.add(listaPeli.get(i));
            }
        }
        return peliculas;

    }

    private PeliculaDto toPeliculasDto(Pelicula Model){
        PeliculaDto dto = new PeliculaDto(
                String.valueOf(Model.getPeliculaID()),
                String.valueOf(Model.getTipoGenero()),
                String.valueOf(Model.getDirector()),
                String.valueOf(Model.getDuracionEnMinutos()),
                String.valueOf(Model.getNombrePelicula()),
                String.valueOf(Model.getTipo()),
                String.valueOf(Model.getCondicionesDescuento()),
                Model.getActores()
        );
        return dto;
    }

    private Pelicula toPeliculasModel(PeliculaDto dto) {
        Pelicula model = new Pelicula(
                Integer.parseInt(dto.getPeliculaID()),
                TipoGenero.valueOf(dto.getTipoGenero()),
                dto.getDirector(),
                Integer.valueOf(dto.getDuracion()),
                dto.getNombrePelicula(),
                TipoProyeccion.valueOf(dto.getTipoProyeccion()),
                dto.getListaActores(),
                null);
        return model;
    }

    public void agregarPeli(PeliculaDto DTO) {
        Pelicula pelicula = toPeliculasModel(DTO);
        peliculas.add(pelicula);
    }

    public Pelicula buscarPelicula(String nombre){
        Pelicula pelicula = null;
        for(int i=0;i<peliculas.size();i++){
            if (Objects.equals(peliculas.get(i).getNombrePelicula(), nombre)){
                pelicula = peliculas.get(i);
            }
        }
        return pelicula;
    }
}