package jp.afterfit.core.framework.exception.handler;

import jp.afterfit.core.framework.exception.model.ErrorCode;
import jp.afterfit.core.framework.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Handling of BindException
 */
@Slf4j
public class MethodArgumentNotValidExceptionHandler implements IExceptionHandler<MethodArgumentNotValidException> {

    @Override
    public ErrorResponse handle(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage(), exception);
        Map<String, Object> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    Object rejectValue = !(error.getRejectedValue() instanceof MultipartFile) ? error.getRejectedValue() : StringUtils.EMPTY;
                    validationErrors.put(error.getField(), new ErrorResponse.ItemError(rejectValue, error.getDefaultMessage()));
                });

        return ErrorResponse.of(HttpStatus.BAD_REQUEST, "Validate error", Arrays.asList(ErrorCode.EINVAL.getErrorCode()), validationErrors);
    }

}
