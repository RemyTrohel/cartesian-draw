package com.perso.cartesian;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CartesianPanel extends JPanel {

    // x-axis coord constants
    public static final int X_AXIS_FIRST_X_COORD = 50;
    public static final int X_AXIS_SECOND_X_COORD = 1500;
    public static final int X_AXIS_Y_COORD = 800;

    // y-axis coord constants
    public static final int Y_AXIS_FIRST_Y_COORD = 50;
    public static final int Y_AXIS_SECOND_Y_COORD = 800;
    public static final int Y_AXIS_X_COORD = 50;

    // arrows of axis are represented with "hipotenuse" of
    // triangle
    // now we are define length of cathetas of that triangle
    public static final int FIRST_LENGHT = 10;
    public static final int SECOND_LENGHT = 5;

    // size of start coordinate lenght
    public static final int ORIGIN_COORDINATE_LENGHT = 6;

    // distance of coordinate strings from axis
    public static final int AXIS_STRING_DISTANCE = 20;

    // numerate axis
    public static final int xCoordNumbers = 100000;
    public static final int yCoordNumbers = 100000;
    public static final float xLength = (float)(X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD) / xCoordNumbers;
    public static final float yLength = (float)(Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD) / yCoordNumbers;
    public static final int xStep = xCoordNumbers/40;
    public static final int yStep = yCoordNumbers/20;

    // Point
    public static final int pointDiameter = 1;

    private List<Point> points;

    public void init(List<Long> sequence) {
        this.points = new ArrayList<Point>();
        int x = 0;
        for (Long y : sequence) {
            points.add(
                new Point(x, y)
            );
            x++;
        }
    }
    
    private void drawPointOnPanel(Point point, Graphics g) {
        final int x = Math.round((float)X_AXIS_FIRST_X_COORD + (point.getX() * xLength) - (float) pointDiameter / 2);
        final int y = Math.round((float)Y_AXIS_SECOND_Y_COORD - (point.getY() * yLength) - (float) pointDiameter / 2);
        g.fillOval(x, y, pointDiameter, pointDiameter);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 8));

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // x-axis
        g2.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        // y-axis
        g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);

        // draw origin Point
        g2.fillOval(X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2),
                Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2), ORIGIN_COORDINATE_LENGHT,
                ORIGIN_COORDINATE_LENGHT);

        // draw x-axis numbers
        for (int i = xStep; i <= xCoordNumbers; i=i+xStep) {
            g2.drawLine(X_AXIS_FIRST_X_COORD + Math.round(i * xLength), X_AXIS_Y_COORD - SECOND_LENGHT,
                    X_AXIS_FIRST_X_COORD + Math.round(i * xLength), X_AXIS_Y_COORD + SECOND_LENGHT);
            g2.drawString(Integer.toString(i), X_AXIS_FIRST_X_COORD + (i * xLength) - 3,
                    X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }

        // draw y-axis numbers
        for (int i = yStep; i <= yCoordNumbers; i=i+yStep) {
            g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - Math.round(i * yLength),
                    Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - Math.round(i * yLength));
            g2.drawString(Integer.toString(i), Y_AXIS_X_COORD - AXIS_STRING_DISTANCE,
                    Y_AXIS_SECOND_Y_COORD - (i * yLength));
        }
        long startTime = System.currentTimeMillis();
        points.forEach(p -> drawPointOnPanel(p, g));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("\nDraw points time : " + elapsedTime + " ms");
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
