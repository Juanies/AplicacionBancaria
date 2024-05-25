package vista;

import vista.LoginForm;
import javax.swing.plaf.basic.BasicScrollBarUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Dashboard extends JFrame {
    private JPanel leftPanel;
    public String tuDineroTotal = "122";
    public String tuFinanciacionTotal = "122";

    public Dashboard() {
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Santander");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Font Fonts = new Font("Arial", Font.PLAIN, 16);
        Font FontsBold = new Font("Arial", Font.BOLD, 16);

        JPanel navBar = new JPanel();
        navBar.setPreferredSize(new Dimension(getWidth(), 50));
        navBar.setLayout(new BoxLayout(navBar, BoxLayout.X_AXIS));
        navBar.setBackground(new Color(220, 53, 69));
        navBar.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel x = new JLabel("Buenas tardes, Romero Angel Millan");
        JLabel x1 = new JLabel("Ultima conexion: 18-05-2024 / 20:43");
        JLabel x2 = new JLabel("Cambiar");

        x.setFont(Fonts);
        x.setForeground(Color.WHITE);
        x1.setFont(Fonts);
        x1.setForeground(Color.WHITE);
        x2.setFont(FontsBold);
        x2.setForeground(Color.WHITE);

        navBar.add(x);
        navBar.add(Box.createHorizontalGlue());
        navBar.add(x1);
        navBar.add(Box.createHorizontalGlue());
        navBar.add(x2);

        add(navBar, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        leftPanel.setSize(new Dimension(760, getHeight()));

        JPanel generalInfo = new JPanel();
        generalInfo.setLayout(new FlowLayout(FlowLayout.LEFT));
        generalInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
        generalInfo.setPreferredSize(new Dimension(630, 90));
        generalInfo.setBackground(new Color(248, 249, 250));

        JPanel tuDineroPanel = new JPanel();
        tuDineroPanel.setLayout(new BoxLayout(tuDineroPanel, BoxLayout.Y_AXIS));
        tuDineroPanel.setBackground(new Color(220, 53, 69));
        tuDineroPanel.setBorder(new EmptyBorder(10, 10, 10, 40));
        JLabel tu = new JLabel("Tu Dinero: ");
        tu.setFont(Fonts);
        tu.setForeground(Color.WHITE);
        tu.setFont(FontsBold);
        tu.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel dinero = new JLabel( tuDineroTotal + " EUR");
        dinero.setFont(FontsBold);
        dinero.setAlignmentX(Component.LEFT_ALIGNMENT);
        dinero.setForeground(Color.WHITE);

        tuDineroPanel.add(tu);
        tuDineroPanel.add(dinero);

        JPanel tuFinanciacion = new JPanel();
        tuFinanciacion.setLayout(new BoxLayout(tuFinanciacion, BoxLayout.Y_AXIS));
        tuFinanciacion.setBackground(new Color(40, 167, 69));
        tuFinanciacion.setBorder(new EmptyBorder(10, 10, 10, 40));

        JLabel financiacionLabel = new JLabel("Tu Financiacion: ");
        financiacionLabel.setFont(FontsBold);
        financiacionLabel.setForeground(Color.WHITE);

        JLabel dinerolabel = new JLabel(tuFinanciacionTotal + " EUR");
        dinerolabel.setFont(FontsBold);
        dinerolabel.setForeground(Color.WHITE);

        tuFinanciacion.add(financiacionLabel);
        tuFinanciacion.add(dinerolabel);

        generalInfo.add(tuDineroPanel);
        generalInfo.add(tuFinanciacion);

        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(generalInfo);

        JScrollPane scrollPane = new JScrollPane(leftPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBackground(Color.WHITE);

        // Forma de cambiar el color de la barra de scroll : PD: StackOverFlow
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(220, 53, 69);
            }
        });

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(270, getHeight()));

        centerPanel.add(scrollPane, BorderLayout.WEST);
        centerPanel.add(rightPanel, BorderLayout.CENTER);

        JPanel Cuentas = new JPanel(new BorderLayout());
        Cuentas.setBorder(new EmptyBorder(10, 10, 10, 10));
        Cuentas.setBackground(new Color(248, 249, 250));

        JLabel cuentasLabel = new JLabel("Cuentas:");
        cuentasLabel.setFont(FontsBold);
        cuentasLabel.setOpaque(true);
        cuentasLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        Cuentas.add(cuentasLabel, BorderLayout.NORTH);

        JPanel cuentasPanel = new JPanel();
        cuentasPanel.setLayout(new BoxLayout(cuentasPanel, BoxLayout.Y_AXIS));
        cuentasPanel.setBackground(new Color(248, 249, 250));
        Cuentas.add(cuentasPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 4; i++) {
            JPanel cuenta = new JPanel(new BorderLayout());
            cuenta.setBorder(new EmptyBorder(10, 40, 10, 10));
            cuenta.setMaximumSize(new Dimension(630, 90));
            cuenta.setBackground(new Color(255, 255, 255));

            JPanel cuentaInfoPanel = new JPanel();
            cuentaInfoPanel.setLayout(new BoxLayout(cuentaInfoPanel, BoxLayout.Y_AXIS));
            cuentaInfoPanel.setOpaque(false);

            JLabel cuentaLabel = new JLabel("Cuenta " + i);
            cuentaLabel.setFont(FontsBold);
            cuentaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel numberLabel = new JLabel("1234"); // Número de cuenta de ejemplo
            numberLabel.setFont(Fonts);
            numberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            cuentaInfoPanel.add(cuentaLabel);
            cuentaInfoPanel.add(Box.createVerticalStrut(5));
            cuentaInfoPanel.add(numberLabel);

            JLabel montoLabel = new JLabel("1232300EUR");
            montoLabel.setFont(FontsBold);
            montoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            cuenta.add(cuentaInfoPanel, BorderLayout.WEST);
            cuenta.add(montoLabel, BorderLayout.EAST);

            cuentasPanel.add(cuenta);
            cuentasPanel.add(Box.createVerticalStrut(10));
        }

        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(Cuentas);

        JPanel Tarjetas = new JPanel(new BorderLayout());
        Tarjetas.setBorder(new EmptyBorder(10, 10, 10, 10));
        Tarjetas.setBackground(new Color(248, 249, 250));

        JLabel tarjetasLabel = new JLabel("Tarjetas:");
        tarjetasLabel.setFont(FontsBold);
        tarjetasLabel.setOpaque(true);
        tarjetasLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        Tarjetas.add(tarjetasLabel, BorderLayout.NORTH);

        JPanel tarjetasPanel = new JPanel();
        tarjetasPanel.setLayout(new BoxLayout(tarjetasPanel, BoxLayout.Y_AXIS));
        tarjetasPanel.setBackground(new Color(248, 249, 250));
        Tarjetas.add(tarjetasPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 3; i++) {
            JPanel tarjeta = new JPanel(new BorderLayout());
            tarjeta.setBorder(new EmptyBorder(10, 40, 10, 10));
            tarjeta.setSize(new Dimension(630, 90));
            tarjeta.setBackground(new Color(255, 255, 255));

            JPanel tarjetaInfoPanel = new JPanel();
            tarjetaInfoPanel.setLayout(new BoxLayout(tarjetaInfoPanel, BoxLayout.Y_AXIS));
            tarjetaInfoPanel.setOpaque(false);

            JLabel tarjetaLabel = new JLabel("Tarjeta " + i);
            tarjetaLabel.setFont(FontsBold);
            tarjetaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel numberLabel = new JLabel("5678");
            numberLabel.setFont(Fonts);
            numberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            tarjetaInfoPanel.add(tarjetaLabel);
            tarjetaInfoPanel.add(Box.createVerticalStrut(5));
            tarjetaInfoPanel.add(numberLabel);

            JLabel montoLabel = new JLabel("5000EUR");
            montoLabel.setFont(FontsBold);
            montoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            JLabel tarjetaImage = new JLabel(new ImageIcon("src/media/icono.png"));
            tarjetaImage.setPreferredSize(new Dimension(60, 40));

            tarjeta.add(tarjetaInfoPanel, BorderLayout.WEST);
            tarjeta.add(montoLabel, BorderLayout.EAST);
            tarjeta.add(tarjetaImage, BorderLayout.CENTER);

            tarjetasPanel.add(tarjeta);
            tarjetasPanel.add(Box.createVerticalStrut(10));
        }

        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(Tarjetas);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void addNewLabel(String text) {
        JLabel newLabel = new JLabel(text);
        newLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        newLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(newLabel);
        leftPanel.revalidate();
        leftPanel.repaint();
    }
}