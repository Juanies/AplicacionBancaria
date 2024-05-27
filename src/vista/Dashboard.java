package vista;

import programa.Cuenta;
import programa.Financiacion;
import programa.Tarjeta;
import vista.LoginForm;
import javax.swing.plaf.basic.BasicScrollBarUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dashboard extends JFrame {
    public JPanel leftPanel;
    public String tuDineroTotal = "122";
    public String tuFinanciacionTotal = "122";
    public JLabel dinero;
    public JLabel dineroFinanciacion;
    public JLabel saludoUsuario;
    public JLabel ultimaConexion;
    public JPanel cuentasPanel;
    public Font FontsBold;
    public Font Fonts;
    public JPanel tarjetasPanel;
    public ArrayList<JButton> botones = new ArrayList<>();
    public JButton cambiar;
    public JPanel financiacionPanel;



    public Dashboard() {
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Santander");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Fonts = new Font("Arial", Font.PLAIN, 16);
        FontsBold = new Font("Arial", Font.BOLD, 16);

        JPanel navBar = new JPanel();
        navBar.setPreferredSize(new Dimension(getWidth(), 50));
        navBar.setLayout(new BoxLayout(navBar, BoxLayout.X_AXIS));
        navBar.setBackground(new Color(220, 53, 69));
        navBar.setBorder(new EmptyBorder(10, 10, 10, 10));

        saludoUsuario = new JLabel("");
        ultimaConexion = new JLabel("");
        cambiar = new JButton("Cambiar");

        saludoUsuario.setFont(Fonts);
        saludoUsuario.setForeground(Color.WHITE);
        ultimaConexion.setFont(Fonts);
        ultimaConexion.setForeground(Color.WHITE);
        cambiar.setFont(FontsBold);
        cambiar.setForeground(Color.WHITE);
        cambiar.setBackground(null);

        navBar.add(saludoUsuario);
        navBar.add(Box.createHorizontalGlue());
        navBar.add(ultimaConexion);
        navBar.add(Box.createHorizontalGlue());
        navBar.add(cambiar);

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

        dinero = new JLabel( tuDineroTotal + " EUR");
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

        dineroFinanciacion = new JLabel(tuFinanciacionTotal + " EUR");
        dineroFinanciacion.setFont(FontsBold);
        dineroFinanciacion.setForeground(Color.WHITE);

        tuFinanciacion.add(financiacionLabel);
        tuFinanciacion.add(dineroFinanciacion);

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
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));




        ArrayList<String> botonesDerecha = new ArrayList<>(Arrays.asList("Nueva cuenta", "Nueva tarjeta", "Nueva financiación", "Enviar dinero", "Cambiar contraseña", "Borrar cuenta Bancaria"));

        for (String boton : botonesDerecha) {
            JButton botons = new JButton(boton);
            botons.setMaximumSize(new Dimension(Integer.MAX_VALUE, botons.getPreferredSize().height + 20));
            botons.setBackground(Color.WHITE);
            rightPanel.add(botons);
            botones.add(botons);
        }

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

        cuentasPanel = new JPanel();
        cuentasPanel.setLayout(new BoxLayout(cuentasPanel, BoxLayout.Y_AXIS));
        cuentasPanel.setBackground(new Color(248, 249, 250));
        Cuentas.add(cuentasPanel, BorderLayout.CENTER);





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

        tarjetasPanel = new JPanel();
        tarjetasPanel.setLayout(new BoxLayout(tarjetasPanel, BoxLayout.Y_AXIS));
        tarjetasPanel.setBackground(new Color(248, 249, 250));
        Tarjetas.add(tarjetasPanel, BorderLayout.CENTER);


        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(Tarjetas);

        add(centerPanel, BorderLayout.CENTER);

        JPanel Financiacion = new JPanel(new BorderLayout());
        Financiacion.setBorder(new EmptyBorder(10, 10, 10, 10));
        Financiacion.setBackground(new Color(248, 249, 250));

        JLabel financiacionLabel2 = new JLabel("Financiación:");
        financiacionLabel2.setFont(FontsBold);
        financiacionLabel2.setOpaque(true);
        financiacionLabel2.setBorder(new EmptyBorder(10, 10, 10, 10));

        Financiacion.add(financiacionLabel2, BorderLayout.NORTH);

        financiacionPanel = new JPanel();
        financiacionPanel.setLayout(new BoxLayout(financiacionPanel, BoxLayout.Y_AXIS));
        financiacionPanel.setBackground(new Color(248, 249, 250));
        Financiacion.add(financiacionPanel, BorderLayout.CENTER);

        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(Financiacion);

        setVisible(true);
    }


    public void setFinanciacionTotalText(String text) {
        tuFinanciacionTotal = text;
        dineroFinanciacion.setText(tuFinanciacionTotal + " EUR");
    }

    public void setSaludoText(String text) {
        saludoUsuario.setText("Buenas tardes, " + text);
    }

    public void setUltimaConexion(String text) {
        ultimaConexion.setText(text);
    }


    public void setDineroTotalText(String text) {
        tuDineroTotal = text;
        dinero.setText(tuDineroTotal + " EUR");
    }


    public void setCuentas(ArrayList<Cuenta> cuentas){
        for (Cuenta cuentaa : cuentas) {
            JPanel cuenta = new JPanel(new BorderLayout());
            cuenta.setBorder(new EmptyBorder(10, 40, 10, 10));
            cuenta.setMaximumSize(new Dimension(630, 90));
            cuenta.setBackground(new Color(255, 255, 255));

            JPanel cuentaInfoPanel = new JPanel();
            cuentaInfoPanel.setLayout(new BoxLayout(cuentaInfoPanel, BoxLayout.Y_AXIS));
            cuentaInfoPanel.setOpaque(false);

            JLabel cuentaLabel = new JLabel(cuentaa.getNombreCuenta());
            cuentaLabel.setFont(FontsBold);
            cuentaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel numberLabel = new JLabel(String.valueOf(cuentaa.getId()));
            numberLabel.setFont(Fonts);
            numberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            cuentaInfoPanel.add(cuentaLabel);
            cuentaInfoPanel.add(Box.createVerticalStrut(5));
            cuentaInfoPanel.add(numberLabel);

            JLabel montoLabel = new JLabel(String.valueOf(cuentaa.getSaldo()) + " EUR");
            montoLabel.setFont(FontsBold);
            montoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            cuenta.add(cuentaInfoPanel, BorderLayout.WEST);
            cuenta.add(montoLabel, BorderLayout.EAST);

            cuentasPanel.add(cuenta);
            cuentasPanel.add(Box.createVerticalStrut(10));
        }
    }

    public void setTarjetas(ArrayList<Tarjeta> tarjetas, HashMap<Integer, Double> saldoPorCuenta) {
        for (Tarjeta tarjetaa : tarjetas) {
            int cuentaId = tarjetaa.getCuentaID();
            double saldo = saldoPorCuenta.getOrDefault(cuentaId, 0.0);


            JPanel tarjeta = new JPanel(new BorderLayout());
            tarjeta.setBorder(new EmptyBorder(10, 40, 10, 10));
            tarjeta.setSize(new Dimension(630, 90));
            tarjeta.setBackground(new Color(255, 255, 255));

            JPanel tarjetaInfoPanel = new JPanel();
            tarjetaInfoPanel.setLayout(new BoxLayout(tarjetaInfoPanel, BoxLayout.Y_AXIS));
            tarjetaInfoPanel.setOpaque(false);

            JLabel tarjetaLabel = new JLabel("Tarjeta " + tarjetaa.getNombre());
            tarjetaLabel.setFont(FontsBold);
            tarjetaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel numberLabel = new JLabel(String.valueOf(tarjetaa.getId()));
            numberLabel.setFont(Fonts);
            numberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            tarjetaInfoPanel.add(tarjetaLabel);
            tarjetaInfoPanel.add(Box.createVerticalStrut(5));
            tarjetaInfoPanel.add(numberLabel);

            JLabel montoLabel = new JLabel(String.valueOf(saldo + " EUR"));
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

    }

    public void setFinanciacion(ArrayList<Financiacion> financiaciones) {
        for (Financiacion financiacion : financiaciones) {
            JPanel financiacionItem = new JPanel(new BorderLayout());
            financiacionItem.setBorder(new EmptyBorder(10, 40, 10, 10));
            financiacionItem.setSize(new Dimension(630, 90));
            financiacionItem.setBackground(new Color(255, 255, 255));

            JPanel financiacionInfoPanel = new JPanel();
            financiacionInfoPanel.setLayout(new BoxLayout(financiacionInfoPanel, BoxLayout.Y_AXIS));
            financiacionInfoPanel.setOpaque(false);

            JLabel financiacionLabel = new JLabel(financiacion.getMotivo());
            financiacionLabel.setFont(FontsBold);
            financiacionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel financiacionIdLabel = new JLabel(String.valueOf(financiacion.getId()));
            financiacionIdLabel.setFont(Fonts);
            financiacionIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            financiacionInfoPanel.add(financiacionLabel);
            financiacionInfoPanel.add(Box.createVerticalStrut(5));
            financiacionInfoPanel.add(financiacionIdLabel);

            JLabel financiacionMontoLabel = new JLabel(financiacion.getCantidad() + " EUR");
            financiacionMontoLabel.setFont(FontsBold);
            financiacionMontoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            financiacionItem.add(financiacionInfoPanel, BorderLayout.WEST);
            financiacionItem.add(financiacionMontoLabel, BorderLayout.EAST);

            financiacionPanel.add(financiacionItem);
            financiacionPanel.add(Box.createVerticalStrut(10));
        }
    }

    }




