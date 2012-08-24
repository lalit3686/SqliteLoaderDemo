package com.example.dbdemo;

public enum QueryType {
	INSERT(1), UPDATE(2), DELETE(3), SELECT(4);

	int value;
	
	private QueryType(int value) {
		this.value = value;
	}
}
