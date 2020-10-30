package gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import models.Uranium235;

public class Display extends JFrame {

	private ParticlePainter particlePainter = new ParticlePainter();
	
  public Display() {
      setSize(500, 500);
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.setVisible(true);
      this.add(particlePainter);
      particlePainter.setVisible(true);
  }

  public void draw(List<Uranium235> particles) {
	  particlePainter.setParticles(particles);
	  particlePainter.repaint();
  }


}
