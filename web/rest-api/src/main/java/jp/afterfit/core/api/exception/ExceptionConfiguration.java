package jp.afterfit.core.api.exception;

import jp.afterfit.core.framework.exception.handler.BindExceptionHandler;
import jp.afterfit.core.framework.exception.handler.IExceptionHandler;
import jp.afterfit.core.framework.exception.handler.MethodArgumentNotValidExceptionHandler;
import jp.afterfit.core.framework.exception.handler.ServiceExceptionHandler;
import jp.afterfit.core.framework.exception.type.ServiceException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Configuration
public class ExceptionConfiguration {
    @Bean
    public IExceptionHandler<ServiceException> serviceExceptionHandler() {
        return new ServiceExceptionHandler();
    }

    @Bean
    public IExceptionHandler<BindException> bindExceptionHandler() {
        return new BindExceptionHandler();
    }

    @Bean
    public IExceptionHandler<MethodArgumentNotValidException> methodArgumentNotValidExceptionIExceptionHandler() {
        return new MethodArgumentNotValidExceptionHandler();
    }

    @Bean
    public AuthenticationEventPublisher authenticationEventPublisher
            (ApplicationEventPublisher applicationEventPublisher) {
        return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
    }
}
