package kh.edu.fswdmobilebankingapi.exception;

public class ServiceException extends RuntimeException {

    // Constructor with just a message
    public ServiceException(String message) {
        super(message);
    }

    // Constructor with a message and a cause (another throwable)
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with just a cause
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
