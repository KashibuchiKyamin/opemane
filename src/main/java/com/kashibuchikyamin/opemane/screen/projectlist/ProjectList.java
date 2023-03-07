package com.kashibuchikyamin.opemane.screen.projectlist;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * プロジェクト一覧のRestAPIで使用するレスポンスボディのクラス。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectList {

	List<Project> subjects;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Project {
		String name;
		String code;
	}
}
