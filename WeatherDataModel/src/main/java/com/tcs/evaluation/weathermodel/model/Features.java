package com.tcs.evaluation.weathermodel.model;

public class Features {
	private String hemisphere;
	private String latitude;
	private String longitude;
	private String elevation;
	private String koppen_1;
	private String koppen_2;
	private String koppen_3;
	private int month;
	private String season;
	private boolean isDay;
	
	public String getHemisphere() {
		return hemisphere;
	}
	public void setHemisphere(String hemisphere) {
		this.hemisphere = hemisphere;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	public String getKoppen_1() {
		return koppen_1;
	}
	public void setKoppen_1(String koppen_1) {
		this.koppen_1 = koppen_1;
	}
	public String getKoppen_2() {
		return koppen_2;
	}
	public void setKoppen_2(String koppen_2) {
		this.koppen_2 = koppen_2;
	}
	public String getKoppen_3() {
		return koppen_3;
	}
	public void setKoppen_3(String koppen_3) {
		this.koppen_3 = koppen_3;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public boolean isDay() {
		return isDay;
	}
	public void setDay(boolean isDay) {
		this.isDay = isDay;
	}
	
}
