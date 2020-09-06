package jp.afterfit.core.api.exception;

import jp.afterfit.core.framework.exception.DefaultRestExceptionControllerAdvice;
import jp.afterfit.core.framework.exception.handler.IExceptionHandler;
import jp.afterfit.core.framework.exception.type.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionControllerAdvice extends DefaultRestExceptionControllerAdvice {

    public ExceptionControllerAdvice(IExceptionHandler<ServiceException> serviceExceptionHandler,
                                     IExceptionHandler<BindException> bindExceptionHandler,
                                     IExceptionHandler<MethodArgumentNotValidException> methodArgumentNotValidExceptionIExceptionHandler,
                                     IExceptionHandler<Exception> unknownExceptionHandler) {
        super(serviceExceptionHandler,
                bindExceptionHandler,
                methodArgumentNotValidExceptionIExceptionHandler,
                unknownExceptionHandler);
    }
}
