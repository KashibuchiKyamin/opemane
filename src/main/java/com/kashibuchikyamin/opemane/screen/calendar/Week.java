package com.kashibuchikyamin.opemane.screen.calendar;

import lombok.Builder;

/**
 * 1週間のレコード。
 */
@Builder
public record Week(Day monday, Day tuesday, Day wednesday, Day thursday, Day friday, Day saturday, Day sunday) {
	/**
	 * 稼働時間の合計をし、返却する。
	 *
	 * @return 合計稼働時間(H)
	 */
	public double totalHours() {
		double day1 = monday == null ? 0.0 : monday.hours();
		double day2 = tuesday == null ? 0.0 : tuesday.hours();
		double day3 = wednesday == null ? 0.0 : wednesday.hours();
		double day4 = thursday == null ? 0.0 : thursday.hours();
		double day5 = friday == null ? 0.0 : friday.hours();
		double day6 = saturday == null ? 0.0 : saturday.hours();
		double day7 = sunday == null ? 0.0 : sunday.hours();
		return day1 + day2 + day3 + day4 + day5 + day6 + day7;
	}
}
