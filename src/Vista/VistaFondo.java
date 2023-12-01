package Vista;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VistaFondo extends JPanel{

    private BufferedImage image;

    public VistaFondo() {
        try {
            image = ImageIO.read(new File("Imagenes/TableroSaboteur.jpg"));
        }
        catch (IOException ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}