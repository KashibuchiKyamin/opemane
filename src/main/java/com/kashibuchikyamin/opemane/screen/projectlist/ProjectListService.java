package com.kashibuchikyamin.opemane.screen.projectlist;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kashibuchikyamin.opemane.config.properties.AccessTokenApiConfig;
import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenRequest;
import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenResponse;
import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * プロジェクト一覧のサービスクラス。
 */
@AllArgsConstructor
@Service
@Log4j2
public class ProjectListService {


	private AccessTokenApiConfig tokenApiConfig;
	private AccessTokenService accessTokenService;

	/**
	 * プロジェクト一覧の取得をする。
	 *
	 * @return プロジェクト一覧のオブジェクト
	 */
	public ProjectList getProjectList() {
		AccessTokenRequest request = new AccessTokenRequest(tokenApiConfig.getId(), tokenApiConfig.getKey());
		log.info("request: {}", request.toString());
		ResponseEntity<AccessTokenResponse> accessToken = accessTokenService.getAccessToken(request);
		log.info("response: {}", accessToken.toString());
		return null;
	}

}
