package com.kashibuchikyamin.opemane.screen.projectlist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

/**
 * プロジェクト一覧のクラス。
 */
@RequestMapping("project-list")
@Controller
@AllArgsConstructor
public class ProjectListController {
	@GetMapping
	public String showProjectList() {
		return "project-list";
	}
}
