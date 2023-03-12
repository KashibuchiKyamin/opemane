package com.kashibuchikyamin.opemane.screen.projectlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kashibuchikyamin.opemane.config.properties.AccessTokenApiConfig;
import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenRequest;
import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenResponse;
import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenService;

import lombok.AllArgsConstructor;

/**
 * プロジェクト一覧のサービスクラス。
 */
@AllArgsConstructor
@Service
public class ProjectListService {

	private final static Logger logger = LogManager.getLogger(ProjectListService.class);

	private AccessTokenApiConfig tokenApiConfig;
	private AccessTokenService accessTokenService;

	/**
	 * プロジェクト一覧の取得をする。
	 *
	 * @return プロジェクト一覧のオブジェクト
	 */
	public ProjectList getProjectList() {
		AccessTokenRequest request = new AccessTokenRequest(tokenApiConfig.getId(), tokenApiConfig.getKey());
		logger.info("request: {}", request.toString());
		ResponseEntity<AccessTokenResponse> accessToken = accessTokenService.getAccessToken(request);
		logger.info("response: {}", accessToken.toString());
		return null;
	}

}
