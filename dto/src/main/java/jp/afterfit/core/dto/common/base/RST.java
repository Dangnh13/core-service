package jp.afterfit.core.dto.common.base;

import jp.afterfit.core.dto.common.base.RESPONSE;

public abstract class RST {

    public abstract <T extends RESPONSE> T toResponse();
}
