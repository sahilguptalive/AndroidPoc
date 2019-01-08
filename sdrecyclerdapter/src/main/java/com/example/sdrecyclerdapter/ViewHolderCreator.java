package com.example.sdrecyclerdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface ViewHolderCreator<T extends BaseViewHolder>{
	
	@NonNull
	T createViewHolder(
			@NonNull final ViewGroup parent
			, @NonNull final Context context
			, @NonNull final LayoutInflater layoutInflater);
}
