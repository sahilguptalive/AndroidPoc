package com.example.poc_mmvm;

import android.arch.persistence.room.Room;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.test.core.app.ApplicationProvider;

/**
 * Created by Sahil Gupta on 16/12/18.
 */
@RunWith(AndroidJUnit4.class)
public class TaskDaoTest{
	
	private static final String TEST_MESSAGE = "test message";
	private static final String TEST_TITLE = "test title";
	
	private PocDatabase db;
	private TaskDao mTaskDao;
	
	@Before
	public void setup(){
		db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext()
				, PocDatabase.class)
		         .build();
		mTaskDao = db.getTaskDao();
	}
	
	@After
	public void tearDown(){
	
	}
	
	@Test
	public void testDbIsNotNull(){
		Assert.assertNotNull(db);
	}
	
	@Test
	public void getAllTasks(){
		final Task task = new Task();
		task.mTaskContent = TEST_MESSAGE;
		task.mTaskTitle = TEST_TITLE;
		mTaskDao.insertTask(task);
		final List<Task> tasks = mTaskDao.getAllTasks();
		Assert.assertNotNull(tasks);
		Assert.assertEquals(tasks.size(), 1);
		Assert.assertEquals(task.mTaskContent, TEST_MESSAGE);
		Assert.assertEquals(task.mTaskTitle, TEST_TITLE);
	}
	
	@Test
	public void insertTask(){
	
	}
}