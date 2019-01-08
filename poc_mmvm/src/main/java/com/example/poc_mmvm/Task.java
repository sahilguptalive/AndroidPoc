package com.example.poc_mmvm;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Sahil Gupta on 16/12/18.
 */
@Entity(tableName = Task.TABLE_NAME)
public class Task{
	
	@ColumnInfo(name = ColumnNames.TASK_ID)
	@PrimaryKey(autoGenerate = true)
	int mTaskId;
	
	@ColumnInfo(name = ColumnNames.TASK_TITLE)
	String mTaskTitle;
	
	@ColumnInfo(name = ColumnNames.TASK_CONTENT)
	String mTaskContent;
	
	
	@Ignore
	public static final String TABLE_NAME="Tasks";
	static class ColumnNames{
		public static final String TASK_ID="taskid";
		public static final String TASK_TITLE="task_title";
		public static final String TASK_CONTENT="task_content";
	}
	
	@Override
	public String toString(){
		return "  Task{" +
		       "  mTaskId = " + mTaskId +
		       ", mTaskTitle = '" + mTaskTitle + '\'' +
		       ", mTaskContent = '" + mTaskContent + '\'' +
		       '}';
	}
}
