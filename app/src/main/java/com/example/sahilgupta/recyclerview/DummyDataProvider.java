package com.example.sahilgupta.recyclerview;

import android.graphics.Color;
import android.support.annotation.NonNull;

import com.example.sahilgupta.recyclerview.model.Advertisement;
import com.example.sahilgupta.recyclerview.model.Article;
import com.example.sahilgupta.recyclerview.model.Bike;
import com.example.sahilgupta.recyclerview.model.Car;
import com.example.sahilgupta.recyclerview.model.GridItem;
import com.example.sahilgupta.recyclerview.model.Header;
import com.example.sahilgupta.recyclerview.model.User;
import com.example.sahilgupta.recyclerview.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by sahil gupta on 27/11/18.
 */
class DummyDataProvider {

	private static Random random = new Random();

	private static String[] articleDummyTimes = { "Few seconds ago", "3 minutes ago", "2 hours ago", "1 Sep", "24 Aug", "22 Aug", "21 Aug", "21 Aug", "20 Aug", "20 Aug", };

	private static String[] articleDummyTitles =
			{ "Create recyclerview adapters like a boss",
			  "On the road with Android",
			  "Life can be tough - Here are few SDK " + "improvements",
			  "Google developer podcast - Android",
			  "A maze of twisty little passages",
			  "A stitch in time", "Android first week",
			  "Just show me the code",
			  "This is the droid you are looking for" };

	private static int[] colorList = { Color.parseColor( "#ef9a9a" ), Color.parseColor( "#F48FB1" ), Color.parseColor( "#CE93D8" ), Color.parseColor( "#B39DDB" ),
	                                   Color.parseColor( "#9FA8DA" ), Color.parseColor( "#90CAF9" ), Color.parseColor( "#81D4FA" ), Color.parseColor( "#C5E1A5" ),
	                                   Color.parseColor( "#FFCC80" ) };

	private static int[] drawableList = { R.drawable.ic_circle, R.drawable.ic_heart, R.drawable.ic_star };

	public static List< Article > getArticles() {

		List< Article > articles = new ArrayList<>();
		int i = -1;
		for ( String title : articleDummyTitles ) {
			Article article = new Article( ++i, title, "Android", articleDummyTimes[ i ], i == 0, i == 0 ? R.drawable.cover_image : drawableList[ random.nextInt( 3 ) ],
			                               colorList[ i ] );
			articles.add( article );
		}
		return articles;
	}

	public static Advertisement getAdvertisementOne() {

		return new Advertisement( 1, "Do you like this library?", "Star and watch the library on Github to get latest updates",
		                          "https://github.com/DevAhamed/MultiViewAdapter" );
	}

	public static Advertisement getAdvertisementTwo() {

		return new Advertisement( 1, "Would you like to contribute?", "Fork the repo on Github and send the PR. Don't forget read the guidelines",
		                          "https://github.com/DevAhamed/MultiViewAdapter" );
	}

	public static Advertisement getAdvertisementThree() {

		return new Advertisement( 1, "Found an issue?", "Bug? Feature request? Need help? Create an issue on the issue tracker",
		                          "https://github.com/DevAhamed/MultiViewAdapter" );
	}

	@NonNull
	static List< GridItem > getGridItems() {

		List< GridItem > gridDataList = new ArrayList<>();
		for ( int i = 0; i < 9; i++ ) {
			gridDataList.add( GridItem.generateGridItem( i ) );
		}
		return gridDataList;
	}

	static List< Object > generateData() {

		List< Object > data = new ArrayList<>();
		data.add( new Header( "Articles" ) );
//		data.addAll( getArticles() );
//		data.add( getAdvertisementOne() );
//
		data.add( new Header( "Grid", true ) );
//		data.addAll( getGridItems() );
//		data.add( getAdvertisementTwo() );
//
		data.add( new Header( "Multiple ViewTypes" ) );
//		data.addAll( getVehicles() );
//		data.add( getAdvertisementThree() );
//
		data.add( new Header( "Users" ) );
//		data.addAll( getUsers() );
//
		return data;
	}

	private static Collection< User > getUsers() {

		List< User > users = new ArrayList<>();
		users.add( new User( "Sahil Gupta  1", "Add 1", null ) );
		users.add( new User( "Sahil Gupta  2", "Add 2", null ) );
		users.add( new User( "Sahil Gupta  3", "Add 3", null ) );
		users.add( new User( "Sahil Gupta  4", "Add 4", null ) );
		users.add( new User( "Sahil Gupta  5", "Add 4", null ) );
		users.add( new User( "Sahil Gupta  6", "Add 4", null ) );
		users.add( new User( "Sahil Gupta  7", "Add 4", null ) );
		users.add( new User( "Sahil Gupta  8", "Add 4", null ) );
		users.add( new User( "Sahil Gupta  9", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 10", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 12", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 13", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 14", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 15", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 16", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 17", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 18", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 19", "Add 4", null ) );
		users.add( new User( "Sahil Gupta 20", "Add 4", null ) );
		return users;
	}


	@NonNull
	private static List< Vehicle > getVehicles() {

		List< Vehicle > multiItemList = new ArrayList<>();
		Random random = new Random();
		for ( int i = 0; i < 10; i++ ) {
			if ( random.nextBoolean() ) {
				multiItemList.add( new Car( i, "Car " + i, "Manufacturer " + i, String.valueOf( 1900 + random.nextInt( 100 ) ) ) );
			} else {
				multiItemList.add( new Bike( i, "Bike " + i, "Description of bike" + i ) );
			}
		}
		return multiItemList;
	}
}
