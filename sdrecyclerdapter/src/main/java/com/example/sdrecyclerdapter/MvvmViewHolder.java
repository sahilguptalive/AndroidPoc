package com.example.sdrecyclerdapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by sahil gupta on 29/11/18.
 */
public class MvvmViewHolder extends BaseViewHolder{
	
	private final ViewDataBinding mViewDataBinding;
	
	public MvvmViewHolder(@NonNull final View view){
		super(view);
		mViewDataBinding = DataBindingUtil.bind(view);
	}
	
	private ViewDataBinding getViewDataBinding(){
		return mViewDataBinding;
	}
}
