package com.aistarvision.autotracking;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Select extends Activity {

	ListView listView = null;
	ArrayList<String> list = new ArrayList<String>();;
	private String ipname;
	
	Class[] classes = {
			AutoTracking.class,
			CameraPreviewActivity.class,
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_activity);
	
		Intent intent = getIntent();
		Bundle data = intent.getExtras();
		ipname = data.getString("ipname");
		
		for(Class cls:classes){
			list.add(cls.getSimpleName());
		}
		listView = (ListView)this.findViewById(R.id.list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , list);
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(clicklistener);

	}
	AdapterView.OnItemClickListener clicklistener = new AdapterView.OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			
			Bundle data = new Bundle();
			data.putString("ipname", ipname);
			
			Intent intent = new Intent();
			intent.putExtras(data);
			intent.setClass(getApplication(), classes[arg2]);
			Select.this.startActivity(intent);
		}
		
	};
	

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
}
