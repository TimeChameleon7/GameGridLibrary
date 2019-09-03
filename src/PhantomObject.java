import java.awt.*;
import java.io.Serializable;

public class PhantomObject extends Object implements Serializable {
    private static final long serialVersionUID = 6012579889128109877L;

    /**
     * Creates an object that is ignored during the collision checking of CollisionObject.
     * @param anchor An absolute point that is not displayed and is used to calculate the absolute positions of pixels.
     * @param pixels Relative (to Point anchor) pixels that are displayed.
     */
    public PhantomObject(Point anchor, Pixel[] pixels) {
        super(anchor,pixels);
    }
}
