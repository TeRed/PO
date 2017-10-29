package lab5.e3;

import java.io.IOException;

public class MicroDvdStartLaterThenEndException extends IOException {

    public MicroDvdStartLaterThenEndException() {}
    public MicroDvdStartLaterThenEndException(String message) {
        super(message);
    }
    public MicroDvdStartLaterThenEndException(String message, Throwable cause) {
        super(message, cause);
    }
    public MicroDvdStartLaterThenEndException(Throwable cause) {
        super(cause);
    }
}
