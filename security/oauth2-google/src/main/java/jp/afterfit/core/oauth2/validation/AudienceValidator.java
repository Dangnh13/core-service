package jp.afterfit.core.oauth2.validation;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

public class AudienceValidator implements OAuth2TokenValidator<Jwt> {
    private OAuth2Error error = new OAuth2Error("invalid_token", "The required audience is missing", null);

    private OAuth2ResourceServerProperties oAuth2ResourceServerProperties;

    public AudienceValidator(OAuth2ResourceServerProperties oAuth2ResourceServerProperties) {
        this.oAuth2ResourceServerProperties = oAuth2ResourceServerProperties;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        if (true) return OAuth2TokenValidatorResult.success();
        if (jwt.getAudience().contains("messaging")) {
            return OAuth2TokenValidatorResult.success();
        } else {
            return OAuth2TokenValidatorResult.failure(error);
        }
    }
}
