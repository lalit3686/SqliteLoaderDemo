package com.example.dbdemo;


public interface TaskListener {
	void onTaskCompleted(QueryType queryType, Object result);
}
