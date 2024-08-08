package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresarGenro extends JFrame {
    private JButton aceptar,cancelar;
    private JTextField tipoGenero;
    private JLabel labelGenero;

    public IngresarGenro(){
        setLayout(null);
        setBounds(0, 0, 700, 500);
        setTitle("Ingresar Genero");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tipoGenero = new JTextField();
        tipoGenero.setBounds(140, 10, 200, 20);
        add(tipoGenero);

        labelGenero = new JLabel("Ingrese tipo genero:");
        labelGenero.setBounds(10, 10, 200, 20);
        add(labelGenero);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(10, 40, 90, 30);
        add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = tipoGenero.getText();
                if (genero.isEmpty() || !isValidGenero(genero)) {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado o el dato ingresado es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    RegistrarPeliculaPorgenero pelig = new RegistrarPeliculaPorgenero(genero);
                }
            }
        });

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(110, 40, 90, 30);
        add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);

    }
    public IngresarGenro(String dato){
        setLayout(null);
        setBounds(0, 0, 700, 500);
        setTitle("Ingresar Genero");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tipoGenero = new JTextField();
        tipoGenero.setBounds(140, 10, 200, 20);
        add(tipoGenero);

        labelGenero = new JLabel("Ingrese tipo genero:");
        labelGenero.setBounds(10, 10, 200, 20);
        add(labelGenero);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(10, 40, 90, 30);
        add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = tipoGenero.getText();
                if (genero.isEmpty() || !isValidGenero(genero)) {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado o el dato ingresado es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    ConsultarPelicula cpeli = new ConsultarPelicula(genero);
                }
            }
        });


        cancelar = new JButton("Cancelar");
        cancelar.setBounds(110, 40, 90, 30);
        add(cancelar);
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);

    }
    private boolean isValidGenero(String genero) {
        return true;
    }
    public static void main(String[] args){
        new IngresarGenro();
    }
}
