package com.minyul.api.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TimeUtilTest {

	/**
	 * 관심사가 비슷한 테스트끼리는 @Nested를 이용하여 묶기
	 * @author : Minyul
	 */
	@Nested
	class DateParsing {

		@DisplayName("포맷에 맞지 않는 StringType Date 일 때, 예외처리가 되는 지 확인하는 테스트")
		@Test
		void StringDate_to_Timestamp_Exception() {

			Assertions.assertThrows(RuntimeException.class, () -> TimeUtil.dateToTimestamp("20210201"));
		}

		@DisplayName("포맷에 맞는 String Date 일 때, Timestamp Type으로 잘 반환되는 지 확인하는 테스트")
		@Test
		void String_to_Timestamp() {
			Timestamp resultTimestamp = TimeUtil.dateToTimestamp("2021-02-01");
			Timestamp date = Timestamp.valueOf("2021-02-01 00:00:00.0");

			assertThat(resultTimestamp).isEqualTo(date);
		}
	}
}