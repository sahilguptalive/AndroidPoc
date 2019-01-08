package com.example.truecaller_poc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.truecaller.android.sdk.ITrueCallback;
import com.truecaller.android.sdk.TrueButton;
import com.truecaller.android.sdk.TrueError;
import com.truecaller.android.sdk.TrueProfile;
import com.truecaller.android.sdk.TrueSDK;
import com.truecaller.android.sdk.TrueSdkScope;

public class TruecallerLogin extends AppCompatActivity{
	
	private View trueButton;
	
	@Override
	protected void onCreate(@Nullable final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_truecaller_login);
		
		trueButton = findViewById(com.truecaller.android.sdk.R.id.com_truecaller_android_sdk_truebutton);
		//TC: step : 3
		setupTC();
	}
	private void setupTC(){
		TrueSdkScope trueScope = new TrueSdkScope.Builder(this, new TCCallback())
				                         .consentMode(TrueSdkScope.CONSENT_MODE_POPUP)
				                         //change the title based on if user has logged in or not
				                         .consentTitleOption(TrueSdkScope.SDK_CONSENT_TITLE_LOG_IN)
				                         //.consentTitleOption( TrueSdkScope.SDK_CONSENT_TITLE_SIGN_UP )
				                         .footerType(TrueSdkScope.FOOTER_TYPE_CONTINUE)
				                         .build();
		TrueSDK.init(trueScope);
		if(TrueSDK.getInstance()!=null && TrueSDK.getInstance().isUsable()){
			//true if truecaller app is installed on device.
			//set visibility to visible only if is usable has returned true, else it will throw an exception
			if(trueButton != null){
				trueButton.setVisibility(View.VISIBLE);
			}
			//following commented code will be called inside onClick of TrueButton
//			if(TrueSDK.getInstance()!=null){
//				TrueSDK.getInstance()
//				       .getUserProfile(this);
//			}
		}else{
			if(trueButton != null){
				trueButton.setVisibility(View.GONE);
			}
		}
	}
	private class TCCallback implements ITrueCallback{
		
		@Override
		public void onSuccessProfileShared(@NonNull final TrueProfile trueProfile){
			// This method is invoked when the truecaller app is installed on the device and the user gives his
			// consent to share his truecaller profile
		}
		@Override
		public void onFailureProfileShared(@NonNull final TrueError trueError){
			// This method is invoked when some error occurs or if an invalid request for verification is made
			//When user clicks on sign in with another mobile, it will be treated as an failure (Error Code: 14)
		}
		@Override
		public void onOtpRequired(){
		
		}
	}
	
	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data){
		//TC:  Step: 4
		//we need to pass the results to Truecaller, only then
		//we will get the method callbacks in ITrueCallback.(Success, failure, etc)
		if(TrueSDK.getInstance() != null
		   && TrueSDK.getInstance().isUsable()
		   && TrueSDK.getInstance().onActivityResultObtained(this, resultCode, data)){
		}else{
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
}
