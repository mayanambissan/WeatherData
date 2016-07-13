package com.tcs.evaluation.weathermodel.model;

public enum WeatherStations {
	Alert("YLT",82.50,-62.34,76,"N", "E","T","-"),
	Dikson("DKS",73.5,80.52,47,"N", "E","T","-"),
	Reykjavík("RKV", 64.13, -21.89,37,"N", "C","F","c"),
	London("LHR", 51.51, -0.12, 25,"N", "C","F","b"),
	Boston("BOS", 42.36, -71.06, 43,"N","C","F","a"),
	Tokyo("HND", 35.69, 139.69,40,"N", "C","F","a"),
	Dubai("DXB", 25.26, 55.30, 16,"N", "B","W","h"),
	Mumbai("BOM", 19.07, 72.88, 14, "N", "A","w","-"),
	Kochi("COK", 9.94, 76.26, 9, "N", "A","m","-"),
	Jakarta("CGK", -6.21, 106.84,7.9, "S", "A","m","-"),
	Brasília("BSB", -15.79, -47.88, 1172, "S", "A","w","-"),
	Johannesburg("JNB", -26.20, 28.04, 1680, "S", "B","S","k"),
	Sydney("SYD", -33.86, 151.20, 19, "S", "C","F","a"),
	Wellington("WLG", -41.28, 174.77, 13, "S", "C","F","b"),
	Concordia ("CCI", -75.10, 123.33, 3265, "S", "E","F","-");
	
	WeatherStations(String code, double latitude, double longitude, double elevation, String hemisphere, String koppen_1, String koppen_2, String koppen_3) {
		this.code = code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.hemisphere = hemisphere;
		this.koppen_1 = koppen_1;
		this.koppen_2 = koppen_2;
		this.koppen_3 = koppen_3;
	}
	
	private final String code;
	private final double latitude;
	private final double longitude;
	private final double elevation;
	private final String hemisphere;
	private final String koppen_1;
	private final String koppen_2;
	private final String koppen_3;
	public String getCode() {
		return code;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getElevation() {
		return elevation;
	}

	public String getHemisphere() {
		return hemisphere;
	}

	public String getKoppen_1() {
		return koppen_1;
	}

	public String getKoppen_2() {
		return koppen_2;
	}

	public String getKoppen_3() {
		return koppen_3;
	}	
	
}
