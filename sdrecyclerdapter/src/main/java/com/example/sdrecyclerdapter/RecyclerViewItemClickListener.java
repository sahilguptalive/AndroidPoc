package com.example.sdrecyclerdapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by sahil gupta on 26/11/18.
 */
public interface RecyclerViewItemClickListener< T, V extends View > {

	void onClick( @Nullable T data, @NonNull V v, int position );
}
