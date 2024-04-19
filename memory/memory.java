package memory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class memory extends JPanel implements ActionListener 
{
    public static Image Bg;

    public static ImageIcon haut = new ImageIcon("memory/tapis.jpg");
    public memory()
    {
        //ImageIcon obj = new ImageIcon("memory/tapis.jpg");
        Bg = Toolkit.getDefaultToolkit().createImage("memory/tapis.jpg");
    }
    
    public static void main(String[] args)
    {
        JLabel label = new JLabel();
        label.setText("C'est plus.");
        label.setBounds(JFrame.MAXIMIZED_BOTH);
        label.setIcon(haut);
        JFrame frame = new JFrame();
        memory Bg = new memory();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.drawImage("justePrix/bas.png", 0, 0, null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        JButton card = new JButton();
        card.setBounds(200, 200, 200, 100);
        card.addActionListener(new memory());
        frame.setLayout(null);
        frame.add(Bg);
        frame.add(card);
        frame.add(label);

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Bg, 0, 0, null);
    }
        
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("card");

    }
}
