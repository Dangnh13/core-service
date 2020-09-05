package jp.afterfit.core.oauth2.filter;

import jp.afterfit.core.oauth2.config.MetadataContextHolder;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

public class AddHeaderExchangeFilter implements ExchangeFilterFunction {
    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {

        ClientRequest newRequest = ClientRequest.from(request)
                .headers(header -> header.setBearerAuth(MetadataContextHolder.getMetadata().getAccessToken()))
                .build();
        return next.exchange(newRequest);
    }
}
