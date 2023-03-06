package com.kashibuchikyamin.opemane.screen.calendar;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kashibuchikyamin.opemane.repository.holidays.HolidaysMapper;

import lombok.AllArgsConstructor;

/**
 * 稼働一覧(カレンダー)の業務処理クラス。
 */
@Service
@AllArgsConstructor
public class CalendarService {

	private HolidaysMapper holidays;

	/**
	 * カレンダー情報の作成をする。
	 *
	 * @param targetYearMonth - 作成対象年月
	 * @return
	 */
	public CalendarTable createCalenderData(YearMonth targetYearMonth) {

		List<LocalDate> holidayData = holidays.getHolidayData(targetYearMonth);

		return CalendarTable.createCalendar(targetYearMonth, holidayData);

	}

}
