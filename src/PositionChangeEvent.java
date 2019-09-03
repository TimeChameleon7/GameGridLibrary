import java.awt.*;
import java.io.Serializable;

public class PositionChangeEvent extends Event implements Serializable {
    private static final long serialVersionUID = 5128265450548816284L;
    final int index;
    final Point position;

    PositionChangeEvent(int index, Point position) {
        this.index = index;
        this.position = position;
    }

    @Override
    void function() {
        grid.getObjects()[index].move(position.x, position.y);
    }
}
