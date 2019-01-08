package com.example.sdrecyclerdapter;

import android.view.View;

/**
 * Created by sahil gupta on 26/11/18.
 */
public abstract class AbstractRecyclerViewManager< T, V extends View > implements GridViewManager, RecyclerViewItemClickListener< T, V > {

	@Override
	public void onClick( final T data, final V iV, final int position ) {

	}

	@Override
	public int getSpanSize( final int position, final int maxSpanCount, final Object dataAtPos ) {

		return 1;
	}
}
