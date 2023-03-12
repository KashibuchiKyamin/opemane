package com.kashibuchikyamin.opemane.config.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenService;

/**
 * API呼び出しに使用するBean定義のクラス。
 */
@Configuration
public class HttpClientConfig {

	private WebClient webClient;

	/**
	 * API呼び出しに使用するBean定義のコンストラクター。
	 *
	 * @param webClient
	 */
	public HttpClientConfig(@Value("${opemane.api.baseuri}") String baseUrl, WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(baseUrl).build();
	}

	@Bean
	public AccessTokenService accessTokenService() {
		HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(webClient))
				.build();
		return proxyFactory.createClient(AccessTokenService.class);
	}

}
