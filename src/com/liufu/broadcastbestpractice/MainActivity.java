package com.liufu.broadcastbestpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button forceoffline;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		forceoffline = (Button) findViewById(R.id.force_offline);
		forceoffline.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(
						"com.liufu.broadcastbestparctice.FORCE_OFFLINE");
				sendBroadcast(intent);
			}
		});
	}
}
