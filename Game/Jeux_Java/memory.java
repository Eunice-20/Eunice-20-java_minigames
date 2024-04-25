package Jeux_Java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays; 


public class memory extends JPanel implements ActionListener 
{
   // public static Image Bg;

    public static JPanel panel = new JPanel();

    public static JButton card , card2 , card3 , card4 , card5 , card6 , card7 , card8 , card9 , card10 , card11 , card12 , card13 , card14 , card15 , card16 , card17 , card18, card19;

    public static JFrame frame = new JFrame();

    public static int cardt;

    public static javax.swing.JButton h;

    public static String k;

    //public static ImageIcon haut = new ImageIcon("memory/tapis.jpg");
    // public memory()
    // {
    //     //ImageIcon obj = new ImageIcon("memory/tapis.jpg");
    //     Bg = Toolkit.getDefaultToolkit().createImage("./asset/tapis.jpg");
    // }
    
    public static void main(String[] args)
    {
    JButton [] tabname = {
        card = new JButton("./asset/Memory/1.png"), card2 = new JButton("./asset/Memory/1.png"),card3 = new JButton("./asset/Memory/2.png"),
        card4 = new JButton("./asset/Memory/2.png"), card5 = new JButton("./asset/Memory/3.png"),card6 = new JButton("./asset/Memory/3.png"),
        card7 = new JButton("./asset/Memory/4.png"), card8 = new JButton("./asset/Memory/4.png"),card9 = new JButton("./asset/Memory/5.png"),
        card10 = new JButton("./asset/Memory/5.png"), card11 = new JButton("./asset/Memory/6.png"),card12 = new JButton("./asset/Memory/6.png"),
        card13 = new JButton("./asset/Memory/7.png"), card14 = new JButton("./asset/Memory/7.png"),card15 = new JButton("./asset/Memory/8.png"),
        card16 = new JButton("./asset/Memory/8.png"), card17 = new JButton("./asset/Memory/9.png"),card18 = new JButton("./asset/Memory/9.png"),
        card19 = new JButton(),
    };
    int x = 100;
    int y = 200;
    int ra = 6;
    for(int gg = 18; gg != -1 ; gg --)
    {
        if(ra == 0)
        {
            x = 100;
            y += 200;
            ra = 6;
        }
        int undex = (int)(Math.random() * gg);
        tabname[undex].setBounds(x, y, 150, 100);
        tabname[undex].addActionListener(new memory());
        frame.add(tabname[undex]);
        tabname = removeTheElement(tabname, undex); 
        x += 250;
        ra -= 1;
    }

       // JLabel label = new JLabel();
       // label.setText("");
       // label.setBounds(0, 0 , 1000 , 1000);
       // label.setIcon(haut);
       // frame.drawImage("justePrix/bas.png", 0, 0, null);
      
      // card.setBorder(BorderFactory.createEmptyBorder());
      // card.setContentAreaFilled(false);
       // memory Bg = new memory();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(10, 10);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.setLayout(null);
       // frame.add(Bg);
       // frame.add(label);
       
    }

    /*public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Bg, 0, 0, null);
    }*/
        


	public void actionPerformed(ActionEvent e) 
    {
        System.out.print(cardt);
        if(cardt == 0)
        {
            h = ((JButton)e.getSource());
            k = ((JButton)e.getSource()).getText();
            System.out.print(k);
        }


        cardt += 1;
        System.out.print(cardt);
        System.out.print(((JButton)e.getSource()).getText());

        if(cardt >= 2)
        { 
            if(k ==  ((JButton)e.getSource()).getText() &&  h != ((JButton)e.getSource()))
                {
                frame.remove(((JButton)e.getSource()));
                frame.remove(h);
                System.out.print(((JButton)e.getSource()).getText());
                }
            cardt = 0;
        System.out.print(cardt);
        }
    }


        public static JButton[] removeTheElement(JButton[] arr, int index) 
        { 
      
            // If the array is empty 
            // or the index is not in array range 
            // return the original array 
            if (arr == null || index < 0
                || index >= arr.length) { 
      
                return arr; 
            } 
      
            // Create another array of size one less 
            JButton[] anotherArray = new JButton[arr.length - 1]; 
      
            // Copy the elements except the index 
            // from original array to the other array 
            for (int i = 0, k = 0; i < arr.length; i++) { 
      
                // if the index is 
                // the removal element index 
                if (i == index) { 
                    continue; 
                } 
      
                // if the index is not 
                // the removal element index 
                anotherArray[k++] = arr[i]; 
            } 
      
            // return the resultant array 
            return anotherArray;
	    }
}

//frame.remove(((JButton)e.getSource()));
// frame.add(((JButton)e.getSource()));
// frame.add(h);
// cardt = 0;