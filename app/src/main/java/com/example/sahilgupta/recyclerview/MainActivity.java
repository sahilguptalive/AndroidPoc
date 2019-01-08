package com.example.sahilgupta.recyclerview;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.poc_mmvm.listing.TasksList;
import com.example.sdrecyclerdapter.CoreRecyclerAdapter;
import com.example.sdrecyclerdapter.RecyclerViewItemClickListener;
import com.example.truecaller_poc.TruecallerLogin;

public class MainActivity extends AppCompatActivity implements RecyclerViewItemClickListener{
	
	private static final int View_TYPE_SCRATCH_CARD = 1;
	private static final int View_TYPE_BANNER = 2;
	private static final int View_TYPE_PRODUCT_RECYCLER_VIEW = 3;
	private static final int View_TYPE_PRODUCT_IMAGES = 4;
	private RecyclerView mRV;
	private CoreRecyclerAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService (Context.CONNECTIVITY_SERVICE);
		NetworkInfo nf = cm.getActiveNetworkInfo();
		
		setContentView(R.layout.activity_main);
//		startActivity(new android.content.Intent(this, ComplexActivity.class));
//		startActivity(new android.content.Intent(this, TasksList.class));
//		startActivity(new android.content.Intent(this, TruecallerLogin.class));
		startActivity(new android.content.Intent(this, FragmentLifecycleActivity.class));
//		mRV = findViewById(R.id.recycler_view);
//		mRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//		adapter = CoreRecyclerAdapter.newInstance();
//		mRV.setAdapter(adapter);
//		adapter.registerViewType(String.class, new StudentViewManager());
//		adapter.registerViewType(SchoolName.class, new SchoolNameViewManager());
//		adapter.registerViewType(MarutiName.class, new MarutiNameViewManager());
//		adapter.registerViewType(View_TYPE_SCRATCH_CARD, new ScratchCardViewManager());
//		adapter.registerViewType(View_TYPE_BANNER, new BannerViewManager());
//		adapter.registerViewType(View_TYPE_PRODUCT_RECYCLER_VIEW, new ProductsRecyclerViewManager(this));
//		//		adapter.registerViewType( View_TYPE_BANNER, new BANNERViewManager() );
//		//		adapter.registerViewType( View_TYPE_PRODUCT_RECYCLER_VIEW, new PRODUCTSViewManager() );
//		final ArrayList<Object> data = new ArrayList<Object>();
//		data.add("Sahil Gupta");
//		data.add("Sahil Gupta 1");
//		data.add("Sahil Gupta 2");
//		data.add("Sahil Gupta 7");
//		data.add(new SchoolName("V.V.D.A.V"));
//		data.add(new MarutiName("SX4"));
//		data.add(new MarutiName("Swift"));
//		data.add("1");
//		data.add("Sahil Gupta 7");
//		data.add("Sahil Gupta 4");
//		data.add("Sahil Gupta 6");
//		String s = "{\n" + "\t\"data\": [\"https://dummyimage.com/200x200/151538/fff.png&text=image1\",\n"
//		           + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image2\",\n" + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image3\",\n"
//		           + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image4\",\n" + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image5\",\n"
//		           + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image6\",\n" + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image7\",\n"
//		           + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image8\",\n" + "\t\t\"https://dummyimage.com/200x200/151538/fff.png&text=image9\"\n" + "\t]\n"
//		           + "}";
//		try{
//			data.add(new JsonObjectContainer(View_TYPE_PRODUCT_RECYCLER_VIEW, new JSONObject(s)));
//		}catch(JSONException iE){
//			iE.printStackTrace();
//		}
//		data.add(new SchoolName("D.P.S"));
//		data.add(new SchoolName("D.A.S"));
//		data.add("Saurabh");
//		data.add("Sahil Gupta 5");
//		try{
//			data.add(new JsonObjectContainer(View_TYPE_SCRATCH_CARD, new JSONObject("{\"data\":\"custom data for scratch\"}")));
//		}catch(JSONException iE){
//			iE.printStackTrace();
//		}
//		try{
//			data.add(new JsonObjectContainer(View_TYPE_BANNER, new JSONObject("{\"data\":\"custom data for banner\"}")));
//		}catch(JSONException iE){
//			iE.printStackTrace();
//		}
//
//		data.add(new SchoolName("S.P.S"));
//		data.add(new SchoolName("P.P.S"));
//		data.add(new SchoolName("D.P.A"));
//		data.add(new SchoolName("A.P.S"));
//
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		try{
//			data.add(new JsonObjectContainer(View_TYPE_PRODUCT_RECYCLER_VIEW, new JSONObject(s)));
//		}catch(JSONException iE){
//			iE.printStackTrace();
//		}
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//		data.add("1234");
//
//		adapter.setData(data);
	}
	
