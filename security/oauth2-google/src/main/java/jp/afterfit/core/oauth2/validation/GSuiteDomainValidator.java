package jp.afterfit.core.oauth2.validation;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

public class GSuiteDomainValidator implements OAuth2TokenValidator<Jwt> {

    private static final String HD_CLAIM = "hd";
    private OAuth2Error error = new OAuth2Error("invalid_token", "The HD claim is invalid", null);

    private String hd;

    public GSuiteDomainValidator(String hd) {
        this.hd = hd;
    }

    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        if (jwt.getClaim(HD_CLAIM).equals(this.hd)) {
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult.failure(error);
    }
}
