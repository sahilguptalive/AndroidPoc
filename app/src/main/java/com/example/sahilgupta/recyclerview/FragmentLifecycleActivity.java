package com.example.sahilgupta.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class FragmentLifecycleActivity extends AppCompatActivity{

	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_lifecycle);
		getSupportFragmentManager()
				.beginTransaction()
//				.add(LifecycleFragment.newInstance("frag 1"),null)
				.add(R.id.frag_container,LifecycleFragment.newInstance("frag 1"))
				.addToBackStack("frag 1")
		        .commit();
		this.getWindow().getDecorView().postDelayed(
				() ->  getSupportFragmentManager()
								.beginTransaction()
								.replace(R.id.frag_container, LifecycleFragment.newInstance("frag 2"))
//								.add(LifecycleFragment.newInstance("frag 2"),null)
								.addToBackStack("frag 2")
								.commit(), 4000);
	}
}
