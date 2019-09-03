import java.io.Serializable;

public class PixelChangeEvent extends Event implements Serializable {
    private static final long serialVersionUID = 5075382584286239854L;
    final int index;
    final Pixel[] pixels;

    PixelChangeEvent(int index, Pixel[] pixels) {
        this.index = index;
        this.pixels = pixels;
    }

    @Override
    void function() {
        grid.getObjects()[index].setPixels(pixels);
    }
}
