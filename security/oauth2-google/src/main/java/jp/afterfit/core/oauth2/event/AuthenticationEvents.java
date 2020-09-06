package jp.afterfit.core.oauth2.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureCredentialsExpiredEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.AuthenticationFailureExpiredEvent;
import org.springframework.security.authentication.event.AuthenticationFailureLockedEvent;
import org.springframework.security.authentication.event.AuthenticationFailureProviderNotFoundEvent;
import org.springframework.security.authentication.event.AuthenticationFailureServiceExceptionEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Listener authentication events
 */
@Component
@Slf4j
public class AuthenticationEvents {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        // TODO
        log.info("Login SUCCESS");
    }


    /**
     * @param failures usernameNotFoundException, invalidBearerTokenException, badCredentialsException
     */
    @EventListener
    public void invalidBearerTokenException(AuthenticationFailureBadCredentialsEvent failures) {
        log.info("Login failed: invalidBearerTokenException");
        // TODO
    }

    @EventListener
    public void credentialsExpiredException(AuthenticationFailureCredentialsExpiredEvent failures) {
        log.info("Login failed: CredentialsExpiredException");
        // TODO
    }

    @EventListener
    public void authenticationServiceException(AuthenticationFailureServiceExceptionEvent failures) {
        log.info("Login failed: authenticationServiceException");
        // TODO
    }

    @EventListener
    public void lockedException(AuthenticationFailureLockedEvent failures) {
        log.info("Login failed: lockedException");
        // TODO
    }

    @EventListener
    public void disabledException(AuthenticationFailureDisabledEvent failures) {
        log.info("Login failed: disabledException");
        // TODO
    }

    @EventListener
    public void providerNotFoundException(AuthenticationFailureProviderNotFoundEvent failures) {
        log.info("Login failed: providerNotFoundException");
        // TODO
    }

    @EventListener
    public void accountExpiredException(AuthenticationFailureExpiredEvent failures) {
        log.info("Login failed: AccountExpiredException");
        // TODO
    }
}
