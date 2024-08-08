package View;

import Controller.PeliculasController;
import Controller.VentasController;
import Dto.PeliculaDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EmitirReporte extends JFrame {
    JPanel panelPrincipal; //creamos un panel
    private JTable table;// creamos una tabla
    private Object[][] data; // 1er []filas - 2ndo columnas
    private DefaultTableModel modeloTabla;//tabla default
    private String[] columnas = {"Pelicula","Recaudacion"}; //las cols
    private VentasController ventasController; //creamos el controller
    private PeliculasController peliculaController;
    //Constructor
    public EmitirReporte(){
        super("Mayores Peliculas recaudadoras");
        panelPrincipal = new JPanel(); //inicializam panel
        //Configurac del panel
        panelPrincipal.setLayout(new BorderLayout()); //del tipo borde el layout
        getContentPane().add(panelPrincipal); //se añade al panel
        setSize(700,600); // Establece el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación de cierre de la ventana

        ventasController = VentasController.getInstance(); //Obtener instancia del controller
        peliculaController = PeliculasController.getInstance();

        data = convertDtoToData(peliculaController.listaPeliculas()); //Esto para crear la matriz trayendo la lista, lo q devuelve el metodo

        modeloTabla= new DefaultTableModel(data,columnas); //Crea un modelo de tabla con los datos y las columnas
        table = new JTable(modeloTabla); //crea tabla para mostrar

        JScrollPane scrollPane = new JScrollPane(table); //Panel de desplazam
        panelPrincipal.add(scrollPane,BorderLayout.CENTER);

        setVisible(true); // Hace visible la ventana
    }

    //Metodo para mostrar lo q queremos ver
    public Object[][] convertDtoToData(List<PeliculaDto> list){
        Object[][] data = new Object[list.size()][2]; // Crea una matriz de objetos con el tamaño de la lista y 2 columnas
        for (int i = 0; i < list.size(); i++){
            PeliculaDto pelicula = list.get(i);
            data[i][0] = pelicula.getNombrePelicula();
            data[i][1] = ventasController.recaudacionPorPelicula(Integer.valueOf(pelicula.getPeliculaID())); // Asigna el ID de la propiedad a la primera columna
        }
        return data;
    }

    public static void main(String[] args){
        new EmitirReporte();
    }

}