package jp.afterfit.core.framework.validation;

import org.springframework.util.StringUtils;
import jp.afterfit.core.framework.validation.annotation.Number;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator implements ConstraintValidator<Number, String> {

    public void initialize(java.lang.Number parameters) {
        validateParameters();
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        String regex = "^(\\d+)$";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(value.trim());

        if (m.find()) {
            return true;
        } else {
            return false;
        }

    }

    private void validateParameters() {
    }
}
