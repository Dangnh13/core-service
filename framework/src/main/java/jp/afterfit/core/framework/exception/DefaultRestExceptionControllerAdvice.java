package jp.afterfit.core.framework.exception;

import jp.afterfit.core.framework.exception.handler.IExceptionHandler;
import jp.afterfit.core.framework.exception.model.ErrorResponse;
import jp.afterfit.core.framework.exception.type.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handle exceptions across the whole application
 */
public class DefaultRestExceptionControllerAdvice {

    private final IExceptionHandler<ServiceException> serviceExceptionHandler;

    private final IExceptionHandler<BindException> bindExceptionHandler;

    public DefaultRestExceptionControllerAdvice(IExceptionHandler<ServiceException> serviceExceptionHandler,
                                                IExceptionHandler<BindException> bindExceptionHandler) {
        this.serviceExceptionHandler = serviceExceptionHandler;
        this.bindExceptionHandler = bindExceptionHandler;
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

}
