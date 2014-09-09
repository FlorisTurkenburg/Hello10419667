/* Author: Floris Turkenburg
 * UvANetID: 10419667
 * E-Mail: sk8_floris@hotmail.com
 */

package com.example.helloworld;

import java.util.Random;
import com.example.helloworld.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";
	public final static String EXTRA_COLOR = "com.example.helloworld.COLOR";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// Called when "Change Color"-button is pressed.
	// Random color method from: 
	// http://stackoverflow.com/questions/11622926/android-textview-setting-text-and-color
	public void changeColor(View view) {
		TextView message = (TextView) findViewById(R.id.Hello_cs);

		Random r = new Random();
        message.setTextColor(Color.rgb(r.nextInt(256), r.nextInt(256),
                r.nextInt(256)));
		
	}
	
	// Called when "Edit Text"-button is pressed.
	public void editText(View view) {
		EditText editText = (EditText) findViewById(R.id.edit_text);
		String message = editText.getText().toString();
		TextView text = (TextView) findViewById(R.id.Hello_cs);
		text.setText(message);
		editText.setText(null);
	}
	
	// This method starts a new activity to view the text in full screen
	public void fullView(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		
		TextView text = (TextView) findViewById(R.id.Hello_cs);
		String message = text.getText().toString();
		int color = text.getCurrentTextColor();
		intent.putExtra(EXTRA_MESSAGE, message);
		intent.putExtra(EXTRA_COLOR, String.valueOf(color));
		startActivity(intent);
	}
}
