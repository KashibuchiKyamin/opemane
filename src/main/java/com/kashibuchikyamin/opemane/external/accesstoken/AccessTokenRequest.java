package com.kashibuchikyamin.opemane.external.accesstoken;

import lombok.Builder;
import lombok.Getter;

/**
 * アクセストークン取得APIのリクエストボディのクラス。
 */
@Builder
@Getter
public class AccessTokenRequest {
	String crientId;
	String secretKey;
}
