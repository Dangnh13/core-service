package jp.afterfit.core.api.exception;

import jp.afterfit.core.framework.exception.handler.IExceptionHandler;
import jp.afterfit.core.framework.exception.DefaultRestExceptionControllerAdvice;
import jp.afterfit.core.framework.exception.type.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionControllerAdvice extends DefaultRestExceptionControllerAdvice {


    public ExceptionControllerAdvice(IExceptionHandler<ServiceException> serviceExceptionHandler,
                                     IExceptionHandler<BindException> bindExceptionHandler) {
        super(serviceExceptionHandler, bindExceptionHandler);
    }
}
