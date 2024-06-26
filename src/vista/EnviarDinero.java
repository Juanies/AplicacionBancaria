package vista;

import programa.Cuenta;
import programa.UsuarioDAO;
import programa.Util;
import programa.CuentaDAO;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class EnviarDinero extends JFrame {
    public JTextField idCuentaField;
    public JTextField cantidadField;
    public JTextField motivoField;
    public JButton enviarButton;
    public JButton volverButton;
    public JComboBox<String> cuenta;
    public String[] financiacionOptions = {""};

    public EnviarDinero(){
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Enviar Dinero");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());

        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Enviar Dinero");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFontBold);
        titulo.setBounds(150, 10, 200, size.height);

        JLabel idCuentaLabel = new JLabel("Id cuenta:");
        idCuentaLabel.setFont(headlineFontBold);
        idCuentaLabel.setBounds(50, 50, 150, 30);

        idCuentaField = new JTextField();
        idCuentaField.setBounds(150, 50, 200, 30);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setFont(headlineFontBold);
        cantidadLabel.setBounds(50, 100, 100, 30);

        cantidadField = new JTextField();
        cantidadField.setBounds(150, 100, 200, 30);

        JLabel motivoLabel = new JLabel("Motivo:");
        motivoLabel.setFont(headlineFontBold);
        motivoLabel.setBounds(50, 150, 100, 30);

        motivoField = new JTextField();
        motivoField.setBounds(150, 150, 200, 30);

        cuenta = new JComboBox<>(financiacionOptions);
        cuenta.setBounds(50, 200, 300, 30);

        enviarButton = new JButton("Enviar");
        enviarButton.setBounds(50, 240, 150, 40);
        enviarButton.setBackground(Color.RED);
        enviarButton.setBorder(null);
        enviarButton.setFont(headlineFontBold);
        enviarButton.setForeground(Color.WHITE);

        volverButton = new JButton("Volver");
        volverButton.setBounds(210, 240, 150, 40);
        volverButton.setBackground(Color.LIGHT_GRAY);
        volverButton.setBorder(null);
        volverButton.setFont(headlineFontBold);
        volverButton.setForeground(Color.WHITE);

        add(idCuentaField);
        add(idCuentaLabel);

        add(titulo);
        add(cantidadLabel);
        add(cantidadField);
        add(motivoLabel);
        add(motivoField);
        add(cuenta);
        add(enviarButton);
        add(volverButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setCuentas() throws IOException, ClassNotFoundException {
        ArrayList<Cuenta> cuentas = CuentaDAO.cogerTodasCuentasUsuario(UsuarioDAO.getUsuarioActual().getId(), Util.con());
        ArrayList<String> nombres = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            nombres.add(cuenta.getNombreCuenta());
        }

        financiacionOptions = nombres.toArray(new String[0]);

        // Esto actualiza el ComboBox con el array cambiado
        cuenta.setModel(new DefaultComboBoxModel<>(financiacionOptions));
    }

    public int getidCuentaField() {
        return  Integer.parseInt(idCuentaField.getText());
    }

    public double getCantidad() {
        return Double.parseDouble(cantidadField.getText());
    }

    public String getMotivo() {
        return motivoField.getText();
    }

    public String getSelectedCuenta() {
        return (String) cuenta.getSelectedItem();
    }
}
