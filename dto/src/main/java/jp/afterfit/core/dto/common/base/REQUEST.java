package jp.afterfit.core.dto.common.base;

import jp.afterfit.core.dto.common.base.DXO;

public abstract class REQUEST {

    public abstract <T extends DXO> T toDxo();
}
