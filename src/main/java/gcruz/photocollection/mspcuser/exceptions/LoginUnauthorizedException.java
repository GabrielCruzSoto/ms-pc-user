package gcruz.photocollection.mspcuser.exceptions;

public class LoginUnauthorizedException extends Exception {
    public LoginUnauthorizedException() {
    }

    public LoginUnauthorizedException(String message) {
        super(message);
    }

    public LoginUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginUnauthorizedException(Throwable cause) {
        super(cause);
    }

    public LoginUnauthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
