package org.serugle.sergey.notes.expection;

public class NoSuchUserExpection extends RuntimeException {
    public NoSuchUserExpection(String message) {
        super(message);
    }

    public NoSuchUserExpection() {
        super("An error appeared");
    }

    public NoSuchUserExpection(Throwable cause) {
        super(cause);
    }

    public NoSuchUserExpection(String message, Throwable cause) {
        super(message, cause);
    }
}
