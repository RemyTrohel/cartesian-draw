import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CartesianPanel extends JPanel {

	private static final long serialVersionUID = 1318338164348050087L;
	
	
	
	

	/********************* CHANGE SIZE HERE *********************/
    public static final int xCoordNumbers = 200000;
    public static final int yCoordNumbers = 200000;
    /********************* CHANGE SIZE HERE *********************/
    
    
    
    
    
	// Screensize
    static Rectangle screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();//Toolkit.getDefaultToolkit().getScreenSize();

    // x-axis coord constants
    public static final int X_AXIS_FIRST_X_COORD = 50;
    public static final int X_AXIS_SECOND_X_COORD = (int)screenSize.getWidth() - 20;
    public static final int X_AXIS_Y_COORD = (int)screenSize.getHeight() - 50;

    // y-axis coord constants
    public static final int Y_AXIS_FIRST_Y_COORD = 20;
    public static final int Y_AXIS_SECOND_Y_COORD = (int)screenSize.getHeight() - 50;
    public static final int Y_AXIS_X_COORD = 50;

    // arrows of axis are represented with "hipotenuse" of triangle
    // now we are define length of cathetas of that triangle
    public static final int FIRST_LENGHT = 10;
    public static final int SECOND_LENGHT = 5;

    // size of start coordinate lenght
    public static final int ORIGIN_COORDINATE_LENGHT = 6;

    // distance of coordinate strings from axis
    public static final int AXIS_STRING_DISTANCE = 20;

    // numerate axis
    public static final float xLength = (float)(X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD) / xCoordNumbers;
    public static final float yLength = (float)(Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD) / yCoordNumbers;
    public static final int xStep = xCoordNumbers/40;
    public static final int yStep = yCoordNumbers/20;

    // Point size
    public static final int pointDiameter = 1;

    private List<Point> points;

    public void init(List<Long> sequence) {
        this.points = new ArrayList<Point>();
        int x = 0;
        if (sequence != null) {
            for (Long y : sequence) {
                points.add(
                    new Point(x, y)
                );
                x++;
            }
        }
    }
    
    private void drawPointOnPanel(Point point, Graphics g) {
        final int x = Math.round((float)X_AXIS_FIRST_X_COORD + (point.getX() * xLength) - (float) pointDiameter / 2);
        final int y = Math.round((float)Y_AXIS_SECOND_Y_COORD - (point.getY() * yLength) - (float) pointDiameter / 2);
        g.fillOval(x, y, pointDiameter, pointDiameter);
    }

    public void paintComponent(Graphics g) {

        int extraDistance, temp;
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
            temp = i;
            extraDistance = 1;
            while (temp >= 10) {
                temp /= 10;
                extraDistance++;
            }
            g2.drawLine(X_AXIS_FIRST_X_COORD + Math.round(i * xLength), X_AXIS_Y_COORD - SECOND_LENGHT,
                    X_AXIS_FIRST_X_COORD + Math.round(i * xLength), X_AXIS_Y_COORD + SECOND_LENGHT);
            g2.drawString(Integer.toString(i), X_AXIS_FIRST_X_COORD + (i * xLength) - (3 * extraDistance),
                    X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }

        // draw y-axis numbers
        for (int i = yStep; i <= yCoordNumbers; i=i+yStep) {
            temp = i;
            extraDistance = 0;
            while (temp >= 10) {
                temp /= 10;
                extraDistance++;
            }
            g2.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - Math.round(i * yLength),
                    Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - Math.round(i * yLength));
            g2.drawString(Integer.toString(i), Y_AXIS_X_COORD - AXIS_STRING_DISTANCE - (3 * extraDistance),
                    Y_AXIS_SECOND_Y_COORD - (i * yLength) + 3);
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
