package kh.edu.fswdmobilebankingapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

public class ServiceException extends RuntimeException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleServiceException(
            ResponseStatusException e, HttpServletRequest request

    ){
        ErrorResponse<?> error =ErrorResponse.builder()
                .message("Service Business Logic Error")
                .code(e.getStatusCode().value())
                .timestamp(LocalDateTime.now())
                .details(e.getReason())
                .build();

        return ResponseEntity.status(e.getStatusCode().value())
                .body(error);
    }
    
}
