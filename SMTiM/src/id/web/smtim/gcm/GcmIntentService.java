package id.web.smtim.gcm;

import id.web.smtim.MainActivity;
import id.web.smtim.R;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class GcmIntentService extends IntentService {
	public static final int NOTIFICATION_ID = 1;
	private NotificationManager mNotificationManager;
	Notification.Builder builder;
	
	String pengirim;
	
	public GcmIntentService() {
		super("GcmIntentService");
	}
	
	public static final String TAG = "GCM Service";

	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle extras = intent.getExtras();
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
		
		String messageType = gcm.getMessageType(intent);
		
		if(!extras.isEmpty()){
			if(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)){
				sendNotification("Send error: " + extras.toString());
			} else if(GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)){
				sendNotification("Deleted message on server: " + extras.toString());
			} else if(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)){
				String msg = extras.getString("message");
				pengirim = extras.getString("from");
				Log.i(TAG, "Complete Work @ " + SystemClock.elapsedRealtime());
				sendNotification(pengirim + ": " + msg);
				Log.i(TAG, "Received: " + extras.toString());
			}
		}
		GcmBroadcastReceiver.completeWakefulIntent(intent);
	}
	
	public void sendNotification(String msg){
		mNotificationManager = (NotificationManager)
				this.getSystemService(Context.NOTIFICATION_SERVICE);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 
				0, new Intent(this, MainActivity.class), 0);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
			.setSmallIcon(R.drawable.ic_launcher)
			.setContentTitle("SMTiM Message")
			.setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
			.setContentText(msg);
		
		mBuilder.setContentIntent(contentIntent);
		mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
	}
	
}
