package net.mondaini.android.test.TestTwitterFacebookIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class main extends Activity {
	private EditText editTxtMessage;
	private Button btnShare; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		editTxtMessage = (EditText) findViewById(R.id.editTxtMessage);
		
		btnShare = (Button) findViewById(R.id.btnShare); 		
		btnShare.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Share("Subject", editTxtMessage.getText().toString());
			}
		});
	}
	
	public void Share(String subject,String text) {
		 final Intent intent = new Intent(Intent.ACTION_SEND);

		 intent.setType("text/plain");
		 intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		 intent.putExtra(Intent.EXTRA_TEXT, text);

		 startActivity(Intent.createChooser(intent, getString(R.string.app_name)));
		}	
}