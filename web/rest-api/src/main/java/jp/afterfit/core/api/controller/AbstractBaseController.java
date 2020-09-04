package jp.afterfit.core.api.controller;

import jp.afterfit.core.dto.common.base.DXO;
import jp.afterfit.core.dto.common.base.Envelope;
import jp.afterfit.core.dto.common.base.REQUEST;
import jp.afterfit.core.dto.common.base.RESPONSE;
import jp.afterfit.core.dto.common.base.RST;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;

@Slf4j
public abstract class AbstractBaseController {

/*	private <REQ extends REQUEST, RES extends RESPONSE, XO extends DXO, RS extends RST> ResponseEntity<RES> bindingResult(REQ request, Function<XO, RS> method) {
		ResponseEntity<RES> responseEntity = new Envelope<RES>(method.apply(request.toDxo()).toResponse()).toResponseEntity();
		if (responseEntity.getBody() instanceof Void) {
			return new ResponseEntity(responseEntity.getStatusCode());
		}
		return responseEntity;
	}

	protected <REQ extends REQUEST, RES extends RESPONSE, XO extends DXO, RS extends RST> ResponseEntity<RES> resultOf(REQ request, Function<XO, RS> method) {
		return bindingResult(request, method);
	}*/

}
