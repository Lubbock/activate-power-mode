package com.jiyuanime.colorful;

import com.jiyuanime.particle.ParticleView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AreaGraphFactory {
    private static String[] chars = new String[]{
            "0100000000", "1000001010", "100000010", "0101011101010", "1001101010", "101110010", "101100010",
    };
    static InputStream fontInputStream;

    static Font font;
    static {
        fontInputStream=AreaGraphFactory.class.getResourceAsStream("/font/PressStart2P-Regular.ttf");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void drawParticleView(Graphics2D graph,
                                        JComponent component,
                                        Map<String, ParticleView> particleViews,int areaWidth,int areaHeight) {
        graph.setBackground(new Color(0x00FFFFFF, true));
        graph.clearRect(0, 0, areaWidth * 2, areaHeight * 2);
        boolean isPaint = false;
        for (String key : particleViews.keySet()) {
            int i = 0;
            ParticleView particleView = particleViews.get(key);
            graph.setColor(ColorFactory.gen());
            graph.drawLine(0, areaHeight, areaWidth, areaHeight+200);
            isPaint = (isPaint || particleView.isEnable());
            if (particleView != null && particleView.isEnable()) {
                AreaGraphFactory.randomGraph(graph, particleView, i);
                update(particleView);
            }
            i++;
        }
        if (component != null){
            component.repaint();
        }
    }
    public static void update(ParticleView particleView) {
        if (particleView.mAlpha <= 0.1) {
            particleView.setEnable(false);
            return;
        }

        particleView.update();
    }
    public static void randomGraph(Graphics2D graph, ParticleView particleView, int len) {
//        if (len < 4) {
//            Random random = new Random();
//            int i = random.nextInt(chars.length - 1) % chars.length;
//            float x = particleView.x;
//            float y = particleView.y;
//            x += random.nextInt((int) x) % (int) x;
//            y += random.nextInt((int) y) % (int) y;
//            try {
//                graph.setColor(ColorFactory.gen());
//                font = font.deriveFont(Font.PLAIN, 13f);
//                graph.setFont(font);
//                graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//                graph.drawString(chars[i], x / 2 + len * 100, y / 3);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        Random random = new Random();
        int i = random.nextInt(chars.length - 1) % chars.length;


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
