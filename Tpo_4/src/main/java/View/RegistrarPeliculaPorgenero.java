package View;

import Controller.FuncionController;
import Controller.PeliculasController;
import Dto.PeliculaDto;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrarPeliculaPorgenero extends JFrame {
    private PeliculasController controller;
    private JButton aceptar,borrar,limpiar;
    private JTextField tpeliculaID,tipoGenero,director,duracion,nombrePelicula,tipoproyeccion,descuento,actorT;
    private JLabel lpeliculaID,tipoG,direc,duro,nompeli,tipoP,desc,actorL;
    public RegistrarPeliculaPorgenero(String genero) {
        setLayout(null);
        setBounds(0, 0, 500, 500);
        setTitle("Registrar Pelicula");
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //para input DE TXT

        tpeliculaID = new JTextField();
        tpeliculaID.setBounds(120,10,200,20);
        add(tpeliculaID);

/*
        tipoGenero = new JTextField();
        tipoGenero.setBounds(120, 40, 200, 20);
        add(tipoGenero);
        tipoGenero.setColumns(10);
*/

        director = new JTextField();
        director.setBounds(120, 40, 200, 20);
        add(director);
        director.setColumns(10);

        duracion = new JTextField();
        duracion.setBounds(120, 70, 200, 20);
        add(duracion);
        duracion.setColumns(10);

        nombrePelicula = new JTextField();
        nombrePelicula.setBounds(120, 100, 200, 20);
        add(nombrePelicula);
        nombrePelicula.setColumns(10);

        tipoproyeccion = new JTextField();
        tipoproyeccion.setBounds(120, 130, 200, 20);
        add(tipoproyeccion);
        tipoproyeccion.setColumns(10);

        descuento = new JTextField();
        descuento.setBounds(120,160,200,20);
        add(descuento);
        descuento.setColumns(10);

        actorT = new JTextField();
        actorT.setBounds(120,190,200,20);
        add(actorT);

        //TEXTO

        lpeliculaID = new JLabel("PeliculaID:");
        lpeliculaID.setBounds(10,10,100,20);
        add(lpeliculaID);

        /*
        tipoG = new JLabel("Tipo Genero:");
        tipoG.setBounds(10, 40, 100, 20);
        add(tipoG);
*/
        direc = new JLabel("Director:");
        direc.setBounds(10, 40, 100, 20);
        add(direc);

        duro = new JLabel("Duracion:");
        duro.setBounds(10, 70, 100, 20);
        add(duro);

        nompeli = new JLabel("Nombre de la Pelicula:");
        nompeli.setBounds(10, 100, 100, 20);
        add(nompeli);

        tipoP = new JLabel("Tipo Proyeccion:");
        tipoP.setBounds(10, 130, 100, 20);
        add(tipoP);

        desc = new JLabel("Descuento:");
        desc.setBounds(10, 160, 100, 20);
        add(desc);

        actorL = new JLabel("NombreActor(separados por una coma):");
        actorL.setBounds(10,190,150,20);
        add(actorL);

        //BOTTON


        aceptar=new JButton("Aceptar");
        aceptar.setBounds(10, 220, 90, 30);
        add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String peliculaID = tpeliculaID.getText();
                String tipogenero = genero;
                String direct = director.getText();
                String durac = duracion.getText();
                String pelicula = nombrePelicula.getText();
                String tipoproyec = tipoproyeccion.getText();
                String descuen = desc.getText();
                List<String> listaActores = Arrays.asList(actorT.getText().split(","));
                PeliculaDto dto = new PeliculaDto(peliculaID,tipogenero,direct,durac,pelicula,tipoproyec,descuen,listaActores);
                controller = PeliculasController.getInstance();
                controller.agregarPeli(dto);
            }
        });

        borrar=new JButton("Borrar");
        borrar.setBounds(110, 220, 90, 30);
        add(borrar);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        limpiar=new JButton("Limpiar");
        limpiar.setBounds(210, 220, 90, 30);
        add(limpiar);
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tipoGenero.setText("");
                director.setText("");
                duracion.setText("");
                nombrePelicula.setText("");
                tipoproyeccion.setText("");
                descuento.setText("");
            }
        });
        //Muestro JFrame (lo último para que lo pinte todo correctamanete)
        setVisible(true);
    }

    public static void main(String[] args) {
        String genero = "Terror";
        new RegistrarPeliculaPorgenero(genero);
    }

}
