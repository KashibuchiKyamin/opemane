package com.kashibuchikyamin.opemane.config.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * アクセストークン取得に使用する設定値クラス。
 */
@Component
@ConfigurationProperties(prefix = "opemane.api.accesstoken")
@Data
public class AccessTokenApiConfig {
	/**
	 * APIのURL
	 */
	private String url;
	/**
	 * リクエストに使用するクライアントID
	 */
	private String id;
	/**
	 * リクエストに使用するシークレットキー
	 */
	private String key;
}
