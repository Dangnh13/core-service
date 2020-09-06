package jp.afterfit.core.framework.exception.handler;

import jp.afterfit.core.framework.exception.model.ErrorResponse;
import jp.afterfit.core.framework.exception.type.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * Handling service exception
 */
@Slf4j
public class UnknownExceptionHandler implements IExceptionHandler<Exception> {

}
