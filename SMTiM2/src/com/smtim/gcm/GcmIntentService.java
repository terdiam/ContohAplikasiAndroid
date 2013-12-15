package com.smtim.gcm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.smtim.LoginActivity;
import com.smtim.R;

public class GcmIntentService extends IntentService {
	public static final int NOTIFICATION_ID = 1;
	private NotificationManager mNotificationManager;
	NotificationCompat.Builder builder;
	public static final String TAG = "GCM";
	
	public GcmIntentService(){
		super("GcmIntentService");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		Bundle extras = intent.getExtras();
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
		String messageType = gcm.getMessageType(intent);
		if(!extras.isEmpty()){
			if(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)){
				sendNotification("Send Error: " + extras.toString());
			}else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)){
				sendNotification("Deleted messages on Server: " + extras.toString());
			}else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)){
				for(int i=0;i <5;i++){
					Log.i(TAG, "Working... "+(i+1) + "/5 @ " + SystemClock.elapsedRealtime());
					try{
						Thread.sleep(5000);
					} catch (InterruptedException e){
						
					}
				}
				Log.i(TAG, "Complete Work @ " + SystemClock.elapsedRealtime());
				sendNotification("Received: " + extras.toString());
				Log.i(TAG, "Received: " + extras.toString());
			}
		}
	}
	
	private void sendNotification(String msg){
		mNotificationManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, LoginActivity.class), 0);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
			.setSmallIcon(R.drawable.ic_launcher)
			.setContentTitle("SMTiM Notification")
			.setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
			.setContentText(msg);
		mBuilder.setContentIntent(contentIntent);
		mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
	}
	
}
