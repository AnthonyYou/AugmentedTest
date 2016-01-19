package com.frontier.augmentedtest;

import android.os.Bundle;
import android.util.Log;
import edu.dhbw.andar.ARObject;
import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.AndARActivity;
import edu.dhbw.andar.exceptions.AndARException;

public class MainActivity extends AndARActivity {

	private ARObject someObject;
	private ARToolkit arToolKit;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		try {
			CustomRenderer renderer = new CustomRenderer();
			setNonARRenderer(renderer);
			
			arToolKit = getArtoolkit();
			
			someObject = new CustomObject1("test", "marker_at16.patt", 80.0, new double[]{0, 0});
			arToolKit.registerARObject(someObject);
			
			someObject = new CustomObject2("test", "marker_peace16.patt", 80.0, new double[]{0, 0});
			arToolKit.registerARObject(someObject);
			
			someObject = new CustomObject3("test", "marker_rupee16.patt", 80.0, new double[]{0, 0});
			arToolKit.registerARObject(someObject);
			
			someObject = new CustomObject4("test", "marker_hand16.patt", 80.0, new double[]{0, 0});
			arToolKit.registerARObject(someObject);
		} catch (AndARException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		startPreview();
	}



	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.e("AndAR Exception", ex.getMessage());
		finish();
	}

}
