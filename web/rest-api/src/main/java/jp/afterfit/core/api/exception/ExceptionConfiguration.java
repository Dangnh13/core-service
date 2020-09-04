package jp.afterfit.core.api.exception;

import jp.afterfit.core.framework.exception.handler.IExceptionHandler;
import jp.afterfit.core.framework.exception.handler.BindExceptionHandler;
import jp.afterfit.core.framework.exception.handler.ServiceExceptionHandler;
import jp.afterfit.core.framework.exception.type.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;

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
}
