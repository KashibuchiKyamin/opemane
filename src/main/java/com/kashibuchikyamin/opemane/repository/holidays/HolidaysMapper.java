package com.kashibuchikyamin.opemane.repository.holidays;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 休日情報テーブルのインターフェース。
 */
@Mapper
public interface HolidaysMapper {
	@Select("""
			SELECT
				HOLIDAY_DATE
			FROM
				HOLIDAYS
			WHERE
				HOLIDAY_DATE like CONCAT(#{target}, '%')
			""")
	public List<LocalDate> getHolidayData(@Param("target") YearMonth target);
}
