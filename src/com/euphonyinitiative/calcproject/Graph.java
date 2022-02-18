package com.euphonyinitiative.calcproject;

import javax.swing.*;
import java.awt.*;

public class Graph extends JComponent {

    private Line line;

    public Graph(Line line) {
        this.line = line;
    }

    @Override
    public void paintComponent(Graphics g) {
        drawGrid(g);
        drawLine(g);
    }

    public void setLine(Line line) {
        this.line = line;
        repaint();
    }

    private void drawGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for(int x = (int) (line.getxStart()); x < (int) (line.getxEnd() + 1); x++) {
            if(x == 0) {
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(2));
            } else {
                g2.setColor(Color.LIGHT_GRAY);
                g2.setStroke(new BasicStroke(1));
            }
            g2.drawLine(x2p(x), 0, x2p(x), getHeight());
        }
        for(int y = (int) (line.getyStart()); y < (int) (line.getyEnd() + 1); y++) {
            if(y == 0) {
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(2));
            } else {
                g2.setColor(Color.LIGHT_GRAY);
                g2.setStroke(new BasicStroke(1));
            }
            g2.drawLine(0, y2p(y), getWidth(), y2p(y));
        }
    }

    private void drawLine(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(3));
        double[][] values = line.getValues();
        int[] xPoints = new int[values.length];
        int[] yPoints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            xPoints[i] = x2p(values[i][0]);
            yPoints[i] = y2p(values[i][1]);
        }
        g2.drawPolyline(xPoints, yPoints, values.length);
    }

    private int x2p(double x) {
        return (int) ((x - line.getxStart()) * (getWidth() / (line.getxEnd() - line.getxStart())));
    }

    private int y2p(double y) {
        return (int) (getHeight() - ((y - line.getyStart()) * (getHeight() / (line.getyEnd() - line.getyStart()))));
    }

    private double p2x(int p) {
        return (((double) p) / (getWidth() / (line.getxEnd() - line.getxStart()))) - line.getxStart();
    }

    private double p2y(int p) {
        return (((double) (getHeight() - p)) / (getHeight() / (line.getyEnd() - line.getyStart()))) - line.getyStart();
    }
}
