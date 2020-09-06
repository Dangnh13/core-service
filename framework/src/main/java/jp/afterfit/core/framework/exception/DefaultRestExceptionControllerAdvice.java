package jp.afterfit.core.framework.exception;

import jp.afterfit.core.framework.exception.handler.IExceptionHandler;
import jp.afterfit.core.framework.exception.model.ErrorResponse;
import jp.afterfit.core.framework.exception.type.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * Handle exceptions across the whole application
 */
@Data
@AllArgsConstructor
public class DefaultRestExceptionControllerAdvice {

    private final IExceptionHandler<ServiceException> serviceExceptionHandler;
    private final IExceptionHandler<BindException> bindExceptionHandler;
    private final IExceptionHandler<MethodArgumentNotValidException> methodArgumentNotValidExceptionIExceptionHandler;


    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        ErrorResponse errorResponse = serviceExceptionHandler.handle(ex);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler({
            BindException.class,
    })
    public ResponseEntity<ErrorResponse> handleBindException(BindException ex) {
        ErrorResponse errorResponse = bindExceptionHandler.handle(ex);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = methodArgumentNotValidExceptionIExceptionHandler.handle(ex);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

}

