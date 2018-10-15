package com.jiyuanime.colorful;

import com.jiyuanime.particle.ParticleView;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class AreaGraphFactory {
    public static void randomGraph(Graphics2D graph, ParticleView particleView) {
        Random random = new Random();
        int i = random.nextInt(3) % 4;
        graph.setColor(ColorFactory.gen());
        switch (i) {
            case 0:
                graph.drawRect((int) particleView.x, (int) particleView.y, ParticleView.PARTICLE_WIDTH, ParticleView.PARTICLE_WIDTH);
                break;
            case 1:
                graph.fillOval((int) particleView.x, (int) particleView.y, ParticleView.PARTICLE_WIDTH, ParticleView.PARTICLE_WIDTH);
                break;
            case 2:
                int[] xPoints = {(int) particleView.x, (int) particleView.x + 10};
                int[] yPoints = {(int) particleView.y, (int) particleView.y + 20};

                graph.drawPolyline(xPoints, yPoints, xPoints.length);
                break;
            default:
                graph.fillOval((int) particleView.x, (int) particleView.y, ParticleView.PARTICLE_WIDTH, ParticleView.PARTICLE_WIDTH);

        }
    }


}
