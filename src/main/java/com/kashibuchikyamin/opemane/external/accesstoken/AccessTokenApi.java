package com.kashibuchikyamin.opemane.external.accesstoken;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.kashibuchikyamin.opemane.config.constant.AccessTokenApiConfig;

/**
 * アクセストークン取得APIのクラス。
 */
@Component
public class AccessTokenApi {

	/**
	 * API呼び出し用のコンポーネント
	 */
	private final WebClient webClient;

	/**
	 * URL、クライアントIDとシークレットキーを保持
	 */
	private AccessTokenApiConfig config;

	/**
	 * アクセストークン取得APIのクラスのコンストラクター。
	 *
	 * @param buillder API呼び出し用のコンポーネント
	 * @param config URL、クライアントIDとシークレットキーの情報
	 */
	public AccessTokenApi(WebClient.Builder buillder, AccessTokenApiConfig config) {
		this.webClient = buillder.build();
		this.config = config;
	}

	public AccessToken getAccessToken() {
		AccessTokenRequest requestBody = AccessTokenRequest.builder().crientId(config.getId())
				.secretKey(config.getKey()).build();

		this.webClient.post().uri(config.getUrl()).accept(MediaType.APPLICATION_JSON).bodyValue(requestBody).retrieve();
		return null;
	}
}
