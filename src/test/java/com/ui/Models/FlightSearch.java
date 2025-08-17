package com.ui.Models;

public class FlightSearch {
	
	private String fromCity;
	private String toCity;
	
	public FlightSearch(String fromCity, String toCity) {
		this.fromCity = fromCity;
		this.toCity = toCity;
	}
	
	public String getFromCity() {return this.fromCity;}
	public String getToCity() {return this.toCity;}
	
	public void setFromCity(String fromCity) {this.fromCity = fromCity;}
	public void setToCity(String toCity) {this.toCity = toCity;}
}
