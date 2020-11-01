package gui;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import models.Uranium235;

class ParticlePainter extends JPanel {

    private List<Uranium235> particles;

    public void setParticles(final List<Uranium235> particles) {
        this.particles = particles;
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        for (Uranium235 particle : particles) {
            graphics.fillOval(particle.getX(), particle.getY(), 10, 10);
        }
    }
}
