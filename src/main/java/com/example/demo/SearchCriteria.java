package com.example.demo;

import java.io.Serializable;

public class SearchCriteria implements Serializable {
	private String key;
    public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	private Object value;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return key+','+value.toString();
	}
}
