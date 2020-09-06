package jp.afterfit.core.oauth2.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter;

import java.util.Collections;
import java.util.Map;

/**
 * CRUD claim converter
 */
public class ClaimSetAdapterConverter implements Converter<Map<String, Object>, Map<String, Object>> {

    private final MappedJwtClaimSetConverter delegate =
            MappedJwtClaimSetConverter.withDefaults(Collections.emptyMap());

    public Map<String, Object> convert(Map<String, Object> claims) {
        Map<String, Object> convertedClaims = this.delegate.convert(claims);

        /*String username = (String) convertedClaims.get("user_name");
        convertedClaims.put("custom", username);*/

        return convertedClaims;
    }
}
