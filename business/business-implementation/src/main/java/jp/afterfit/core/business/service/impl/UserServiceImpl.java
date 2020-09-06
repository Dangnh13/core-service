package jp.afterfit.core.business.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jp.afterfit.core.business.service.IUserService;
import jp.afterfit.core.domain.entity.generator.Users;
import jp.afterfit.core.domain.entity.generator.UsersCriteria;
import jp.afterfit.core.dto.common.base.DXO;
import jp.afterfit.core.persistence.dao.generator.UsersMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final UsersMapper usersMapper;

    public UserServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Page<Users> findUser(DXO dxo) {
        UsersCriteria criteria = new UsersCriteria();
		/*criteria.createCriteria().andUsernameEqualTo("admin");
		criteria.setOrderByClause("username");*/
        Page<Users> page = PageHelper.startPage(1, 2).doSelectPage(() -> usersMapper.selectByExample(criteria));
        return page;
    }

}
