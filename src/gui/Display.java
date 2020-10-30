package gui;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {

  static JFrame frame;
  static JPanel panel;

  public static void run() {
    frame = new JFrame();
    frame.setBounds(500, 500, 500, 500);
    panel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 100, 100);
        g.drawOval(10 ,10, 10, 10);
      }
    };
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    Graphics g = panel.getGraphics();
    g.drawOval(50, 50, 50, 50);
    panel.paint(g);
  }

  public static void insertComponent() {
    Graphics g = panel.getGraphics();
  }


}
