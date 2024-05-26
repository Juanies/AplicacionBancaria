package vista;

import javax.swing.*;
import java.awt.*;

public class NuevaCuenta extends JFrame {
    public JComboBox<String> tipoCuenta;
    public JTextField nombreCuenta;
    public JButton crear;

    public NuevaCuenta(){
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Santander - Crear Nueva Cuenta");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());

        Font headlineFontBold = new Font("Headline", Font.BOLD, 16);

        JLabel titulo = new JLabel("Crear Nueva Cuenta Bancaria");
        Dimension size = titulo.getPreferredSize();
        titulo.setFont(headlineFontBold);
        titulo.setBounds(100, 10, 300, size.height);

        JLabel accountTypeLabel = new JLabel("Tipo de Cuenta:");
        accountTypeLabel.setFont(headlineFontBold);
        accountTypeLabel.setBounds(50, 50, 200, 30);

        String[] accountTypes = {"Corriente", "Ahorro", "Nómina"};
        tipoCuenta = new JComboBox<>(accountTypes);
        tipoCuenta.setBounds(200, 50, 150, 30);

        JLabel accountNameLabel = new JLabel("Nombre de la Cuenta:");
        accountNameLabel.setFont(headlineFontBold);
        accountNameLabel.setBounds(50, 100, 200, 30);

        nombreCuenta = new JTextField();
        nombreCuenta.setBounds(50, 130, 300, 30);

        crear = new JButton("Crear Cuenta");
        crear.setBounds(125, 180, 150, 40);
        crear.setBackground(Color.RED);
        crear.setBorder(null);
        crear.setFont(headlineFontBold);
        crear.setForeground(Color.WHITE);

        add(titulo);
        add(accountTypeLabel);
        add(tipoCuenta);
        add(accountNameLabel);
        add(nombreCuenta);
        add(crear);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String gettipoCuenta() {
        return (String) tipoCuenta.getSelectedItem();
    }

    public String getCuentaNombre() {
        return nombreCuenta.getText().trim();
    }

}


