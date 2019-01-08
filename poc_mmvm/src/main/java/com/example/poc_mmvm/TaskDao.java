package com.example.poc_mmvm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Sahil Gupta on 16/12/18.
 */
@Dao
public interface TaskDao{

	@Query("SELECT * FROM "+Task.TABLE_NAME)
	List<Task> getAllTasks();
	
	@Insert
	void insertTask(Task... task);

}
