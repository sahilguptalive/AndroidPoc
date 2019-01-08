package com.example.sdrecyclerdapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @param <VH>
 * @param <T>
 */
interface BaseViewDataBinder<VH extends BaseViewHolder, T>{
	
	void bindData(@NonNull VH viewForBinding,
	              int position,
	              @Nullable T data);
}
