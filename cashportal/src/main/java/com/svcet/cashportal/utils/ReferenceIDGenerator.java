package com.svcet.cashportal.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReferenceIDGenerator {

	public static String getFTReference() {
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss");
		String currentDateString = format.format(new Date());
		return "FT" + currentDateString;
	}
}
