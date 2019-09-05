
package ventanaprincipal;

import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    
    private JTextField textMoneda;
    private JTextField textCambio;
    private JLabel labelMoneda;
    private JLabel labelCambio;
    private JButton button;
    
    public VentanaPrincipal(){
        initComponents();
    }
    
    private void initComponents(){
        setSize(500,600);
        setTitle("Conversor de monedas");
        setVisible(true);
        textMoneda = new JTextField("");
        textMoneda.setBounds(50, 100, 50, 80);
        add(textMoneda);
    }

    public static void main(String[] args) {
        VentanaPrincipal v = new VentanaPrincipal();
        v.setVisible(true);
    }
}
