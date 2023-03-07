package com.kashibuchikyamin.opemane.external.accesstoken;

import lombok.Data;

/**
 * アクセストークンのクラス。
 */
@Data
public class AccessToken {

	/**
	 * 結果
	 */
	private String result;

	/**
	 * アクセストークン
	 */
	private String token;

	/**
	 * レスポンスボディのステータスが成功であるかの判定をする。
	 *
	 * @return "success"であればtrue。それ以外はfalse。
	 */
	public boolean success() {
		if ("success".equals(result)) {
			return true;
		}
		return false;
	}
}
