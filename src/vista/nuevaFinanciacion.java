package vista;

import javax.swing.*;
import java.awt.*;

public class nuevaFinanciacion extends JFrame {
    public JTextField montoFinanciado;
    public JTextField motivoFinanciacion;
    public JComboBox<String> cuenta; // Cambiado nombre y posición

    public JButton solicitar;

    public nuevaFinanciacion(){
        setSize(400, 350); // Se ajusta la altura para acomodar el nuevo campo
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

        JLabel financiacionLabel = new JLabel("Cuenta para la Financiación:"); // Nuevo
        financiacionLabel.setFont(headlineFontBold);
        financiacionLabel.setBounds(50, 190, 200, 30);

        String[] financiacionOptions = {"Préstamo Personal", "Hipoteca", "Tarjeta de Crédito"};
        cuenta = new JComboBox<>(financiacionOptions);
        cuenta.setBounds(50, 220, 300, 30); // Cambiado posición

        solicitar = new JButton("Solicitar Financiación");
        solicitar.setBounds(100, 270, 200, 40);
        solicitar.setBackground(Color.RED);
        solicitar.setBorder(null);
        solicitar.setFont(headlineFontBold);
        solicitar.setForeground(Color.WHITE);

        add(titulo);
        add(montoLabel);
        add(montoFinanciado);
        add(motivoLabel);
        add(motivoFinanciacion);
        add(financiacionLabel); // Agregado
        add(cuenta); // Agregado
        add(solicitar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getMontoFinanciado() {
        return montoFinanciado.getText().trim();
    }

    public String getMotivoFinanciacion() {
        return motivoFinanciacion.getText().trim();
    }

    public String getTipoFinanciacion() {
        return (String) cuenta.getSelectedItem();
    }
}