	@Override
	public void onClick(final Object data, final View iView, final int position){
		
		Toast.makeText(this, "Activity Listener: " + data + position, Toast.LENGTH_LONG)
		     .show();
	}
//
//	private class StudentViewManager extends AbstractRecyclerViewManager<String, TextView>{
//
//		@Override
//		public TextView createView(final ViewGroup iParent){
//
//			return getTextView(iParent);
//		}
//
//		@Override
//		public void bindData(final String data, final TextView iTextView){
//
//			iTextView.setText("Student:" + data + " (Textview)");
//		}
//	}
//
//	private class SchoolName{
//
//		String schoolName;
//
//		public SchoolName(final String iSchoolName){
//
//			schoolName = iSchoolName;
//		}
//	}
//
//	private class SchoolNameViewManager extends AbstractRecyclerViewManager<SchoolName, TextView>{
//
//		@Override
//		public TextView createView(final ViewGroup iParent){
//
//			return getTextView(iParent);
//		}
//
//		@Override
//		public void bindData(final SchoolName data, final TextView iTextView){
//
//			iTextView.setText("School:" + data.schoolName + " (Textview)");
//		}
//	}
//
//	interface CarName{
//
//		String getCarName();
//	}
//
//	class MarutiName implements CarName{
//
//		String marutiCarName;
//
//		public MarutiName(final String iMarutiCarName){
//
//			marutiCarName = iMarutiCarName;
//		}
//
//		@Override
//		public String getCarName(){
//
//			return marutiCarName;
//		}
//	}
//
//	private class MarutiNameViewManager extends AbstractRecyclerViewManager<MarutiName, TextView>{
//
//		@Override
//		public TextView createView(final ViewGroup iParent){
//
//			return getTextView(iParent);
//		}
//
//		@Override
//		public void bindData(final MarutiName data, final TextView iTextView){
//
//			iTextView.setText("Maruti:" + data.getCarName() + " (Textview)");
//		}
//	}
//
//	@NonNull
//	private TextView getTextView(final ViewGroup iParent){
//
//		final TextView textView = new TextView(iParent.getContext());
//		textView.setTextSize(20);
//		return textView;
//	}
//
//	private class ScratchCardViewManager extends AbstractRecyclerViewManager<JsonObjectContainer, LinearLayout>{
//
//		@Override
//		public LinearLayout createView(final ViewGroup iParent){
//
//			final LinearLayout linearLayout = new LinearLayout(iParent.getContext());
//			final TextView child = getTextView(iParent);
//			child.setTag("child");
//			linearLayout.addView(child);
//			return linearLayout;
//		}
//
//		@Override
//		public void bindData(final JsonObjectContainer data, final LinearLayout iLinearLayout){
//
//			((TextView)iLinearLayout.findViewWithTag("child")).setText(data.getData()
//			                                                               .optString("data"));
//		}
//
//		@Override
//		public void onClick(final JsonObjectContainer data, final LinearLayout iLinearLayout, final int position){
//
//			super.onClick(data, iLinearLayout, position);
//			Toast.makeText(iLinearLayout.getContext(), "Scratch Card Clicked", Toast.LENGTH_LONG)
//			     .show();
//		}
//	}
//
//	private class BannerViewManager extends AbstractRecyclerViewManager<RuntimeData<JSONObject>, FrameLayout>{
//
//		@Override
//		public FrameLayout createView(final ViewGroup iParent){
//
//			final FrameLayout layout = new FrameLayout(iParent.getContext());
//			final TextView child = getTextView(iParent);
//			child.setTag("child");
//			layout.addView(child);
//			return layout;
//		}
//
//		@Override
//		public void bindData(final RuntimeData<JSONObject> data, final FrameLayout iFrameLayout){
//
//			((TextView)iFrameLayout.findViewWithTag("child")).setText(data.getData()
//			                                                              .optString("data"));
//		}
//
//		@Override
//		public void onClick(final RuntimeData<JSONObject> data, final FrameLayout iFrameLayout, final int position){
//
//			Toast.makeText(iFrameLayout.getContext(), "Banner Clicked", Toast.LENGTH_LONG)
//			     .show();
//		}
//	}
//
//	private class ProductsRecyclerViewManager implements
//	                                          RecyclerViewItemClickListener<JsonObjectContainer, RecyclerView>{
//
//		private RecyclerViewItemClickListener iRecyclerViewItemClickListener;
//
//		private ProductsRecyclerViewManager(final RecyclerViewItemClickListener iIRecyclerViewItemClickListener){
//
//			iRecyclerViewItemClickListener = iIRecyclerViewItemClickListener;
//		}
//
//		@Override
//		public RecyclerView createView(final ViewGroup iParent){
//
//			RecyclerView recyclerView = new RecyclerView(iParent.getContext());
//			recyclerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200 * 3));
//			recyclerView.setLayoutManager(new LinearLayoutManager(iParent.getContext(), LinearLayoutManager.HORIZONTAL, false));
//			final CoreRecyclerAdapter adapter = CoreRecyclerAdapter.newInstance();
//			adapter.registerViewType(String.class, ProductImageViewManager(iRecyclerViewItemClickListener));
//			recyclerView.setAdapter(adapter);
//
//			return recyclerView;
//		}
//
//		@Override
//		public void bindData(final JsonObjectContainer data, final RecyclerView iRecyclerView){
//
//			final List<Object> outData = new ArrayList<>();
//			final JSONArray arrayObj = data.getData()
//			                               .optJSONArray("data");
//			for(int i = 0;i < arrayObj.length();i++){
//				outData.add(arrayObj.optString(i, ""));
//			}
//			final CoreRecyclerAdapter adapter = (CoreRecyclerAdapter)iRecyclerView.getAdapter();
//			adapter.setData(outData);
//			adapter.notifyDataSetChanged();
//		}
//
//		@Override
//		public void onClick(final JsonObjectContainer data, final RecyclerView iRecyclerView, final int position){
//
//			Toast.makeText(iRecyclerView.getContext(), "image clicked: " + data, Toast.LENGTH_LONG)
//			     .show();
//		}
//	}
//
//	private static class ProductImageViewManager
//			implements RecyclerViewItemClickListener<String, ImageView>{
//
//		private RecyclerViewItemClickListener<String, ImageView> mRecyclerViewItemClickListener;
//
//		private ProductImageViewManager(final RecyclerViewItemClickListener iRecyclerViewItemClickListener){
//
//			mRecyclerViewItemClickListener = iRecyclerViewItemClickListener;
//			final Test a = new Test(){
//
//				@Override
//				public void test(final int a){
//					System.out.print("a" + a);
//				}
//			};
//		}
//
//		interface Test{
//
//			void test(int a);
//		}
//
//		@Override
//		public ImageView createView(final ViewGroup iParent){
//
//			final ImageView imageView = new ImageView(iParent.getContext());
//			imageView.setPadding(40, 40, 40, 40);
//			return imageView;
//		}
//
//		@Override
//		public void bindData(final String data, final ImageView iImageView){
//
//			Picasso.get()
//			       .load(data)
//			       .into(iImageView);
//		}
//
//		@Override
//		public void onClick(final String data, final ImageView iImageView, final int position){
//
//			mRecyclerViewItemClickListener.onClick(data, iImageView, position);
//			//			Toast.makeText( iImageView.getContext(), "image clicked: " + data, Toast.LENGTH_LONG )
//			//			     .show();
//		}
//	}
}

