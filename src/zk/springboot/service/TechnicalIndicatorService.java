package zk.springboot.service;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Service
@Deprecated
public class TechnicalIndicatorService {
	protected static final Logger logger = LoggerFactory.getLogger(TechnicalIndicatorService.class);
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###,###.##");

	/**
	 * List<TWStockDailyTrading> -> org.ta4j.core.TimeSeries
	 */
	// protected TimeSeries getTimeSeries(List<TWStockDailyTrading> dailyTradings) {
	// TimeSeries result = new BaseTimeSeries();
	//
	// try {
	// for (TWStockDailyTrading trading : dailyTradings) {
	// // 107/01/01
	// String[] tradingDateArr = trading.getTradingDate().split("/");
	//
	// ZonedDateTime zonedDateTime = ZonedDateTime.of(
	// LocalDateTime.of(1911 + Integer.valueOf(tradingDateArr[0]),
	// Integer.valueOf(tradingDateArr[1]), Integer.valueOf(tradingDateArr[2]), 00,
	// 00, 00, 00), ZoneId.of("Asia/Taipei"));
	//
	// result.addBar(new BaseBar(zonedDateTime,
	// DECIMAL_FORMAT.parse(trading.getOpeningPrice()).toString(),
	// DECIMAL_FORMAT.parse(trading.getDayHigh()).toString(),
	// DECIMAL_FORMAT.parse(trading.getDayLow()).toString(),
	// DECIMAL_FORMAT.parse(trading.getClosingPrice()).toString(),
	// DECIMAL_FORMAT.parse(trading.getTotalVolume()).toString()));
	// }
	// } catch (Throwable cause) {
	// logger.error(cause.getMessage(), cause);
	// }
	//
	// return result;
	// }
}
