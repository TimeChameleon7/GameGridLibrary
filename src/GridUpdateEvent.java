import java.io.Serializable;

public class GridUpdateEvent extends Event implements Serializable {
    private static final long serialVersionUID = -9142596980236905454L;
    final Grid grid;

    public GridUpdateEvent(Grid grid) {
        this.grid = grid;
    }

    @Override
    void function() {
        super.grid = grid;
    }
}
