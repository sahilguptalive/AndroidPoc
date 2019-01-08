package com.example.sahilgupta.recyclerview.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by sahil gupta on 27/11/18.
 */
public class User extends BaseObservable {

	@Bindable
	String name;
	String address;
	String imageUrl;

	public User( final String iName, final String iAddress, final String iImageUrl ) {

		name = iName;
		address = iAddress;
		imageUrl = iImageUrl;
	}

	@Bindable
	public String getName() {

		return name;
	}

	@Bindable
	public String getAddress() {

		return address;
	}

	public String getImageUrl() {

		return imageUrl;
	}
}
