package com.cedacri.progetoDocumentale.exception.handler;

import com.cedacri.progetoDocumentale.exception.ResourceAlreadyExistsException;
import com.cedacri.progetoDocumentale.exception.ResourceNotFoundException;
import com.cedacri.progetoDocumentale.exception.model.ErrorDetails;
import com.cedacri.progetoDocumentale.exception.model.ValidationErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        e -> e.getDefaultMessage() != null ? e.getDefaultMessage() : "no default message"));

        ValidationErrorDetails errorDetails = new ValidationErrorDetails(
                LocalDate.now(), errors, request.getDescription(false)
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceAlreadyExistsException.class})
    public ResponseEntity<ErrorDetails> handleResourceAlreadyExistsException(Exception e, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorDetails(LocalDate.now(), e.getMessage(), request.getDescription(false)),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(Exception e, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorDetails(LocalDate.now(), e.getMessage(), request.getDescription(false)),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDetails> handleAnyException(Exception e, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorDetails(LocalDate.now(), e.getMessage(), request.getDescription(false)),
                HttpStatus.BAD_REQUEST
        );
    }
}
