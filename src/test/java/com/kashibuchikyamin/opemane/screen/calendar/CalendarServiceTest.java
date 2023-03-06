package com.kashibuchikyamin.opemane.screen.calendar;

import java.time.YearMonth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * のクラス。
 */
@SpringJUnitConfig(CalendarService.class)
class CalendarServiceTest {

	@Autowired
	private CalendarService target;

	@DisplayName("createCalenderDataのテスト")
	@Nested
	class TestCreateCalenderData {

		@DisplayName("指定した年月でカレンダーを返す")
		@Test
		void create() {
			YearMonth input = YearMonth.of(2023, 2);
			CalendarTable actual = target.createCalenderData(input);
		}
	}

}
