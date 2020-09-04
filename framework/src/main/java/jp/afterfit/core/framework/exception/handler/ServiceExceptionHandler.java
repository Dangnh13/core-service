package jp.afterfit.core.framework.exception.handler;

import jp.afterfit.core.framework.exception.model.ErrorResponse;
import jp.afterfit.core.framework.exception.type.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * Handling service exception
 */
@Slf4j
public class ServiceExceptionHandler implements IExceptionHandler<ServiceException> {

    @Override
    public ErrorResponse handle(ServiceException exception) {
        log.error(exception.getMessage(), exception);
        return ErrorResponse.of(exception.getHttpStatus(), exception.getMessage(), exception.getErrorCodes());
    }
}
