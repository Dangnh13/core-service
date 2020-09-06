package jp.afterfit.core.oauth2.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationEvents {
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        // TODO
        log.info("Login SUCCESS");
    }

    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent failures) {
        log.info("Login failed");
        // TODO
    }
}
