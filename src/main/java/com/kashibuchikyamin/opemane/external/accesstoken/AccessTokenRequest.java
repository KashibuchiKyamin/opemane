package com.kashibuchikyamin.opemane.external.accesstoken;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * アクセストークン取得APIのリクエストボディのクラス。
 */
@Data
@AllArgsConstructor
public class AccessTokenRequest {
	String crientId;
	String secretKey;
}
