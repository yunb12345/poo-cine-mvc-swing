package View;

import Controller.FuncionController;
import Dto.FuncionDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class RegistrarFuncionPorgenero extends JFrame {
    private FuncionController controller;
    private JButton aceptar, borrar, limpiar;
    private JTextField tfecha, tfuncionID, thorario, tentrada, tsalaid,tnombrePelicula;
    private JLabel funcion, fecha, horario, entrada, salaid, pelicula;
    //private FuncionController funcionController = FuncionController.getInstance();

    public RegistrarFuncionPorgenero() {
        setLayout(null);
        setBounds(0, 0, 700, 500);
        setTitle("Registrar Funcion");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //cuadro txt

        tnombrePelicula = new JTextField();
        tnombrePelicula.setBounds(120,10,200,20);
        add(tnombrePelicula);
        tfuncionID = new JTextField();
        tfuncionID.setBounds(120, 40, 200, 20);
        add(tfuncionID);
        thorario = new JTextField();
        thorario.setBounds(120, 70, 200, 20);
        add(thorario);
        /*
        tentrada = new JTextField();
        tentrada.setBounds(120, 100, 200, 20);
        add(tentrada);

         */
        tsalaid = new JTextField();
        tsalaid.setBounds(120, 130, 200, 20);
        add(tsalaid);

        tfecha = new JTextField();
        tfecha.setBounds(120,160,200,20);
        add(tfecha);



        //labels

        pelicula = new JLabel("NombrePelicula:");
        pelicula.setBounds(10, 10, 200, 20);
        add(pelicula);

        funcion = new JLabel("funcionID:");
        funcion.setBounds(10, 40, 200, 20);
        add(funcion);
        horario = new JLabel("Horario:");
        horario.setBounds(10, 70, 200, 20);
        add(horario);
        /*
        entrada = new JLabel("nroAsiento(separado por coma):");
        entrada.setBounds(10, 100, 200, 20);
        add(entrada);

         */
        salaid = new JLabel("sala id:");
        salaid.setBounds(10, 130, 200, 20);
        add(salaid);
        fecha = new JLabel("fecha:");
        fecha.setBounds(10,160,200,20);
        add(fecha);



        //Bottones
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(10, 190, 90, 30);
        add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionController funcionController = FuncionController.getInstance();
                String nombrePelicula = tnombrePelicula.getText();
                String funcionID = tfuncionID.getText();
                String hora = thorario.getText();
                //List<String> entradas = Arrays.asList(tentrada.getText().split(","));
                String salaID = tsalaid.getText();
                String fech = tfecha.getText();

                FuncionDTO dto = new FuncionDTO(nombrePelicula,funcionID,hora,salaID,fech);
                funcionController.agregarFuncion(dto);


            }
        });
        borrar = new JButton("Borrar");
        borrar.setBounds(110, 190, 90, 30);
        add(borrar);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(210, 190, 90, 30);
        add(limpiar);

        setVisible(true);
    }

    public static void main(String[] args){
        new RegistrarFuncionPorgenero();
    }
}
