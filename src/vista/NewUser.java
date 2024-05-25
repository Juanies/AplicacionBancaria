package vista;

import javax.swing.*;
import java.awt.*;

public class NewUser extends JFrame {
    public JComboBox tipoDocumentoDropdown;
    public JTextField numeroDocumentoField;
    public JTextField usuarioField;
    public JTextField claveField;
    public JButton registrarButton;
    public JButton cancelarButton;

    public NewUser(){
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Registro de Usuario");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());

        Font headlineFont = new Font("Headline", Font.PLAIN, 16);
        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Registra una nueva cuenta");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFont);
        titulo.setBounds(200, 10, 200, size.height);

        String[] opcionesDocumento = {"NIF", "CIF", "NIE"};
        tipoDocumentoDropdown = new JComboBox<>(opcionesDocumento);
        tipoDocumentoDropdown.setSelectedIndex(0);
        tipoDocumentoDropdown.setBounds(150, 50, 80, 30);

        numeroDocumentoField = new JTextField("Número de documento");
        numeroDocumentoField.setFont(headlineFont);
        numeroDocumentoField.setBounds(240, 50, 210, 30);

        usuarioField = new JTextField("Usuario");
        usuarioField.setFont(headlineFont);
        usuarioField.setBounds(150, 100, 300, 30);

        claveField = new JTextField("Contraseña");
        claveField.setFont(headlineFont);
        claveField.setBounds(150, 150, 300, 30);

        registrarButton = new JButton("Registrar");
        registrarButton.setBounds(150, 200, 145, 40);
        registrarButton.setBackground(Color.RED);
        registrarButton.setBorder(null);
        registrarButton.setFont(headlineFontBold);
        registrarButton.setForeground(Color.WHITE);

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(305, 200, 145, 40);
        cancelarButton.setBackground(Color.GRAY);
        cancelarButton.setBorder(null);
        cancelarButton.setFont(headlineFontBold);
        cancelarButton.setForeground(Color.WHITE);

        add(titulo);
        add(tipoDocumentoDropdown);
        add(numeroDocumentoField);
        add(usuarioField);
        add(claveField);
        add(registrarButton);
        add(cancelarButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getTipoDocumento() {
        return (String) tipoDocumentoDropdown.getSelectedItem();
    }

    public String getDocumento() {
        return numeroDocumentoField.getText();
    }

    public String getUsuario() {
        return usuarioField.getText();
    }

    public String getClave() {
        return claveField.getText();
    }



}


