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

        JLabel dinerolabel = new JLabel("1200EUR");
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



        JPanel generalInfo2 = new JPanel();
        generalInfo2.setLayout(new FlowLayout(FlowLayout.LEFT));
        generalInfo2.setBorder(new EmptyBorder(10, 10, 10, 10));
        generalInfo2.setMaximumSize(new Dimension(630, 90));

        leftPanel.add(generalInfo2);

        JLabel cuentasLabel = new JLabel("Cuentas :");
        cuentasLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        generalInfo2.add(cuentasLabel);

        generalInfo2.setBorder(new EmptyBorder(10, 24, 10, 10));
        cuentasLabel.setFont(FontsBold);

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
