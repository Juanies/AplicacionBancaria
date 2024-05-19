import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends JFrame {
    private JPanel leftPanel;

    public Main() {
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Santander");
        setIconImage(new ImageIcon("src/media/icono.png").getImage());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Font Fonts = new Font("Headline", Font.PLAIN, 16);
        Font FontsBold = new Font("Headline", Font.BOLD, 16);

        JPanel navBar = new JPanel();
        navBar.setPreferredSize(new Dimension(getWidth(), 50));
        navBar.setLayout(new BoxLayout(navBar, BoxLayout.X_AXIS));
        add(navBar, BorderLayout.NORTH);

        JLabel x = new JLabel("Buenas tardes, Romero Angel Millan");
        JLabel x1 = new JLabel("Ultima conexion: 18-05-2024 / 20:43");
        JLabel x2 = new JLabel("Cambiar");

        x.setFont(Fonts);
        x1.setFont(Fonts);
        x2.setFont(Fonts);

        navBar.add(x);
        navBar.add(Box.createHorizontalGlue());
        navBar.add(x1);
        navBar.add(Box.createHorizontalGlue());
        navBar.add(x2);

        navBar.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(630, getHeight()));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JPanel generalInfo = new JPanel();
        generalInfo.setLayout(new FlowLayout(FlowLayout.LEFT));
        generalInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
        generalInfo.setMaximumSize(new Dimension(630, 90));

        JPanel tuDineroPanel = new JPanel();
        tuDineroPanel.setLayout(new BoxLayout(tuDineroPanel, BoxLayout.Y_AXIS));
        tuDineroPanel.setBackground(Color.RED);
        tuDineroPanel.setBorder(new EmptyBorder(10, 10, 10, 40));

        JLabel tu = new JLabel("Tu Dinero: ");
        tu.setFont(Fonts);
        tu.setForeground(Color.WHITE);
        tu.setFont(FontsBold);
        tu.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel dinero = new JLabel("1200EUR");
        dinero.setFont(FontsBold);
        dinero.setAlignmentX(Component.LEFT_ALIGNMENT);
        dinero.setForeground(Color.WHITE);

        tuDineroPanel.add(tu);
        tuDineroPanel.add(dinero);

        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel tuFinanciacion = new JPanel();
        tuFinanciacion.setLayout(new BoxLayout(tuFinanciacion, BoxLayout.Y_AXIS));
        tuFinanciacion.setBorder(new EmptyBorder(10, 10, 10, 40));

        JLabel financiacionLabel = new JLabel("Tu Financiacion: ");
        financiacionLabel.setFont(FontsBold);

        JLabel dinerolabel = new JLabel("1232300EUR");
        dinerolabel.setFont(FontsBold);

        tuFinanciacion.add(financiacionLabel);
        tuFinanciacion.add(dinerolabel);
        generalInfo.add(tuFinanciacion);
        generalInfo.add(tuDineroPanel);
        leftPanel.add(generalInfo);

        JScrollPane scrollPane = new JScrollPane(leftPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(270, getHeight()));

        centerPanel.add(scrollPane, BorderLayout.WEST);
        centerPanel.add(rightPanel, BorderLayout.CENTER);

        // Panel Cuentas
        JPanel Cuentas = new JPanel(new BorderLayout()); // Cambiado a BorderLayout
        Cuentas.setBorder(new EmptyBorder(10, 10, 10, 10));
        leftPanel.add(Cuentas);

        JLabel cuentasLabel = new JLabel("Cuentas:");
        cuentasLabel.setFont(FontsBold);
        cuentasLabel.setOpaque(true);
        cuentasLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        Cuentas.add(cuentasLabel, BorderLayout.NORTH); // Añadir el label al norte del BorderLayout

        JPanel cuentasPanel = new JPanel();
        cuentasPanel.setLayout(new BoxLayout(cuentasPanel, BoxLayout.Y_AXIS));
        Cuentas.add(cuentasPanel, BorderLayout.CENTER);


        //TODO: Hacer metodo crear cuenta
        for (int i = 1; i <= 2; i++) {
            JPanel cuenta = new JPanel(new BorderLayout());
            cuenta.setBorder(new EmptyBorder(10, 40, 10, 10));
            cuenta.setMaximumSize(new Dimension(630, 90));

            JPanel cuentaInfoPanel = new JPanel();
            cuentaInfoPanel.setLayout(new BoxLayout(cuentaInfoPanel, BoxLayout.Y_AXIS));
            cuentaInfoPanel.setOpaque(false);

            JLabel cuentaLabel = new JLabel("Cuenta " + i);
            cuentaLabel.setFont(FontsBold);
            cuentaLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            JLabel numberLabel = new JLabel("1234"); // Nuevo label con 4 números
            numberLabel.setFont(Fonts);
            numberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            cuentaInfoPanel.add(cuentaLabel);
            cuentaInfoPanel.add(Box.createVerticalStrut(5)); // Añadir espacio vertical entre los labels
            cuentaInfoPanel.add(numberLabel);

            JLabel montoLabel = new JLabel("1232300EUR");
            montoLabel.setFont(FontsBold);
            montoLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            cuenta.add(cuentaInfoPanel, BorderLayout.WEST);
            cuenta.add(montoLabel, BorderLayout.EAST);

            cuentasPanel.add(cuenta);
        }



        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }


    public void addNewLabel(String text) {
        JLabel newLabel = new JLabel(text);
        newLabel.setFont(new Font("Headline", Font.PLAIN, 16));
        newLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(newLabel);
        leftPanel.revalidate();
        leftPanel.repaint();
    }

    public static void main(String[] args) {
        Main mainApp = new Main();
    }
}
