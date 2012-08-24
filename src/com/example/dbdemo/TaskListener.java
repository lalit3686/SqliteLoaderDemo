package com.example.dbdemo;

import android.database.Cursor;

public interface TaskListener {
	void onTaskCompleted(QueryType queryType, Cursor cursor);
}
