import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Grid implements Serializable {
    private static final long serialVersionUID = -1506286266814823197L;
    private int width, height;
    private Object[] objects;
    private Color background;
    private BufferedImage grid;

    /**
     * Creates a Grid with width, height, with color background and with objects displayed on it.
     * Objects are drawn on the image in the same order they are in within the array.
     * @param width Width of the grid in pixels.
     * @param height Height of the grid in pixels.
     * @param objects Objects to be drawn on the grid.
     * @param background Color to fill in the rest of the grid with.
     */
    Grid(int width, int height, Object[] objects, Color background){
        this.width = width;
        this.height = height;
        this.objects = objects;
        this.background = background;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public Object[] getObjects() {
        return objects;
    }
    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public Color getBackground() {
        return background;
    }
    public void setBackground(Color background) {
        this.background = background;
    }

    private void draw(){
        BufferedImage grid = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                grid.setRGB(x,y,background.getRGB());
            }
        }
        for(Object object : objects){
            for(Pixel pixel : object.getAbsolutePixels()){
                if(pixel.getPoint().x>=0 && pixel.getPoint().x<width && pixel.getPoint().y>=0 && pixel.getPoint().y<height) {
                    grid.setRGB(
                            pixel.getPoint().x,
                            pixel.getPoint().y,
                            pixel.getRGB()
                    );
                }
            }
        }
        this.grid = grid;
    }
    public BufferedImage getGrid(){
        draw();
        return grid;
    }
}
