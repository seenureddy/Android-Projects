package com.example.email_sending;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	private EditText recipient;
	private EditText subject;
	private EditText body;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recipient = (EditText) findViewById(R.id.recipient);
		subject = (EditText) findViewById(R.id.subject);
		body = (EditText) findViewById(R.id.body);
		
		Button email_send_button = (Button) findViewById(R.id.sendingEmail);
		email_send_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendingEmail();
				recipient.setText("");
				subject.setText("");
				body.setText("");
				
			}
		});
	}

	protected void sendingEmail() {
		// TODO Auto-generated method stub
		Log.i("sending Email", "");
		String [] recipients = {recipient.getText().toString()};
		Intent emailIntent = new Intent(Intent.ACTION_SEND, Uri.parse("malito:"));
		//emailIntent.setData(Uri.parse("malito"));
		emailIntent.setType("text/plain");
		
		emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);
		//emailIntent.putExtra(Intent.EXTRA_CC, Cc);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
		emailIntent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
		
		try {
			startActivity(Intent.createChooser(emailIntent, "Choose an email client from ... "));
			finish();
			Log.i("Finished the sending email", "");
		}catch(android.content.ActivityNotFoundException ex) {
			Toast.makeText(MainActivity.this, "There is no email client installed", Toast.LENGTH_SHORT).show();
		}
		
		
	}
}
