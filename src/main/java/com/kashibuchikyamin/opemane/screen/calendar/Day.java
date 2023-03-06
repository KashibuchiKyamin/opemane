package com.kashibuchikyamin.opemane.screen.calendar;

/**
 * 日にちのレコード。
 */
public record Day(int date, double hours, boolean holiday) {
	/**
	 * 日にちのレコードのコンストラクター。
	 * 
	 * @deprecated staticメソッドを使用してください。
	 */
	@Deprecated
	public Day {
	}

	/**
	 * 平日のレコードの作成をする。
	 *
	 * @param date 日にち
	 * @return 平日のレコード
	 */
	public static Day createWeekday(int date, double hours) {
		return new Day(date, hours, false);
	}

	/**
	 * 休日のレコードの作成をする。
	 *
	 * @param date 日にち
	 * @return 休日のレコード
	 */
	public static Day createHoliday(int date, double hours) {
		return new Day(date, hours, true);
	}
}
