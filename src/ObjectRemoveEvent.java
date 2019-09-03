import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjectRemoveEvent extends Event implements Serializable {
    private static final long serialVersionUID = -9092299585607747368L;
    final int index;

    public ObjectRemoveEvent(int index) {
        this.index = index;
    }

    @Override
    void function() {
        ArrayList<Object> objects = new ArrayList<>(Arrays.asList(grid.getObjects()));
        objects.remove(index);
        grid.setObjects(objects.toArray(new Object[0]));
    }
}
