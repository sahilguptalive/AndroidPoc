package com.example.sahilgupta.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

/**
 * Created by Sahil Gupta on 2/1/19.
 */
public class LifecycleFragment extends DialogFragment{
	
	public static LifecycleFragment newInstance(String name){
		
		Bundle args = new Bundle();
		args.putString("name", name);
		LifecycleFragment fragment = new LifecycleFragment();
		fragment.setArguments(args);
		return fragment;
	}
	private String getName(){
		return getArguments() != null?getArguments().getString("name", ""):"";
	}
	@Nullable
	@Override
	public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState){
		View view = inflater.inflate(R.layout.frag_view, container, false);
		Random rnd = new Random();
		view.setBackgroundColor(Color.argb(255,rnd.nextInt(256),
		                                   rnd.nextInt(256), rnd.nextInt(256)));
		return view;
	}
	@Override
	public void onCreate(@Nullable final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.i("TAG", getName() + " : " + "onCreate");
	}
	@Override
	public void onPause(){
		super.onPause();
		Log.i("TAG", getName() + " : " + "onPause");
	}
	@Override
	public void onStop(){
		super.onStop();
		Log.i("TAG", getName() + " : " + "onStop");
	}
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.i("TAG", getName() + " : " + "onDestroy");
	}
	@Override
	public void onStart(){
		super.onStart();
		Log.i("TAG", getName() + " : " + "onStart");
	}
	@Override
	public void onResume(){
		super.onResume();
		Log.i("TAG", getName() + " : " + "onResume");
	}
}
