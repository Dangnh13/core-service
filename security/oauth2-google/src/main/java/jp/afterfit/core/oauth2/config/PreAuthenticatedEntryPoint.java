package jp.afterfit.core.oauth2.config;

import com.google.gson.Gson;
import jp.afterfit.core.framework.component.MessageService;
import jp.afterfit.core.framework.exception.model.BasicErrorResponse;
import jp.afterfit.core.framework.exception.model.ErrorCode;
import jp.afterfit.core.framework.exception.model.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class PreAuthenticatedEntryPoint implements AuthenticationEntryPoint {

    private static transient String UNAUTHORIZED_MESSAGE = "error.message.common.authentication.unauthorized";

    @Autowired
    private MessageService messageService;

    // Override
    // ------------------------------------------------------------------------

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException ex) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        BasicErrorResponse errorResponse = ErrorResponse.of(
                messageService.getMessage(UNAUTHORIZED_MESSAGE, request),
                Arrays.asList(ErrorCode.EUNAUTHORIZED.getErrorCode()));

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().println(new Gson().toJson(errorResponse));
        response.getWriter().flush();
    }

}
