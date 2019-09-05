
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Imagenes extends javax.swing.JPanel {
    int x, y;
    String ruta;

    public Imagenes(JPanel jPanel1, String ruta) {
        this.ruta=ruta;
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon Img = new ImageIcon(getClass().getResource(ruta));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }    

}
