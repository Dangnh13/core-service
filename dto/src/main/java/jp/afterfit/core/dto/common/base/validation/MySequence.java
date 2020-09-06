package jp.afterfit.core.dto.common.base.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, First.class, Second.class, Third.class})
public interface MySequence {

}
