import java.awt.*;
import java.io.Serializable;

public class Object implements Serializable {
    private static final long serialVersionUID = 1915904167327798178L;
    private Point anchor;
    private Pixel[] pixels;


    /**
     * Creates an object with a anchor at anchor and pixels drawn relative to it.
     *
     * @param anchor An absolute point that is not displayed and is used to calculate the absolute positions of pixels.
     * @param pixels Relative (to Point anchor) pixels that are displayed.
     */
    public Object(Point anchor, Pixel[] pixels) {
        this.anchor = anchor;
        this.pixels = pixels;
    }

    /**
     * Creates an object with a anchor at (x,y) and pixels drawn relative to it.
     *
     * @param x      The absolute coordinate of anchor
     * @param y      The absolute coordinate of anchor
     * @param pixels Relative (to Point anchor) pixels that are displayed
     */
    public Object(int x, int y, Pixel[] pixels) {
        this.anchor = new Point(x, y);
        this.pixels = pixels;
    }

    /**
     * Compares the absolute positions of the object's pixels and returns true if any are the same.
     *
     * @param objects All objects to check.
     * @return Whether they are overlapping.
     */
    public static boolean isOverlapping(Object[] objects) {
        if (objects.length < 2) {
            return false;
        }
        for (int i = 0; i < objects.length; i++) {
            for (int x = 0; x < objects.length; x++) {
                if (i != x) {
                    for (Point point1 : objects[i].getAbsolutePoints()) {
                        for (Point point2 : objects[x].getAbsolutePoints()) {
                            if (point1.equals(point2)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void move(int x, int y) {
        anchor.move(x, y);
    }

    public void translate(int x, int y) {
        anchor.translate(x, y);
    }

    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public Pixel[] getPixels() {
        return pixels;
    }

    public void setPixels(Pixel[] pixels) {
        this.pixels = pixels;
    }

    /**
     * Calculates and returns an array of the absolute pixels of the object
     *
     * @return Pixels of the object
     */
    public Pixel[] getAbsolutePixels() {
        Pixel[] pixels = new Pixel[this.pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = new Pixel(
                    anchor.x + this.pixels[i].getPoint().x,
                    anchor.y + this.pixels[i].getPoint().y,
                    this.pixels[i].getColor()
            );
        }
        return pixels;
    }

    /**
     * Calculates and returns an array of the absolute points of the object
     *
     * @return Points of the object
     */
    public Point[] getAbsolutePoints() {
        Point[] points = new Point[pixels.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(
                    anchor.x + pixels[i].getPoint().x,
                    anchor.y + pixels[i].getPoint().y
            );
        }
        return points;
    }
}
