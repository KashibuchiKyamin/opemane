package com.kashibuchikyamin.opemane.screen.calendar;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

/**
 * 稼働一覧(カレンダー)のクラス。
 */
@RequestMapping("calendar")
@Controller
@AllArgsConstructor
public class CalendarController {
	
	private CalendarService calendarService;
	
	@GetMapping({"", "{yearMonth}"})
	public String showCalendar(
			@PathVariable(required = false) @DateTimeFormat(pattern = "uuuu-MM") Optional<YearMonth> yearMonth,
			Model model) {
		YearMonth targetYearMonth = yearMonth.orElse(YearMonth.now(ZoneId.of("Asia/Tokyo")));
		CalendarTable calenderData = calendarService.createCalenderData(targetYearMonth);
		model.addAttribute("calendarValue", calenderData);
		return "calendar";
	}
	
}
