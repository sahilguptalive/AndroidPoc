package com.example.poc_mmvm.listing;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.poc_mmvm.PocDatabase;
import com.example.poc_mmvm.R;

/**
 * Created by Sahil Gupta on 16/12/18.
 */
public class TasksList extends Activity{
	
	private TextView tv;
	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task_list);
		tv=findViewById(R.id.listing_tv);
		tv.setText(PocDatabase.getDatabase(this).getTaskDao().getAllTasks().toString());
	}
	
}
