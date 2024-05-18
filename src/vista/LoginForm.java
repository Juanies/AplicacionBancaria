package vista;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    public LoginForm(){
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Inicia sesion");
        setIconImage(new ImageIcon( "src/media/icono.png").getImage());

        Font headlineFont = new Font("Headline", Font.PLAIN, 16);
        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Te damos la bienvenida a tu Banca Online");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFont);
        titulo.setBounds(150, 10, 300, size.height);

        JComboBox<String> optionsDropdown;
        String[] options = {"NIF", "CIF", "NIE", "Usuario"};
        optionsDropdown = new JComboBox<>(options);
        optionsDropdown.setSelectedIndex(1); // No option selected by default
        add(optionsDropdown);
        optionsDropdown.setBounds(150, 80, 80, 30);

        JTextField nDocumento = new JTextField("Nº de documento");
        nDocumento.setFont(headlineFont);
        nDocumento.setBounds(236, 80, 300 - 90, 30);

        JTextField clave = new JTextField("Clave de acceso");
        clave.setFont(headlineFont);
        clave.setBounds(150, 140, (300 - 90) + 80 + 6, 30);

        JCheckBox recordar = new JCheckBox("Recordar usuario");
        recordar.setBounds(150, 190, recordar.getPreferredSize().width, 20);

        JButton entrar = new JButton("Entrar");
        entrar.setBounds(300, 190, 145, 40);
        entrar.setBackground(Color.RED);
        entrar.setBorder(null);
        entrar.setFont(headlineFontBold);
        entrar.setForeground(Color.WHITE);



        JButton problemas = new JButton("¿Problemas con tu clave de acceso?");
        problemas.setBounds(250, 240, problemas.getPreferredSize().width, size.height);
        problemas.setBackground(null);
        problemas.setContentAreaFilled(false);
        problemas.setOpaque(false);
        problemas.setBorderPainted(false);


        add(titulo);
        add(nDocumento);
        add(clave);
        add(recordar);
        add(entrar);
        add(problemas);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
