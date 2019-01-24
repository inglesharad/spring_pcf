package com.cf.rs.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = GetRate.class)
public class GetRate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -532561588109770725L;
	private String base;
	private Map<String,String> rates = new HashMap<String,String>();
	private String date;
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Map<String, String> getRates() {
		return rates;
	}
	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "GetRate [base=" + base + ", rates=" + rates + ", date=" + date + ", getBase()=" + getBase()
				+ ", getRates()=" + getRates() + ", getDate()=" + getDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
