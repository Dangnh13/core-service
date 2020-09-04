package jp.afterfit.core.oauth2.service;

import jp.afterfit.core.domain.entity.generator.Authorities;
import jp.afterfit.core.domain.entity.generator.AuthoritiesCriteria;
import jp.afterfit.core.domain.entity.generator.Users;
import jp.afterfit.core.persistence.dao.generator.AuthoritiesMapper;
import jp.afterfit.core.persistence.dao.generator.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LoginInfoService implements UserDetailsService {

	// Instance variables
	// ------------------------------------------------------------------------

	private final UsersMapper usersMapper;
	private final AuthoritiesMapper authoritiesMapper;

	// Constructors
	// ------------------------------------------------------------------------

	public LoginInfoService(UsersMapper usersMapper, AuthoritiesMapper authoritiesMapper) {
		this.usersMapper = usersMapper;
		this.authoritiesMapper = authoritiesMapper;
	}

	// Overrided methods
	// ------------------------------------------------------------------------
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersMapper.selectByPrimaryKey(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Username {} not found", username));
		}
		AuthoritiesCriteria authoritiesCriteria = new AuthoritiesCriteria();
		authoritiesCriteria
				.createCriteria()
				.andUsernameEqualTo(username);

		List<Authorities> authorities = authoritiesMapper.selectByExample(authoritiesCriteria);
		return null;
	}
}