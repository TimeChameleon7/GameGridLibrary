import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class CollisionObject extends Object implements Serializable {
    private static final long serialVersionUID = 771571823489479614L;

    /**
     * Creates an object with collision checking on every movement. The standard translate method is invalid with
     * objects of this class, instead translate(Movement, Object[]) must be used instead.
     * @param anchor An absolute point that is not displayed and is used to calculate the absolute positions of pixels.
     * @param pixels Relative (to Point anchor) pixels that are displayed.
     */
    public CollisionObject(Point anchor, Pixel[] pixels){
        super(anchor,pixels);
    }

    /**
     * Creates an object with collision checking on every movement. The standard translate method is invalid with
     * objects of this class, instead translate(Movement, Object[]) must be used instead.
     * @param x The absolute coordinate of anchor.
     * @param y The absolute coordinate of anchor.
     * @param pixels Relative (to Point anchor) pixels that are displayed.
     */
    public CollisionObject(int x, int y, Pixel[] pixels){
        super(x,y,pixels);
    }

    /**
     * Attempts to translate this one pixel in the direction determined by movement, throwing ObjectCollisionException
     * if colliding with an Object within objects.
     * @param objects Objects to check if conflicting with, method DOES remove this from the array.
     */
    public void translate(Movement movement, Object[] objects) throws ObjectCollisionException{
        //Removal of this from the input array
        ArrayList<Object> objectsArrayList = new ArrayList<>(objects.length);
        objectsArrayList.addAll(Arrays.asList(objects));
        objectsArrayList.remove(this);
        objectsArrayList.trimToSize();
        Object[] objectsWithoutThis = new Object[objectsArrayList.size()];
        objectsWithoutThis = objectsArrayList.toArray(objectsWithoutThis);

        Object clone = new Object((Point)this.getAnchor().clone(),this.getPixels());
        clone.translate(movement.getX(),movement.getY());

        for(Object object : objectsWithoutThis){
            if (!(object instanceof PhantomObject)) {
                Object[] cloneAndObject = {clone, object};
                if (isOverlapping(cloneAndObject)) {
                    throw new ObjectCollisionException(object);
                }
            }
        }

        super.translate(movement.getX(),movement.getY());
    }

    /**
     * Attempts to translate this distance pixels in the direction determined by movement, throwing
     * ObjectCollisionException if colliding with an Object within objects.
     * This method will loop translate(Movement, Object[]) distance times or until ObjectCollisionException is thrown
     * @param movement Direction to move towards.
     * @param distance Number of pixels to move.
     * @param objects Objects to check if conflicting with, method DOES remove this from the array.
     * @throws ObjectCollisionException If this fails to move due to colliding with another object;
     */
    public void translate(Movement movement, int distance, Object[] objects) throws ObjectCollisionException{
        for(int i = 0; i<distance; i++)
            translate(movement,objects);
    }

    @Deprecated
    @Override
    public void translate(int x, int y) {
        throw new UnsupportedOperationException(
                "translate(Movement,Object[]) should be used instead for objects of "+getClass());
    }
}
