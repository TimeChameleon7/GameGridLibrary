import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjectAddEvent extends Event implements Serializable {
    private static final long serialVersionUID = 4507487286467691135L;
    final Object object;

    public ObjectAddEvent(Object object) {
        this.object = object;
    }

    @Override
    void function() {
        ArrayList<Object> objects = new ArrayList<>(Arrays.asList(grid.getObjects()));
        objects.add(object);
        grid.setObjects(objects.toArray(new Object[0]));
    }
}
