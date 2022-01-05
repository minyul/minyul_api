package com.minyul.api.utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;

@Slf4j
public class TimeUtil {

	private static final Integer NUMBER_ZERO = 0;
	private static final Integer NUMBER_ONE = 1;

	// 평일
	private static final Integer WEEK_DAY = 5;
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	// 시간대 로직 변수
	private static final Integer MILLIS_UNIT = 1_000;
	private static final Integer SECONDS_UNIT = 60;

	public static LocalDateTime StringToLocalDateTime(String date) {
		DateTimeFormatter dateForMatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		LocalDate ld = LocalDate.parse(date, dateForMatter);

		return ld.atStartOfDay();
	}

	public static LocalDateTime monday() {

		return LocalDate.now().plusDays(NUMBER_ONE).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).minusWeeks(NUMBER_ONE)
						.atStartOfDay();
	}

	public static LocalDateTime saturday() {

		return LocalDate.now().plusDays(NUMBER_ONE).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).minusWeeks(NUMBER_ONE)
						.plusDays(WEEK_DAY).atStartOfDay();
	}

	public static LocalDateTime sunday() {

		return LocalDate.now().plusDays(NUMBER_ONE).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).minusWeeks(NUMBER_ONE)
						.plusDays(WEEK_DAY + NUMBER_ONE).atStartOfDay();
	}

	// 이번주 주말인지 아닌지
	public static Boolean isHoliday() {
		if ((LocalDate.now().compareTo(TimeUtil.saturday().toLocalDate()) == NUMBER_ZERO) ||
						(LocalDate.now().compareTo(TimeUtil.sunday().toLocalDate()) == NUMBER_ZERO)) {

			return true;
		}

		return false;
	}

	// 현재 시간에 수행을 해도 괜찮은 지에 대한 로직
	public static Boolean isExecutionByCurrentTime() {

		// 우선 현재 날짜를 갖고 온다.
		String currentDate = StringDate(System.currentTimeMillis());

		// 그날의 첫번째 시간
		Timestamp firstTime = dateToTimestamp(currentDate);

		// 현재 시간
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		long timeInterval = currentTime.getTime() - firstTime.getTime();
		long seconds = timeInterval / MILLIS_UNIT;
		long minutes = seconds / SECONDS_UNIT;

		// 9시 20분
		return minutes >= 560;
	}

	public static String StringDate(long time){
		Calendar day = Calendar.getInstance();
		day.setTimeInMillis(time);

		return new java.text.SimpleDateFormat(DATE_FORMAT).format(day.getTime());
	}

	public static Timestamp dateToTimestamp(String time) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

			return new Timestamp ((dateFormat.parse(time)).getTime());
		}catch (ParseException parseException) {

			/**
			 * log.error("{}, {}", e.getMessage(), e); : 이것 같은 경우 보안상 좋지않을 수 있다. 근데
			 * 에러 찾기는 개편한데 말이지.. 흠
			 * e.printStackTrace 같은 경우에는 System.err 기에 쓰면 안된다.
			 *
			 * 또한, 하나의 예시일 뿐, Util에는 보통 NPE, PARSE 에 대한 에러로 예측가능하므로 굳이 log를 안찍어도..
			 */

			log.error("Time Utils ERROR - PARAM : {}, MESSAGE {}", time, parseException.getMessage());

			throw new RuntimeException(parseException.getMessage());
		}
	}
}
