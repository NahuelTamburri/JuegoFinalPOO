package Vista;
import javax.swing.*;

public class Prueba extends JFrame {

    public Prueba() {
        // Configurar la ventana principal
        setTitle("Saboteur");
        setSize(800, 566);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icono = new ImageIcon("Imagenes/Logo.png");
        setIconImage(icono.getImage());
        VistaFondo imagePanel = new VistaFondo();
        add(imagePanel);
        setVisible(true);
        // Botones
        JButton boton1 = new JButton();
        // boton1.addActionListener(e -> );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Prueba();
        });
    }
}