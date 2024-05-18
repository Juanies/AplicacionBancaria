import javax.swing.*;
import java.awt.*;

public class ColorExample {
    public static void main(String[] args) {
        // Crear el frame
        JFrame frame = new JFrame("Colores HSL a RGB en Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Establecer el layout
        frame.setLayout(new BorderLayout());

        // Crear colores convertidos
        Color textColor = new Color(212, 212, 212);
        Color bgColor = new Color(38, 38, 38);
        Color bgCardColor = new Color(51, 51, 51);

        // Panel de fondo
        JPanel bgPanel = new JPanel();
        bgPanel.setBackground(bgColor);
        bgPanel.setLayout(new BorderLayout());
        frame.add(bgPanel, BorderLayout.CENTER);

        // Panel de la tarjeta
        JPanel cardPanel = new JPanel();
        cardPanel.setBackground(bgCardColor);
        cardPanel.setPreferredSize(new Dimension(200, 100));
        cardPanel.setLayout(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiqueta con texto
        JLabel label = new JLabel("Texto de Ejemplo");
        label.setForeground(textColor);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        cardPanel.add(label, BorderLayout.CENTER);

        // Añadir la tarjeta al panel de fondo
        bgPanel.add(cardPanel, BorderLayout.CENTER);

        // Hacer visible el frame
        frame.setVisible(true);
    }
}
