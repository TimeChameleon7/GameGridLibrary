import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Pixel implements Serializable {
    private static final long serialVersionUID = -2067008401190945493L;
    private Point point;
    private Color color;

    public Pixel(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public Pixel(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Pixel(int x, int y, int color) {
        this.point = new Point(x, y);
        this.color = new Color(color);
    }

    public Pixel(Point point, int color) {
        this.point = point;
        this.color = new Color(color);
    }

    /**
     * Creates and returns a rectangle from point1 to point2, inclusive,  of color.
     *
     * @param point1 This point will be included on the Pixel[].
     * @param point2 This point will be included on the Pixel[].
     * @param color  All returned pixels will be this color.
     * @return Resulting Pixel[].
     */
    public static Pixel[] rectangle(Point point1, Point point2, Color color) {
        Point upperLeft = new Point(),
                lowerRight = new Point();
        if (point1.x <= point2.x) {
            upperLeft.x = point1.x;
            lowerRight.x = point2.x;
        } else {
            upperLeft.x = point2.x;
            lowerRight.x = point1.x;
        }
        if (point1.y <= point2.y) {
            upperLeft.y = point1.y;
            lowerRight.y = point2.y;
        } else {
            upperLeft.y = point2.y;
            lowerRight.y = point1.y;
        }
        ArrayList<Pixel> pixels = new ArrayList<>();
        for (int x = upperLeft.x; x <= lowerRight.y; x++) {
            for (int y = upperLeft.y; y <= lowerRight.y; y++) {
                pixels.add(new Pixel(x, y, color));
            }
        }
        pixels.trimToSize();
        Pixel[] ret = new Pixel[pixels.size()];
        ret = pixels.toArray(ret);
        return ret;
    }

    /**
     * Creates and returns an ellipse with a center at center, width of radiusX*2, height of radiusY*2, and of color.
     *
     * @param center  Center of the ellipse, all pixels returned have coordinates relative to this.
     * @param radiusX half Width of the ellipse.
     * @param radiusY half Height of the ellipse.
     * @param color   All returned pixels will be this color.
     * @return Resulting Pixel[].
     */
    public static Pixel[] ellipse(Point center, int radiusX, int radiusY, Color color) {
        ArrayList<Pixel> pixels = new ArrayList<>();
        for (int x = center.x - radiusX; x < center.x + radiusX; x++) {
            for (int y = center.y - radiusY; y < center.y + radiusY; y++) {
                //todo make this more efficient
                if (Math.pow(x - center.x, 2) / Math.pow(radiusX, 2) + Math.pow(y - center.y, 2) / Math.pow(radiusY, 2) < 1) {
                    pixels.add(new Pixel(x, y, color));
                }
            }
        }
        pixels.trimToSize();
        Pixel[] ret = new Pixel[pixels.size()];
        ret = pixels.toArray(ret);
        return ret;
    }

    /**
     * Merges all the Pixels in the input arrays to on output array. Does not deal with overlap.
     *
     * @param pixels Pixel[] to be merged together.
     * @return Merged Pixel[]
     */
    public static Pixel[] mergeArray(Pixel[]... pixels) {
        ArrayList<Pixel> pixelArrayList = new ArrayList<>();
        for (Pixel[] pixels1 : pixels) {
            pixelArrayList.addAll(Arrays.asList(pixels1));
        }
        pixelArrayList.trimToSize();
        return pixelArrayList.toArray(new Pixel[0]);
    }

    public void translate(int x, int y) {
        point.translate(x, y);
    }

    public void move(int x, int y) {
        point.move(x, y);
    }

    public Point getPoint() {
        return point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRGB() {
        return color.getRGB();
    }
}
