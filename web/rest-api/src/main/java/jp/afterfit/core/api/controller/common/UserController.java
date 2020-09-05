package jp.afterfit.core.api.controller.common;

import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import jp.afterfit.core.api.controller.AbstractBaseController;
import jp.afterfit.core.business.service.IUserService;
import jp.afterfit.core.dto.common.user.SearchUserRequest;
import jp.afterfit.core.dto.common.user.SearchUserResponse;
import jp.afterfit.core.framework.constant.Router;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "UserController")
public class UserController extends AbstractBaseController {

    private final IUserService userService;

    @PostMapping(value = "${endpoint.user.find}")
    public ResponseEntity<SearchUserResponse> search(@RequestBody @Valid SearchUserRequest request) {
        Page<jp.afterfit.core.domain.entity.generator.Users> page = userService.findUser(request.toDxo());
        return ResponseEntity.ok(new SearchUserResponse());
    }
}

