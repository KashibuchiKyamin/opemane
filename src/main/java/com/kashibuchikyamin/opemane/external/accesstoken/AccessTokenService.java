package com.kashibuchikyamin.opemane.external.accesstoken;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * アクセストークン取得APIのインタフェース。
 */
@HttpExchange("/token") // プロパティの値を使用できない(${}、#{}、#{${}}試したがNGでした)
public interface AccessTokenService {

	/**
	 * アクセストークンの取得をする。
	 *
	 * @param requestBody
	 * @return レスポンスボディ
	 */
	@PostExchange
	ResponseEntity<AccessTokenResponse> getAccessToken(@RequestBody AccessTokenRequest requestBody);
}
