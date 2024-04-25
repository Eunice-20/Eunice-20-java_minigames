// package Jeux_Java;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// public class Menu extends JFrame {
//     private JLabel jeu1Label;
//     private JLabel trueFalseLabel;
//     private JLabel snakeLabel;

//     public static void main(String[] args) {
//         Menu menu = new Menu();
//         menu.setVisible(true);

//         SwingUtilities.invokeLater(() -> {
//             Menu interfaceJeux = new Menu();
//             interfaceJeux.setVisible(true);
//         });
//     }

//     public Menu() {
//         setTitle("Choose a game");
//         setSize(300, 200);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         jeu1Label = new JLabel();
//         trueFalseLabel = new JLabel();
//         snakeLabel = new JLabel();

//         ImageIcon jeu1Icon = new ImageIcon("./asset/jeux1.jpg");
//         jeu1Label.setIcon(jeu1Icon);

//         ImageIcon trueFalseIcon = new ImageIcon("./asset/TrueFalse.jpg");
//         trueFalseLabel.setIcon(trueFalseIcon);

//         ImageIcon snakeIcon = new ImageIcon("./asset/Snake_Game.jpg");
//         snakeLabel.setIcon(snakeIcon);

//         JPanel panel = new JPanel();
//         panel.setLayout(new GridLayout(1, 3));
//         panel.add(jeu1Label);
//         panel.add(trueFalseLabel);
//         panel.add(snakeLabel);
//         add(panel);

//         jeu1Label.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 new Jeux1().setVisible(true);
//             }
//         });

//         trueFalseLabel.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 new TrueFalse().setVisible(true);
//             }
//         });

//         snakeLabel.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 new Snake().setVisible(true);
//             }
//         });
//     }

//     public void setVisible(boolean visible) {
//         super.setVisible(visible);
//     }
// }
