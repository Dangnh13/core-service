package jp.afterfit.core.framework.exception;

import jp.afterfit.core.framework.exception.handler.IExceptionHandler;
import jp.afterfit.core.framework.exception.model.ErrorCode;
import jp.afterfit.core.framework.exception.model.ErrorResponse;
import jp.afterfit.core.framework.exception.type.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Handle exceptions across the whole application
 */
@Data
@AllArgsConstructor
@Slf4j
public class DefaultRestExceptionControllerAdvice {

    private final IExceptionHandler<ServiceException> serviceExceptionHandler;
    private final IExceptionHandler<BindException> bindExceptionHandler;
    private final IExceptionHandler<MethodArgumentNotValidException> methodArgumentNotValidExceptionIExceptionHandler;
    private final IExceptionHandler<Exception> unknownExceptionHandler;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> defaultErrorHandler(Exception e) {
        log.error("Unknown error", e);
        ErrorResponse errorResponse = unknownExceptionHandler.handle(e);
        return new ResponseEntity<>(errorResponse,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

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

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> methodNotSupportErrorHandler(
            HttpServletRequest req, Exception e) throws Exception {
        log.debug("MethodNotSupportedException error", e);
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.METHOD_NOT_ALLOWED,
                "Method NotSupported",
                Arrays.asList(ErrorCode.EMETHODNOSUPPORT.getErrorCode()));
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

}

