package jp.afterfit.core.dto.common.user;

import io.swagger.annotations.Api;
import jp.afterfit.core.dto.common.base.DXO;
import jp.afterfit.core.dto.common.base.REQUEST;
import jp.afterfit.core.dto.common.base.validation.annotation.RequiredNotBlank;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchUserRequest extends REQUEST {

    @NotBlank
    private String id;

    @RequiredNotBlank(name = "FULLNAME")
    private String full;

    @Override
    public <T extends DXO> T toDxo() {
        return null;
    }
}
