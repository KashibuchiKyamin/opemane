package com.kashibuchikyamin.opemane.external.accesstoken;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * アクセストークン取得APIのインタフェース。
 */
@HttpExchange(url = "/token")
public interface AccessTokenService {

	@PostExchange
	ResponseEntity<AccessTokenResponse> getAccessToken(@RequestBody AccessTokenRequest requestBody);
}
