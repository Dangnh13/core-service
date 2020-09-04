package jp.afterfit.core.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import jp.afterfit.core.framework.validation.annotation.LengthMinAndMax;

public class LengthMinAndMaxValidator implements ConstraintValidator<LengthMinAndMax, String> {
	private int min;
	private int max;

	public void initialize(LengthMinAndMax parameters) {
		min = parameters.min();
		max = parameters.max();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		int length = value.length();

		if (min <= length && length <= max) {
			return true;
		}
		return false;
	}

	private void validateParameters() {

	}

}
