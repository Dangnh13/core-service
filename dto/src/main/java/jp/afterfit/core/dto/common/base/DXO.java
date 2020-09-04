package jp.afterfit.core.dto.common.base;

import lombok.Data;

@Data
public abstract class DXO {

    public abstract <T extends PRM> T toPrm();

}
