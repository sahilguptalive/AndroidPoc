package com.example.poc_mmvm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Sahil Gupta on 16/12/18.
 */
@Database(entities = {Task.class}, version = 1)
public abstract class PocDatabase extends RoomDatabase{
	
	private static PocDatabase mDb;
	
	public static PocDatabase getDatabase(@NonNull Context context){
		if(mDb == null){
			mDb = Room.databaseBuilder(context.getApplicationContext(),
			                           PocDatabase.class,
			                           "poc_database")
			          .build();
		}
		return mDb;
	}
	
	public abstract TaskDao getTaskDao();
}
