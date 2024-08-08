package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame{

    JButton btnConsultarPeliculasPorGenero;
    JButton btnRegistrarUnaPeliculaPorGenero;
    JButton btnRegistrarUnaFuncionPorGenero;
    JButton btnEmitirReporte;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menu(){
    super("Menú");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,600,400);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    btnRegistrarUnaFuncionPorGenero = new JButton("Registrar una nueva función por género");
    btnRegistrarUnaPeliculaPorGenero = new JButton("Registrar una película por género");
    btnConsultarPeliculasPorGenero = new JButton("Consultar las películas por género");
    btnEmitirReporte= new JButton("Emitir un reporte de las películas con mayor recaudación");

    btnRegistrarUnaFuncionPorGenero.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            RegistrarFuncionPorgenero registF = new RegistrarFuncionPorgenero();
        }
    });
    btnRegistrarUnaFuncionPorGenero.setBounds(107,60,400,25);
    contentPane.add(btnRegistrarUnaFuncionPorGenero);
    this.dispose();

    btnRegistrarUnaPeliculaPorGenero.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            IngresarGenro registP = new IngresarGenro();
        }
    });
    btnRegistrarUnaPeliculaPorGenero.setBounds(107,120,400,25);
    contentPane.add(btnRegistrarUnaPeliculaPorGenero);
    this.dispose();

    btnConsultarPeliculasPorGenero.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String dato = "dsa";
            IngresarGenro consuPeli = new IngresarGenro(dato);
        }
    });
    btnConsultarPeliculasPorGenero.setBounds(107,180,400,25);
    contentPane.add(btnConsultarPeliculasPorGenero);
    this.dispose();

    btnEmitirReporte.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            EmitirReporte emiRepo = new EmitirReporte();
        }
    });
    btnEmitirReporte.setBounds(107,240,400,25);
    contentPane.add(btnEmitirReporte);
    this.dispose();
    }

    private JPanel crearConsultaPelicula(){
        JPanel panel = new JPanel();
        return panel;
    }
}
