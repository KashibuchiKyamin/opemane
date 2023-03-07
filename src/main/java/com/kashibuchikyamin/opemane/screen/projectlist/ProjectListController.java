package com.kashibuchikyamin.opemane.screen.projectlist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

/**
 * プロジェクト一覧のクラス。
 */
@RequestMapping("project-list")
@Controller
@AllArgsConstructor
public class ProjectListController {
	/**
	 * 初期表示をする。
	 *
	 * @return プロジェクト一覧のテンプレート名
	 */
	@GetMapping
	public String showInitPage() {
		return "project-list";
	}

	/**
	 * プロジェクト一覧のデータを取得する。
	 *
	 * @return プロジェクト一覧のデータ
	 */
	@GetMapping("data")
	@ResponseBody
	public ProjectList showProjectList() {
		List<ProjectList.Project> projectList = new ArrayList<>();
		projectList.add(new ProjectList.Project("samurai - STEP2.5対応", "A0123456789"));
		projectList.add(new ProjectList.Project("gate - 新規開発", "A1123456789"));
		projectList.add(new ProjectList.Project("社内業務", "G0123456789"));
		projectList.add(new ProjectList.Project("ideon - 保守対応", "A3123456789"));
		return new ProjectList(projectList);
	}
}
