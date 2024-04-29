package Jeux_Java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import Jeux_Java.FlappyBird;

public class MenuGame extends JFrame {

    public MenuGame() {
        setTitle("Menu MultiGame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Charger l'image à partir des ressources
                    Image image = ImageIO.read(getClass().getResource("./Ressources/MenuImg/flappy_Brid.png"));
                    g.drawImage(image, 10, 10, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    startFlappyBird();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(panel);
        // Rafraîchir l'interface utilisateur
        revalidate();
        repaint();
        setVisible(true);
    }

    private void startFlappyBird() throws Exception {
        FlappyBird.main(new String[]{});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuGame::new);
    }
}
