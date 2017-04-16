package com.example;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class DateAndTimeTest {

	@Test
	public void dateAndTimeAPIで日付を生成() {
		// デフォルトタイムゾーンで、現在時刻を生成
		LocalDateTime time1 = LocalDateTime.now();
		System.out.println(time1);

		// タイムゾーンを指定して、現在時刻を生成
		LocalDateTime time2 = LocalDateTime.now(Clock.systemDefaultZone());
		System.out.println(time2);

		// 文字列から生成
		LocalDateTime time3 = LocalDateTime.parse("2012-01-11T11:30:12");
		System.out.println(time3);
		assertThat(time3.toString(), is("2012-01-11T11:30:12"));

		// 文字列から生成(タイムゾーン指定あり)
		OffsetDateTime time4 = OffsetDateTime.parse("2012-01-11T11:30:12Z");
		assertThat(time4.toString(), is("2012-01-11T11:30:12Z"));
	}

	@Test
	public void dateAndTimeAPIで日付を同値か判定する() {
		// 同値判定
		OffsetDateTime time1 = OffsetDateTime.parse("2012-01-11T11:30:12Z");
		OffsetDateTime time2 = OffsetDateTime.parse("2012-01-11T11:30:12Z");
		assertThat(time1.isEqual(time2), is(true));
	}
	
	@Test
	public void dateAndTimeAPIで日付を比較する() {
		OffsetDateTime time1 = OffsetDateTime.parse("2012-01-11T11:30:12Z");
		OffsetDateTime time2 = OffsetDateTime.parse("2012-01-11T11:31:12Z");

		// 大小比較
		assertThat(time1.isAfter(time2), is(false));
		assertThat(time2.isAfter(time1), is(true));
		assertThat(time1.isBefore(time2), is(true));
		assertThat(time2.isBefore(time1), is(false));		
		assertThat(time1.isEqual(time2), is(false));
	}

}
