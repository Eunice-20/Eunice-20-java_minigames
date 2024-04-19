package Jeux_Java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class memory extends JPanel implements ActionListener 
{
    public static Image Bg;

    public static JPanel panel = new JPanel();

    public static JButton card , card2 , card3 , card4;

    public static JFrame frame = new JFrame();

    //public static ImageIcon haut = new ImageIcon("memory/tapis.jpg");
    public memory()
    {
        //ImageIcon obj = new ImageIcon("memory/tapis.jpg");
        Bg = Toolkit.getDefaultToolkit().createImage("./asset/tapis.jpg");
    }
    
    public static void main(String[] args)
    {
       // JLabel label = new JLabel();
       // label.setText("");
       // label.setBounds(0, 0 , 1000 , 1000);
       // label.setIcon(haut);
       // frame.drawImage("justePrix/bas.png", 0, 0, null);
       card = new JButton();
       card2 = new JButton();
       card3 = new JButton();
       card4 = new JButton();
      // card.setBorder(BorderFactory.createEmptyBorder());
      // card.setContentAreaFilled(false);
        memory Bg = new memory();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        card.setBounds(200, 200, 200, 100);
        card2.setBounds(400, 400, 200, 100);
        card3.setBounds(400, 200, 200, 100);
        card4.setBounds(200, 400, 200, 100);
        card.addActionListener(new memory());
        card2.addActionListener(new memory());
        card3.addActionListener(new memory());
        card4.addActionListener(new memory());
        frame.setLayout(null);
        frame.add(Bg);
        frame.add(card);
        frame.add(card2);
        frame.add(card3);
        frame.add(card4);
       // frame.add(label);
       
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Bg, 0, 0, null);
    }
        
    public void actionPerformed(ActionEvent e) 
    {
        Component deux ;
        JButton un;
        int turn = 0;
        System.out.println("card");
        frame.remove(((JButton)e.getSource()));
        if(turn == 0) 
        {
        un = ((JButton)e.getSource());
        }
        if(turn == 1) 
        {
        deux = ((JButton)e.getSource());
        }
        turn +=1;
        if(turn == 2) 
        {
            turn = 0;
            frame.add((un));
            
            }
        }
    }
    