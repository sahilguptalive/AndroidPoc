package com.example.sahilgupta.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sahilgupta.recyclerview.model.Header;
import com.example.sdrecyclerdapter.CoreRecyclerAdapter;
import com.example.sdrecyclerdapter.DeprecatedViewDataBinder;
import com.example.sdrecyclerdapter.DeprecatedViewHolder;
import com.example.sdrecyclerdapter.GridViewManager;
import com.example.sdrecyclerdapter.ViewHolderCreator;

/**
 * Created by sahil gupta on 26/11/18.
 */
public class ComplexActivity extends Activity{
	
	private RecyclerView mRV;
	
	class HeaderViewHolder extends DeprecatedViewHolder{
		
		TextView textView;
		
		public HeaderViewHolder(@NonNull final View view){
			super(view);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mRV = findViewById(R.id.recycler_view);
		final GridLayoutManager layout = new GridLayoutManager(this, 3);
		mRV.setLayoutManager(layout);
		
		final CoreRecyclerAdapter adapter = CoreRecyclerAdapter.newGridAdapter(3);
		adapter.registerViewType(Header.class,
		                         new ViewHolderCreator<HeaderViewHolder>(){
			
			                         @NonNull
			                         @Override
			                         public HeaderViewHolder
			                         createViewHolder(@NonNull final ViewGroup parent, @NonNull final Context context,
			                                          @NonNull final LayoutInflater layoutInflater){
				                         final View view = layoutInflater.inflate(R.layout.item_header, parent, false);
				                         final HeaderViewHolder viewHolder = new HeaderViewHolder(view);
				                         viewHolder.textView = view.findViewById(R.id.tv_header);
				                         return viewHolder;
			                         }
		                         },
		                         new HeaderViewHolderHeaderDeprecatedViewDataBinder());
//		adapter.registerViewType(Article.class, ArticleViewManager.class);
//		adapter.registerViewType(GridItem.class, GridItemsViewManager.class);
//		adapter.registerViewType(Advertisement.class, AdvertisementViewManager.class);
//		adapter.registerViewType(Bike.class, BikeViewManager.class);
//		adapter.registerViewType(Car.class, CarViewManager.class);
//		adapter.registerViewType(User.class, UserViewManager.class);
		mRV.setAdapter(adapter);
		layout.setSpanSizeLookup(adapter.getSpanSizeLookup());
		adapter.setData(DummyDataProvider.generateData());
	}
	private class HeaderViewHolderHeaderDeprecatedViewDataBinder
			implements DeprecatedViewDataBinder<HeaderViewHolder, Header>
					           , GridViewManager{
		
		@Override
		public void bindData(@NonNull final HeaderViewHolder viewForBinding, final int position, @Nullable final Header data){
			viewForBinding.textView.setText(data.getHeaderInfo());
		}
		
		@Override
		public int getSpanSize(final int position, final int maxSpanCount, final Object dataAtPos){
			return maxSpanCount;
		}
	}
}

