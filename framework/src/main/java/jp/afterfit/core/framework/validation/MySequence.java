package jp.afterfit.core.framework.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, First.class, Second.class, Third.class})
public interface MySequence {

}
