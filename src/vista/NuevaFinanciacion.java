package vista;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class NuevaFinanciacion extends JFrame {
    public JTextField montoFinanciado;
    public JTextField motivoFinanciacion;
    public JComboBox<String> cuenta;

    public JButton solicitar;
    public String[] financiacionOptions = {""};
    public JButton volver;

    public NuevaFinanciacion(){
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Solicitar Financiación");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());

        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Solicitar Financiación Bancaria");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFontBold);
        titulo.setBounds(80, 10, 300, size.height);

        JLabel montoLabel = new JLabel("Monto Financiado:");
        montoLabel.setFont(headlineFontBold);
        montoLabel.setBounds(50, 50, 200, 30);

        montoFinanciado = new JTextField();
        montoFinanciado.setBounds(50, 80, 300, 30);

        JLabel motivoLabel = new JLabel("Motivo de la Financiación:");
        motivoLabel.setFont(headlineFontBold);
        motivoLabel.setBounds(50, 120, 200, 30);

        motivoFinanciacion = new JTextField();
        motivoFinanciacion.setBounds(50, 150, 300, 30);

        JLabel financiacionLabel = new JLabel("Cuenta para la Financiación:");
        financiacionLabel.setFont(headlineFontBold);
        financiacionLabel.setBounds(50, 190, 200, 30);

        cuenta = new JComboBox<>(financiacionOptions);
        cuenta.setBounds(50, 220, 300, 30);

        solicitar = new JButton("Solicitar Financiación");
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
        add(montoLabel);
        add(montoFinanciado);
        add(motivoLabel);
        add(motivoFinanciacion);
        add(financiacionLabel);
        add(cuenta);
        add(solicitar);
        add(volver);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getMontoFinanciado() {
        return montoFinanciado.getText().trim();
    }

    public String getMotivoFinanciacion() {
        return motivoFinanciacion.getText().trim();
    }

    public String getCuenta() {
        return (String) cuenta.getSelectedItem();
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

}
