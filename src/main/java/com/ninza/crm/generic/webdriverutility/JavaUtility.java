package com.ninza.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}
	
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
		String currentDate = sim.format(date);
		return currentDate;
	}
	
	public String getRequireDate(int exDate) {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
		sim.format(date);
		Calendar calendar = sim.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH,exDate);
		String expectedDate = sim.format(calendar.getTime());
		return expectedDate;
	}
}
