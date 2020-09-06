package jp.afterfit.core.business.service;

import com.github.pagehelper.Page;
import jp.afterfit.core.dto.common.base.DXO;

public interface IUserService {
    Page<Users> findUser(DXO dxo);
}
