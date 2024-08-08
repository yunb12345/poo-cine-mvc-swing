package View;

import Controller.PeliculasController;
import Dto.PeliculaDto;
import Model.Pelicula;
import Model.TipoGenero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultarPelicula extends JFrame {
    JPanel panelPrincipal;
    private JTable table;
    private Object[][] data;
    private DefaultTableModel modeloTabla;
    private String[] columnas = {"Pelicula","Genero"};
    private PeliculasController controller;

    public ConsultarPelicula(String genero){
        super("Catalogo de Peliculas");
        panelPrincipal = new JPanel(); // Crea un nuevo panel principal

        panelPrincipal.setLayout(new BorderLayout()); // Establece el BorderLayout para el panel principal
        getContentPane().add(panelPrincipal); // Añade el panel principal al contenido de la ventana

        setSize(700, 600); // Establece el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación de cierre de la ventana

        controller = PeliculasController.getInstance();
        List<PeliculaDto> peliculas = controller.listaPeliculas();
        List<PeliculaDto> pelis = controller.filtrarPeliPorGenero(peliculas, TipoGenero.valueOf(genero));
        data = convertDtoToData(pelis);

        modeloTabla = new DefaultTableModel(data, columnas); // Crea un modelo de tabla con los datos y las columnas
        table = new JTable(modeloTabla); // Crea una nueva tabla con el modelo de tabla

        JScrollPane scrollPane = new JScrollPane(table); // Crea un panel de desplazamiento y añade la tabla
        panelPrincipal.add(scrollPane, BorderLayout.CENTER); // Añade el panel de desplazamiento al centro del panel principal

        setVisible(true); // Hace visible la ventana
    }
    public Object[][] convertDtoToData(List<PeliculaDto> list) {
        Object[][] data = new Object[list.size()][2]; // Crea una matriz de objetos con el tamaño de la lista y 2 columnas
        for (int i = 0; i < list.size(); i++) {
            PeliculaDto pelicula = list.get(i);
            data[i][0] = pelicula.getNombrePelicula(); // Asigna el ID de la propiedad a la primera columna
            data[i][1] = pelicula.getTipoGenero();
        }
        return data; // Devuelve la matriz de objetos
    }
    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        String genero = "Romance";
        new ConsultarPelicula(genero); // Crea una nueva instancia de la GUI y la hace visible
    }
}

