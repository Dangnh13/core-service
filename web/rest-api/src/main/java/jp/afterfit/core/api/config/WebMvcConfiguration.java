package jp.afterfit.core.api.config;

import jp.afterfit.core.framework.component.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    // =========================================================================
    //                                                                Constant
    //                                                                ==========

    // =========================================================================
    //                                                                DI
    //                                                                ==========

    @Bean
    public MessageService messageService(final MessageSource messageSource) {
        return new MessageService(messageSource, Locale.JAPANESE);
    }

    // =========================================================================
    //                                                                Public method
    //                                                                ==========

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

}
