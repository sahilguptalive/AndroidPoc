package com.example.sdrecyclerdapter;

import org.json.JSONObject;

/**
 * Created by sahil gupta on 23/11/18.
 */
public class JsonObjectContainer implements RuntimeData< JSONObject > {

	private final JSONObject mJSONObject;
	private final int mItemType;

	public JsonObjectContainer( final int iItemType, final JSONObject iJSONObject ) {

		mJSONObject = iJSONObject;
		mItemType = iItemType;
	}

	@Override
	public int getItemType() {

		return mItemType;
	}

	@Override
	public JSONObject getData() {

		return mJSONObject;
	}

	@Override
	public String toString() {

		return "JsonObjectContainer{" + "mJSONObject=" + mJSONObject + ", mItemType=" + mItemType + '}';
	}
}
