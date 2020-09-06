package jp.afterfit.core.oauth2.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service.security.google-oauth.resource-server")
@Data
public class GoogleOAuth2ResourceServerProperties {
    private String clientId;
    private String projectId;
    private String jwkSetUri;
    private String issuerUri;
    private String hd;
}
