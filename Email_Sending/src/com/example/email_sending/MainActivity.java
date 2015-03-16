package com.example.email_sending;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button email_send_button = (Button) findViewById(R.id.sendingEmail);
		email_send_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendingEmail();
				
			}
		});
	}

	protected void sendingEmail() {
		// TODO Auto-generated method stub
		Log.i("sending Email", "");
		String [] To = {"seenu@agiliq.com"};
		String [] Cc = {"shiva@agiliq.com"};
		Intent emailIntent = new Intent(Intent.ACTION_SEND, Uri.parse("malito:"));
		//emailIntent.setData(Uri.parse("malito"));
		emailIntent.setType("text/plain");
		
		emailIntent.putExtra(Intent.EXTRA_EMAIL, To);
		emailIntent.putExtra(Intent.EXTRA_CC, Cc);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Sending test");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "are you received the email");
		
		try {
			startActivity(Intent.createChooser(emailIntent, "Sending Email"));
			finish();
			Log.i("Finished the sending email", "");
		}catch(android.content.ActivityNotFoundException ex) {
			Toast.makeText(MainActivity.this, "There is no email client installed", Toast.LENGTH_SHORT).show();
		}
		
		
	}
}
