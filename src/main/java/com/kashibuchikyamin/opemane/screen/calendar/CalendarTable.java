package com.kashibuchikyamin.opemane.screen.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.kashibuchikyamin.opemane.screen.calendar.Week.WeekBuilder;

import lombok.Builder;

/**
 * 稼働一覧のカレンダー用のレコード。
 * 
 * @param yearMonth 年月 Null不可
 * @param weeks 週毎のデータのリスト Null不可かつ、4週または5週ぶんのデータでないと不可
 */
@Builder
public record CalendarTable(
		YearMonth yearMonth,
		List<Week> weeks) {

	/**
	 * 稼働一覧のカレンダー用のレコードのコンストラクター。
	 */
	public CalendarTable {
		if (yearMonth == null || weeks == null) {
			throw new IllegalArgumentException("引数にnullは指定できません。");
		}

		if (weeks.size() != 4 && weeks.size() != 5) {
			throw new IllegalArgumentException("週のリストサイズは4または5つぶん設定してください(リストサイズ: " + weeks.size() + ")。");
		}

	}

	/**
	 * 月曜始まりの週のリスト
	 */
	private static final List<DayOfWeek> LIST_OF_DAY_OF_THE_WEEK = Arrays.asList(
			DayOfWeek.MONDAY,
			DayOfWeek.TUESDAY,
			DayOfWeek.WEDNESDAY,
			DayOfWeek.THURSDAY,
			DayOfWeek.FRIDAY,
			DayOfWeek.SATURDAY,
			DayOfWeek.SUNDAY);

	/**
	 * カレンダーの作成をする。
	 * 作成されるカレンダーは土日を休日として扱い、その他の曜日の休日については{@link HolidayData}を元に判定する。
	 * 
	 * @param yearMonth 対象年月
	 * @param holidayData 休日情報
	 * @return カレンダーのレコード
	 */
	public static CalendarTable createCalendar(YearMonth yearMonth, List<LocalDate> holidayData) {
		CalendarTableBuilder builder = CalendarTable.builder();
		builder.yearMonth(yearMonth);
		int dayNumber = 1;
		int lengthOfMonth = yearMonth.lengthOfMonth();

		ArrayList<Week> weeks = new ArrayList<>();

		while (dayNumber <= lengthOfMonth) {
			WeekBuilder weekBuilder = Week.builder();

			for (DayOfWeek dayOfWeek : LIST_OF_DAY_OF_THE_WEEK) {
				if (dayNumber > lengthOfMonth) {
					break;
				}
				LocalDate day = yearMonth.atDay(dayNumber);
				if (day.getDayOfWeek() != dayOfWeek) {
					continue;
				}
				switch (dayOfWeek) {
					case MONDAY -> weekBuilder.monday(createDay(dayNumber, holidayData));
					case TUESDAY -> weekBuilder.tuesday(createDay(dayNumber, holidayData));
					case WEDNESDAY -> weekBuilder.wednesday(createDay(dayNumber, holidayData));
					case THURSDAY -> weekBuilder.thursday(createDay(dayNumber, holidayData));
					case FRIDAY -> weekBuilder.friday(createDay(dayNumber, holidayData));
					case SATURDAY -> weekBuilder.saturday(Day.createHoliday(dayNumber, 0.0));
					case SUNDAY -> weekBuilder.sunday(Day.createHoliday(dayNumber, 0.0));
					default -> throw new RuntimeException("想定外の曜日が使用されました。");
				};
				dayNumber++;
			}

			weeks.add(weekBuilder.build());
		}
		builder.weeks(weeks);
		return builder.build();
	}

	/**
	 * 休日判定を行い、平日または休日の{@link Day}オブジェクトの作成をする。
	 *
	 * @param dayNumber 日にちの数値
	 * @param holidayData 休日リスト
	 * @return 作成された{@link Day}オブジェクト。
	 */
	private static Day createDay(int dayNumber, List<LocalDate> holidayData) {
		Optional<LocalDate> findResult = holidayData.stream().filter(data -> data.getDayOfMonth() == dayNumber)
				.findFirst();

		if (findResult.isPresent()) {
			return Day.createHoliday(dayNumber, 0.0);
		}
		return Day.createWeekday(dayNumber, 7.5);
	}
}
