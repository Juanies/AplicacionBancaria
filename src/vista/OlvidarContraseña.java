package vista;

import javax.swing.*;
import java.awt.*;

public class OlvidarContraseña extends JFrame {

    public JButton cancelar;
    public JButton recuperar;
    public JComboBox<String> tipoDocumentoDropdown;
    public JTextField numeroDocumentoField;
    public JTextField usuarioField;

    public OlvidarContraseña(){
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Recuperar Contraseña");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());

        Font headlineFont = new Font("Headline", Font.PLAIN, 16);
        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Recuperar Contraseña");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFont);
        titulo.setBounds(220, 10, 200, size.height);


        String[] opcionesDocumento = {"NIF", "CIF", "NIE"};
        tipoDocumentoDropdown = new JComboBox<>(opcionesDocumento);
        tipoDocumentoDropdown.setSelectedIndex(0);
        tipoDocumentoDropdown.setBounds(150, 50, 80, 30);

         numeroDocumentoField = new JTextField("Número de documento");
        numeroDocumentoField.setFont(headlineFont);
        numeroDocumentoField.setBounds(240, 50, 200, 30);

        usuarioField = new JTextField("Usuario");
        usuarioField.setFont(headlineFont);
        usuarioField.setBounds(150, 100, 300, 30);

        recuperar = new JButton("Recuperar");
        recuperar.setBounds(150, 150, 145, 40);
        recuperar.setBackground(Color.RED);
        recuperar.setBorder(null);
        recuperar.setFont(headlineFontBold);
        recuperar.setForeground(Color.WHITE);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(305, 150, 145, 40);
        cancelar.setBackground(Color.GRAY);
        cancelar.setBorder(null);
        cancelar.setFont(headlineFontBold);
        cancelar.setForeground(Color.WHITE);

        add(titulo);
        add(tipoDocumentoDropdown);
        add(numeroDocumentoField);
        add(usuarioField);
        add(recuperar);
        add(cancelar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getDocumento(){
        return numeroDocumentoField.getText();
    }

    public String getUsuario(){
        return usuarioField.getText();
    }

}
