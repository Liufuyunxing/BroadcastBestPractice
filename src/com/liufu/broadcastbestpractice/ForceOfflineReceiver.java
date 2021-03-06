package com.liufu.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("Wraning");
		dialogBuilder.setMessage("You are forced to be offline.Please"
				+ " try to login again");
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("OK", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				ActivityCollector.finishAll();
				Intent intent = new Intent(context, LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		AlertDialog dialog = dialogBuilder.create();
		dialog.getWindow()
				.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		dialog.show();
	}

}
