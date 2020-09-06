package jp.afterfit.core.framework.component;

import jp.afterfit.core.framework.util.AcceptHeaderResolver;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public class MessageService extends MessageSourceAccessor {

    public MessageService(MessageSource messageSource) {
        super(messageSource);
    }

    public MessageService(MessageSource messageSource, Locale defaultLocale) {
        super(messageSource, defaultLocale);
    }

    public String getMessage(String code, HttpServletRequest request) {
        Locale locale = AcceptHeaderResolver.resolveLocale(request);
        String msg = (locale != null) ? super.getMessage(code, locale) : super.getMessage(code);
        return StringUtils.defaultIfEmpty(msg, StringUtils.EMPTY);
    }
}
