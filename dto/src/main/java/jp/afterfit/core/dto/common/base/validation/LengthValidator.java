package jp.afterfit.core.dto.common.base.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import jp.afterfit.core.dto.common.base.validation.annotation.Length;

public class LengthValidator implements ConstraintValidator<Length, String> {
	private int length;

	public void initialize(Length parameters) {
		length = parameters.length();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		return value.length() == length;
	}

	private void validateParameters() {
		if (length < 0) {
			throw new IllegalArgumentException("The length parameter cannot be negative.");
		}
	}
}
