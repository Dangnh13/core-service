package jp.afterfit.core.oauth2.filter;

import jp.afterfit.core.oauth2.config.Metadata;
import jp.afterfit.core.oauth2.config.MetadataContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Setting Access token to MetadataContextHolder for using later
 */
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class SaveHeaderFilter extends OncePerRequestFilter {

    private static final String AUTHENTICATION_SCHEME = "Bearer";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isNotBlank(authorization)) {
            String token = authorization
                    .substring(AUTHENTICATION_SCHEME.length()).trim();
            MetadataContextHolder.setMetadata(new Metadata(token));
        }

        filterChain.doFilter(request, response);
    }
}
