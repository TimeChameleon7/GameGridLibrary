public class ObjectCollisionException extends Exception {
    private final Object conflictingObject;
    ObjectCollisionException(Object conflictingObject){
        this.conflictingObject = conflictingObject;
    }

    public Object getConflictingObject() {
        return conflictingObject;
    }
}
