package lab5.e3;

import java.io.IOException;

public class wrongMicroDvdLineFormatException extends IOException {

    public wrongMicroDvdLineFormatException() {}
    public wrongMicroDvdLineFormatException(String message) {
        super(message);
    }
    public wrongMicroDvdLineFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    public wrongMicroDvdLineFormatException(Throwable cause) {
        super(cause);
    }
}
