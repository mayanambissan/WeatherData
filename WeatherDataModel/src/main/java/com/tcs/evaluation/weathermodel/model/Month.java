package com.tcs.evaluation.weathermodel.model;

public enum Month {
	January(1, 31),
	February(2, 28),
	March(3, 31),
	April(4, 30),
	May(5, 31),
	June(6, 30),
	July(7, 31),
	August(8, 31),
	September(9, 30),
	October(10, 31),
	November(11, 30),
	December(12, 31);
	
	Month(int month, int numOfDays) {
		this.month = month;
		this.numOfDays = numOfDays;
	}
	
	private final int month;
	private final int numOfDays;
	
	public int getMonth() {
		return month;
	}
	public int getNumOfDays(){
		return numOfDays;
	}
	
}
