/**
 * Defines a change in the grid.
 * All subclasses should implement <code>Serializable</code>
 * @see java.io.Serializable
 */
public abstract class Event {
    /**
     * Grid to execute the change on.
     */
    transient Grid grid;

    /**
     * What the <code>event</code> will do to the <code>grid</code>.
     */
    abstract void function();
}
