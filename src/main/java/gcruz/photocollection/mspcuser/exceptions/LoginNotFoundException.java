package gcruz.photocollection.mspcuser.exceptions;

public class LoginNotFoundException extends Exception {
    public LoginNotFoundException() {
    }

    public LoginNotFoundException(String message) {
        super(message);
    }

    public LoginNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginNotFoundException(Throwable cause) {
        super(cause);
    }

    public LoginNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
