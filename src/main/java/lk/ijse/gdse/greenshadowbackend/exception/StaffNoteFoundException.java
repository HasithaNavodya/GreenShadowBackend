package lk.ijse.gdse.greenshadowbackend.exception;


public class StaffNoteFoundException extends RuntimeException {
    public StaffNoteFoundException() {
        super();
    }

    public StaffNoteFoundException(String message) {
        super(message);
    }

    public StaffNoteFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
