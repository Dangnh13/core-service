package jp.afterfit.core.framework.exception.handler;

import jp.afterfit.core.framework.exception.model.ErrorCode;
import jp.afterfit.core.framework.exception.model.ErrorResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * Interface for system;s exceptions
 *
 * @param <T> which extends Exception
 */
public interface IExceptionHandler<T extends Exception> {

    Log log = LogFactory.getLog(IExceptionHandler.class);

    /**
     * Handle exception behavior
     *
     * @param exception which extends Exception
     * @return error response {@link ErrorResponse}
     */
    default ErrorResponse handle(T exception) {
        return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                Arrays.asList(ErrorCode.EUNKNOWN.getErrorCode()));
    }

}