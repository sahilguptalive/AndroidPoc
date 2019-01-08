package com.example.sdrecyclerdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sahil gupta on 23/11/18.
 */
public final class CoreRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder>{
	
	private static final int INVALID_VIEW_TYPE = -1;
	private final SparseArray<ViewHolderCreator> mViewHolderCreatorMap = new SparseArray<>();
	private final SparseArray<BaseViewDataBinder> mViewDataBinderMap = new SparseArray<>();
	private final HashMap<Object, Integer> mModelClassToViewTypeMap = new HashMap<>();
	private final boolean mIsNested;
	private AtomicInteger mViewTypeCount = new AtomicInteger(0);
	
	private final List<Object> mData = new ArrayList<>();
	private int mMaxSpan;
	
	private CoreRecyclerAdapter(boolean isNested, int maxSpan){
		
		mIsNested = isNested;
		mMaxSpan = maxSpan;
	}
	
	public static CoreRecyclerAdapter newInstance(){
		
		return new CoreRecyclerAdapter(false, 1);
	}
	
	public static CoreRecyclerAdapter newGridAdapter(final int maxSpan){
		
		return new CoreRecyclerAdapter(false, maxSpan);
	}
	
	@NonNull
	@Override
	public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
		
		final ViewHolderCreator viewHolderCreator = mViewHolderCreatorMap.get(viewType);
		if(viewType == INVALID_VIEW_TYPE || viewHolderCreator == null){
			return new DeprecatedViewHolder(new View(parent.getContext()));
		}else{
			return viewHolderCreator
					       .createViewHolder(parent,
					                         parent.getContext(),
					                         LayoutInflater.from(parent.getContext()));
		}
	}
	
	@Override
	public int getItemViewType(final int position){
		final Object data = getData(position);
		final Integer viewTypeUsingClass = mModelClassToViewTypeMap.get(data.getClass());
		if(viewTypeUsingClass != null){
			return viewTypeUsingClass;
		}
		Integer viewTypeUsingRuntimeDataInterface = INVALID_VIEW_TYPE;
		if(data instanceof RuntimeData){
			viewTypeUsingRuntimeDataInterface
					= (mModelClassToViewTypeMap.get(((RuntimeData)data).getItemType()));
		}
		return viewTypeUsingRuntimeDataInterface == null?INVALID_VIEW_TYPE:viewTypeUsingRuntimeDataInterface;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onBindViewHolder(@NonNull final BaseViewHolder viewHolder,
	                             int position){
		
		final int mappedViewType = getItemViewType(position);
		BaseViewDataBinder viewDataBinder;
		if(mappedViewType == INVALID_VIEW_TYPE
		   || (viewDataBinder = mViewDataBinderMap.get(mappedViewType)) == null){
			return;
		}
		if(viewHolder instanceof RecyclerViewItemClickListener){
			addClickListener(position, viewHolder, viewDataBinder);
		}
		viewDataBinder.bindData(viewHolder, position, mData.get(position));
	}
	
	private Object getData(final int position){
		
		return mData.get(position);
	}
	
	@Override
	public int getItemCount(){
		
		return mData.size();
	}
	
	public <T, VH extends BaseViewHolder, VHC extends ViewHolderCreator<VH>, VDB extends BaseViewDataBinder<VH, T>>
	void registerViewType(@NonNull Class<T> dataModel,
	                      @NonNull VHC viewHolderCreator,
	                      @NonNull VDB viewDataBinder){
		
		final int newViewTypeCount = mViewTypeCount.incrementAndGet();
		mModelClassToViewTypeMap.put(dataModel, newViewTypeCount);
		mViewHolderCreatorMap.put(newViewTypeCount, viewHolderCreator);
		mViewDataBinderMap.put(newViewTypeCount, viewDataBinder);
	}
	
	public <T> void unregisterViewType(@NonNull Class<T> dataModel){
		
		if(mModelClassToViewTypeMap.get(dataModel) == null){
			return;
		}
		//noinspection ConstantConditions
		mViewHolderCreatorMap.remove(mModelClassToViewTypeMap.get(dataModel));
		//noinspection ConstantConditions
		mViewDataBinderMap.remove(mModelClassToViewTypeMap.get(dataModel));
		mModelClassToViewTypeMap.remove(dataModel);
	}
	
	/**
	 * This method must be used for objects which implement {@link RuntimeData}
	 *
	 * @param viewType
	 * 		an unique integer within an adapter
	 * @param viewManager
	 * 		view manager responsible for view creation and view data binding
	 * @param <T>
	 * 		type of data which would be handled by this view manager.
	 */
	public <T extends RuntimeData<?>, VH extends BaseViewHolder, VHC extends ViewHolderCreator<VH>, VDB extends BaseViewDataBinder<VH, T>>
	void registerViewType(@NonNull int viewType,
	                      @NonNull VHC viewHolderCreator,
	                      @NonNull VDB viewDataBinder){
		
		final int newViewTypeCount = mViewTypeCount.incrementAndGet();
		mModelClassToViewTypeMap.put(viewType, newViewTypeCount);
		mViewHolderCreatorMap.put(newViewTypeCount, viewHolderCreator);
		mViewDataBinderMap.put(newViewTypeCount, viewDataBinder);
	}
	
	public void unregisterViewType(int viewType){
		
		if(mModelClassToViewTypeMap.get(viewType) == null){
			return;
		}
		//noinspection ConstantConditions
		mViewHolderCreatorMap.remove(mModelClassToViewTypeMap.get(viewType));
		//noinspection ConstantConditions
		mViewDataBinderMap.remove(mModelClassToViewTypeMap.get(viewType));
		mModelClassToViewTypeMap.remove(viewType);
	}
	
	public void setData(List<Object> data){
		
		mData.clear();
		mData.addAll(data);
	}
	
	private void addClickListener(final int position, final BaseViewHolder viewHolder, final BaseViewDataBinder viewDataBinder){
		
		if(!(viewDataBinder instanceof RecyclerViewItemClickListener)){
			return;
		}
		viewHolder.itemView.setOnClickListener(
				new ItemClickListener(((RecyclerViewItemClickListener)viewDataBinder), position));
	}
	
	public GridLayoutManager.SpanSizeLookup getSpanSizeLookup(){
		
		return new GridLayoutSpanSizeLookup(this);
	}
	
	private class ItemClickListener implements View.OnClickListener{
		
		private final RecyclerViewItemClickListener mRecyclerViewItemClickListener;
		private final int mPosition;
		
		ItemClickListener(@NonNull final RecyclerViewItemClickListener recyclerViewItemClickListener,
		                  final int iPosition){
			
			mRecyclerViewItemClickListener = recyclerViewItemClickListener;
			mPosition = iPosition;
		}
		
		@Override
		public void onClick(final View v){
			
			//noinspection unchecked
			mRecyclerViewItemClickListener.onClick(mData.get(mPosition), v, mPosition);
		}
	}
	
	private static class GridLayoutSpanSizeLookup extends GridLayoutManager.SpanSizeLookup{
		
		final WeakReference<CoreRecyclerAdapter> coreRecyclerAdapterWeakReference;
		static final int INVALID_SPAN = 1;
		private GridLayoutSpanSizeLookup(final CoreRecyclerAdapter coreRecyclerAdapterWeakReference){
			
			this.coreRecyclerAdapterWeakReference = new WeakReference<>(coreRecyclerAdapterWeakReference);
		}
		
		@Override
		public int getSpanSize(final int position){
			final CoreRecyclerAdapter coreRecyclerAdapter = this.coreRecyclerAdapterWeakReference.get();
			if(coreRecyclerAdapter == null){
				return INVALID_SPAN;
			}
			final BaseViewDataBinder viewDataBinder = coreRecyclerAdapter.mViewDataBinderMap.get(position);
			if(!(viewDataBinder instanceof GridViewManager)){
				return INVALID_SPAN;
			}
			return ((GridViewManager)viewDataBinder)
					       .getSpanSize(position, coreRecyclerAdapter.mMaxSpan, coreRecyclerAdapter.mData.get(position));
		}
	}
}
