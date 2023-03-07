package com.kashibuchikyamin.opemane.screen.projectlist;

import org.springframework.stereotype.Service;

import com.kashibuchikyamin.opemane.external.accesstoken.AccessTokenApi;

import lombok.AllArgsConstructor;

/**
 * プロジェクト一覧のサービスクラス。
 */
@AllArgsConstructor
@Service
public class ProjectListService {

	private AccessTokenApi accessTokenApi;

	/**
	 * プロジェクト一覧の取得をする。
	 *
	 * @return プロジェクト一覧のオブジェクト
	 */
	public ProjectList getProjectList() {
		accessTokenApi.getAccessToken();
		return null;
	}

}
