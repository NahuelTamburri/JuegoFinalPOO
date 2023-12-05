package Vista;
import javax.swing.*;
import java.awt.*;
import java.net.URI;
import Controlador.Controlador;

public class VistaFondo{

    private CardLayout cardLayout;
    private JFrame frame;
    private Controlador controlador;
    private JPanel panel;
    public VistaFondo (Controlador controlador){
        this.controlador = controlador;
        frame = new JFrame("Saboteur");
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        frame.setLayout(cardLayout);
        panel = new JPanel(cardLayout);
        frame.add(panel);
        iniciarMenu();
    }

    public void iniciarMenu (){
        BorderLayout borde = new BorderLayout();
        JPanel menu = new JPanel();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("Imagenes/MenuPrincipal.jpg"));
        menu.add(label, BorderLayout.CENTER);
        menu.setLayout(borde);
        FlowLayout flow = new FlowLayout();
        JPanel menu2 = new JPanel(flow);
        menu.add(menu2, BorderLayout.SOUTH);
        JButton nuevo = new JButton("Nueva partida");
        JButton cargar = new JButton("Cargar partida");
        JButton reglas = new JButton("Reglas del juego");
        JButton salir = new JButton("Salir");
        nuevo.addActionListener(e -> cardLayout.show(panel, "juego"));
        nuevo.setIcon(new ImageIcon("Imagenes/Accion Dorso.png"));
        //cargar.addActionListener(e -> controlador.cargarPartida);
        reglas.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://garesys.com/media/rules/reglas-saboteur.pdf"));
            } catch (Exception error){
                error.printStackTrace();
            }
        });
        salir.addActionListener(e -> frame.dispose());
        menu2.add(nuevo);
        menu2.add(cargar);
        menu2.add(reglas);
        menu2.add(salir);
        panel.add(menu, "menu");
    }

    public void jugarJuego (){

    }
}