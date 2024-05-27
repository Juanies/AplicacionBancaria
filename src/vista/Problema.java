package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Problema extends JFrame{

    public JButton botonPanelIzquierdo;
    public JButton botonPanelDerecho;

    public Problema(){
        setSize(640, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Santander - Problemas con tu clave");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());

        Font headlineFont = new Font("Headline", Font.PLAIN, 16);
        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);


        JPanel panelIzquierdo = new JPanel();
        JPanel panelDerecho = new JPanel();

        panelIzquierdo.setLayout(null);
        panelDerecho.setLayout(null);

        getContentPane().setLayout(new GridLayout(1, 2, 10, 0));
        getContentPane().add(panelIzquierdo);
        getContentPane().add(panelDerecho);

        JLabel tituloPanelIzquierdo = new JLabel("No recuerdo mi clave de acceso");
        tituloPanelIzquierdo.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPanelIzquierdo.setBounds(0, 10, 300, 30);
        tituloPanelIzquierdo.setFont(headlineFontBold);

        JTextArea detallePanelIzqueirdo = new JTextArea("Si no recuerdas tu clave de acceso recupérela de manera sencilla aquí.");
        detallePanelIzqueirdo.setBounds(20, 40, 300, 100);
        detallePanelIzqueirdo.setLineWrap(true);
        detallePanelIzqueirdo.setWrapStyleWord(true);
        detallePanelIzqueirdo.setOpaque(false);
        detallePanelIzqueirdo.setBorder(new EmptyBorder(10, 10, 10, 10));
        detallePanelIzqueirdo.setFont(headlineFont);


        botonPanelIzquierdo = new JButton("Recuperar Clave");
        botonPanelIzquierdo.setBounds(100, 160, 145, 40);
        botonPanelIzquierdo.setFont(headlineFont);
        botonPanelIzquierdo.setBackground(Color.RED);
        botonPanelIzquierdo.setBorder(null);
        botonPanelIzquierdo.setFont(headlineFontBold);
        botonPanelIzquierdo.setForeground(Color.WHITE);

        JLabel tituloPanelDerecho = new JLabel("No tengo clave de acceso");
        tituloPanelDerecho.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPanelDerecho.setBounds(0, 10, 300, 30);
        tituloPanelDerecho.setFont(headlineFontBold);

        JTextArea detallePanelDerecho= new JTextArea("Date de alta en el servicio de Banca online y consigue tu clave de acceso para operar de manera sencilla.");
        detallePanelDerecho.setBounds(20, 40, 300, 100);
        detallePanelDerecho.setLineWrap(true);
        detallePanelDerecho.setWrapStyleWord(true);
        detallePanelDerecho.setOpaque(false);
        detallePanelDerecho.setBorder(new EmptyBorder(10, 10, 10, 10));
        detallePanelDerecho.setFont(headlineFont);


        botonPanelDerecho = new JButton("Alta en el servicio");
        botonPanelDerecho.setBounds(100, 160, 145, 40);
        botonPanelDerecho.setBackground(Color.RED);
        botonPanelDerecho.setBorder(null);
        botonPanelDerecho.setFont(headlineFontBold);
        botonPanelDerecho.setForeground(Color.WHITE);

        panelIzquierdo.add(tituloPanelIzquierdo);
        panelIzquierdo.add(botonPanelIzquierdo);
        panelIzquierdo.add(detallePanelIzqueirdo);

        panelDerecho.add(tituloPanelDerecho);
        panelDerecho.add(botonPanelDerecho);
        panelDerecho.add(detallePanelDerecho);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
