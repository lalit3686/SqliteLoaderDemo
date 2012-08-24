package com.example.dbdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
/**
 *
 * AsyncTask class that does the processing of query in doInBackground()
 * and returns the cursor for table data from onPostExecute() using an Interface.
 * 
 * @constructor
 * public SqliteTask(Activity mActivity, String table, SQLiteDatabase db, ContentValues values, String where, String[] whereArgs)
 * 
 **/
public class SqliteTask extends AsyncTask<QueryType, Void, Cursor>{

	private TaskListener mTaskListener;
	private SQLiteDatabase db;
	private ContentValues values;
	private String table, where;
	private String[] whereArgs;
	private QueryType queryType;
	
	public SqliteTask(Activity mActivity, String table, ContentValues values, String where, String[] whereArgs) {
		this.mTaskListener = (TaskListener) mActivity;
		this.table = table;
		this.db = SQLiteDatabase.openDatabase(mActivity.getDatabasePath(DBHelper.DB_NAME).getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);;
		this.values = values;
		this.where = where;
		this.whereArgs = whereArgs;
	}
	@Override
	protected Cursor doInBackground(QueryType... params) {
		queryType = params[0];
		Cursor cursor;
		
		switch (queryType) {
		case INSERT:
			db.insert(table, null, values);	
			break;
		case UPDATE:
			db.update(table, values, where, whereArgs);
			break;
		case DELETE:
			db.delete(table, where, whereArgs);
			break;
		case SELECT:
			cursor = db.query(table, null, where, whereArgs, null, null, null);
			return cursor;
		}
		cursor = db.query(table, null, null, null, null, null, null);
		return cursor;
	}
	@Override
	protected void onPostExecute(Cursor result) {
		mTaskListener.onTaskCompleted(queryType, result);
		db.close();
	}
}
