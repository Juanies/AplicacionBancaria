package vista;

import javax.swing.*;
import java.awt.*;

public class OlvidarContraseña extends JFrame {
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

        JComboBox<String> tipoDocumentoDropdown;
        String[] opcionesDocumento = {"NIF", "CIF", "NIE"};
        tipoDocumentoDropdown = new JComboBox<>(opcionesDocumento);
        tipoDocumentoDropdown.setSelectedIndex(0);
        tipoDocumentoDropdown.setBounds(150, 50, 80, 30);

        JTextField numeroDocumentoField = new JTextField("Número de documento");
        numeroDocumentoField.setFont(headlineFont);
        numeroDocumentoField.setBounds(240, 50, 200, 30);

        JTextField usuarioField = new JTextField("Usuario");
        usuarioField.setFont(headlineFont);
        usuarioField.setBounds(150, 100, 300, 30);

        JButton recuperarButton = new JButton("Recuperar");
        recuperarButton.setBounds(150, 150, 145, 40);
        recuperarButton.setBackground(Color.RED);
        recuperarButton.setBorder(null);
        recuperarButton.setFont(headlineFontBold);
        recuperarButton.setForeground(Color.WHITE);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(305, 150, 145, 40);
        cancelarButton.setBackground(Color.GRAY);
        cancelarButton.setBorder(null);
        cancelarButton.setFont(headlineFontBold);
        cancelarButton.setForeground(Color.WHITE);

        add(titulo);
        add(tipoDocumentoDropdown);
        add(numeroDocumentoField);
        add(usuarioField);
        add(recuperarButton);
        add(cancelarButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
