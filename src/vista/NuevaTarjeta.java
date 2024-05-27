package vista;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class NuevaTarjeta extends JFrame {
    public JTextField nombreTarjeta;
    public JComboBox<String> cuenta;
    public JComboBox<String> tipoTarjeta;

    public JButton volver;

    public JButton solicitar;
    public String[] financiacionOptions = {""};

    public NuevaTarjeta(){
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Solicitar Financiación");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());

        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Solicitar nueva tarjeta");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFontBold);
        titulo.setBounds(80, 10, 300, size.height);

        JLabel nombreTajetaLabel = new JLabel("Nombre tarjeta:");
        nombreTajetaLabel.setFont(headlineFontBold);
        nombreTajetaLabel.setBounds(50, 50, 200, 30);

        nombreTarjeta = new JTextField();
        nombreTarjeta.setBounds(50, 80, 300, 30);



        JLabel financiacionLabel = new JLabel("Cuenta para la tarjeta:");
        financiacionLabel.setFont(headlineFontBold);
        financiacionLabel.setBounds(50, 120, 200, 30);

        cuenta = new JComboBox<>(financiacionOptions);
        cuenta.setBounds(50, 150, 300, 30);
        String[] tipoTarjetas = {"Debito", "Credito"};

        tipoTarjeta = new JComboBox<>(tipoTarjetas);
        tipoTarjeta.setBounds(50, 200, 300, 30);


        solicitar = new JButton("Solicitar Tarjeta");
        solicitar.setBounds(50, 270, 300, 40);
        solicitar.setBackground(Color.RED);
        solicitar.setBorder(null);
        solicitar.setFont(headlineFontBold);
        solicitar.setForeground(Color.WHITE);

        volver = new JButton("Volver");
        volver.setBounds(50, 320, 300, 40);
        volver.setBackground(Color.LIGHT_GRAY);
        volver.setBorder(null);
        volver.setFont(headlineFontBold);
        volver.setForeground(Color.WHITE);


        add(titulo);
        add(nombreTajetaLabel);
        add(nombreTarjeta);
        add(financiacionLabel);
        add(cuenta);
        add(solicitar);
        add(volver);
        add(tipoTarjeta);
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

    public String getCuenta() {
        return (String) cuenta.getSelectedItem();
    }

    public String getTipoTarjeta() {
        return (String) tipoTarjeta.getSelectedItem();
    }


    public String getNombreTarjeta() {
        return nombreTarjeta.getText().trim();
    }





}
