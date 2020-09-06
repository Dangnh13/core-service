package jp.afterfit.core.oauth2.config;

import jp.afterfit.core.oauth2.config.properties.GoogleOAuth2ResourceServerProperties;
import jp.afterfit.core.oauth2.converter.ClaimSetAdapterConverter;
import jp.afterfit.core.oauth2.converter.GrantConverter;
import jp.afterfit.core.oauth2.filter.AddHeaderExchangeFilter;
import jp.afterfit.core.oauth2.validation.AudienceValidator;
import jp.afterfit.core.oauth2.validation.GSuiteDomainValidator;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtIssuerValidator;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.web.HeaderBearerTokenResolver;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.reactive.function.client.WebClient;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Data
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ID_TOKEN = "id_token";

    private final GoogleOAuth2ResourceServerProperties oAuth2ResourceServerProperties;

    @Bean
    public JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(oAuth2ResourceServerProperties.getJwkSetUri()).build();
        jwtDecoder.setClaimSetConverter(new ClaimSetAdapterConverter());

        OAuth2TokenValidator<Jwt> timestampValidator = new JwtTimestampValidator();
        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(oAuth2ResourceServerProperties.getClientId());
        OAuth2TokenValidator<Jwt> issuerValidator = new JwtIssuerValidator(oAuth2ResourceServerProperties.getIssuerUri());
        OAuth2TokenValidator<Jwt> hdValidator = new GSuiteDomainValidator(oAuth2ResourceServerProperties.getHd());

        OAuth2TokenValidator<Jwt> tokenValidator = new DelegatingOAuth2TokenValidator<>(
                timestampValidator,
                audienceValidator,
                issuerValidator,
                hdValidator);

        jwtDecoder.setJwtValidator(tokenValidator);

        return jwtDecoder;
    }

    public Converter<Jwt, AbstractAuthenticationToken> grantedAuthoritiesExtractor() {
        JwtAuthenticationConverter jwtAuthenticationConverter =
                new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter
                (new GrantConverter());
        return jwtAuthenticationConverter;
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new PreAuthenticatedEntryPoint();
    }

    @Bean
    public WebClient rest() {
        return WebClient.builder()
                .filter(new AddHeaderExchangeFilter())
                .build();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/resources/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer(
                        oauth2ResourceServer ->
                                oauth2ResourceServer
                                        .jwt(jwt -> jwt.decoder(jwtDecoder())
                                                .jwtAuthenticationConverter(grantedAuthoritiesExtractor()))
                                        .bearerTokenResolver(new HeaderBearerTokenResolver(ID_TOKEN))
                                        .authenticationEntryPoint(authenticationEntryPoint()))
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    }
}

