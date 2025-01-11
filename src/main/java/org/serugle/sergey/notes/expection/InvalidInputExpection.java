package org.serugle.sergey.notes.expection;

public class InvalidInputExpection extends RuntimeException {
    public InvalidInputExpection(String message) {
        super(message);
    }

    public InvalidInputExpection() {
        super("An error appeared");
    }

    public InvalidInputExpection(Throwable cause) {
        super(cause);
    }

    public InvalidInputExpection(String message, Throwable cause) {
        super(message, cause);
    }
}
